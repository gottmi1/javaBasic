package kr.or.ddit.study03;

import java.util.Scanner;

public class VariableTest {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		VariableTest obj = new VariableTest();
//		obj.method1();
//		obj.method2();
//		obj.method3();
//		obj.method4();
		obj.method6();
	}

	private void method1() {
		// 기본타입을 각각 선언해보고 갑을 저장 할 것
		// 8가지
		// System.out.println 을 이용해서 출력까지 해보자.

		// 정수형 byte ~

		// 바이트 = 8bit 프로그램 기본단위로 많이 사용

		byte by = 1;
		char ch = 'a';
		short sh = 255;
		int i = 5;
		long l = 6;

		float f = 3.14f;
		double d = 3.14;
		// float와 double은 정밀도가 달라서 값을 이렇게 넣어도 다른 값이 나옴

		boolean b = f == 3.14f;

		System.out.println(by);
		System.out.println(ch);
		System.out.println(sh);
		System.out.println(i);
		System.out.println(l);
		System.out.println(f);
		System.out.println(d);
		System.out.println(b);
	}

	private void method2() {
		/*
		 * 각 데이터를 형변환 하고 출력 하시오.
		 */
		// char -> int
		char ch = 'J';
		int i = ch;
		// int > char, 자동 현변환
		System.out.println("char 'J' -> int 변환 " + i);

		// int -> char
		int i2 = 46000;
		char ch2 = (char) i;
		// char < int 강제 형변환 필요

		System.out.println("int 4600 -> char 변환 " + ch2);

		// int -> double

		int i3 = 56;
		double d3 = i3;
		System.out.println("int 56 -> double 형변환 " + d3);

		// int 값 변수 a,b 를 나누기 연산후 double로 저장

		int i4 = 500;
		int i4_2 = 26;

		double d4 = (double) i4 / i4_2;
		System.out.println("int 2개 나눠서 double형변환 " + d4);

		// char -> String
		char ch5 = 'A';
		String str5 = "" + ch5;

		System.out.println("char -> String 형변환 " + str5);

		// c3_1 + c3_2 값을 문자열에 저장

		char ch6 = 'A';
		char ch6_2 = 'Z';

		String str6 = "" + ch6 + ch6_2;
		System.out.println("두 개의 char를 String으로 저장 " + str6);

		// charAt 문자열 -> 문자
		// 0번 부터 시작
		char ch7 = str6.charAt(0);
		System.out.println("위 String의 0번쨰 인덱스의 char " + ch7);
	}

	private void method3() {
		// Math.random
		// 0~0.9999999999999999 범위 값.
		// *10은 범위 값 +1은 시작 값.
		// (int)(Math.random()*10)+1

//		int ran = (int)(Math.random()*100)+1;
//		System.out.println(ran);

		// 11 ~ 20 범위 랜덤 숫자
		int random1 = (int) (Math.random() * 10) + 11;
		System.out.println(random1);

		/*
		 * 양꼬치는 1인분에 12000원 음료수는 2000원 입니다. 양꼬치 n개와 음료수 k 를 먹었다면 총 얼마를 지불해야 하는지 출력해보세요.
		 * n 값은 1~10 k 값은 1~3
		 */

		int n = (int) (Math.random() * 10) + 1;
		int k = (int) (Math.random() * 3) + 1;

		int totalPrice = (n * 12000) + (k * 2000);

		System.out.printf("양꼬치 %d개 음료수 %d개 총 지불 가격은 %d원 입니다.", n, k, totalPrice);

		// 결과값 저장 할 곳
	}

	private void method4() {
		/*
		 * 정수 num1, num2 랜덤한 변수(1~50)로 주어질때 num1을 num2로 나눈 나머지와 몫을 출력하세요.
		 */
		int num1 = (int) (Math.random() * 50) + 1;
		int num2 = (int) (Math.random() * 50) + 1;

		// 몫 : 정수형 데이터 이기 때문에 소수점 값 자동 생략됨.
		int re1 = num1 / num2;
		// 나머지
		int re2 = num1 % num2;

		System.out.printf("랜덤변수1 %d, 랜덤변수2 %d, 몫 %d, 나머지 %d", num1, num2, re1, re2);

	}

	private void method6() {
		/*
		 * 두 정수에 대한 연산으로 두정수를 붙여서 쓴 값을 출력합니다. 예를 들면 다음과 같습니다. a = 12, b =3 12 ☆ 3 = 123
		 * 3 ☆ 12 = 312
		 * 
		 * 양의 정수 a와 b가 주어졌을때 a ☆ b 와 b ☆ a 값중 더 큰값을 출력하세요
		 */
		int a = (int) (Math.random() * 100) + 1;
		int b = (int) (Math.random() * 100) + 1;

		int iResult1 = Integer.parseInt("" + a + b);
		int iResult2 = Integer.parseInt("" + b + a);

		boolean flag = iResult1 > iResult2;

		if (flag) {
			System.out.printf("첫 번째 숫자 %d 두 번째 숫자 %d, 첫 번쨰 숫자가 더 큼 결과값 %d",a,b,iResult1);
		} else {
			System.out.printf("첫 번째 숫자 %d 두 번째 숫자 %d, 두 번쨰 숫자가 더 큼 결과값 %d",a,b,iResult2);
		}
	}

}
