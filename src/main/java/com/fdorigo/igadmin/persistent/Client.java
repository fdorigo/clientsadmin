package com.fdorigo.igadmin.persistent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.fdorigo.igadmin.persistent.auto._Client;

public class Client extends _Client
{
	private static final String DEFAULT_DATE_FORMAT = "yyyyMMdd";
	private static final Logger LOG = Logger.getLogger(Client.class);
	private static final long serialVersionUID = 4633162388388367972L;
	private Address address = null;
	private Phone secondary = null;
	private Email email = null;
	private Phone primary = null;

	public String getTrainerName()
	{
		return super.getTrainer().getName();
	}

	public Address getAddress()
	{
		if (address == null)
		{
			address = new Address(getAddressStreet(), getAddressCity(), getAddressState(), getAddressZip());
		}

		return address;
	}

	public Phone getSecondary()
	{
		if (secondary == null)
		{
			secondary = new Phone(super.getPhoneSecondary());
		}

		return secondary;
	}

	@Override
	public String getEmailAddress()
	{
		if (email == null)
		{
			email = new Email(super.getEmailAddress());
		}

		return super.getEmailAddress();
	}

	public String getName()
	{
		return getNameFirst() + " " + getNameLast();
	}

	public Phone getPrimary()
	{
		if (primary == null)
		{
			primary = new Phone(super.getPhonePrimary());
		}

		return primary;
	}

	public void setAddress(Address a)
	{
		super.setAddressStreet(a.getStreet());
		super.setAddressCity(a.getCity());
		super.setAddressState(a.getState());
		super.setAddressZip(a.getZip());

		address = a;
	}

	public void setSecondary(Phone phoneAlternate)
	{
		super.setPhoneSecondary(phoneAlternate.toString());
		secondary = phoneAlternate;
	}

	/**
	 * Sets joining date using a string in format yyyyMMdd.
	 */
	public void setDateJoinedString(String yearMonthDay)
	{
		if (yearMonthDay == null)
		{
			setDateJoined(null);
		} else
		{
			Date date;
			try
			{
				date = new SimpleDateFormat(DEFAULT_DATE_FORMAT).parse(yearMonthDay);
			} catch (ParseException e)
			{
				throw new IllegalArgumentException("A date argument must be in format '" + DEFAULT_DATE_FORMAT + "': " + yearMonthDay);
			}

			setDateJoined(date);
		}
	}

	/**
	 * Sets date of birth using a string in format yyyyMMdd.
	 */
	public void setDateOfBirthString(String yearMonthDay)
	{
		if (yearMonthDay == null)
		{
			setDateBirth(null);
		} else
		{
			Date date;
			try
			{
				date = new SimpleDateFormat(DEFAULT_DATE_FORMAT).parse(yearMonthDay);
			} catch (ParseException e)
			{
				throw new IllegalArgumentException("A date argument must be in format '" + DEFAULT_DATE_FORMAT + "': " + yearMonthDay);
			}

			setDateBirth(date);
		}
	}

	public void setEmail(String emailAddress)
	{
		super.setEmailAddress(emailAddress);
		email = new Email(emailAddress);
	}

	public void setPrimary(Phone phonePrimary)
	{
		super.setPhonePrimary(phonePrimary.toString());
		primary = phonePrimary;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Client: ");
		sb.append(getName());
		sb.append("; Address: " + address);
		sb.append("; Primary phone: " + primary);
		sb.append("; Alternate phone: " + secondary);
		sb.append("; Trained by: " + this.getTrainerName());
		sb.append("; Trained at: " + this.getLocation().getName());

		return super.toString();
	}
}
