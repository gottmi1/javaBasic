package kr.or.ddit.HomeWork.home12;

public class Grade {
	int kor;
	int math;
	int eng;

	int total;
	
	Grade(int kor, int math, int eng) {
		this.kor = kor;
		this.math = math;
		this.eng = eng;
		
		this.total = kor + math + eng;
	}

	static void zz() {
		System.out.println("십");
	}
	
	public void sumTotal() {
		System.out.printf("총점 : %d\n", total);
	}

	public void average() {
		System.out.printf("평균 : %.1f\n", total / 3.0);
	}
}
