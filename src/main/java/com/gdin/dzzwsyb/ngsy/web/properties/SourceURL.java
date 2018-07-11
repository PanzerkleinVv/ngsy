package com.gdin.dzzwsyb.ngsy.web.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:properties/sourceURL.properties")
public class SourceURL {
	@Value("${photoURL}")
	public String PHOTO_URL;

	@Value("${photoURLDefault}")
	public String PHOTO_URL_DEFAULT;
}
