package com.ccanoprojects.aldeas.utils;

import java.nio.charset.Charset;

import org.springframework.http.MediaType;

public class Constants {

	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

}
