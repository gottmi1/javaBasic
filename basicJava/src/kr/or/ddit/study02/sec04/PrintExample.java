package kr.or.ddit.study02.sec04;

import java.util.Scanner;

public class PrintExample {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		PrintExample obj = new PrintExample();
//		obj.printLn();
//		obj.print();
//		obj.printf();
		obj.printf2();
	}

	public void print() {
		// 줄바꿈 기능 x
		System.out.print("홍길동");
		System.out.print(" 34061");
		System.out.print("  대전시 중구 계룡로");
	}

	public void printf() {
//		System.out.printf("형식 지정문자열", 변수 리스트); 스트링 포맷과 비슷한 형식
//		형식 문자열 -> "%%[[i|0]n]d 10진 정수"
//		왼쪽 정렬 -> 0 남은 왼쪽 빈공간에 0 채움
		System.out.printf("숫자 : %d\n", 1000); // 일반적
		System.out.printf("숫자 : %8d\n", 1000); // 그냥 숫자 : 8칸중 오른쪽에 이걸 씀
		System.out.printf("숫자 : %-8d\n", 1000); // 마이너스 숫자 : 8칸 중 왼쪽에 이걸 씀
		System.out.printf("숫자 : %08d\n", 1000); // 나머지 공간을 0 으로 채움
	}

	public void printf2() {
		// 나이와 이름 넣어보기
		System.out.println("나이를 입력하세요.");
		int age = Integer.parseInt(sc.next());
		System.out.println("이름을 입력하세요.");
		String name = sc.next();

		System.out.printf("이름 : %s\t나이 : %d", name, age);
	}

	public void printLn() {
		// 줄바꿈 기능 o
		System.out.println("홍길동");
		System.out.println(" 34061");
		System.out.println("  대전시 중구 계룡로");
	}

}
