package com.pjt.util.ys;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;

public class MediaUtils {

	private static Map<String, MediaType> mediaMap;
	
	// 클래스 레벨의 초기화 작업
	static {
		mediaMap = new HashMap<>();
		mediaMap.put("JPG", MediaType.IMAGE_JPEG); // image/jpeg
		mediaMap.put("GIF", MediaType.IMAGE_GIF); // image/gif
		mediaMap.put("PNG", MediaType.IMAGE_PNG); // image/png
	}
	
	public static MediaType getMediaType(String type) {
		return mediaMap.get(type.toUpperCase());
	}
	
	public static String getFormatName(String fileName) {
		int dotIndex = fileName.lastIndexOf(".");
		String formatName = fileName.substring(dotIndex + 1).toUpperCase();
		return formatName;
	}

}
