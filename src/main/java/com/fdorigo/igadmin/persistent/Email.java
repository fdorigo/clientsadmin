package com.fdorigo.igadmin.persistent;

public class Email
{
	private String email;

	public Email(String e)
	{
		if (isValid(email))
		{
			this.email = email;
		}
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		if (isValid(email))
		{
			this.email = email;
		}
	}

	/**
	 * TODO implement email validator
	 */
	private boolean isValid(String email)
	{
		return true;
	}
}
