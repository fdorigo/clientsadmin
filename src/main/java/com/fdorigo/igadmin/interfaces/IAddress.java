package com.fdorigo.igadmin.interfaces;

/**
 *	Defines the contract for persisting an address.
 * 
 * @author fdorigo
 */
public interface IAddress
{
	public String getStreet();
	public void setStreet(String streety);

	public String getCity();
	public void setCity(String city);

	public String getState();
	public void setState(String state);
	
	public String getZip();
	public void setZip(String zip);
}
