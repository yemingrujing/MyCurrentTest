package com.ustcInfo.util.Jedis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class PoolConfigFactory {

	private static GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();

	public static GenericObjectPoolConfig getPoolConfig() {
		return poolConfig;
	}

	static {
		poolConfig.setBlockWhenExhausted(Boolean.parseBoolean(PropertiesUtil.getString("redis", "BlockWhenExhausted")));
		poolConfig.setEvictionPolicyClassName(PropertiesUtil.getString("redis", "EvictionPolicyClassName"));
		poolConfig.setJmxEnabled(Boolean.parseBoolean(PropertiesUtil.getString("redis", "JmxEnabled")));
		poolConfig.setJmxNamePrefix(PropertiesUtil.getString("redis", "JmxNamePrefix"));
		poolConfig.setLifo(Boolean.parseBoolean(PropertiesUtil.getString("redis", "Lifo")));
		poolConfig.setMaxIdle(Integer.parseInt(PropertiesUtil.getString("redis", "MaxIdle")));
		poolConfig.setMaxTotal(Integer.parseInt(PropertiesUtil.getString("redis", "MaxTotal")));
		poolConfig.setMaxWaitMillis((long) Integer.parseInt(PropertiesUtil.getString("redis", "MaxWaitMillis")));
		poolConfig.setMinEvictableIdleTimeMillis(
				(long) Integer.parseInt(PropertiesUtil.getString("redis", "MinEvictableIdleTimeMillis")));
		poolConfig.setMinIdle(Integer.parseInt(PropertiesUtil.getString("redis", "MinIdle")));
		poolConfig.setNumTestsPerEvictionRun(
				Integer.parseInt(PropertiesUtil.getString("redis", "NumTestsPerEvictionRun")));
		poolConfig.setSoftMinEvictableIdleTimeMillis(
				(long) Integer.parseInt(PropertiesUtil.getString("redis", "SoftMinEvictableIdleTimeMillis")));
		poolConfig.setTestOnBorrow(Boolean.parseBoolean(PropertiesUtil.getString("redis", "TestOnBorrow")));
		poolConfig.setTestWhileIdle(Boolean.parseBoolean(PropertiesUtil.getString("redis", "TestWhileIdle")));
		poolConfig.setTimeBetweenEvictionRunsMillis(
				(long) Integer.parseInt(PropertiesUtil.getString("redis", "TimeBetweenEvictionRunsMillis")));
	}
}
