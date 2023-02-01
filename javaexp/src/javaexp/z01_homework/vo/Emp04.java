package javaexp.z01_homework.vo;

import java.util.Date;

public class Emp04 {

	private String ename;
	private Date hiredate;
	private int year;
	private int month;
	private int date;
	public Emp04() {
		// TODO Auto-generated constructor stub
	}
	public Emp04(String ename, Date hiredate) {
		this.ename = ename;
		this.hiredate = hiredate;
	}
	public Emp04(int year, int month, int date) {
		this.year = year;
		this.month = month;
		this.date = date;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	
}
