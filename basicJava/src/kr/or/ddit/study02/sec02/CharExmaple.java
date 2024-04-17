package kr.or.ddit.study02.sec02;

public class CharExmaple {
	
	public static void main(String[] args) {
		// Char 부호 없는 2바이트 정수 0 ~ 65535

		// 작은 따옴표 사용, 문자열이 아니라 문자를 저장

		char c1 = 'A';
		System.out.println(c1);

//		char c2 = 'a';
		char c2 = 75;
		System.out.println(c2);

		char c3 = 45167;
		System.out.println(c3);
		
		// 문자를 int에 할당하면 유니코드로 문자가 몇번 인지 알 수 있음
		int i3 = c3;
		System.out.println(i3);
	}
	
}
