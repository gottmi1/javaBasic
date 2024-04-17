package kr.or.ddit.HomeWork;

import java.util.Scanner;

import javax.xml.bind.ParseConversionEvent;

public class HomeWork2 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork2 obj = new HomeWork2();
//		obj.method1();
//		obj.method2();
//		obj.method3();
		obj.method4();
	}
	
	public void method1() {
		/*
		 *   실수 데이터를 입력 받은후 
		 *   *100 한후 정수 부분만 출력해보기. 
		 */
		System.out.println("실수 데이터를 입력하세요.");
		String num = sc.next();
		
		double numdouble = Double.parseDouble(num) * 100;
		int num1 = (int)numdouble;
		
		System.out.println(num1);
	}
	
	public void method2() {
		/*
		 *   소수점 2째 자리까지 출력.
		 */
		System.out.println("실수 데이터를 입력하세요.");
		String num = sc.next();
		
		double numDouble = Double.parseDouble(num);
		
		System.out.printf("%.2f",numDouble);
	}
	
	public void method3() {
		/*
		 *   num1 에 num2 값을 나눈후 *2000 한 값을 출력.
		 *   num1 = 3 
		 *   num2 = 2 
		 *   -> 결과 값 3000
		 */
		System.out.println("첫 번째 값을 입력하세요.");
		String num1 = sc.next();
		System.out.println("나눌 값을 입력하세요.");
		String num2 = sc.next();
		
		double result = Double.parseDouble(num1) / Double.parseDouble(num2) * 2000.0;
		int nResult = (int)result;
		System.out.println(nResult);
	}
	
	public void method4() {
		/*
		 * 	 심화 과제
		 *   (생략 가능  if 문 사용 하지 않고.)
		 *   소수점 2째 자리에서 반올림 하기.
		 */
		
		System.out.println("소수점 둘 째 자리에서 반올림 할 숫자를 입력하세요.");
		double num1 = Double.parseDouble(sc.next());
		
		// 메서드 사용
		double roundedNum = Math.round(num1 * 10.0) / 10.0;
        System.out.println(roundedNum);
        
        // 단순 계산
        int numInt = (int)num1;
        System.out.printf("%.1f\n", numInt + ((num1 - numInt)));
	}
}
