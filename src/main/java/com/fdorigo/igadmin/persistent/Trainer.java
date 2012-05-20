package com.fdorigo.igadmin.persistent;

import com.fdorigo.igadmin.persistent.auto._Trainer;

public class Trainer extends _Trainer 
{
	private static final long serialVersionUID = -4645605064383314478L;
	private Address address;
	private Phone primary;
	private Phone secondary;
	
	public String getName()
	{
		return super.getNameFirst() + " " + super.getNameMiddle() + " " + super.getNameLast();
	}
	
	public String toString() 
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("Trainer Name: ");
		sb.append(this.getName());
		sb.append("; Address: ");
		sb.append(getAddress());
		sb.append("; Primary: ");
		sb.append(primary);
		sb.append("; Secondary: ");
		sb.append(secondary);
		
		return sb.toString();
	}

	public Address getAddress()
	{
		if (address == null)
		{
			address = new Address(super.getAddressNum(), super.getAddressStreet(), super.getAddressApt(), super.getAddressCity(), super.getAddressState(), super.getAddressZip());
		}
		
		return address;
	}

	public void setAddress(Address address)
	{	
		this.address = address;
	}

	public Phone getPrimary()
	{
		if (primary == null)
		{
			primary = new Phone(super.getPhonePrimary());
		}
		
		return primary;
	}

	public void setPrimary(Phone primary)
	{
		this.primary = primary;
	}

	public Phone getSecondary()
	{
		if (secondary == null)
		{
			secondary = new Phone(super.getPhonePrimary());
		}

		return secondary;
	}

	public void setSecondary(Phone secondary)
	{
		this.secondary = secondary;
	}
	
	
}
