package kr.or.ddit.study02.sec03;

public class WrapperClass {
	public static void main(String[] args) {

		// 박싱, 언박싱

		// 박싱( 기본 타입을 랩퍼클래스에 넣는 것 )
		int n1 = 10;
		Integer num1 = n1;

		// 언박싱 ( 랩퍼클래스를 기본 타입에 넣는 것 )
		Integer num2 = new Integer(0);
		num2 = 11;
		int n2 = num2;

		// 이것도 일종의 형변환임( 기본타입 -> 랩퍼클래스 )
		
		
		
	}
}
