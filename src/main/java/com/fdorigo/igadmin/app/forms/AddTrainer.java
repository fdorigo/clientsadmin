package com.fdorigo.igadmin.app.forms;

import java.util.ArrayList;
import java.util.List;

import org.apache.cayenne.access.DataContext;
import org.apache.log4j.Logger;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import com.fdorigo.igadmin.app.forms.utils.FormUtils;
import com.fdorigo.igadmin.app.forms.utils.StateSelectOption;
import com.fdorigo.igadmin.model.DatabaseBridge;
import com.fdorigo.igadmin.persistent.Phone;
import com.fdorigo.igadmin.persistent.Trainer;

public class AddTrainer extends Panel
{
	private static final long serialVersionUID = -2334745566004580326L;
	private static final Logger LOG = Logger.getLogger(AddTrainer.class);
	private final Trainer trainerModel;
	private final DataContext context = DatabaseBridge.getContext();
	
	private StateSelectOption selectedState;

	public AddTrainer(String panelId)
	{
		super(panelId);
		trainerModel = context.newObject(Trainer.class);
		initComponents();
	}

	private void initComponents()
	{
		final Model<String> modelPriPhArea = new Model<String>("");
		final Model<String> modelPriPhExchange = new Model<String>("");
		final Model<String> modelPriPhSuffix = new Model<String>("");
		final Model<String> modelPriPhExtension = new Model<String>("ext");

		final Model<String> modelSecPhArea = new Model<String>("");
		final Model<String> modelSecPhExchange = new Model<String>("");
		final Model<String> modelSecPhSuffix = new Model<String>("");
		final Model<String> modelSecPhExtension = new Model<String>("ext");

		final List<StateSelectOption> listOfStates = new ArrayList<StateSelectOption>();

		FormUtils.initStateList(listOfStates);

		final IModel<List<StateSelectOption>> stateChoiceModel = new AbstractReadOnlyModel<List<StateSelectOption>>() {
			private static final long serialVersionUID = 1L;

			@Override
			public List<StateSelectOption> getObject()
			{
				return listOfStates;
			}
		};

		Form<Trainer> form = new Form<Trainer>("form", new CompoundPropertyModel<Trainer>(trainerModel)) {
			private static final long serialVersionUID = 1617572834759513718L;

			@Override
			protected void onSubmit()
			{
				Phone primary = new Phone(modelPriPhArea.getObject(), modelPriPhExchange.getObject(), modelPriPhSuffix.getObject(), modelPriPhExtension.getObject());
				Phone secondary = new Phone(modelSecPhArea.getObject(), modelSecPhExchange.getObject(), modelSecPhSuffix.getObject(), modelSecPhExtension.getObject());

				trainerModel.setPrimary(primary);
				trainerModel.setSecondary(secondary);
				trainerModel.setPhonePrimary(primary.getDbString());
				trainerModel.setPhoneSecondary(secondary.getDbString());
				trainerModel.setCompRate(50);
				trainerModel.setAddressState(selectedState.getKey());

				LOG.debug(trainerModel.toString());

				context.commitChanges();
			}
		};

		add(form);

		TextField<String> nameFirst = new TextField<String>(Trainer.NAME_FIRST_PROPERTY);
		form.add(nameFirst.add(new AttributeModifier("onFocus", "clearFormField(this);")));
		TextField<String> nameMiddle = new TextField<String>(Trainer.NAME_MIDDLE_PROPERTY);
		form.add(nameMiddle.add(new AttributeModifier("onFocus", "clearFormField(this);")));
		TextField<String> nameLast = new TextField<String>(Trainer.NAME_LAST_PROPERTY);
		form.add(nameLast.add(new AttributeModifier("onFocus", "clearFormField(this);")));

		TextField<String> priPhArea = new TextField<String>("priPhArea", modelPriPhArea);
		form.add(priPhArea.add(new AttributeModifier("onFocus", "clearFormField(this);")));
		TextField<String> priPhExchange = new TextField<String>("priPhExchange", modelPriPhExchange);
		form.add(priPhExchange.add(new AttributeModifier("onFocus", "clearFormField(this);")));
		TextField<String> priPhSuffix = new TextField<String>("priPhSuffix", modelPriPhSuffix);
		form.add(priPhSuffix.add(new AttributeModifier("onFocus", "clearFormField(this);")));
		TextField<String> priPhExtension = new TextField<String>("priPhExtension", modelPriPhExtension);
		form.add(priPhExtension.add(new AttributeModifier("onFocus", "clearFormField(this);")));

		TextField<String> secPhArea = new TextField<String>("secPhArea", modelSecPhArea);
		form.add(secPhArea.add(new AttributeModifier("onFocus", "clearFormField(this);")));
		TextField<String> secPhExchange = new TextField<String>("secPhExchange", modelSecPhExchange);
		form.add(secPhExchange.add(new AttributeModifier("onFocus", "clearFormField(this);")));
		TextField<String> secPhSuffix = new TextField<String>("secPhSuffix", modelSecPhSuffix);
		form.add(secPhSuffix.add(new AttributeModifier("onFocus", "clearFormField(this);")));
		TextField<String> secPhExtension = new TextField<String>("secPhExtension", modelSecPhExtension);
		form.add(secPhExtension.add(new AttributeModifier("onFocus", "clearFormField(this);")));

		TextField<String> addrNum = new TextField<String>(Trainer.ADDRESS_NUM_PROPERTY);
		form.add(addrNum.add(new AttributeModifier("onFocus", "clearFormField(this);")));
		TextField<String> addrStreet = new TextField<String>(Trainer.ADDRESS_STREET_PROPERTY);
		form.add(addrStreet.add(new AttributeModifier("onFocus", "clearFormField(this);")));
		TextField<String> addrApt = new TextField<String>(Trainer.ADDRESS_APT_PROPERTY);
		form.add(addrApt.add(new AttributeModifier("onFocus", "clearFormField(this);")));
		TextField<String> addrCity = new TextField<String>(Trainer.ADDRESS_CITY_PROPERTY);
		form.add(addrCity.add(new AttributeModifier("onFocus", "clearFormField(this);")));

		ChoiceRenderer<StateSelectOption> choiceRenderer = new ChoiceRenderer<StateSelectOption>("value", "key");
		DropDownChoice<StateSelectOption> fieldState = new DropDownChoice<StateSelectOption>(Trainer.ADDRESS_STATE_PROPERTY,  new PropertyModel<StateSelectOption>(this, "selectedState"), stateChoiceModel, choiceRenderer);
		form.add(fieldState.add(new AttributeModifier("onFocus", "clearFormField(this);")));

		TextField<String> addrZip = new TextField<String>(Trainer.ADDRESS_ZIP_PROPERTY);
		form.add(addrZip.add(new AttributeModifier("onFocus", "clearFormField(this);")));

		EmailTextField email = new EmailTextField(Trainer.EMAIL_ADDRESS_PROPERTY);
		form.add(email.add(new AttributeModifier("onFocus", "clearFormField(this);")));

		TextField<Integer> payRate = new TextField<Integer>(Trainer.COMP_RATE_PROPERTY);
		form.add(payRate.add(new AttributeModifier("onFocus", "clearFormField(this);")));
	}
	
	public StateSelectOption getSelectedState()
	{
		return selectedState;
	}

	public void setSelectedState(StateSelectOption selectedState)
	{
		this.selectedState = selectedState;
	}
}
