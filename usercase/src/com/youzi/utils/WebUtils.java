package com.youzi.utils;

import java.util.UUID;

public class WebUtils {

	public WebUtils() {
	}

	public static String generateID() {
		return UUID.randomUUID().toString();
	}
}
