package kr.or.ddit.HomeWork;

import java.awt.Frame;
import java.util.Scanner;

public class HomeWork09 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork09 obj = new HomeWork09();
		obj.process();
	}

	public void process() {
		// 5명의 3과목(국어 영어 수학) 성적과 이름을 배열에 저장하고
		// 총점과 평균과 등수를 출력

		String[] name = { "김", "이", "최", "박", "조" };
		int[][] scores = { { 80, 70, 80, 0, 0, 1 }, // 3,4번째 인덱스는 총점,평균 넣는 곳, 맨 마지막은 등수
				{ 90, 85, 90, 0, 0, 1 }, { 90, 70, 75, 0, 0, 1 }, { 65, 75, 70, 0, 0, 1 }, { 80, 80, 70, 0, 0, 1 }, };

		// 총점,평균 구하기
		for (int i = 0; i < name.length; i++) {

			for (int j = 0; j < 3; j++) {
				scores[i][3] += scores[i][j];
			}

			scores[i][4] = scores[i][3] / 3;
		}

		for (int i = 0; i < scores.length; i++) {

			// 등수 구하기
			for (int j = 0; j < scores.length; j++) {
				if (scores[i][3] < scores[j][3]) {
					scores[i][5]++;
				}
			}
		}

//		for (int i = 0; i < scores.length; i++) {
//			for (int j = i + 1; j < scores.length; j++) {
//
//				if (scores[i][5] > scores[j][5]) {
//
//					int[] temp = scores[i];
//					scores[i] = scores[j];
//					scores[j] = temp;
//
//					String tempname = name[i];
//					name[i] = name[j];
//					name[j] = tempname;
//
//				}
//			}
//		}
		
		// 풀이
		for (int i = 0; i < scores.length - 1; i++) {
			for (int j = 0; j < scores.length - 1; j++) {

				if (scores[j][3] < scores[j+1][3]) {

					int[] temp = scores[j];
					scores[j] = scores[j+1];
					scores[j+1] = temp;

					String tempname = name[j];
					name[j] = name[j+1];
					name[j+1] = tempname;

				}
			}
		}

		for (int i = 0; i < scores.length; i++) {
			System.out.print(name[i] + " :");

			// 출력
			for (int j = 0; j < scores[i].length; j++) {
				System.out.printf(scores[i][j] + " ");
			}
			System.out.println();
		}

	}
}
