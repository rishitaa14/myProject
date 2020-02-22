package com.capgemini.healthcare.service;

import java.util.Date;
import java.util.List;

import com.capgemini.healthcare.bean.DiagnosticCenter;
import com.capgemini.healthcare.bean.Test;
import com.capgemini.healthcare.bean.User;
import com.capgemini.healthcare.dao.HealthCareDAOImp;

public class HealthCareServiceImp implements IHealthCareService {
	// creating an object of HealthCareDAOImp class
	HealthCareDAOImp dao = new HealthCareDAOImp();

	// Retrieving the list of tests based on the center
	public List<Test> getListOfTest(String centerid) {
		return dao.getListOfTest(centerid);
	}

	public String makeAppointment(User user, DiagnosticCenter center, Test test, Date dateTime) {

		return dao.makeAppointment(user, center, test, dateTime);
	}

}
