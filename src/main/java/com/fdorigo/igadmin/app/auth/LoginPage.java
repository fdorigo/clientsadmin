package com.fdorigo.igadmin.app.auth;

import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;

import com.fdorigo.igadmin.app.BasePage;
import com.fdorigo.igadmin.app.HomePage;

public class LoginPage extends BasePage
{
	private static final long serialVersionUID = 7656261851135396404L;
	private static final Logger LOG = Logger.getLogger(LoginPage.class);

	private String username;
	private String password;

	public LoginPage()
	{
		add(new FeedbackPanel("feedback"));

		Form<?> form = new Form<Void>("form") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit()
			{
				LOG.debug("Logging in");
				login();
			}
		};
		add(form);

		form.add(new TextField<String>("username", new PropertyModel<String>(this, "username")).setRequired(true));
		form.add(new PasswordTextField("password", new PropertyModel<String>(this, "password")));
	}

	private void login()
	{
		User user = new User(username, password);

		if (user != null)
		{
			if (((AppSession) getSession()).authenticate(username, password))
			{
				// Redirect to home page
				LOG.debug("Succcess, redirect to home");
				setResponsePage(HomePage.class);
			}
			else
			{
				error("Invalid user");
			}
		} 
	}
}
