package sch.web.entity;

import javax.servlet.http.HttpServletRequest;

public class User {
	private String username;
	private HttpServletRequest requset;
	
	/**
	 * @return the requset
	 */
	public HttpServletRequest getRequset() {
		return requset;
	}

	/**
	 * @param requset the requset to set
	 */
	public void setRequset(HttpServletRequest requset) {
		this.requset = requset;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
}
