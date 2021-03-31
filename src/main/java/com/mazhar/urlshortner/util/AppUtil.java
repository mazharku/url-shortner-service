package com.mazhar.urlshortner.util;

import java.net.URL;

import org.springframework.beans.factory.annotation.Value;

public class AppUtil {
	@Value("${spring.jpa.properties.hibernate.default_schema}")
	public static  String dbSchema;
	
	
	
	public static boolean isValid(String url) {

		try {
			new URL(url).toURI();
			return true;
		}

		catch (Exception e) {
			return false;
		}
	}
}
