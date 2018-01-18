package com.maduar.miaosha.redis;

public abstract class BasePrefix implements KeyPrifix {

  private int expireSeconds;
  private String prefix;

  public BasePrefix(String prefix) {
    this(0, prefix);
  }

  public BasePrefix(int expireSeconds, String prefix) {
    this.expireSeconds = expireSeconds;
    this.prefix = prefix;
  }

  public int expireSeconds() {
    return expireSeconds;
  };

  public String getPrifix() {
    String className = getClass().getSimpleName();
    return className + ":" + prefix;
  };
}
