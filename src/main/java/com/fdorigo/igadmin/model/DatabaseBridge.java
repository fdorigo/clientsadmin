package com.fdorigo.igadmin.model;

import org.apache.cayenne.BaseContext;
import org.apache.cayenne.access.DataContext;

public class DatabaseBridge
{
	public static DataContext getContext() 
	{
				
		BaseContext.bindThreadObjectContext(DataContext.createDataContext());
		
		((DataContext)BaseContext.getThreadObjectContext()).getEventManager().isSingleThreaded();
		//((DataContext)BaseContext.getThreadObjectContext()).
		return (DataContext) BaseContext.getThreadObjectContext();
	}
}
