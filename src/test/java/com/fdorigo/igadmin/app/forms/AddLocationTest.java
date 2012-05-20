package com.fdorigo.igadmin.app.forms;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

import com.fdorigo.igadmin.app.HomePage;
import com.fdorigo.igadmin.app.WicketApplication;

public class AddLocationTest
{
	private WicketTester tester;

	@Before
	public void setUp()
	{
		tester = new WicketTester(new WicketApplication());
	}

	@Test
	public void testBasicRender()
	{
		tester.startPage(HomePage.class);
		tester.assertRenderedPage(HomePage.class);
	}
}
