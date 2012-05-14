package com.fdorigo.igadmin.persistent;

import org.apache.log4j.Logger;

public class Phone
{
	private static final String COMPONENTS_DELIMITER = ":";
	private static final Logger LOG = Logger.getLogger(Phone.class);
	private String area;
	private String exchange;
	private String suffix;
	private String extension;
	private String dbString;

	public Phone()
	{
		this("555", "555", "5555", "5");
	}

	public Phone(String area, String exchange, String suffix, String extension)
	{
		this.area = area;
		this.exchange = exchange;
		this.suffix = suffix;
		this.extension = extension;
	}

	public Phone(String phone)
	{
		String[] components = phone.split(COMPONENTS_DELIMITER);

		if (components.length < 3)
		{
			LOG.error("Error creating phone from string: " + phone);
			return;
		}

		if (components[0] != null && components[0].length() > 0)
		{
			this.area = components[0];
		}

		if (components[1] != null && components[1].length() > 0)
		{
			this.exchange = components[1];
		}

		if (components[2] != null && components[2].length() > 0)
		{
			this.suffix = components[2];
		}

		if (components.length > 0 && components[3] != null
				&& components[3].length() > 0)
		{
			this.extension = components[3];
		}

		LOG.trace("Created phone object " + this.toString() + ", using string: "
				+ phone);
	}
	
	public String getDbString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(this.area);
		sb.append(COMPONENTS_DELIMITER);
		sb.append(this.exchange);
		sb.append(COMPONENTS_DELIMITER);
		sb.append(this.suffix);
		if (this.extension != null && this.extension.length() > 0)
		{
			sb.append(COMPONENTS_DELIMITER);
			sb.append(this.extension);
		}
		
		return sb.toString();
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		sb.append("(");
		sb.append(this.area);
		sb.append(") ");
		sb.append(this.exchange);
		sb.append("-");
		sb.append(this.suffix);

		if (this.extension != null && this.extension.length() > 0)
		{
			sb.append(" ext: ");
			sb.append(this.extension);
		}

		return sb.toString();
	}

	public String getArea()
	{
		return area;
	}

	public void setArea(String area)
	{
		this.area = area;
	}

	public String getExchange()
	{
		return exchange;
	}

	public void setExchange(String exchange)
	{
		this.exchange = exchange;
	}

	public String getSuffix()
	{
		return suffix;
	}

	public void setSuffix(String suffix)
	{
		this.suffix = suffix;
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
