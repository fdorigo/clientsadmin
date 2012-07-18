package com.fdorigo.igadmin.persistent;

import java.io.Serializable;

import org.apache.log4j.Logger;

public class Phone implements Serializable
{
	private static final long serialVersionUID = -7227906431599297832L;
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(Phone.class);
	
	private String number;
	private String extension;

	public Phone(String number)
	{
		this.number = number;
	}

	public Phone(String number, String extension)
	{
		this.number = number;
		this.extension = extension;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		sb.append(this.number);

		if (this.extension != null && this.extension.length() > 0)
		{
			sb.append(" ext: ");
			sb.append(this.extension);
		}

		return sb.toString();
	}

	public String getNumber()
	{
		return number;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	public String getExtension()
	{
		return extension;
	}

	public void setExtension(String extension)
	{
		this.extension = extension;
	}
}
