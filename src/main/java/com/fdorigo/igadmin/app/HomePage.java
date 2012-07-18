package com.fdorigo.igadmin.app;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.extensions.ajax.markup.html.tabs.AjaxTabbedPanel;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.eclipse.jetty.util.log.Log;

import com.fdorigo.igadmin.app.auth.LoginPage;
import com.fdorigo.igadmin.app.auth.LogoutPage;
import com.fdorigo.igadmin.app.forms.AddClient;
import com.fdorigo.igadmin.app.forms.AddLocation;
import com.fdorigo.igadmin.app.forms.AddTrainer;

@AuthorizeInstantiation("ADMIN")
public class HomePage extends BasePage 
{
	private static final Logger LOG = Logger.getLogger(HomePage.class);
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters)
	{
		LOG.debug("Building Home Page");
		initComponents();
	}

	private void initComponents()
	{
		AjaxTabbedPanel<ITab> tabbedPanel = new AjaxTabbedPanel<ITab>("tabbedPanel", getTabList());
		add(tabbedPanel);

		add(new Link<Void>("login") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick()
			{
				setResponsePage(LoginPage.class);
			}
		});

		add(new Link<Void>("logout") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick()
			{
				setResponsePage(LogoutPage.class);
			}
		});
	}

	private List<ITab> getTabList()
	{
		List<ITab> tabs = new ArrayList<ITab>();

		tabs.add(new AbstractTab(new Model<String>("Add Location")) {
			private static final long serialVersionUID = 1L;

			@Override
			public WebMarkupContainer getPanel(String panelId)
			{
				return new AddLocation(panelId);
			}
		});

		tabs.add(new AbstractTab(new Model<String>("Add Trainer")) {
			private static final long serialVersionUID = 1L;

			@Override
			public WebMarkupContainer getPanel(String panelId)
			{
				return new AddTrainer(panelId);
			}
		});

		tabs.add(new AbstractTab(new Model<String>("Add Client")) {
			private static final long serialVersionUID = 1L;

			@Override
			public WebMarkupContainer getPanel(String panelId)
			{
				return new AddClient(panelId);
			}
		});

		return tabs;
	}

}
