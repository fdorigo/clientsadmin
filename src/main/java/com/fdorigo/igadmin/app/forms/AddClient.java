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
import org.apache.wicket.model.PropertyModel;

import com.fdorigo.igadmin.app.forms.utils.FormUtils;
import com.fdorigo.igadmin.app.forms.utils.StateSelectOption;
import com.fdorigo.igadmin.model.DatabaseBridge;
import com.fdorigo.igadmin.persistent.Client;
import com.fdorigo.igadmin.persistent.utils.DBUtils;

public class AddClient extends Panel
{
	private static final long serialVersionUID = 8452012594546761540L;
	private static final Logger LOG = Logger.getLogger(AddClient.class);
	private final Client clientModel;
	private final DataContext context = DatabaseBridge.getContext();
	private StateSelectOption selectedState;
	private final List<StateSelectOption> listOfStates = new ArrayList<StateSelectOption>();


	public AddClient(String panelId)
	{
		super(panelId);
		clientModel = context.newObject(Client.class);

		clientModel.setNameFirst("First");
		clientModel.setNameMiddle("Middle");
		clientModel.setNameLast("Last");
		clientModel.setAddressStreet("eg. 675 Sunset Blvd, #201");
		clientModel.setAddressCity("City");
		clientModel.setAddressZip("ZIP");

		initComponents();
	}
	
	private void initComponents()
	{
		add(new FeedbackPanel("feedback"));
		
		Form<Client> form = new Form<Client>("form", new CompoundPropertyModel<Client>(clientModel)) {
			private static final long serialVersionUID = 1617572834759513718L;

			@Override
			protected void onSubmit()
			{
				clientModel.setAddressState(selectedState.getKey());

				LOG.debug(clientModel.toString());

				if (DBUtils.get().<Client>isNew(clientModel))
				{
					context.commitChanges();
				}
			}
		};

		add(form);

		initNameFields(form);
		initAddressFields(form);
		initPhoneFields(form);
	}

	private void initNameFields(final Form<Client> form)
	{
		final TextField<String> nameFirst = new TextField<String>(Client.NAME_FIRST_PROPERTY);
		form.add(nameFirst.add(new AttributeModifier("onFocus", "clearFormField(this);")));

		final TextField<String> nameMiddle = new TextField<String>(Client.NAME_MIDDLE_PROPERTY);
		form.add(nameMiddle.add(new AttributeModifier("onFocus", "clearFormField(this);")));
		
		final TextField<String> nameLast = new TextField<String>(Client.NAME_LAST_PROPERTY);
		form.add(nameLast.add(new AttributeModifier("onFocus", "clearFormField(this);")));
	}

	private void initPhoneFields(final Form<Client> form)
	{
		final TextField<String> priPhNubmer = new TextField<String>(Client.PHONE_PRIMARY_PROPERTY);
		form.add(priPhNubmer);
		priPhNubmer.add(new AttributeModifier("onFocus", "clearFormField(this);"));
		priPhNubmer.add(new AttributeModifier("onChange", "formatPhone(this);"));

		final TextField<String> secPhNumber = new TextField<String>(Client.PHONE_SECONDARY_PROPERTY);
		form.add(secPhNumber);
		secPhNumber.add(new AttributeModifier("onFocus", "clearFormField(this);"));
		secPhNumber.add(new AttributeModifier("onChange", "formatPhone(this);"));
	}

	private void initAddressFields(final Form<Client> form)
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

		TextField<String> addrStreet = new TextField<String>(Client.ADDRESS_STREET_PROPERTY);
		form.add(addrStreet.add(new AttributeModifier("onFocus", "clearFormField(this);")));
		TextField<String> addrCity = new TextField<String>(Client.ADDRESS_CITY_PROPERTY);
		form.add(addrCity.add(new AttributeModifier("onFocus", "clearFormField(this);")));

		ChoiceRenderer<StateSelectOption> choiceRenderer = new ChoiceRenderer<StateSelectOption>("value", "key");
		DropDownChoice<StateSelectOption> fieldState = new DropDownChoice<StateSelectOption>(Client.ADDRESS_STATE_PROPERTY,  new PropertyModel<StateSelectOption>(this, "selectedState"), stateChoiceModel, choiceRenderer);
		form.add(fieldState.add(new AttributeModifier("onFocus", "clearFormField(this);")));
		fieldState.setRequired(true);

		TextField<String> addrZip = new TextField<String>(Client.ADDRESS_ZIP_PROPERTY);
		form.add(addrZip.add(new AttributeModifier("onFocus", "clearFormField(this);")));

		EmailTextField email = new EmailTextField(Client.EMAIL_ADDRESS_PROPERTY);
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
