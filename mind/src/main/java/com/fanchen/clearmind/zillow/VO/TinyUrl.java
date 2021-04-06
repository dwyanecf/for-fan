package com.fanchen.clearmind.zillow.VO;

import java.util.HashMap;
import java.util.Map;

public class TinyUrl {

	Map<String, String> map = new HashMap<>();

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		map.put(String.valueOf(map.size() + 1), longUrl);
		return String.valueOf(map.size());
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return map.get(shortUrl);
	}
}
