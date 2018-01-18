package com.maduar.miaosha.redis;

public class MiaoshaUserKey extends BasePrefix{
  
  private static final int TOKEN_EXPRIRE = 3600 * 24 * 2;
  
  public MiaoshaUserKey(int expreire, String prefix) {
    super(expreire, prefix);
    // TODO Auto-generated constructor stub
  }

  public static MiaoshaUserKey tocken = new MiaoshaUserKey(TOKEN_EXPRIRE, "token");
}
