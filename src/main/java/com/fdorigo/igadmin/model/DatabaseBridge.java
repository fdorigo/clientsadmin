package com.fdorigo.igadmin.model;

import org.apache.cayenne.BaseContext;
import org.apache.cayenne.access.DataContext;

public class DatabaseBridge
{
	public static DataContext getContext() 
	{
		BaseContext.bindThreadObjectContext(DataContext.createDataContext());
		return (DataContext) BaseContext.getThreadObjectContext();
	}
}
