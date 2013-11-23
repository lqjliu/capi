package com.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	private static Config instance = new Config();
	private Properties p;
	public static Config getInstance() {
		return instance;
	}

	private Config() {
		InputStream inputStream = this.getClass()
				.getResourceAsStream("caru_config.properties");
		p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public String getUploadPath(){
		return p.getProperty("caru.upload.path");
	}
}
