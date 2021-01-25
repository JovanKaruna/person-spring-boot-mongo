package com.demo.base;

public class SingleBaseResponse<T> extends BaseResponse {

	private T value;

	public SingleBaseResponse() {
	}

	public SingleBaseResponse(String errorMessage, String errorCode, boolean success, String requestId, T value) {
		super(errorMessage, errorCode, success, requestId);
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "SingleBaseResponse{" + "value=" + value + '}';
	}
}
