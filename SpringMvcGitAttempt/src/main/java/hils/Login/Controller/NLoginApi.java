package hils.Login.Controller;

import com.github.scribejava.core.builder.api.DefaultApi20;

public class NLoginApi extends DefaultApi20 {

	protected NLoginApi() {
	}

	private static class InstanceHolder {
		private static final NLoginApi INSTANCE = new NLoginApi();
	}

	public static NLoginApi instance() {
		return InstanceHolder.INSTANCE;
	}

	@Override
	public String getAccessTokenEndpoint() {
		return "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code";
	}

	@Override
	protected String getAuthorizationBaseUrl() {
		return "https://nid.naver.com/oauth2.0/authorize";
	}

}