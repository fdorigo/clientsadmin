package com.fdorigo.igadmin.persistent.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cayenne.access.DataContext;
import org.apache.cayenne.exp.Expression;
import org.apache.cayenne.map.ObjEntity;
import org.apache.cayenne.query.SelectQuery;
import org.apache.log4j.Logger;

import com.fdorigo.igadmin.model.DatabaseBridge;
import com.fdorigo.igadmin.persistent.Location;

public class DBUtils
{
	private static final Logger LOG = Logger.getLogger(DBUtils.class);
	private static final DBUtils INSTANCE = new DBUtils();
	private static final DataContext context = DatabaseBridge.getContext();

	// Private constructor prevents instantiation from other classes.
	private DBUtils()
	{
		LOG.trace("Initializing DBUtils singleton");
	}

	/**
	 * Access the singleton instance.
	 * 
	 * @return The instance of this class.
	 */
	public static DBUtils get()
	{
		return INSTANCE;
	}

	/**
	 * Check to see if the object already exist in the database. This utility
	 * method is called before adding a new entry in the database to avoid
	 * duplicates.
	 * 
	 * @param obj
	 *           the object to check for existence
	 * @return true if the object is new, false otherwise
	 */
	@SuppressWarnings("unchecked")
	public synchronized <T> boolean isNew(T object)
	{
		final SelectQuery query = new SelectQuery((ObjEntity) object);
		final List<T> list = context.performQuery(query);

		for (T item : list)
		{
			if (item.equals(object))
			{
				return false;
			}
		}

		return true;
	}

	/**
	 * Returns a list of all the objects in the database.
	 * 
	 * @param object
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public synchronized <T> List<T> getList(T object)
	{
		final SelectQuery query = new SelectQuery((Class<T>)object.getClass());
		final List<T> list = context.performQuery(query);

		return list;
	}

	/**
	 * Returns a list of all the objects in the database for a given
	 * <code>Location</code>.
	 * 
	 * @param object
	 *           The type of object to look for.
	 * @paran loc The location where these objects resides.
	 * @return A list of objects belonging to the specified location.
	 */
	@SuppressWarnings("unchecked")
	public synchronized <T> List<T> getListByLocation(T object, Location loc)
	{
		final Expression template = Expression.fromString("location = $location");
		final Map<String, Location> params = new HashMap<String, Location>();
		params.put("location", loc);
		final SelectQuery query = new SelectQuery((ObjEntity) object, template.expWithParameters(params));
		final List<T> list = context.performQuery(query);

		return list;
	}
}
