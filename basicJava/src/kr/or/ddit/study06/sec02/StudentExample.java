package kr.or.ddit.study06.sec02;

public class StudentExample {
	public static void main(String[] args) {
		
		// 새 클래스 생성 = Stack에 st1생성
		// 할당할 때 Heap에 저장 공간이 생성 됨.
		Student st1 = new Student();
		st1.name = "라마바";
		st1.kor = 100;
		st1.eng = 50;
		st1.math = 99;
		st1.scoreSum();
		System.out.println(st1); 
		
		Student st2 = new Student();
		st2.name = "가나다";
		st2.kor = 99;
		st2.eng = 90;
		st2.math = 100;
		// 메서드 정의된 곳으로 이동 : 메서드명 선택 후 F3
		st2.scoreSum();
		System.out.println(st2);
	}
}
