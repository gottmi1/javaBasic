package kr.or.ddit.study05;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample03 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayExample03 obj = new ArrayExample03();
//		obj.m1(); //2차원 배열
//		obj.m2();
//		obj.m3();
		obj.m4();
	}
	
	public void m4() {
		// Java.util.Arrays 배열 관련 클래스

		int[] arr = {4,2,3,5,1};
		
		// 배열안에 값을 문자열로 변환
		// Arrays.toString()
		System.out.println(Arrays.toString(arr));
		
		// 배열 값을 정렬
		// Arrays.sort()
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public void m3() {
		// 국어 / 영어 / 수학 점수
		String[] name = { "홍길동", "강감찬", "이순신" };
		int[][] scores = { { 80, 756, 89 }, { 87, 21, 69 }, { 84, 64, 19 } };
		
		
		System.out.printf("%s의 수학 점수 : %d\n" , name[2],scores[2][2]);
		System.out.printf("%s의 국어 점수 : %d\n" , name[0],scores[0][0]);
		
		double a = scores[0][0] + scores[1][0] + scores[2][0] / 3.0;
		System.out.printf("세 명의 국어 점수 평균 : %.1f\n", a );
		
		double average =  scores[1][0] + scores[1][1] + scores[1][2] / 3.0;
		System.out.printf("강감찬의 평균 점수 : %.1f", average);
	}

	public void m2() {
		// 1차원 배열의 길이가 정해지지 않았을 때는 두 번째 배열을 비워 둠
		int[][] arr = new int[3][];

		int[] score1 = { 100, 90, 80, 70 };
		int[] score2 = { 91, 81, 72, 76 };
		int[] score3 = { 100, 90, 80, 70, 52 };

		arr[0] = score1;
		arr[1] = score2;
		arr[2] = score3;

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}

		}
	}

	public void m1() {
		// 2차원 배열
		// 1차원 배열로 배열을 만든 것

		int[] num1 = { 1, 2, 3 };
		int[] num2 = { 2, 3, 4 };

		int[][] arr = new int[2][3]; // [일차원 배열의 갯수][일차원 배열 원수 갯수]
		arr[0] = num1;
		arr[1] = num2;

		System.out.println(arr);
		System.out.println(num1);
		System.out.println(num1);

		System.out.println(arr[0][0]);
		System.out.println(arr[1][2]);

		for (int i = 0; i < arr.length; i++) {
			int[] temp = arr[i];
			for (int j = 0; j < arr[i].length; j++) {
//				System.out.print(arr[i][j] + " ");
				System.out.print(temp[j] + " ");
			}
		}

		double a = 0.2;
		System.out.println("\n" + (int) (Math.ceil(a)));
	}
}
