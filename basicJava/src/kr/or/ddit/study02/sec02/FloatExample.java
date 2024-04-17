package kr.or.ddit.study02.sec02;

public class FloatExample {

	// float : 4byte (부호 1byte , 지수 8bit, 가수 23bit) 정밀도 : 소수점 약 7자리
	// double : 8byte (부호 1bit , 지수 11bit, 가수 52bit) 정밀도 : 소수점 약 15자리
	// ㄴ 이렇게 돼있다는 개념만 알고 있으면 됨

	public static void main(String[] args) {
		float f1 = 3.141592f;
		System.out.println(f1);
		double d1 = 3.141592;
		System.out.println(d1);

		if (f1 == d1) {
			System.out.println("float와 double 같은 값");
		} else {
			System.out.println("float와 double 다른 값");
		}

	}
}