package com.maduar.miaosha.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Service
public class RedisPoolFactory {

  @Autowired
  RedisConfig redisConfig;

  @Bean
  public JedisPool JedisPoolFactory() {

    Long max = new Long(redisConfig.getPoolMaxWait() * 1000);
    JedisPoolConfig poolConfig = new JedisPoolConfig();

    poolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
    poolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
    poolConfig.setMaxWaitMillis(max);

    JedisPool jp = new JedisPool(poolConfig, redisConfig.getHost(), redisConfig.getPort(),
        redisConfig.getTimeout() * 1000, redisConfig.getPassword(), 0);
    return jp;

  }

}
