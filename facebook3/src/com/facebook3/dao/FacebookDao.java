package com.facebook3.dao;

import com.facebook3.entity.FacebookEmployee;

public class FacebookDao implements FacebookDaoInterface {

	
	private FacebookDao() {}
	public static FacebookDaoInterface createDaoObject() {
		return new FacebookDao();
	}
	@Override
	public int createProfile(FacebookEmployee fe) {
		return 1;
	}

}
