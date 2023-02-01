package javaexp.z01_homework.vo;

public class Emp02 {

	
		private String year;
		private int cnt;
		private double sal;
		public Emp02(String year, int cnt, double sal) {
			this.year = year;
			this.cnt = cnt;
			this.sal = sal;
		}
		
		public Emp02(String year) {
			this.year = year;
		}

		public String getYear() {
			return year;
		}
		public void setYear(String year) {
			this.year = year;
		}
		public int getCnt() {
			return cnt;
		}
		public void setCnt(int cnt) {
			this.cnt = cnt;
		}
		public double getSal() {
			return sal;
		}
		public void setSal(double sal) {
			this.sal = sal;
		}
		
	
	
}
