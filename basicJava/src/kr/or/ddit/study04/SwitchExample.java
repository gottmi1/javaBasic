package kr.or.ddit.study04;

import java.util.Scanner;

public class SwitchExample {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		SwitchExample obj = new SwitchExample();
//		obj.method1();
//		obj.method2();
//		obj.method3();
		obj.method4();
	}

	public void method4() {

		// 스위치문을 이용해서 끝자리가 31(1 3 5 7 8 10 12)
		// 30(4 6 9 11), 28, 29(2)일지 출력

		System.out.println("몇 월인지 입력하세요.");
		int mon = sc.nextInt();

		switch (mon) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("끝자리가 31일 입니다.");
			break;
		case 2:
			System.out.println("끝자리가 28, 29일 입니다");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("끝자리가 30일 입니다.");
			break;
		default:
			System.out.println("정확한 값을 입력하세요.");
			break;
		}
	}

	public void method3() {
		// 학점을 스위치문으로
		System.out.println("점수를 입력하세요.");

		int score = sc.nextInt();

		switch (score / 10) {
		case 10:
			switch (score % 10) {
			case 0:
			case 1:
			case 2:
				System.out.println("-");
				break;
			case 3:
			case 4:
			case 5:
			case 6:
				System.out.println("0");
				break;
			case 7:
			case 8:
			case 9:
				System.out.println("+");
				break;
			default:
				break;
			}
			System.out.println("A+학점");
			break;
		case 9:
			System.out.println("A학점");
			break;
		case 8:
			System.out.println("B학점");
			break;
		case 7:
			System.out.println("C학점");
			break;
		case 6:
			System.out.println("D학점");
			break;
		default:
			System.out.println("F학점");
			break;
		}

	}

	public void method2() {

		System.out.println("국가 명 입력");
		String nation = sc.next();

		switch (nation) {
		case "kor":
			System.out.println("한국 입니다");
			break;
		case "jpn":
			System.out.println("일본 입니다");
			break;
		case "chn":
			System.out.println("한국");
			break;
		default:
			break;
		}
	}

	public void method1() {

		System.out.println("회원 등급 입력");

		int grade = sc.nextInt();

		switch (grade) {
		case 1:
			System.out.println("Vip");
			break;
		case 2:
			System.out.println("우수");
			break;
		case 3:
			System.out.println("일반");
			break;
		default:
			System.out.println("잘못된 값");
			break;
		}
	}
}
