package kr.or.ddit.study03;

public class TrinomialOperator {
	public static void main(String[] args) {
		// 3항연산자
		// 한줄짜리 1조건 if문

//		boolean a = true;
//		int b = a ? 15 : 14;
//		
//		System.out.println(b);

//		int age = 20;
//		String str = age > 18 ? "성인" : "청소년";
//		System.out.println(str);

		int a = 10;
		int b = 10;

		int result = a % 2 == 0 ? a * b : a + b;
		System.out.println(result);
	}
}
