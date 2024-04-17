package kr.or.ddit.HomeWork.home12;

import java.awt.TextArea;

public class Tv {
	// 2. 다음을 만족하는 TV클래스 설계
	// Tv 클래스에 제조사 생산년도 크기를 필드로 선언
	// 생성자(제조사, 생산년도, 크기)로 객체 생성
	// printTv 메서드 생성 -> 동작 : 필드값 출력

	String manufacturer;
	int productionYear;
	int size;

	Tv() {

	}

	Tv(String str, int year, int size) {
		this.manufacturer = str;
		this.productionYear = year;
		this.size = size;
	}

	public void printTv() {
		System.out.println("제조사 : " + manufacturer + " 생산년도 : " + productionYear + " 크기 : " + size);
	}
}
