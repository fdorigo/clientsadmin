package com.fdorigo.igadmin.app;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.extensions.ajax.markup.html.tabs.AjaxTabbedPanel;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.fdorigo.igadmin.app.forms.AddClient;
import com.fdorigo.igadmin.app.forms.AddLocation;
import com.fdorigo.igadmin.app.forms.AddTrainer;

public class HomePage extends BasePage
{
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters)
	{
		initComponents();
	}

	private void initComponents()
	{
		AjaxTabbedPanel tabbedPanel = new AjaxTabbedPanel("tabbedPanel", getTabList());
		add(tabbedPanel);
	}

	private List<ITab> getTabList()
	{
		List<ITab> tabs = new ArrayList<ITab>();

		tabs.add(new AbstractTab(new Model<String>("Add Location")) 
		{
			private static final long serialVersionUID = 1L;

			@Override
			public WebMarkupContainer getPanel(String panelId)
			{
				return new AddLocation(panelId);
			}
		});

		tabs.add(new AbstractTab(new Model<String>("Add Trainer")) 
		{
			private static final long serialVersionUID = 1L;

			@Override
			public WebMarkupContainer getPanel(String panelId)
			{
				return new AddTrainer(panelId);
			}
		});

		tabs.add(new AbstractTab(new Model<String>("Add Client")) 
		{
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
