package kr.or.ddit.HomeWork;

import java.util.Scanner;

public class HomeWork15 {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// 계산기 만들기

//		System.out.println(cal(22, Oper.PLUS, 7));
		System.out.println(cal("32523-394293"));
//		System.out.println(cal2("5*34-2"));
	}

	public static double cal(int a, Oper oper, int b) {
		HomeWork15 hw = new HomeWork15();

		if (oper == oper.PLUS) {
			return hw.plus(a, b);
		} else if (oper == oper.MINUS) {
			return hw.minus(a, b);
		} else if (oper == oper.GOP) {
			return hw.multiply(a, b);
		} else if (oper == oper.NANUGI) {
			return hw.devide(a, b);
		} else {
			System.out.println("잘못된 입력");
			return 0.0;
		}
	}

	public static double cal(int a, String oper, int b) {
		HomeWork15 hw = new HomeWork15();

		if (oper.equals("+")) {
			return hw.plus(a, b);
		} else if (oper.equals("-")) {
			return hw.minus(a, b);
		} else if (oper.equals("*")) {
			return hw.multiply(a, b);
		} else if (oper.equals("/")) {
			return hw.devide(a, b);
		} else {
			System.out.println("잘못된 입력");
			return 0.0;
		}
	}

	// 심화, 스트링으로 숫자 2개 연산자 하나 일때 결과 리턴
	public static double cal(String str) {
		HomeWork15 hw = new HomeWork15();
		String[] number;

		if (str.contains("+")) {
			number = str.split("\\+");
			return hw.plus(Integer.parseInt(number[0]), Integer.parseInt(number[1]));
		} else if (str.contains("-")) {
			number = str.split("-");
			return hw.minus(Integer.parseInt(number[0]), Integer.parseInt(number[1]));
		} else if (str.contains("*")) {
			number = str.split("\\*");
			return hw.multiply(Integer.parseInt(number[0]), Integer.parseInt(number[1]));
		} else if (str.contains("/")) {
			number = str.split("/");
			return hw.devide(Integer.parseInt(number[0]), Integer.parseInt(number[1]));
		} else {
			System.out.println("잘못된 입력");
			return 0.0;
		}
	}

	// 심화2 숫자 n+1개 연산자 n개일 때 결과 리턴 -- 어려움
	public static double cal2(String str) {
		HomeWork15 hw = new HomeWork15();
		// 일단 연산자 2개일 때만 결과 나오도록 해보기

		char[] opers = { '*', '/', '+', '-' };
		int[] numbers; // 여긴 str을 연산자로 스플릿해서 담고
		int[] operIndexArr = new int[str.length()]; // str스플릿한 거에서 연산자 인덱스 찾아서 담기
		int operLegnth = 0;

		char[] chArr = str.toCharArray();

		// 연산자 몇개인지 확인
		for (char c : chArr) {
			for (int i = 0; i < opers.length; i++) {
				if (c == opers[i]) {
					operIndexArr[operLegnth] = (int) c;
					operLegnth++;
				}
			}
		}
		// 연산자 몇 개인지 확인 했고, char로 받아서 어떤 기호인지 확인 함.

		if (operIndexArr[0] == (char) 42) {

		} else if (operIndexArr[0] == (char) 47) {

		} else {

		}

		return (double) operIndexArr[1];

		// (int)'*' 42
		// (int)'+' 43
		// (int)'-' 45
		// (int)'/' 47
		// for문으로 이거 하나씩 까서 인덱스 비교하면?

	}

	public int plus(int a, int b) {
		return a + b;
	}

	public int minus(int a, int b) {
		return a - b;
	}

	public double devide(int a, int b) {
		return a / (double) b;
	}

	public double multiply(int a, int b) {
		return a * (double) b;
	}
}