package kr.or.ddit.HomeWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class HomeWork19 {
	public static void main(String[] args) {

		HomeWork19 hw = new HomeWork19();
//		int oneDice = hw.rollDice();
//		int twoDice = hw.rollDiceTwice();
//		System.out.println(oneDice);
//		System.out.println(twoDice);

//		for (int i = 0; i < lstResult.size(); i++) {
//			System.out.println(lstResult.get(i));
//		}

		List lstResult = hw.throwDice(222222);
		hw.printHistogram(lstResult);

	}

	public int rollDice() {
		int result = new Random().nextInt(6) + 1;
		return result;
	}

	public int rollDiceTwice() {
		int result1 = rollDice();
		int result2 = rollDice();

		return result1 + result2;
	}

	public List throwDice(int num) {
		List<Integer> lst = new ArrayList();

		for (int i = 0; i < num; i++) {
			lst.add(rollDiceTwice());
		}

		return lst;
	}

	public void printHistogram(List lst) {
		int[] numArr = new int[11];
		int[] valueArr = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		for (int i = 0; i < lst.size(); i++) {
			for (int j = 0; j < numArr.length; j++) {
				if ((int) lst.get(i) == valueArr[j]) numArr[j]++;
			}
		}
		double[] intArr = new double[11];
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = numArr[i];
		}
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = intArr[i] / lst.size() * 100.0;
			System.out.print(i + 2 + ": \t");
			String str = "";
			for (int j = 0; j < intArr[i]; j++) {
				str += "*";
			}System.out.println(str);
		}
	}
	
}
