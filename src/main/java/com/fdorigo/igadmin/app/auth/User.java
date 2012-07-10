package com.fdorigo.igadmin.app.auth;

import java.io.Serializable;

public class User implements Serializable
{
	private static final long serialVersionUID = -5462992047551850520L;

	private String username;
	private String password;
	//private Location location;
	
	public User (final String user, final String pass)
	{
		this.username = user;
		this.password = pass;
	}
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
}
