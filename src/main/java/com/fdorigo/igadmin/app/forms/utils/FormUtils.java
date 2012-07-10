package com.fdorigo.igadmin.app.forms.utils;

import java.util.List;

import org.apache.cayenne.DataObjectUtils;
import org.apache.cayenne.access.DataContext;
import org.apache.cayenne.exp.ExpressionFactory;
import org.apache.cayenne.exp.ExpressionParameter;
import org.apache.cayenne.query.SelectQuery;

import com.fdorigo.igadmin.model.DatabaseBridge;
import com.fdorigo.igadmin.persistent.Client;
import com.fdorigo.igadmin.persistent.Location;
import com.fdorigo.igadmin.persistent.Trainer;

public class FormUtils
{
	@SuppressWarnings("unchecked")
	public static void initTrainerList(List<Trainer> trainers, String location)
	{
		DataContext context = DatabaseBridge.getContext();

		SelectQuery query = new SelectQuery(Trainer.class,
				ExpressionFactory.matchExp(location, new ExpressionParameter(
						Trainer.LOCATION_PROPERTY)));
		
		trainers = (List<Trainer>)context.performQuery(query);
	}

	public static void initLocationList(List<LocationSelectOption> locationList, List<Location> locations)
	{
		for (Location l : locations)
		{
			locationList.add(new LocationSelectOption(l.getName(), l.getName()));
		}
	}
	
	public static void initClientList(List<ClientSelectOption> clientList, List<Client> clients)
	{
		for (Client c : clients)
		{
			clientList.add(new ClientSelectOption(DataObjectUtils.intPKForObject(c), c.getName()));
		}
	}
	
	public static void initStateList(List<StateSelectOption> states)
	{
		states.add(new StateSelectOption("AL", "Alabama"));
		states.add(new StateSelectOption("AK", "Alaska"));
		states.add(new StateSelectOption("AZ", "Arizona"));
		states.add(new StateSelectOption("AR", "Arkansas"));
		states.add(new StateSelectOption("CA", "California"));
		states.add(new StateSelectOption("CO", "Colorado"));
		states.add(new StateSelectOption("CT", "Connecticut"));
		states.add(new StateSelectOption("DE", "Delaware"));
		states.add(new StateSelectOption("DC", "District of Columbia"));
		states.add(new StateSelectOption("FL", "Florida"));
		states.add(new StateSelectOption("GA", "Georgia"));
		states.add(new StateSelectOption("HI", "Hawaii"));
		states.add(new StateSelectOption("ID", "Idaho"));
		states.add(new StateSelectOption("IL", "Illinois"));
		states.add(new StateSelectOption("IN", "Indiana"));
		states.add(new StateSelectOption("IA", "Iowa"));
		states.add(new StateSelectOption("KS", "Kansas"));
		states.add(new StateSelectOption("KY", "Kentucky"));
		states.add(new StateSelectOption("LA", "Louisiana"));
		states.add(new StateSelectOption("ME", "Maine"));
		states.add(new StateSelectOption("MD", "Maryland"));
		states.add(new StateSelectOption("MA", "Massachusetts"));
		states.add(new StateSelectOption("MI", "Michigan"));
		states.add(new StateSelectOption("MN", "Minnesota"));
		states.add(new StateSelectOption("MS", "Mississippi"));
		states.add(new StateSelectOption("MO", "Missouri"));
		states.add(new StateSelectOption("MT", "Montana"));
		states.add(new StateSelectOption("NE", "Nebraska"));
		states.add(new StateSelectOption("NV", "Nevada"));
		states.add(new StateSelectOption("NH", "New Hempshire"));
		states.add(new StateSelectOption("NJ", "New Jersey"));
		states.add(new StateSelectOption("NM", "New Mexico"));
		states.add(new StateSelectOption("NY", "New York"));
		states.add(new StateSelectOption("NC", "North Carolina"));
		states.add(new StateSelectOption("ND", "North Dakota"));
		states.add(new StateSelectOption("OH", "Ohio"));
		states.add(new StateSelectOption("OK", "Oklahoma"));
		states.add(new StateSelectOption("OR", "Oregon"));
		states.add(new StateSelectOption("PA", "Pennsylvania"));
		states.add(new StateSelectOption("RI", "Rhode Island"));
		states.add(new StateSelectOption("SC", "South Carolina"));
		states.add(new StateSelectOption("SD", "South Dakota"));
		states.add(new StateSelectOption("TN", "Tennessee"));
		states.add(new StateSelectOption("TX", "Texas"));
		states.add(new StateSelectOption("UT", "Utah"));
		states.add(new StateSelectOption("VT", "Vermont"));
		states.add(new StateSelectOption("VA", "Virginia"));
		states.add(new StateSelectOption("WA", "Washington"));
		states.add(new StateSelectOption("WV", "West Virginia"));
		states.add(new StateSelectOption("WI", "Wisconsin"));
		states.add(new StateSelectOption("WY", "Wyoming"));
	}
}
