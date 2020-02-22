package com.capgemini.healthcare.bean;

import java.util.Date;

public class Appointment {
	User user;
	private long appointmentId;
	private Date datetime;
	private boolean approved;
	Test test;
	DiagnosticCenter center;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public DiagnosticCenter getCenter() {
		return center;
	}
	public void setCenter(DiagnosticCenter center) {
		this.center = center;
	}
	@Override
	public String toString() {
		return "Appointment [user=" + user + ", appointmentId=" + appointmentId + ", datetime=" + datetime
				+ ", approved=" + approved + ", test=" + test + ", center=" + center + "]";
	}
	public Appointment(User user, long appointmentId, Date datetime, boolean approved, Test test,DiagnosticCenter center) {
		super();
		this.user = user;
		this.appointmentId = appointmentId;
		this.datetime = datetime;
		this.approved = approved;
		this.test = test;
		this.center = center;
	}
	public Appointment() {
		super();
	}
	

}
