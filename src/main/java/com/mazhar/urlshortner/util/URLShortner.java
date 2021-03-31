package com.mazhar.urlshortner.util;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;

public class URLShortner {

	public static String getEncodedUrl(String url) {
		String shortUrl = Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();
		String enc = shortUrl.substring(0, 6);
		return enc;
	}
}
