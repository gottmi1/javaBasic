package print;

import vo.BookVo;

public class LibPrint {
	public void printBar() {
		System.out.println("---------------------------------------------------------------");
	}
	
	public void printLn(int n) {
		// 줄 띄우기인듯
		for (int i = 0; i < n; i++) System.out.println();
	}
	
	public void bookDetailPrint(BookVo book) {
		System.out.println("책 제목 : " + book.getTitle());
		System.out.println("저자 :\t"+book.getWriter()+ "출판사 :\t" + book.getPub() +"\t 출판일 :\t" + book.getPub_date());
		printBar();
		System.out.println("내용 : " + book.getContent());
		printBar();
		
		System.out.println("1. 도서 수정");
		System.out.println("2. 도서 삭제");
		System.out.println("3. 전체 리스트");
	}
}
