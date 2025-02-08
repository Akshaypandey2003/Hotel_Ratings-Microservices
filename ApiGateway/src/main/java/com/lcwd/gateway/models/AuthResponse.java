package com.lcwd.gateway.models;

import java.util.Collection;

import lombok.Data;

public class AuthResponse {

	private String userId;
	private String accessToken;
	private String refreshToken;
	private long expireAt;
	private Collection<String> authoritise;
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}
	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	/**
	 * @return the refreshToken
	 */
	public String getRefreshToken() {
		return refreshToken;
	}
	/**
	 * @param refreshToken the refreshToken to set
	 */
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	/**
	 * @return the expireAt
	 */
	public long getExpireAt() {
		return expireAt;
	}
	/**
	 * @param expireAt the expireAt to set
	 */
	public void setExpireAt(long expireAt) {
		this.expireAt = expireAt;
	}
	/**
	 * @return the authorise
	 */
	public Collection<String> getAuthoritise() {
		return authoritise;
	}
	/**
	 * @param authorise the authorise to set
	 */
	public void setAuthoritise(Collection<String> authorise) {
		this.authoritise = authorise;
	}
	@Override
	public String toString() {
		return "AuthResponse [userId=" + userId + ", accessToken=" + accessToken + ", refreshToken=" + refreshToken
				+ ", expireAt=" + expireAt + ", authoritise=" + authoritise + "]";
	}
	
}
