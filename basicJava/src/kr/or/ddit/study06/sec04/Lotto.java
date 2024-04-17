package kr.or.ddit.study06.sec04;

import java.util.Arrays;
import java.util.Random;

public class Lotto {

	public static void main(String[] args) {
		Lotto lot = new Lotto();
//		int[] lotto = lot.generateLotto();
//
//		System.out.println(Arrays.toString(lotto));

//		int[][] lotPaper = lot.lottoPaper();
//		for (int i = 0; i < lotPaper.length; i++) {
//			System.out.println(Arrays.toString(lotPaper[i]));
//		}

		int[][][] lottoBundle = lot.lottoBundle(8000);

		for (int i = 0; i < lottoBundle.length; i++) {
			for (int j = 0; j < lottoBundle[i].length; j++) {
				System.out.println(Arrays.toString(lottoBundle[i][j]));
			}
			System.out.println("========================");
		}
	}

	public int[] generateLotto() {
		int[] lotto = new int[6];

		for (int i = 0; i < lotto.length; i++) {
			// 랜덤 뽑기
			int random = new Random().nextInt(45) + 1;
			lotto[i] = random;

			// 이번 루프에 뽑은 숫자를 이미 포함하고있는지 확인
			for (int j = 0; j < i; j++) {
				// 있으면 i--하고 다시 루프
				if (lotto[j] == random) {
					i--;
					break;
				}
			}
		}

		Arrays.sort(lotto);
		return lotto;
	}

	public int[][] lottoPaper() {
//		int[][] lp = new int[5][6];
//
//		for (int i = 0; i < lp.length; i++) {
//			lp[i] = generateLotto();
//		}

		// 오버로딩 된 거 재활용
		return lottoPaper(5);
	}

	public int[][] lottoPaper(int num) {
		int[][] lp = new int[num][6];

		for (int i = 0; i < lp.length; i++) {
			lp[i] = generateLotto();
		}

		return lp;
	}

	public int[][][] lottoBundle(int money) {
		int papers = money / 5000;
		int remaining = money % 5000;

		if (remaining != 0)
			papers++;

		int[][][] bundle = new int[papers][5][6];

		for (int i = 0; i < papers; i++) {
			bundle[i] = lottoPaper();
		}

		if (money % 5000 != 0) {
			bundle[papers - 1] = lottoPaper(remaining / 1000);
		}

		return bundle;
	}
}
