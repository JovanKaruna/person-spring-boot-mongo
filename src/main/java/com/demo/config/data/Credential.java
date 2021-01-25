package com.demo.config.data;

import org.slf4j.MDC;

public final class Credential {

	public static final String CREDENTIAL_STORE_ID = "STORE_ID";
	public static final String CREDENTIAL_CHANNEL_ID = "CHANNEL_ID";
	public static final String CREDENTIAL_CLIENT_ID = "CLIENT_ID";
	public static final String CREDENTIAL_REQUEST_ID = "REQUEST_ID";
	public static final String CREDENTIAL_USERNAME = "USERNAME";

	private Credential() {
	}

	public static String getStoreId() {
		return MDC.get(Credential.CREDENTIAL_STORE_ID);
	}

	public static void setStoreId(String storeId) {
		MDC.put(Credential.CREDENTIAL_STORE_ID, storeId);
	}

	public static String getChannelId() {
		return MDC.get(Credential.CREDENTIAL_CHANNEL_ID);
	}

	public static void setChannelId(String channelId) {
		MDC.put(Credential.CREDENTIAL_CHANNEL_ID, channelId);
	}

	public static String getClientId() {
		return MDC.get(Credential.CREDENTIAL_CLIENT_ID);
	}

	public static void setClientId(String clientId) {
		MDC.put(Credential.CREDENTIAL_CLIENT_ID, clientId);
	}

	public static String getRequestId() {
		return MDC.get(Credential.CREDENTIAL_REQUEST_ID);
	}

	public static void setRequestId(String requestId) {
		MDC.put(Credential.CREDENTIAL_REQUEST_ID, requestId);
	}

	public static String getUsername() {
		return MDC.get(Credential.CREDENTIAL_USERNAME);
	}

	public static void setUsername(String username) {
		MDC.put(Credential.CREDENTIAL_USERNAME, username);
	}
}