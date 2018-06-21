package com.fanchen.clearmind.leetcode.map.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * TinyURL is a URL shortening service where you enter a URL such as
 * https://leetcode.com/problems/design-tinyurl and it returns a short URL such
 * as http://tinyurl.com/4e9iAk.
 * 
 * Design the encode and decode methods for the TinyURL service. There is no
 * restriction on how your encode/decode algorithm should work. You just need to
 * ensure that a URL can be encoded to a tiny URL and the tiny URL can be
 * decoded to the original URL.
 * 
 * 
 * @author fan
 *
 */
public class EncodeandDecodeTinyURL {
	public Map<String, String> map = new HashMap<>();

	public String encode(String longUrl) {
		map.put(longUrl, String.valueOf(map.size()));
		return String.valueOf(map.size() - 1);
	}

	public String decode(String shortUrl) {
		return map.get(shortUrl);
	}
}
