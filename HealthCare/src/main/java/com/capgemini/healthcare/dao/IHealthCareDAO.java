package com.capgemini.healthcare.dao;

import java.util.Date;

import com.capgemini.healthcare.bean.DiagnosticCenter;
import com.capgemini.healthcare.bean.Test;
import com.capgemini.healthcare.bean.User;

public interface IHealthCareDAO {

	public String makeAppointment(User user, DiagnosticCenter center, Test test, Date dateTime);
}
