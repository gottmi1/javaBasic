package kr.or.ddit.HomeWork;

import java.util.Scanner;

import kr.or.ddit.study02.sec03.TempExam;

public class HomeWork06 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork06 obj = new HomeWork06();
//		obj.method1();
//		obj.method2();
		obj.method3();
	}

	public void method1() {
		// 전체 구구단 출력
		for (int i = 1; i <= 9; i++) {

			for (int j = 2; j < 10; j++) {
				System.out.printf("%d * %d = %d\t", j, i, i * j);
			}

			System.out.println(" ");
		}
	}

	public void method2() {
		// 전체 구구단 출력하는데 입력받은 구구단은 제외
		System.out.println("제외할 단 선택");
		int input = sc.nextInt();

		for (int i = 1; i <= 9; i++) {

			for (int j = 2; j < 10; j++) {
				if (j == input) {
					continue;
				}

				System.out.printf("%d * %d = %d\t", j, i, i * j);
			}

			System.out.println(" ");
		}
	}

	public void method3() {
		// 입력받은 값이 양의 정수이며
		// 1. 홀수라면
		// n 이하의 모든 홀수의 총합 출력
		// 2. 짝수라면
		// n 이하의 모든 짝수의 제곱의 총합 출력

		System.out.println("정수 입력");
		int input = sc.nextInt();
		int result1 = 0;
		int result2 = 0;
		int temp = 0;

		for (int i = 0; i <= input; i++) {
			if (i % 2 != 0) {
				result1 += i;

				if (i == input)
					System.out.printf("%d 이하의 모든 홀수의 합 %d", input, result1);
			} else {
				temp = i * i;
				result2 += temp;

				if (i == input)
					System.out.printf("%d 이하의 모든 짝수의 제곱의 합 %d", input, result2);
			}
		}

	}
}
