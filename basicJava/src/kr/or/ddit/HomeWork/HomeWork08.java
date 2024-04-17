package kr.or.ddit.HomeWork;

import java.util.Scanner;

public class HomeWork08 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork08 obj = new HomeWork08();
		obj.process();
	}

	public void process() {
		// 5개의 점수 입력받고
		// 길이가 5인 배열 생성
		// 그 후 값을 입력받는데 1이면 오름차순 2면 내림차순 정렬
		int[] score = new int[5];
		String str = "";
		
		System.out.println("5개의 점수를 입력하세요.");
		
		for (int i = 0; i < 5; i++) {
			score[i] = sc.nextInt();
		}

		System.out.printf("입력된 값은 ");
		for (int i = 0; i < score.length; i++) {
			System.out.print(score[i]+ " " );
		}
		System.out.printf("입니다 \n오름차순으로 정렬하려면 1, 내림차순으로 정렬하려면 2를 입력하세요.");
		
		
		while (true) {
			int input = sc.nextInt();
			
			if (input == 1) {
				str = "오름차순";
				
				for (int i = 0; i < score.length - 1; i++) {
					for (int j = 0; j < score.length - 1; j++) {
						if(score[j] > score[j+1]) {
							int temp = score[j];
							score[j] = score[j+1];
							score[j+1] = temp;
						}
					}
				}
			} else if (input == 2) {
				str = "내름차순";
				
				for (int i = 0; i < score.length - 1; i++) {
					for (int j = 0; j < score.length - 1; j++) {
						if(score[j] < score[j+1]) {
							int temp = score[j];
							score[j] = score[j+1];
							score[j+1] = temp;
						}
					}
				}
			} else {
				System.out.println("제대로 된 값을 입력하세요. 유효값 : 1,2");
				continue;
			}

			break;
		}

		System.out.print(str + "으로 정렬된 값 : ");
		for (int i = 0; i < score.length; i++) {
			System.out.print(score[i] + " ");
		}
	}
}
