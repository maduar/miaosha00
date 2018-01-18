package com.maduar.miaosha.redis;

public class UserPrefix extends BasePrefix{

  public UserPrefix(String prefix) {
    super(prefix);
    // TODO Auto-generated constructor stub
  }

  public static UserPrefix getById = new UserPrefix("id");
  public static UserPrefix getByName = new UserPrefix("name");  
}
