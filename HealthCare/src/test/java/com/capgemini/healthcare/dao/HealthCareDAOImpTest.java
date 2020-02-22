package com.capgemini.healthcare.dao;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.capgemini.healthcare.bean.DiagnosticCenter;
import com.capgemini.healthcare.bean.User;

public class HealthCareDAOImpTest {

	static User user;
	static DiagnosticCenter dc;
	
	@BeforeClass
	public static void getID() {
		user=new User();
		dc=new DiagnosticCenter();
	   user.setUserId("1");
	   dc.setCenterId("504");
		
	}

	@Test
	public void test() {
	assertEquals("1", user.getUserId());
	assertEquals("504", dc.getCenterId());
	}
}
