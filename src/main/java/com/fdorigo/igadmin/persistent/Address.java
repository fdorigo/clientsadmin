package com.fdorigo.igadmin.persistent;

import java.io.Serializable;

import com.fdorigo.igadmin.interfaces.IAddress;

public class Address implements IAddress, Serializable
{
	private static final long serialVersionUID = 2927546384466348849L;
	private static final String BLANKSP = " ";
	private static final String COMMASP = ", ";
	
	private String apt;
	private String city;
	private String number;
	private String state;
	private String street;
	private String zip;

	public Address() 
	{
		this("", "", "", "", "", "");
	}
	
	public Address(String num, String street, String apt, String city, String state, String zip)
	{
		this.number = num;
		this.street = street;
		this.apt = apt;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.number + BLANKSP);
		sb.append(this.street);
		
		if (this.apt != null && this.apt.length() > 0) 
		{
			sb.append(BLANKSP);
			sb.append(this.apt);
		}
		
		sb.append(COMMASP + this.city + COMMASP);
		sb.append(this.state + BLANKSP);
		sb.append(this.zip);
		
		return sb.toString();
	}

	public String getApt()
	{
		return apt;
	}

	public String getCity()
	{
		return city;
	}

	public String getNumber()
	{
		return number;
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

	public void setApt(String apt)
	{
		this.apt = apt;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public void setNumber(String number)
	{
		this.number = number;
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
