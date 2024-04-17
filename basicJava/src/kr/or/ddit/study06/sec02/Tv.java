package kr.or.ddit.study06.sec02;

public class Tv {
	String company;
	int year;
	double size;

	public void CompanyString() {
		System.out.printf("제조사 : %s , 생산년도 : %d , 사이즈 : %.1f\n", company, year, size);
	}
}
