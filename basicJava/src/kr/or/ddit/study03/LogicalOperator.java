package kr.or.ddit.study03;

import java.util.Scanner;

public class LogicalOperator {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		LogicalOperator obj = new LogicalOperator();
//		obj.method1();
//		obj.method2();
		obj.method3();
	}

	public void method1() {
		// 논리 연산자
		// && == AND연산자, 조건이 다 맞아야 true
		// || == OR연산자, 조건 중 하나만 맞아도 true

		boolean a = true;
		boolean b = false;

		System.out.println(a && b);
		System.out.println(a || b);
	}

	public void method2() {

		System.out.println("점수를 입력하세요.");
		int score = sc.nextInt();

		if (score >= 80 && score <= 90) {
			System.out.println("B학점");
		} else if (score >= 70 && score <= 80) {
			System.out.println("C학점");
		} else if (score >= 60 && score <= 70) {
			System.out.println("D학점");
		} else if (score < 60) {
			System.out.println("F학점");
		} else {
			System.out.println("A학점");
		}

	}
	
	public void method3() {
		
		// &, |, ^, ~ 연산자, 2진법 계산을 하는 연산자 인듯 정처기에 나온다고 함
		
		//        &
		// 45 : 00101101
		// 25 : 00011001
		//      00001001 -> 9
		
		//        |
		// 45 : 00101101
		// 25 : 00011001
		//      00111101 -> 61
		
		//      ^
		// 45 : 00101101
		// 25 : 00011001
		//      00110100 -> 52
		
		//      ~
		// 45 : 00101101
		// 25 : 00011001
		//      => -(10101101) +1 => - 46
		
		int a = 45;
		int b = 25;
		
		System.out.println(a&b);
		System.out.println(a|b);
		System.out.println(a^b);
		System.out.println(~a);
	}
	
}
