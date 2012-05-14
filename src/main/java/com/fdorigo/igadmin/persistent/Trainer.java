package com.fdorigo.igadmin.persistent;

import com.fdorigo.igadmin.persistent.auto._Trainer;

public class Trainer extends _Trainer {
	
	public String getName()
	{
		return super.getNameFirst() + " " + super.getNameLast();
	}

}
