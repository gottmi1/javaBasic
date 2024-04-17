package kr.or.ddit.study06.sec02;

public class TvExample {
	public static void main(String[] args) {
		
		Tv tv1 = new Tv();
		tv1.company = "LG";
		tv1.year = 2023;
		tv1.size = (double)60.0;
		tv1.CompanyString();
		
		Tv tv2 = new Tv();
		tv2.company = "Samsung";
		tv2.year = 2024;
		tv2.size = (double)85.0;
		tv2.CompanyString();
	}
}
