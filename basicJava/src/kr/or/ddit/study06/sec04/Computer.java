package kr.or.ddit.study06.sec04;

import java.util.Arrays;

public class Computer {

	public static void main(String[] args) {
		Computer me = new Computer();

		int[] arr = { 124, 35, 325, 235, 23, 52, 35, 23, 53, 322542, 3453463 };
		System.out.println("결과값 : " + me.sumArr(arr));
		System.out.println("결과값 : " + me.sumArr2(arr));
	}

	// 파라미터로 int 배열 값을 받아 더해주는 메서드를 설계
	// 리턴값 배열 값이 다 더해진 값

	public int sumArr(int[] intArr) {
		return Arrays.stream(intArr).sum();
	}

	public int sumArr2(int[] intArr) {
		return Arrays.stream(intArr).sum() * 2;
	}
}
