package kr.or.ddit.study02.sec03;

public class TypeChange {
	public static void main(String[] args) {
		// 유의점 ... < long < float < double임

		// 자동 형변환
		// 작은 범위 -> 큰 범위
		int i = 10;
		long l = i;
		System.out.println("long타입 입니다. " + l);

		// 강제 형변환
		// 큰 범위 -> 작은 범위
		long l2 = 1000;
		int i2 = (int) l2;
		System.out.println("int타입 입니다. " + i2);

		/*
		 * double -> int 형변환
		 */

		double d = 100000.0;
		int i3 = (int) d;
		System.out.println("double 100000.0 -> int 형변환 " + i3);

		/*
		 * int -> double 형변환
		 */

		int i4 = 300;
		double d2 = i4;
		System.out.println("int 300 -> double 형변환 " + d2);

		/*
		 * char -> int 형변환
		 */
		char c = 'A';
		int i5 = c;

		System.out.println("char A -> int 형변환 " + i5);

		/*
		 * int -> char 형변환
		 */
		int i6 = 42843;
		char c2 = (char) i6;

		System.out.println("int 42843 -> char 형변환 " + c2);

		// 소문자 a를 대문자 A로 변환하기
		char c8 = 'a';
		char c8_1 = 'a' - 32; // 바꿀 문자를 변수에 대입하지 않고 사용할 때 바로 빼줘도 char형식이 됨
		char c8_2 = (char) (c8 - 32); // 바꿀 문자를 변수에 대입하고 사용하려면 형변환 해줘야 함
		System.out.println("소문자 'a' -> 대문자'A' 하려면 -32해주면 됨 " + c8_1 + c8_2);

		// 대문자 A를 소문자 a로 변환하기
		char c9 = 'A';
		char c9_1 = 'A' + 32; // 바꿀 문자를 변수에 대입하지 않고 사용할 때 바로 빼줘도 char형식이 됨
		char c9_2 = (char) (c9 + 32); // 바꿀 문자를 변수에 대입하고 사용하려면 형변환 해줘야 함
		System.out.println("대문자 'A' -> 소문자'a' 하려면 +32해주면 됨 " + c9_1 + c9_2);
		
		// int -> string 형변환
		int i10 = 200;
		String str1 = "" + i10; // String + any = 항상 String타입이 나옴, 얌생이긴 함
		str1 = String.valueOf(i10); // 이게 정성적인 방법인데 위에 얌생이가 더 자주 쓰임, c#으로치면 Conver.ToString이랑 같은 듯
		System.out.println("int -> String 형변환" + str1);
		
		
	}
}
