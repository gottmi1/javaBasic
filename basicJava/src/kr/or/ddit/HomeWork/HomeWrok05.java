package kr.or.ddit.HomeWork;

import java.util.Scanner;

public class HomeWrok05 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWrok05 hw = new HomeWrok05();
//		hw.method1();
//		hw.method2();
//		hw.method3();
//		hw.method4();
//		hw.method5();
//		hw.method6();
		hw.method7();
	}
	
	public void method1() {
		/*
		 *   for 문을 이용해서 다음 모양을 
		 *   그려 보시오.
		 *   
		 *     *
		 *     **   
		 *     ***
		 *     ****
		 *     
		 */
		
		System.out.println("메소드1 입력");
		int input = sc.nextInt();
		
		for(int i = 0; i < input; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.printf("*");
			}
			System.out.println();
		}
	}
	
	public void method2() {
		/*
		 *   for 문을 이용해서 다음 모양을 
		 *   그려 보시오.
		 *   
		 *        *
		 *       **   
		 *      ***
		 *     ****
		 *     
		 */
		
		System.out.println("메소드2 입력");
		int input = sc.nextInt();
		
		for(int i = 0; i < input; i++) {
			
			// 공백 추가
			for(int j = input - 1; j > i; j--) {
				System.out.printf(" ");
			}
			
			for(int k = 0; k <= i; k++) {
				System.out.printf("*");
			}
			
			System.out.println();
		}
		
	}
	
	public void method3() {
		/*
		 *   for 문을 이용해서 다음 모양을 
		 *   그려 보시오.
		 *   
		 *     ****
		 *     ***   
		 *     **
		 *     *
		 *     
		 */
				System.out.println("메소드3 입력");
				int input = sc.nextInt();
				
				for(int i = 0; i < input; i++) {
					for(int j = input; j > i; j--) {
						System.out.printf("*");
					}
					System.out.println();
				}
	}
	
	public void method4() {
		/*
		 *   for 문을 이용해서 다음 모양을 
		 *   그려 보시오.
		 *   
		 *     ****
		 *      ***   
		 *       **
		 *        *
		 *     
		 */
		
		System.out.println("메소드4 입력");
		int input = sc.nextInt();
		
		for(int i = 0; i < input; i++) {
			
			for(int j = 0; j < i ; j++) {
				System.out.printf(" ");
			}

			for(int k = input; k > i; k--) {
				System.out.printf("*");
			}
			
			System.out.println();
		}
	}
	
	public void method5() {
		/*
		 *   for 문을 이용해서 다음 모양을 
		 *   그려 보시오.
		 *   
		 *       *
		 *      ***
		 *     *****
		 *    *******   
		 *     
		 */
		System.out.println("메소드5 입력");
		int input = sc.nextInt();

		
		for(int i = 0; i <= input; i++) {
			
			for(int j = 0; j < input - i; j++) {
				System.out.printf(" ");
			}

			for (int k = 0; k < 2 * i - 1; k++) {
                System.out.print("*");
            }
			
			
			System.out.println();
		}
	}
	
	public void method6() {
		/*
		 *   for 문을 이용해서 다음 모양을 
		 *   그려 보시오.
		 *   
		 *    *******   
		 *     *****
		 *      ***
		 *       *
		 *     
		 */
		System.out.println("메소드6 입력");
		int input = sc.nextInt();

		
		for(int i = 0; i < input; i++) {
			
			for(int j = 0; j <= i; j++) {
				System.out.printf(" ");
			}

			for(int k = input * 2 + 1; k > 2 * i + 2; k--) {
				System.out.printf("*");
			}
			
			System.out.println();
		}
	}
	
	public void method7() {
		// 숫자 받아서 그 Wdith 가진 네모 그리기
		// **** 
		// *  *
		// *  *
		// ****
		
		System.out.println("메소드7 입력");
		int input = sc.nextInt();
		
		for(int i = 0; i < input; i++) {
			System.out.printf("*");
		}
		
		System.out.println("");
		
		for(int i = 2; i < input; i++ ) {
			System.out.printf("*");
			for(int j = 0; j < input - 2; j++) {
				System.out.printf(" ");
			}
			System.out.printf("*");
			System.out.println("");
		}
		
		for(int i = 0; i < input; i++) {
			System.out.printf("*");
		}
		
	}
}
