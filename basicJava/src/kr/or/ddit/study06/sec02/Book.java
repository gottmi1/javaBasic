package kr.or.ddit.study06.sec02;

public class Book {
	// 책 제목, 저자, 등록일, 책설명
	
	// 초기화시 디폴트 값 주기
	String nation = "한국은 아님";
	
	String title;
	String author;
	int date;
	String descript;
	@Override
	public String toString() {
		return "책 정보 [title=" + title + ", author=" + author + ", date=" + date + ", descript=" + descript + "]";
	}
	
	
}
