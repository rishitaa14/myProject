package com.capgemini.healthcare.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.healthcare.bean.Appointment;
import com.capgemini.healthcare.bean.DiagnosticCenter;
import com.capgemini.healthcare.bean.Test;
import com.capgemini.healthcare.bean.User;
import com.capgemini.healthcare.dao.HealthCareDAOImp;
import com.capgemini.healthcare.exception.InvalidID;
import com.capgemini.healthcare.service.HealthCareServiceImp;

public class Presentation {

	public static void main(String[] args) throws InvalidID {

		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		Appointment app = new Appointment();
		HealthCareServiceImp service = new HealthCareServiceImp();
		HealthCareDAOImp dao = new HealthCareDAOImp();
		DiagnosticCenter dc = new DiagnosticCenter();
		User user = new User();
		System.out.println("CREATING AN APPOINTMENT");
		System.out.println("Enter UserID:");
		String userID = scan.next();
		Map<String, User> map = dao.addUser();
		if (!map.containsKey(userID)) {
			try {
				throw new InvalidID();
			} catch (InvalidID id) {
				System.err.println("Invalid ID");
				
			}
		}
	    user.setUserId(userID);
		dao.addUser();
		long appid = rand.nextInt(1000);
		app.setAppointmentId(appid);
		System.out.println("Date (dd-MM-yyyy) : ");
		String date = scan.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		final String pattern = "dd-mm-yyyy";
		Date d = null;
		dateFormat.applyPattern(pattern);
		try {
			d = dateFormat.parse(date);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		app.setDatetime(d);
		app.setApproved(false);
		Set<String> set = (HealthCareDAOImp.centers).keySet();
		int x = 1;
		System.out.println("CENTERS LIST: ");
		for (String i : set) {
			System.out.println(i + "    " + HealthCareDAOImp.centers.get(i).getCenterName());
		}
		System.out.println("Enter Center's ID : ");
		String center = scan.next();
		if (!HealthCareDAOImp.centers.containsKey(center)) {
			try {
				throw new InvalidID();

			} catch (InvalidID id) {
				System.err.println("Invalid ID");
				
			}
		
		DiagnosticCenter cen = (HealthCareDAOImp.centers).get(center);
		String name = cen.getCenterName();
		app.setCenter(cen);
		List<Test> list = service.getListOfTest(center);
		System.out.println("Available tests in " + name);
		for (Test i : list) {
			System.out.println(i.getTestId() + "    " + i.getTestName());
		}
		System.out.println("Enter TestID: ");
		String test = scan.next();
		List<Test> tests = cen.getListOfTests();
		Test test1 = null;
		for (Test t : tests) {
			if (test.equals(t.getTestId())) {
				test1 = t;
			}

		}
		app.setTest(test1);
		String result = service.makeAppointment(user, cen, test1, d);
		System.out.println(result + " Your Appointment ID is: " + appid);
		System.out.println("Center name: " + name + "  Test name: " + test1.getTestName());

	}
	}
}
