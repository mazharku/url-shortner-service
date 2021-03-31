package com.mazhar.urlshortner.webservice;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mazhar.urlshortner.dto.Response;
import com.mazhar.urlshortner.model.ClickEventModel;
import com.mazhar.urlshortner.model.RequestModel;
import com.mazhar.urlshortner.model.URLModel;
import com.mazhar.urlshortner.service.ClickEventService;
import com.mazhar.urlshortner.service.URLShortnerService;
import com.mazhar.urlshortner.util.AppResponse;

/**
 * @author mazhar
 *
 *         Mar 29, 2021
 */
@RestController
@RequestMapping(path = "/", produces = { "application/json" })
public class URLShortnerResource {
	private final String ROOT= "api";
	private Logger log = LoggerFactory.getLogger(URLShortnerService.class);
	private URLShortnerService service;
	private ClickEventService clickEventService;

	@Autowired
	public void SetURLShortnerResource(URLShortnerService service) {
		this.service = service;
	}

	@Autowired
	public void SetClickEventService(ClickEventService clickEventService) {
		this.clickEventService = clickEventService;
	}

	@PostMapping(ROOT+"/")
	ResponseEntity<?> createShortURL(@RequestBody RequestModel requestbody) {
		try {
			Response createShortURL = service.createShortURL(requestbody);
			return new ResponseEntity<Object>(createShortURL, new HttpHeaders(), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Object>(AppResponse.operationFail(e.getMessage()), new HttpHeaders(),
					HttpStatus.OK);
		}
	}

	@GetMapping(ROOT+"/count")
	public int getNumerOfShortUrl() {
		return service.getNumberOfUrl();
	}

	@GetMapping(ROOT+"/{shorUrlId}")
	ResponseEntity<?> getSingleURLModel(@PathVariable(name = "shorUrlId") UUID id) {
		try {
			URLModel urlModelByid = service.getURLModelByid(id);
			return new ResponseEntity<Object>(urlModelByid, new HttpHeaders(), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Object>(AppResponse.operationFail(e.getMessage()), new HttpHeaders(),
					HttpStatus.OK);
		}
	}

	@GetMapping("{shortUrl}")
	ResponseEntity<?> clickShortUrl(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(name = "shortUrl") String url) throws IOException {
		try {
			String longUrl = service.getClickableLink(request, url);
			response.sendRedirect(longUrl);
			return null;
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Object>(AppResponse.operationFail(e.getMessage()), new HttpHeaders(),
					HttpStatus.OK);
		}

	}

	@GetMapping(ROOT+"/clickevents")
	ResponseEntity<?> getAllClickData() {
		try {
			List<ClickEventModel> clickAllClick = clickEventService.getClickAllClick();
			return new ResponseEntity<Object>(clickAllClick, new HttpHeaders(), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Object>(AppResponse.operationFail(e.getMessage()), new HttpHeaders(),
					HttpStatus.OK);
		}

	}
}
