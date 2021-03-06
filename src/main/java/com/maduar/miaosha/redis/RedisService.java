package com.maduar.miaosha.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Service
public class RedisService {

  @Autowired
  JedisPool jedisPool;

  public <T> T get(KeyPrifix prifix, String key, Class<T> clazz) {
    Jedis jedis = null;
    try {
      jedis = jedisPool.getResource();
      String realKey = prifix.getPrifix() + key;
      System.out.println("realKey: " + realKey);
      String str = jedis.get(realKey);
      T t = stringToBean(str, clazz);
      return t;
    } finally {
      returnToPool(jedis);
    }
  }

  public <T> Boolean set(KeyPrifix prifix, String key, T value) {
    Jedis jedis = null;
    try {
      jedis = jedisPool.getResource();
      String str = beanToString(value);
      if (str == null || str.length() <= 0) {
        return false;
      }

      String realKey = prifix.getPrifix() + key;

      jedis.set(realKey, str);
      return true;
    } finally {
      returnToPool(jedis);
    }
  }

  private <T> String beanToString(T value) {
    if (value == null) {
      return null;
    }

    Class<?> clazz = value.getClass();
    if (clazz == int.class || clazz == Integer.class) {
      return "" + value;
    } else if (clazz == long.class || clazz == Long.class) {
      return "" + value;
    } else if (clazz == String.class) {
      return (String) value;
    } else {
      return JSON.toJSONString(value);
    }
  }

  @SuppressWarnings("unchecked")
  private <T> T stringToBean(String str, Class<T> clazz) {
    if (str == null || str.length() <= 0 || clazz == null) {
      return null;
    }

    if (clazz == int.class || clazz == Integer.class) {
      return (T) Integer.valueOf(str);
    } else if (clazz == long.class || clazz == Long.class) {
      return (T) Long.valueOf(str);
    } else if (clazz == String.class) {
      return (T) str;
    } else {
      return JSON.toJavaObject(JSON.parseObject(str), clazz);
    }
  }

  private void returnToPool(Jedis jedis) {
    if (jedis != null) {
      jedis.close();
    }
  }

}
