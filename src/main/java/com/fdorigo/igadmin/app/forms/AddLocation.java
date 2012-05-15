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
		final Model<String> modelName = new Model<String>("Location Name");

		final Model<String> modelNum = new Model<String>("Street #");
		final Model<String> modelStreet = new Model<String>("Street Name");
		final Model<String> modelApt = new Model<String>("Unit #");
		final Model<String> modelCity = new Model<String>("City");
		final Model<String> modelZip = new Model<String>("ZIP");
		
		final Model<String> modelMgrNameFirst = new Model<String>("First Name");
		final Model<String> modelMgrNameLast = new Model<String>("Last Name");

		final Model<String> modelPriPhArea = new Model<String>("123");
		final Model<String> modelPriPhExchange = new Model<String>("123");
		final Model<String> modelPriPhSuffix = new Model<String>("1234");
		final Model<String> modelPriPhExtension = new Model<String>("ext");

		final Model<String> modelSecPhArea = new Model<String>("123");
		final Model<String> modelSecPhExchange = new Model<String>("123");
		final Model<String> modelSecPhSuffix = new Model<String>("1234");
		final Model<String> modelSecPhExtension = new Model<String>("ext");

		
		final List<StateSelectOption> listOfStates = new ArrayList<StateSelectOption>();
		
		FormUtils.initStateList(listOfStates);

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

		//Location Name
		TextField<String> field = new TextField<String>("locName", modelName);
		form.add(field.add(new AttributeModifier("onFocus", "clearMe(this);")));
		
		//Contact Information
		TextField<String> fieldMgrFirst = new TextField<String>("mgrNameFirst",
				modelMgrNameFirst);
		form.add(fieldMgrFirst
				.add(new AttributeModifier("onFocus", "clearMe(this);")));

		TextField<String> fieldMgrLast = new TextField<String>("mgrNameLast",
				modelMgrNameLast);
		form.add(fieldMgrLast
				.add(new AttributeModifier("onFocus", "clearMe(this);")));

		TextField<String> priPhArea = new TextField<String>("priPhArea",
				modelPriPhArea);
		form.add(priPhArea
				.add(new AttributeModifier("onFocus", "clearMe(this);")));

		TextField<String> priPhExchange = new TextField<String>("priPhExchange",
				modelPriPhExchange);
		form.add(priPhExchange
				.add(new AttributeModifier("onFocus", "clearMe(this);")));

		TextField<String> priPhSuffix = new TextField<String>("priPhSuffix",
				modelPriPhSuffix);
		form.add(priPhSuffix
				.add(new AttributeModifier("onFocus", "clearMe(this);")));

		TextField<String> priPhExtension = new TextField<String>("priPhExtension",
				modelPriPhExtension);
		form.add(priPhExtension
				.add(new AttributeModifier("onFocus", "clearMe(this);")));

		TextField<String> secPhArea = new TextField<String>("secPhArea",
				modelSecPhArea);
		form.add(secPhArea
				.add(new AttributeModifier("onFocus", "clearMe(this);")));

		TextField<String> secPhExchange = new TextField<String>("secPhExchange",
				modelSecPhExchange);
		form.add(secPhExchange
				.add(new AttributeModifier("onFocus", "clearMe(this);")));

		TextField<String> secPhSuffix = new TextField<String>("secPhSuffix",
				modelSecPhSuffix);
		form.add(secPhSuffix
				.add(new AttributeModifier("onFocus", "clearMe(this);")));

		TextField<String> secPhExtension = new TextField<String>("secPhExtension",
				modelSecPhExtension);
		form.add(secPhExtension
				.add(new AttributeModifier("onFocus", "clearMe(this);")));

		//Address
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
}
