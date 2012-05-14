package com.fdorigo.igadmin.interfaces;

import java.util.Date;

public interface IClient 
{
	public void setBirthDate(Date d);
	public Date getBirthDate();
	
	public void setJoinDate(Date d);
	public Date getJoinDate();
}
