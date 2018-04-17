package com.ustcInfo.util.Jedis;

import java.util.HashSet;
import java.util.Iterator;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class JedisUtil {
	private static JedisCluster jedisCluster = null;

	public static JedisCluster getCluster() throws Exception {
		if (jedisCluster == null) {
			Class arg = JedisUtil.class;
			synchronized (JedisUtil.class) {
				jedisCluster = createJedisCluster();
			}
		}

		return jedisCluster;
	}

	private static JedisCluster createJedisCluster() throws Exception {
		GenericObjectPoolConfig poolConfig = PoolConfigFactory.getPoolConfig();
		HashSet jedisClusterNodes = new HashSet();
		Iterator iterator = PropertiesUtil.getKeys("redis", "redisAddress");

		while (iterator.hasNext()) {
			String[] address = PropertiesUtil.getString("redis", (String) iterator.next()).split(":");
			jedisClusterNodes.add(new HostAndPort(address[0], Integer.parseInt(address[1])));
		}

		return new JedisCluster(jedisClusterNodes, 10000, 18, poolConfig);
	}
}
