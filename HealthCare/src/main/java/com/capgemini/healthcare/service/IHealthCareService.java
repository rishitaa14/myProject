package com.capgemini.healthcare.service;

import java.util.Date;

import com.capgemini.healthcare.bean.DiagnosticCenter;
import com.capgemini.healthcare.bean.Test;
import com.capgemini.healthcare.bean.User;

public interface IHealthCareService {
	public String makeAppointment(User user, DiagnosticCenter center, Test test, Date dateTime);

}
