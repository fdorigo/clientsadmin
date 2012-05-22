package com.fdorigo.igadmin.app.forms.validator;

import java.util.List;

import org.apache.cayenne.access.DataContext;
import org.apache.cayenne.query.SelectQuery;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

import com.fdorigo.igadmin.model.DatabaseBridge;
import com.fdorigo.igadmin.persistent.Location;

public class LocationValidator implements IValidator<Location>
{
	private static final long serialVersionUID = -2326864208976977346L;

	@SuppressWarnings("unchecked")
	public void validate(IValidatable<Location> validatable)
	{
		final DataContext context = DatabaseBridge.getContext();
		final SelectQuery query = new SelectQuery(Location.class);
		final List<Location> locations = context.performQuery(query);

		for (Location l : locations)
		{
			if (l.equals((Location) validatable))
			{
				error(validatable, "This location already exists in the database");
			}
		}
	}

	private void error(IValidatable<Location> validatable, String errorKey)
	{
		ValidationError error = new ValidationError();
		error.addMessageKey(getClass().getSimpleName() + "." + errorKey);
		validatable.error(error);
	}
}
