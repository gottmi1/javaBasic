package kr.or.ddit.HomeWork;

import java.util.Scanner;

public class HomeWork03 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork03 obj = new HomeWork03();
//		obj.question1();
		obj.question2();
	}

	public void question2() {
		// && || ! 사용해서
		// 윤년 : 4의 배수
		// 100의 배수 x
		// 400의 배수 o
		// 4 8 12 16 <-- 윤년
		// 100 200 300 500 <-- 윤년 x
		// 400 800 1200 <-- 윤년

		System.out.println("년도를 입력하세요.");
		int question = sc.nextInt();

		boolean flag400 = question % 400 == 0;
		// 400을 나눴을 때 0일시 true

		boolean flag4 = question % 4 == 0;
		// 4를 나눴을 때 0일시 true

		boolean flag100 = question % 100 == 0;
		// 100 나눠서 0이면 true

		if (flag100 && flag400) {
			System.out.println("윤년");
		} else if (flag4 && !flag100) {
			System.out.println("윤년");
		} else {
			System.out.println("평년");
		}
	}

	public void question1() {
		// 정수 하나를 설정하고 키보드로 임의의 수를 입력 받아
		// 입력받은 수가 크면 "더 작은 수를 입력하세요"
		// 입력받은 수가 작으면 "더 큰 수를 입력하세요" 출력

		int question = 53;
		int cnt = 1;

		System.out.println("숫자를 입력하세요.");

		while (true) {
			int a = sc.nextInt();
			if (a > question) {
				System.out.println("더 작은 수를 입력하세요.");
				cnt++;
			} else if (a < question) {
				System.out.println("더 큰 수를 입력하세요.");
				cnt++;
			} else {
				System.out.printf("시도 횟수 : %d번", cnt);
				break;
			}
		}

	}
}
