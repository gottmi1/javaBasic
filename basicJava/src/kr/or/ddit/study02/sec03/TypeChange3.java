package kr.or.ddit.study02.sec03;

import java.util.Scanner;

public class TypeChange3 {
	Scanner sc = new Scanner(System.in); // 입력한 데이터를 컴퓨터에 인식시키는 것 <=> sysout
	// 컨트롤 시프트 o == C#에서의 알트 엔터와 같은 동작

	public static void main(String[] args) {
		TypeChange3 TCobj = new TypeChange3();
//		TCobj.method1();
		TCobj.method2();
	}

	// 템플릿 등록 : 윈도우 -> 프리퍼렌스 -> Java -> Editor -> Template에 숏컷 등록 가능

	public void method2() {
		// 국어 영어 수학 점수 입력받은 후 총점과 평균 구하기

		System.out.println("국어 점수 :");
		int kor = Integer.parseInt(sc.next());

		System.out.println("영어 점수 :");
		int eng = Integer.parseInt(sc.next());

		System.out.println("수학 점수 :");
		int math = Integer.parseInt(sc.next());

		int score = kor + eng + math;
//		double average = score / (double) 3;
//		double average = (double) score / 3;
		// 값이 double값으로 나와야 하기 때문에 둘 중 하나는 double로 강제 형변환 해줘야 함
		double average = score / 3.0; // 이렇게 실수로 나눈다는 걸 확실히 해주는 게 가장 편함

		System.out.println(String.format("국어 : %d, 영어 %d, 수학 %d", kor, eng, math));
		System.out.println(String.format("세 과목의 총점 : %d점 , 세 과목의 평균 : %.3f점", score, average));
	}

	public void method1() {
		/*
		 * 국어 영어 수학 점수 입력받기
		 */
		System.out.println("국어 점수 :");
		String kor = sc.next();
		System.out.println("영어 점수 :");
		String eng = sc.next();
		System.out.println("수학 점수 :");
		String math = sc.next();

		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);
	}

}
