package com.doctrin.test.config;

import java.io.InputStream;
import java.util.Properties;

/**
 * This class handles the centralization of all configurations of the framework
 * under the resource/config.properties file
 * 
 * @author rohan
 *
 */

public class ConfigData {

	public static Properties prop = new Properties();
	public static InputStream File;

	public void loadData() throws Exception {
		File = ConfigData.class.getClassLoader().getResourceAsStream("config.properties");
		prop.load(File);
	}

	public String getAPILink() throws Exception {
		loadData();
		return prop.getProperty("APILINK");
	}
	
	public String getGetLink() throws Exception {
		loadData();
		return prop.getProperty("GETLINK");
	}
	
	public String getTextPath() throws Exception {
		loadData();
		return prop.getProperty("TextPATH");
	}

}
