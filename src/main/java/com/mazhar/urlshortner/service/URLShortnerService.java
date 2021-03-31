package com.mazhar.urlshortner.service;


import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mazhar.urlshortner.dto.Response;
import com.mazhar.urlshortner.exception.ResourceNotFound;
import com.mazhar.urlshortner.model.ClickEventModel;
import com.mazhar.urlshortner.model.RequestModel;
import com.mazhar.urlshortner.model.URLModel;
import com.mazhar.urlshortner.repository.ClickEventRepository;
import com.mazhar.urlshortner.repository.URLShortnerRepository;
import com.mazhar.urlshortner.util.AppUtil;
import com.mazhar.urlshortner.util.ClickEvent;
import com.mazhar.urlshortner.util.URLShortner;

@Service
public class URLShortnerService {
	@Value("${spring.jpa.properties.hibernate.default_schema}")
	public static  String dbSchema;
	private URLShortnerRepository repository;
	private ClickEventRepository clickEventRepository;

	public URLShortnerService(URLShortnerRepository repository) {
		this.repository = repository;
	}
	@Autowired
	public void setClickEventRepository( ClickEventRepository clickEventRepository) {
		this.clickEventRepository = clickEventRepository;
	}
	
	public Response createShortURL(RequestModel requestModel) throws ResourceNotFound {
		String url = requestModel.getLongUrl();
		 if (!AppUtil.isValid(url)) {
			 throw new ResourceNotFound("Request Url is not vaild!");
		 }
		String shortUrl = URLShortner.getEncodedUrl(url);
		URLModel model = new URLModel(url, shortUrl, requestModel.getParameters());
		URLModel saveModel = repository.save(model);
		return new Response(saveModel.getId(), shortUrl);
		
	}
	
	public int getNumberOfUrl() {
		return (int) repository.count();
	}
	
	public URLModel getURLModelByid(UUID id) throws ResourceNotFound {
		return repository.findById(id).orElseThrow(()-> new ResourceNotFound("No Item is found with this id"));
	}
	
	public String getClickableLink(HttpServletRequest request, String shortUrl) throws ResourceNotFound {
		URLModel urlModel = repository.findByShortURL(shortUrl).orElseThrow(() -> new ResourceNotFound("No Item is found with this shortUrl"));
		ClickEventModel clickEvent = ClickEvent.getClickEvent(request);
		clickEvent.setUrlModel(urlModel);
		clickEventRepository.save(clickEvent);
		return urlModel.getLongUrl();
	}
	
}
