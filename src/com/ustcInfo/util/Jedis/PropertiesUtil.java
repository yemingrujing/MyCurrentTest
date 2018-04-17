package com.ustcInfo.util.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

public class PropertiesUtil {

	private static final String encoding = "UTF-8";
	private static Map<String, PropertiesConfiguration> propertiesMap = new HashMap();

	public static PropertiesConfiguration getConfig(String configName) {
		PropertiesConfiguration config = (PropertiesConfiguration) propertiesMap.get(configName);

		try {
			if (null == config) {
				config = new PropertiesConfiguration("./config/" + configName + ".properties");
				config.setReloadingStrategy(new FileChangedReloadingStrategy());
				config.setEncoding("UTF-8");
				propertiesMap.put(configName, config);
			}
		} catch (ConfigurationException arg2) {
			System.out.println("----------------");
		}

		return config;
	}

	public static String getString(String configName, String key) {
		String str = "";

		try {
			str = getConfig(configName).getString(key);
		} catch (Exception arg3) {
			arg3.printStackTrace();
		}

		return str;
	}

	public static int getInt(String configName, String key) throws Exception {
		String str = getConfig(configName).getString(key);

		try {
			return Integer.parseInt(str);
		} catch (Exception arg3) {
			throw new Exception("key = " + key + "取到的值不是整形！", arg3);
		}
	}

	public static Iterator<String> getKeys(String configName, String prefix) throws Exception {
		return getConfig(configName).getKeys(prefix);
	}
}
