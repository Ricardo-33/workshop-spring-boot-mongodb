package com.ricardo.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import lombok.extern.slf4j.Slf4j;

public class URL {
	
	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} 
		catch (UnsupportedEncodingException e) {
			return "";
		}
	}

}
