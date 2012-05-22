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
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.validation.validator.MaximumValidator;
import org.apache.wicket.validation.validator.MinimumValidator;

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
	private final List<StateSelectOption> listOfStates = new ArrayList<StateSelectOption>();

	public AddTrainer(String panelId)
	{
		super(panelId);
		trainerModel = context.newObject(Trainer.class);
		trainerModel.setNameFirst("First");
		trainerModel.setNameMiddle("Middle");
		trainerModel.setNameLast("Last");
		trainerModel.setAddressStreet("eg. 675 Sunset Blvd, #201");
		trainerModel.setAddressCity("City");
		trainerModel.setAddressZip("ZIP");
		initComponents();
	}

	private void initComponents()
	{
		add(new FeedbackPanel("feedback"));
		
		Form<Trainer> form = new Form<Trainer>("form", new CompoundPropertyModel<Trainer>(trainerModel)) {
			private static final long serialVersionUID = 1617572834759513718L;

			@Override
			protected void onSubmit()
			{
				trainerModel.setAddressState(selectedState.getKey());

				LOG.debug(trainerModel.toString());

				context.commitChanges();
			}
		};

		add(form);
		
		initNameFields(form);
		initPhoneFields(form);
		initAddressFields(form);

		TextField<Integer> payRate = new TextField<Integer>(Trainer.COMP_RATE_PROPERTY);
		form.add(payRate);
		payRate.setRequired(true);
		payRate.add(new AttributeModifier("onFocus", "clearFormField(this);"));
		payRate.add(new MinimumValidator<Integer>(0));
		payRate.add(new MaximumValidator<Integer>(100));
		
	}
	
	private void initNameFields(final Form<Trainer> form)
	{
		final TextField<String> nameFirst = new TextField<String>(Trainer.NAME_FIRST_PROPERTY);
		form.add(nameFirst.add(new AttributeModifier("onFocus", "clearFormField(this);")));

		final TextField<String> nameMiddle = new TextField<String>(Trainer.NAME_MIDDLE_PROPERTY);
		form.add(nameMiddle.add(new AttributeModifier("onFocus", "clearFormField(this);")));
		
		final TextField<String> nameLast = new TextField<String>(Trainer.NAME_LAST_PROPERTY);
		form.add(nameLast.add(new AttributeModifier("onFocus", "clearFormField(this);")));
	}
	
	private void initPhoneFields(final Form<Trainer> form)
	{
		final TextField<String> priPhNubmer = new TextField<String>(Trainer.PHONE_PRIMARY_PROPERTY);
		form.add(priPhNubmer);
		priPhNubmer.add(new AttributeModifier("onFocus", "clearFormField(this);"));
		priPhNubmer.add(new AttributeModifier("onChange", "formatPhone(this);"));

		final TextField<String> secPhNumber = new TextField<String>(Trainer.PHONE_SECONDARY_PROPERTY);
		form.add(secPhNumber);
		secPhNumber.add(new AttributeModifier("onFocus", "clearFormField(this);"));
		secPhNumber.add(new AttributeModifier("onChange", "formatPhone(this);"));
	}

	private void initAddressFields(final Form<Trainer> form)
	{
		FormUtils.initStateList(listOfStates);

		final IModel<List<StateSelectOption>> stateChoiceModel = new AbstractReadOnlyModel<List<StateSelectOption>>() {
			private static final long serialVersionUID = 1L;

			@Override
			public List<StateSelectOption> getObject()
			{
				return listOfStates;
			}
		};

		TextField<String> addrStreet = new TextField<String>(Trainer.ADDRESS_STREET_PROPERTY);
		form.add(addrStreet.add(new AttributeModifier("onFocus", "clearFormField(this);")));
		TextField<String> addrCity = new TextField<String>(Trainer.ADDRESS_CITY_PROPERTY);
		form.add(addrCity.add(new AttributeModifier("onFocus", "clearFormField(this);")));

		ChoiceRenderer<StateSelectOption> choiceRenderer = new ChoiceRenderer<StateSelectOption>("value", "key");
		DropDownChoice<StateSelectOption> fieldState = new DropDownChoice<StateSelectOption>(Trainer.ADDRESS_STATE_PROPERTY,  new PropertyModel<StateSelectOption>(this, "selectedState"), stateChoiceModel, choiceRenderer);
		form.add(fieldState.add(new AttributeModifier("onFocus", "clearFormField(this);")));
		fieldState.setRequired(true);

		TextField<String> addrZip = new TextField<String>(Trainer.ADDRESS_ZIP_PROPERTY);
		form.add(addrZip.add(new AttributeModifier("onFocus", "clearFormField(this);")));

		EmailTextField email = new EmailTextField(Trainer.EMAIL_ADDRESS_PROPERTY);
		form.add(email.add(new AttributeModifier("onFocus", "clearFormField(this);")));
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
