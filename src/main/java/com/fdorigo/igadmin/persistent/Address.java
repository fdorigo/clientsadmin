package com.fdorigo.igadmin.persistent;

import java.io.Serializable;

public class Address implements Serializable
{
	private static final long serialVersionUID = 2927546384466348849L;
	private static final String BLANKSP = " ";
	private static final String COMMASP = ", ";
	
	private String street;
	private String city;
	private String state;
	private String zip;

	public Address() 
	{
		this("", "", "", "");
	}
	
	public Address(String street, String city, String state, String zip)
	{
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.street + COMMASP);
		sb.append(this.city + COMMASP);
		sb.append(this.state + BLANKSP);
		sb.append(this.zip);
		
		return sb.toString();
	}

	public String getCity()
	{
		return city;
	}

	public String getState()
	{
		return state;
	}

	public String getStreet()
	{
		return street;
	}

	public String getZip()
	{
		return zip;
	}

	public void setCity(String city)
	{
		this.city = city;
	}
 
	public void setState(String state)
	{
		this.state = state;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}
	
	public void setZip(String zip)
	{
		this.zip = zip;
	}
}
