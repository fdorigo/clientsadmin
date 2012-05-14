package com.fdorigo.igadmin.model;

import org.apache.cayenne.BaseContext;
import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.DataObjectUtils;
import org.apache.cayenne.ObjectId;
import org.apache.cayenne.access.DataContext;
import org.apache.wicket.model.LoadableDetachableModel;

public class CayenneModel<T> extends LoadableDetachableModel<T>
{
	private static final long serialVersionUID = -241560092223787238L;
	private ObjectId id;

	public CayenneModel(T cayObj)
	{
		super(cayObj);
		this.id = ((CayenneDataObject) cayObj).getObjectId();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected T load()
	{
		if (id == null)
		{
			return null;
		}
		
		return (T) DataObjectUtils.objectForPK(
				(DataContext) BaseContext.getThreadObjectContext(), id);
	}

	@Override
	public void detach()
	{
		super.detach();
	}
}
