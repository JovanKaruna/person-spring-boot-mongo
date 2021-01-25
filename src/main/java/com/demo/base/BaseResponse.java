package com.demo.base;

import java.io.Serializable;

public class BaseResponse implements Serializable {

	private String errorMessage;
	private String errorCode;
	private boolean success = false;
	private String requestId;

	public BaseResponse() {
	}

	public BaseResponse(String errorMessage, String errorCode, boolean success, String requestId) {
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.success = success;
		this.requestId = requestId;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	@Override
	public String toString() {
		return "BaseResponse{" + "errorMessage='" + errorMessage + '\'' + ", errorCode='" + errorCode + '\''
				+ ", success=" + success + ", requestId='" + requestId + '\'' + '}';
	}
}
