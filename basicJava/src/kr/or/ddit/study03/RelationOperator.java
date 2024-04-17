package kr.or.ddit.study03;

import java.util.Scanner;

public class RelationOperator {

	public static void main(String[] args) {

		// 관계 연산자

//		int a = 10;
//		int b = 7;
//		
//		System.out.println(a>b);
//		System.out.println(a<b);
//		System.out.println(a==b);
//		
//		System.out.println(a<=b);
//		System.out.println(a>=b);
//		System.out.println(a!=b);

		Scanner sc = new Scanner(System.in);

		System.out.println("점수를 입력하세요.");
		int score = sc.nextInt();

		if (score > 95) {
			System.out.println("A+");
		} else if (score > 90) {
			System.out.println("A");
		} else if (score > 85) {
			System.out.println("B+");
		} else if (score > 80) {
			System.out.println("B");
		} else if (score > 75) {
			System.out.println("C+");
		} else if (score > 70) {
			System.out.println("C");
		} else {
			System.out.println("F");
		}
	}
}
