package com.zsl.homestay.commen;

/**
 * 封装返回结果
 *
 * @param <T>
 */
public class Result<T> {
	// jdfkjadjfkdfkdsfjkfjksdfhkjsdtestss
	/***
	*4444444
	 * 状态
	 */
	private Integer code;
	/**
	 * 信息
	 */
	private String message;
	
	private String nane;
	/**
	 * 返回值
	 */
	private T data;

	public Result(T object) {
		this.data = object;
	}

	Result() {
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
