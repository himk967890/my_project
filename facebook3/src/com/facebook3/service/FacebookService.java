package com.facebook3.service;

import com.facebook3.dao.FacebookDao;
import com.facebook3.dao.FacebookDaoInterface;
import com.facebook3.entity.FacebookEmployee;

public class FacebookService implements FacebookServiceInterface{

	private FacebookService() {}
	public static FacebookServiceInterface createServiceObject() {
		return new FacebookService();
	}
	@Override
	public int createProfile(FacebookEmployee fe) {
		FacebookDaoInterface fd=FacebookDao.createDaoObject();
		return fd.createProfile(fe);
	}

}
