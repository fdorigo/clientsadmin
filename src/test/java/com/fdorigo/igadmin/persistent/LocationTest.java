package com.fdorigo.igadmin.persistent;

import static org.junit.Assert.fail;
import static org.junit.Assert.*;

import org.apache.cayenne.access.DataContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fdorigo.igadmin.model.DatabaseBridge;

public class LocationTest
{
	private static DataContext context;
	private static Address address;
	private static Location location;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		context = DatabaseBridge.getContext();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		//context.rollbackChanges();
	}

	@Before
	public void setUp() throws Exception
	{
		address = new Address("667755", "Jackson Street", "405", "Denver", "CO", "80206");
		location = context.newObject(Location.class);
	}

	@After
	public void tearDown() throws Exception
	{
		address = null;
		location = null;
	}

	@Test
	public void testGetAddress()
	{
		location.setAddress(address);
		context.commitChanges();
		
		Address a = location.getAddress();
		assertEquals(a, address);
	}

	@Test
	public void testSetAddress()
	{
		location.setAddress(address);
		context.commitChanges();
		
		Address a = location.getAddress();
		assertEquals(a, address);
	}

	@Test
	public void testSetAddressApt()
	{
		location.setAddressApt(address.getStreetApt());
		context.commitChanges();
		
		String apt = location.getAddressApt();
		assertEquals(apt, address.getStreetApt());
	}

	@Test
	public void testGetAddressApt()
	{
		location.setAddressApt(address.getStreetApt());
		context.commitChanges();
		
		String apt = location.getAddressApt();
		assertEquals(apt, address.getStreetApt());
	}

	@Test
	public void testSetAddressCity()
	{
		location.setAddressCity(address.getCity());
		context.commitChanges();
		
		String apt = location.getAddressCity();
		assertEquals(apt, address.getCity());
	}

	@Test
	public void testGetAddressCity()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSetAddressNum()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetAddressNum()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSetAddressState()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetAddressState()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSetAddressStreet()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetAddressStreet()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSetAddressZip()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetAddressZip()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSetMgrNameFirst()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetMgrNameFirst()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSetMgrNameLast()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetMgrNameLast()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSetName()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetName()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSetOpeningDate()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetOpeningDate()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSetPhonePrimary()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetPhonePrimary()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSetPhoneSecondary()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetPhoneSecondary()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSetTrainerId()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetTrainerId()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testAddToClients()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveFromClients()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetClients()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSetToTrainer()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetToTrainer()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testAddToTrainers()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveFromTrainers()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetTrainers()
	{
		fail("Not yet implemented");
	}

}
