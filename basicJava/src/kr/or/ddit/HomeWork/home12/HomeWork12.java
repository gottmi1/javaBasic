package kr.or.ddit.HomeWork.home12;

public class HomeWork12 {
	public static void main(String[] args) {

		// 1. 다음을 만족하는 Student 클래스 설계
		// String 형의 학과 정수형의 학번을 필드로 선언
		// 적당한 값을 넣고 출력

		Student s1 = new Student();
		s1.hakgwa = "정보통신과";
		s1.hakburn = 1010110010;
		System.out.println(s1);

		// 2. 다음을 만족하는 TV클래스 설계
		// Tv 클래스에 제조사 생산년도 크기를 필드로 선언
		// 생성자(제조사, 생산년도, 크기)로 객체 생성
		// printTv 메서드 생성 -> 동작 : 필드값 출력

		Tv tv = new Tv("LG", 2024, 68);
		tv.printTv();
		
		// 3. 세 과목의 성적을 입력 받고 총점 메서드  평균 메서드을 만들어서 출력할 수 있는
		// Grade 클래스를 설계
		
		Grade grade = new Grade(100, 97, 90);
		grade.sumTotal();
		grade.average();
	}
}
