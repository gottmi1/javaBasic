package kr.or.ddit.study06.sec02;

public class Student {
	// 국어 영어 수학 총점 평균 등수
	// 이름

	int kor;
	int eng;
	int math;
	int total;

	double average;

	int rank;

	String name;

	// alt + shift + s = 제너레이트 함수 선택 창
	@Override
	public String toString() {
		return "학생 [kor=" + kor + ", eng=" + eng + ", math=" + math + ", total=" + total + ", average="
				+ Math.round(average * 10.0) / 10.0 + ", rank=" + rank + ", name=" + name + "]";
	}

	// F3으로 메소드 정의된 곳으로 이동후 되돌아가기 : alt + 방향키 왼쪽
	public void scoreSum() {
		this.total = this.kor + this.eng + this.math;
		this.average = this.total / 3.0;
//		System.out.printf("총점 : %d , 평균 : %.1f\n", this.total, this.average);
	}

}
