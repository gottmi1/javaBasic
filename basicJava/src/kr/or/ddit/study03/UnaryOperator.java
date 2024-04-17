package kr.or.ddit.study03;

import java.util.Scanner;

public class UnaryOperator {
	// 단항연산자
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		UnaryOperator obj = new UnaryOperator();
//		obj.method1();
		obj.method2();
	}
	
	public void method1() {
		// 부호 연산자
		int num = 100;
		int res = -num;
		
		System.out.println(num);
		System.out.println(res);
	}
	
	public void method2() {
		// 증감연산자 
		// ++변수 : 다른 연산을 수행하기 전에 1을 더함
		// 변수++ : 수행 후 1 더함
		// --변수 : 수행 전 1 뺌
		// 변수-- : 수행 후 1 뺌
		
		int val = 10;
		int res = ++val;
		// ++가 앞에 있으면 res = val + 1
		
		System.out.println(val);
		System.out.println(res);
		
		val = 10;
		res = val++;
		// ++가 뒤에 있으면 res = val 부터 하고 val += 1을 함(res에는 val의 원래 값이 남음)
		
		System.out.println(val); 
		System.out.println(res);
		
		val = 10;
		res = --val;
		
		System.out.println(val);
		System.out.println(res);
		
		val = 10;
		res = val--;
		
		System.out.println(val);
		System.out.println(res);
	}
	
	
}
