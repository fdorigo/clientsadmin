package com.fdorigo.igadmin.app.forms.utils;

import java.io.Serializable;

public class ClientSelectOption implements Serializable, ISelectOption
{
	private static final long serialVersionUID = -2685493059404689141L;
	private String key;
	private String value;
	
	public ClientSelectOption(int key, String value)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(key);
		
		this.key = sb.toString();
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
