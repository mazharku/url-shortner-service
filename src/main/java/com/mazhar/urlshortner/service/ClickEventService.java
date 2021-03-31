package com.mazhar.urlshortner.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazhar.urlshortner.model.ClickEventModel;
import com.mazhar.urlshortner.model.URLModel;
import com.mazhar.urlshortner.repository.ClickEventRepository;
import com.mazhar.urlshortner.repository.URLShortnerRepository;

@Service
public class ClickEventService {

	private ClickEventRepository repository;
	private URLShortnerRepository urlRepository;
	
	@Autowired
	public void setURLRepository(URLShortnerRepository urlRepository)  {
		this.urlRepository = urlRepository;
	}

	public ClickEventService(ClickEventRepository repository) {
		this.repository = repository;
	}

	public List<ClickEventModel> getClickAllClick() {
		List<ClickEventModel> clickEvents = new ArrayList<>();
		clickEvents = repository.findAll();
		for(ClickEventModel event : clickEvents) {
			URLModel model = event.getUrlModel();
			Optional<URLModel> findById = urlRepository.findById(model.getId());
			findById.ifPresent(e -> {
				event.setUrlModel(e);
			});
		}
		return clickEvents;
	}
}
