package com.facebookweb5.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.facebookweb5.entity.FacebookEmployee;

public class FacebookDao implements FacebookDaoInterface{
	
	private FacebookDao() {}

	public static FacebookDaoInterface createDaoObject(String string) {
		return new FacebookDao();
	}

	@Override
	public int createDaoProfile(FacebookEmployee fe) {
		int i=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Zensar123");
			PreparedStatement ps=con.prepareStatement("insert into facebook values(?,?,?,?)");
			ps.setString(1, fe.getName());
			ps.setString(2,fe.getPassword() );
			ps.setString(3, fe.getEmail());
			ps.setString(4, fe.getAddress());
			i=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return i;
	}

}
