package com.mazhar.urlshortner.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Response {

	private UUID uniqueId;
	private String shortUrl;
}
