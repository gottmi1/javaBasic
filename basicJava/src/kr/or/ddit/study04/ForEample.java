package kr.or.ddit.study04;

import java.util.Scanner;

public class ForEample {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ForEample obj = new ForEample();
//		obj.method1();
//		obj.method2();
//		obj.method3();
		obj.method4();
	}

	public void method1() {
		// for문 기본, 시작 값과 끝 값을 받아 시작값과 끝값을 포함하여 그 사이의 수를 전부 더하기

		System.out.println("시작 값을 입력");
		int StartNum = sc.nextInt();

		System.out.println("최대 값을 입력");
		int EndNum = sc.nextInt();

		int sum = 0;

		for (int i = StartNum; i <= EndNum; i++) {
			sum += i;
		}

		System.out.printf("%d ~ %d 까지의 합 : %d", StartNum, EndNum, sum);
	}

	public void method2() {
		// 1 ~ 10까지의 홀수 의 합 구하기

		int result = 0;

		// 방법 1
//		for (int i = 0; i <= 10; i++) {
//			if (i % 2 != 0) {
//				result += i;
//			}
//		}
		
		//방법 2
		for(int i = 1; i < 10; i += 2) {
			result += i;
		}

		System.out.println(result);
	}

	public void method3() {
		// a부터 z까지 출력

		String str = "";
		
		for(int i = (char)'a'; i < (char)'z'; i++) {
			char ch = (char)i;
			str += ch +" ";
		}
		
		System.out.println(str);
		
	}

	public void method4() {

		//입력한 알파벳 부터 z까지 출력
		
		String str = sc.next() +" ";
		char ch = str.charAt(0);
		
		for(int i = ch+1; i < (char)'z'; i++) {
			char ch2 = (char)i;
			str += ch2 +" ";
		}
		
//		for(; ch <='z'; ch++) {
//			str += ch;
//		}
		
		System.out.println(str);
		
	}
}
