package kr.or.ddit.study06.sec03;

public class StudentExample {
	
	public static void main(String[] args) {
		Student s1 = new Student("김", 19);
		Student s2 = new Student("302호","나", 18);
		Student s3 = new Student("영국","1202호","박", 17);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}
}
