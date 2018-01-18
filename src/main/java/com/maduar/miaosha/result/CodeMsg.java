package com.maduar.miaosha.result;

public class CodeMsg {

	private int code;
	private String msg;

	public static CodeMsg SUCCESS = new CodeMsg(0, "success");
	public static CodeMsg SERVER_ERROR = new CodeMsg(504, "服务端异常");
	public static CodeMsg BIND_ERROR = new CodeMsg(504201, "参数校验异常: %s");
	
	public static CodeMsg PASSWORD_EMPTY = new CodeMsg(504100, "密码不能为空");
	public static CodeMsg MOBILE_EMPTY = new CodeMsg(504100, "手机号不能为空");
	public static CodeMsg MOBILE_ERROR = new CodeMsg(504101, "手机号码格式出错");

	public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(504102, "手机号码不存在");
	public static CodeMsg PASSWORD_ERROR = new CodeMsg(504103, "用户密码出错");
	
	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	private CodeMsg(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

    public CodeMsg fillArgs(Object... args) {
      int code = this.code;
      String message = String.format(this.msg, args);
      return new CodeMsg(code, message);
  }
}
