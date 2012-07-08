package com.fdorigo.igadmin.persistent;

import com.fdorigo.igadmin.persistent.auto._Location;

public class Location extends _Location
{
	private static final long serialVersionUID = -4401451023313747266L;
	private Address address;

	public Address getAddress()
	{
		if (address == null)
		{
			address = new Address(getAddressStreet(), getAddressCity(), getAddressState(), getAddressZip());
		}

		return address;
	}

	public void setAddress(Address a)
	{
		super.setAddressStreet(a.getStreet());
		super.setAddressCity(a.getCity());
		super.setAddressState(a.getState());
		super.setAddressZip(a.getZip());

		address = a;
	}
}
