package kr.or.ddit.study04;

import java.util.Scanner;

public class ForExample2 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ForExample2 obj = new ForExample2();
//		obj.method1();
//		obj.method2();
//		obj.method3();
//		obj.method4();
		obj.method5();

	}

	public void method1() {
		// 영어를 입력한 후 영어에 포함된 모음의 갯수구하기
		// a i u e o

		String str = sc.next();

		int length = str.length();

		int cnt = 0;

		for (int i = 0; i < length; i++) {
			char ch = str.charAt(i);

			if (ch == 'a' || ch == 'i' || ch == 'u' || ch == 'e' || ch == 'o') {
				cnt++;
			}
		}

		System.out.printf("포함된 모음의 갯수는 %d개 입니다.", cnt);

	}

	public void method2() {
		// 중첩 포문 구구단 할거같음
	}

	public void method3() {
		// 구구단

		System.out.println("출력할 단을 입력");
		int gugudan = sc.nextInt();

		for (int i = 1; i < 10; i++) {
			System.out.printf("%d * %d = %d \n", gugudan, i, gugudan * i);
		}
	}

	public void method4() {
		// 구구단 1단부터 9단 까지

		for (int i = 2; i < 10; i++) {

			for (int j = 1; j < 10; j++) {
				System.out.printf("%d * %d = %d\t", i, j, i * j);
			}

			System.out.println(" ");
		}
	}

	public void method5() {

		for (int i = 1; i < 20; i++) {

//			if (i % 2 != 0) {
//				System.out.println(i);
//			}

			if (i % 2 == 0) {
				continue;
				// 이 조건이 나오면 다음 루프로 넘어감
			}
			System.out.println(i);
		}

	}
}
