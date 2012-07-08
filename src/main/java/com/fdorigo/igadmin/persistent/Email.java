package com.fdorigo.igadmin.persistent;

import java.io.Serializable;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.log4j.Logger;

public class Email implements Serializable
{
	private static final long serialVersionUID = -4438536682546580324L;
	private static final Logger LOG = Logger.getLogger(Email.class);
	private String email = "";

	public Email(String em)
	{
		if (em != null && isValid(em))
		{
			this.email = em;
		}
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String em)
	{
		if (em != null && isValid(em))
		{
			this.email = em;
		}
	}

	private boolean isValid(String em)
	{
		boolean result = true;
		
		try
		{
			InternetAddress emailAddr = new InternetAddress(em);
			emailAddr.validate();
		} 
		catch (AddressException ex)
		{
			LOG.warn("Email is invalid: " + em);
			result = false;
		}
		
		return result;
	}
}
