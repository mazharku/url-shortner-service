package com.mazhar.urlshortner.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestModel {
	
	private String longUrl;
	private String shortUrlDomain;
	private String parameters;
	
}
