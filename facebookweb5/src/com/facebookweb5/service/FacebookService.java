package com.facebookweb5.service;

import com.facebookweb5.dao.FacebookDao;
import com.facebookweb5.dao.FacebookDaoInterface;
import com.facebookweb5.entity.FacebookEmployee;

public class FacebookService implements FacebookServiceInterface {

	private FacebookService() {}
	public static FacebookServiceInterface createServiceObject(String string) {
		return new FacebookService();
	}
	@Override
	public int createProfileService(FacebookEmployee fe) {
	  FacebookDaoInterface fd=FacebookDao.createDaoObject("g");
		return fd.createDaoProfile(fe);
	}

}
