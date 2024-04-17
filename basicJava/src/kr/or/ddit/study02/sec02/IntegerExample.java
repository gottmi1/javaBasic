package kr.or.ddit.study02.sec02;

public class IntegerExample {
	public static void main(String[] args) {

//		System.out.println("byte 크기(byte단위): " + Byte.SIZE);
//		System.out.println("byte 최소값: " + Byte.MIN_VALUE);
//		System.out.println("byte 최대값: " + Byte.MAX_VALUE);
//
//		System.out.println("short 크기(byte단위): " + Short.SIZE);
//		System.out.println("short 최소값: " + Short.MIN_VALUE);
//		System.out.println("short 최대값: " + Short.MAX_VALUE);
//
//		System.out.println("int 크기(byte단위): " + Integer.SIZE);
//		System.out.println("int 최소값: " + Integer.MIN_VALUE);
//		System.out.println("int 최대값: " + Integer.MAX_VALUE);
//
//		System.out.println("long 크기(byte단위): " + Long.SIZE);
//		System.out.println("long 최소값: " + Long.MIN_VALUE);
//		System.out.println("long 최대값: " + Long.MAX_VALUE);

		byte b1 = 127;
		System.out.println("b1 : " + b1);

		short s1 = 32450;
		System.out.println("s1 : " + s1);

		// short는 잘 안 씀, 초기화 시 사칙연산할 때 형변환 필요함
		short s2 = (short) (s1 + 10); // 이런식으로 해줘야 함
		// (java에서 숫자 기본형은 int이기 때문)

		int i1 = 100;
		int i2 = i1 + 208000000;
		
		long l1 = 22;
		// 기본 숫자형이 int라서 int범이를 초과하는 값 입력시 끝에 l붙여줘야 함
		long l2 = 4534953422384664l;
		long l3 = i1 + 382498239482394l;
	}
}
