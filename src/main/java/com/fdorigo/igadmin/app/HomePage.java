package com.fdorigo.igadmin.app;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.access.DataContext;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.fdorigo.igadmin.persistent.Client;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

    public HomePage(final PageParameters parameters) {
    	
    	ObjectContext context = DataContext.createDataContext();
    	
    	Client c = context.newObject(Client.class);
    	c.setNameFirst("Pablo");
    	context.commitChanges();
    	
		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
        // TODO Add your page's components here
    }
}
