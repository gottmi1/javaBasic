package kr.or.ddit.study06.sec05;

public class PeopleExample {
	public static void main(String[] args) {
		People p1 = new People("권은비", "여");
		People p2 = new People("차정원", "남");
		System.out.println(p1);
		System.out.println(p2);
		
		People.year++;
		System.out.println("년도 + 1");
		System.out.println(p1);
		System.out.println(p2);
	}
}
