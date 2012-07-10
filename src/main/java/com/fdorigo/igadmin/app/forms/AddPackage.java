package com.fdorigo.igadmin.app.forms;

import java.util.ArrayList;
import java.util.List;

import org.apache.cayenne.DataObjectUtils;
import org.apache.cayenne.access.DataContext;
import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;

import com.fdorigo.igadmin.app.forms.utils.ClientSelectOption;
import com.fdorigo.igadmin.model.DatabaseBridge;
import com.fdorigo.igadmin.persistent.Client;
import com.fdorigo.igadmin.persistent.Package;
import com.fdorigo.igadmin.persistent.utils.DBUtils;

public class AddPackage extends Panel
{
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(AddClient.class);

	private static final long serialVersionUID = -2525099796767054006L;

	private final DataContext context = DatabaseBridge.getContext();

	private Package packageModel;
	
	private ClientSelectOption selectedClient;
	
	private List<Client> listOfClients = new ArrayList<Client>();

	public AddPackage(String id)
	{
		super(id);
		packageModel = context.newObject(Package.class);
		initComponents();
	}

	private void initComponents()
	{
		add(new FeedbackPanel("feedback"));

		Form<Package> form = new Form<Package>("form", new CompoundPropertyModel<Package>(packageModel)) 
		{
			private static final long serialVersionUID = 1617572834759513718L;

			@Override
			protected void onSubmit()
			{
				Client c = DataObjectUtils.objectForPK(context, Client.class, selectedClient.getKey());
				
				if (c != null)
				{
					LOG.debug("Adding package for client: " + c);
					packageModel.setClient(c);
				}
				
				LOG.debug(packageModel.toString());

				if (DBUtils.get().<Package> isNew(packageModel))
				{
					context.commitChanges();
				}
			}
		};

		add(form);

		// initNameFields(form);
		// initAddressFields(form);
		// initPhoneFields(form);
	}

	public ClientSelectOption getSelectedClient()
	{
		return selectedClient;
	}

	public void setSelectedClient(ClientSelectOption selectedClient)
	{
		this.selectedClient = selectedClient;
	}

}
