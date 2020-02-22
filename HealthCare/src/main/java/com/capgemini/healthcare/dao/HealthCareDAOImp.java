package com.capgemini.healthcare.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.capgemini.healthcare.bean.Appointment;
import com.capgemini.healthcare.bean.DiagnosticCenter;
import com.capgemini.healthcare.bean.Test;
import com.capgemini.healthcare.bean.User;

public class HealthCareDAOImp implements IHealthCareDAO {
	public static HashMap<String, DiagnosticCenter> centers = new HashMap<String, DiagnosticCenter>();

	public void addCenter() {
		Random rand = new Random();
		Test test1 = new Test();
		// creating test bean class objects and setting values
		test1.setTestId("1");
		test1.setTestName("Blood Test");
		Test test2 = new Test();
		test2.setTestId("2");
		test2.setTestName("Blood Group");
		Test test3 = new Test();
		test3.setTestId("3");
		test3.setTestName("Blood test");
		Appointment app1 = new Appointment();
		// setting appointment bean class values
		app1.setTest(test1);
		app1.setAppointmentId(rand.nextInt(1000));
		app1.setApproved(false);
		app1.setDatetime(new Date(2020, 1, 14));
		User user1 = new User("1", "Vani Gorthi", "apple", 949068960, "vani14@gmail.com", "Guardian");
		app1.setUser(user1);
		List<Appointment> app = new ArrayList<Appointment>();
		app.add(app1);
		DiagnosticCenter dc1 = new DiagnosticCenter();
		app1.setCenter(dc1);
		// passing Test bean class object to DiagnosticCenter bean class listOfTest
		List<Test> list = new ArrayList<Test>();
		list.add(test1);
		list.add(test2);
		list.add(test3);
		// setting test list,appointment list, Center ID and center name
		dc1.setListOfTests(list);
		dc1.setAppointmentList(app);
		dc1.setCenterId("1005");
		dc1.setCenterName("Nizampet");
		DiagnosticCenter dc2 = new DiagnosticCenter();
		Appointment app2 = new Appointment();
		app2.setTest(test3);
		app2.setAppointmentId(rand.nextInt(1000));
		app2.setApproved(false);
		app2.setDatetime(new Date(2020, 2, 15));
		app2.setCenter(dc1);
		User user2 = new User("2", "Shilpa Netha", "java", 949596709, "shilpa.12@gmail.com", "Patient");
		app2.setUser(user2);
		app.add(app2);
		// setting test list,appointment list, Center ID and center name
		dc2.setListOfTests(list);
		dc2.setAppointmentList(app);
		dc2.setCenterId("5004");
		dc2.setCenterName("Miyapur");
		// putting center's IDs and DiagnosticCenter objects into a map
		centers.put(dc1.getCenterId(), dc1);
		centers.put(dc2.getCenterId(), dc2);

	}

	// returns list of tests available in a center
	public List<Test> getListOfTest(String centerid) {
		return centers.get(centerid).getListOfTests();

	}

	public HealthCareDAOImp() {
		addCenter();

	}

	public Map<String, User> addUser() {
		User user1 = new User("1", "Vani Gorthi", "apple", 949068960, "vani14@gmail.com", "Guardian");
		User user2 = new User("2", "Shilpa Netha", "java", 949596709, "shilpa.12@gmail.com", "Patient");
		User user3 = new User("3", "Greeshmanth", "1234", 890985674, "Greesh@gmail.com", "Parent");
		Map<String, User> map = new HashMap<String, User>();
		map.put(user1.getUserId(), user1);
		map.put(user2.getUserId(), user2);
		map.put(user3.getUserId(), user3);
		return map;

	}

	public String makeAppointment(User user, DiagnosticCenter center, Test test, Date dateTime) {
		List<Appointment> list = center.getAppointmentList();
		Appointment app = new Appointment();
		List<Appointment> list1 = new ArrayList<Appointment>();
		list1.add(app);
		list1.addAll(list);
		center.setAppointmentList(list1);
		return "Appointment created! Wait for approval. ";

	}

}
