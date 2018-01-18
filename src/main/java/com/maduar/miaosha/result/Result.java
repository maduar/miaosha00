package com.maduar.miaosha.result;

public class Result<T> {

	private int code;
	private String msg;
	private T data;

	public static <T> Result<T> success(T data) {
		return new Result<T>(data);
	}

	public static <T> Result<T> error(CodeMsg cm) {
		return new Result<T>(cm);
	}

	private Result(T data) {
		this.code = 0;
		this.msg = "success";
		this.data = data;
	}

	public Result(int code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	private Result(CodeMsg cm) {
		if (cm == null) {
			return;
		}

		this.code = cm.getCode();
		this.msg = cm.getMsg();

	}

	public String getMsg() {
		return msg;
	}

	public int getCode() {
		return code;
	}

	public T getData() {
		return data;
	}

}
