package com.fdorigo.igadmin.app.forms.utils;

import java.io.Serializable;

public class StateSelectOption implements Serializable
{
	private static final long serialVersionUID = -2941979778049979428L;
	private String key;
	private String value;
	
	public StateSelectOption(String key, String value)
	{
		this.key = key;
		this.value = value;
	}

	public String getKey()
	{
		return key;
	}
	
	public void setKey(String key)
	{
		this.key = key;
	}
	
	public String getValue()
	{
		return value;
	}
	
	public void setValue(String value)
	{
		this.value = value;
	}
}
