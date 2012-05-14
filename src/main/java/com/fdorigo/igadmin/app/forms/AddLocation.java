package com.fdorigo.igadmin.app.forms;

import java.util.ArrayList;
import java.util.List;

import org.apache.cayenne.access.DataContext;
import org.apache.log4j.Logger;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import com.fdorigo.igadmin.app.BasePage;
import com.fdorigo.igadmin.model.DatabaseBridge;
import com.fdorigo.igadmin.model.StateSelectOption;
import com.fdorigo.igadmin.persistent.Address;
import com.fdorigo.igadmin.persistent.Location;

public class AddLocation extends BasePage
{
	private static final long serialVersionUID = 3695907416548135080L;
	private static final Logger LOG = Logger.getLogger(AddLocation.class);
	
	private StateSelectOption selectedState;

	public StateSelectOption getSelectedState()
	{
		return selectedState;
	}

	public void setSelectedState(StateSelectOption selectedState)
	{
		this.selectedState = selectedState;
	}

	public AddLocation()
	{
		init();
	}

	private void init()
	{
		final Model<String> modelName = new Model<String>("choose name");
		final Model<String> modelNum = new Model<String>("street #");
		final Model<String> modelStreet = new Model<String>("street name");
		final Model<String> modelApt = new Model<String>("unit #");
		final Model<String> modelCity = new Model<String>("city");
		//final Model<String> modelState = new Model<String>("state");
		final Model<String> modelZip = new Model<String>("zip");
		
		final List<StateSelectOption> listOfStates = new ArrayList<StateSelectOption>();
		
		initStateList(listOfStates);

		final IModel<List<StateSelectOption>> stateChoiceModel = new AbstractReadOnlyModel<List<StateSelectOption>>() 
		{
			private static final long serialVersionUID = 1L;

			@Override
			public List<StateSelectOption> getObject()
			{
				return listOfStates;
			}
		};

		Form<Void> form = new Form<Void>("form") {
			private static final long serialVersionUID = 709544921769281327L;

			@Override
			protected void onSubmit()
			{
				LOG.debug("AddLocation: " + modelName.getObject());

				Address locAddress = new Address(modelNum.getObject(),
						modelStreet.getObject(), modelApt.getObject(),
						modelCity.getObject(), selectedState.getKey(),
						modelZip.getObject());

				LOG.debug("Saving objcet");
				DataContext context = DatabaseBridge.getContext();
				Location location = context.newObject(Location.class);
				location.setName(modelName.getObject());
				location.setAddress(locAddress);
				context.commitChanges();
				LOG.debug("Done saving object");
			}
		};
		add(form);

		TextField<String> field = new TextField<String>("locName", modelName);
		form.add(field.add(new AttributeModifier("onFocus", "clearMe(this);")));

		TextField<String> fieldNum = new TextField<String>("locAddrNum", modelNum);
		form.add(fieldNum.add(new AttributeModifier("onFocus", "clearMe(this);")));

		TextField<String> fieldStreet = new TextField<String>("locAddrStreet",
				modelStreet);
		form.add(fieldStreet.add(new AttributeModifier("onFocus",
				"clearMe(this);")));

		TextField<String> fieldApt = new TextField<String>("locAddrApt", modelApt);
		form.add(fieldApt.add(new AttributeModifier("onFocus", "clearMe(this);")));

		TextField<String> fieldCity = new TextField<String>("locAddrCity",
				modelCity);
		form.add(fieldCity
				.add(new AttributeModifier("onFocus", "clearMe(this);")));

		ChoiceRenderer<StateSelectOption> choiceRenderer = new ChoiceRenderer<StateSelectOption>("value","key");
		DropDownChoice<StateSelectOption> fieldState = new DropDownChoice<StateSelectOption>(
				"locAddrState", new PropertyModel<StateSelectOption>(this, "selectedState"), stateChoiceModel, choiceRenderer );
		form.add(fieldState
				.add(new AttributeModifier("onFocus", "clearMe(this);")));

		TextField<String> fieldZip = new TextField<String>("locAddrZip", modelZip);
		form.add(fieldZip.add(new AttributeModifier("onFocus", "clearMe(this);")));

	}
	
	
	private void initStateList(List<StateSelectOption> states) 
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
