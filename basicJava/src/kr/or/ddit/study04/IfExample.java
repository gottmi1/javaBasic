package kr.or.ddit.study04;

import java.util.Scanner;

public class IfExample {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		IfExample obj = new IfExample();
//		obj.method1();
//		obj.method2();
//		obj.method3();
		obj.method4();
	}
	
	public void method4() {
		
		boolean flag = false;
		
		if(flag) {
			System.out.println("실행1");
			System.out.println("실행1-1");
		}
		
		if(flag) System.out.println("실행2");
		
		System.out.println("실행2-1");
	}

	public void method3() {
		// 0 ~ 2 - , 3~5 0 , 6 ~ 9 +
		System.out.println("점수를 입력하세요");
		int score = sc.nextInt();
		
		if(score > 100) {
			System.out.println("제대로 된 값을 입력해주세요.");
			return;
		}
		
		String grade = "";

		if (score >= 90) {
			grade = "A";
		} else if (score >= 80) {
			grade = "B";
		} else if (score >= 70) {
			grade = "C";
		} else if (score >= 60) {
			grade = "D";
		} else {
			grade = "F";
			
			System.out.println("F학점 입니다.");
			return;
		}

		if (score % 10 < 3 && score != 100) {
			grade += "-";
		} else if (score % 10 < 7 && score != 100) {
			grade += "0";
		} else {
			grade += "+";
		}

		System.out.printf("학점은 %s 입니다.", grade);
	}

	public void method2() {

		System.out.println("점수를 입력하세요");
		int score = sc.nextInt();

		if (score >= 90) {
			System.out.println("A학점");
		} else if (score >= 80) {
			System.out.println("B학점");
		} else if (score >= 70) {
			System.out.println("C학점");
		} else if (score >= 60) {
			System.out.println("D학점");
		} else {
			System.out.println("F학점");
		}

	}

	public void method1() {
		System.out.println("method1 실행");
		boolean flag = true;

		if (flag) {
			System.out.println("if문 실행");
		}

		System.out.println("if문 종료");
		System.out.println("method1 종료");
	}

}
