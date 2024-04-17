package kr.or.ddit.study06.sec06;

import java.util.Scanner;

public class SalaryTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		SalaryMan s1 = new SalaryMan();
		s1.setName("차정원");
		
		
		System.out.println("사람1의 나이 입력");
		
		int age = sc.nextInt();
		s1.setAge(age);
		
		System.out.println(s1);
	}
}
