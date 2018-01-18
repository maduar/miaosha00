package com.maduar.miaosha.redis;

public interface KeyPrifix {

  public int expireSeconds();

  public String getPrifix();
}
