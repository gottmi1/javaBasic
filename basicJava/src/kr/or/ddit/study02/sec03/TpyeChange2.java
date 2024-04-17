package kr.or.ddit.study02.sec03;

public class TpyeChange2 {
	public static void main(String[] args) {

		String str1 = "10";
		int i1 = Integer.parseInt(str1);
		int i2 = Integer.valueOf(str1);
		// String은 기본타입이 아닌 클래스이기 때문에,
		// 랩퍼클래스 Interger같은 애의 메서드를 사용해서 변환 함.
		// 랩퍼클래스는 보통 String -> 다른 타입으로 변환할 때 사용되는데,
		// char는 문자열을 담을 수 없는 '문자'이기 때문에 스트링을 넣을 수는 없음

		/*
		 * 랩퍼클래스 기본 타입 랩퍼클래스 byte의 랩퍼클래스 -> Byte short의 랩퍼클래스 -> Short int의 랩퍼클래스 ->
		 * Integer ** 얘만 약간 특이함 long의 랩퍼클래스 -> Long
		 * 
		 * float의 랩퍼클래스 -> Float double의 랩퍼클래스 -> Double
		 * 
		 * boolean의 랩퍼클래스 -> Boolean
		 */

		// valueOf, Parse... 은 사실상 같다고 보면 됨 큰 차이 없음
		System.out.println(i1 + ", " + i2);
		System.out.println(i1 + i2);

		// String -> Byte
		String str2 = "1";
		byte b1 = Byte.valueOf(str2);
		System.out.println("String -> Byte 변환 :" + b1);
		
		// String -> Short
		String str3 = "2";
		short s1 = Short.valueOf(str3);
		System.out.println("String -> Short 변환 :" + s1);
		
		// String -> long
		String str4 = "8";
		long l1 = Short.valueOf(str4);
		System.out.println("String -> Long 변환 :" + l1);

		// String -> float
		String str5 = "3.141592";
		float f1 = Float.parseFloat(str5);
		System.out.println("String -> Float 변환" + f1);
		
		// String -> double
		String str6 = "3.1415926535285285";
		double d1 = Double.parseDouble(str6);
		System.out.println("String -> Double 변환" + d1);
	}
}
