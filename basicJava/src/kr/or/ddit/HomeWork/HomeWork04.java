package kr.or.ddit.HomeWork;

import java.util.Scanner;

public class HomeWork04 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork04 obj = new HomeWork04();
		obj.process();
	}

	public void process() {

		// 가위 바위 보
		// 0 1 2
		// 컴퓨터가 가위바위보 랜덤으로 뽑고
		// 내가 입력한 숫자랑 비교해서 이겼으면 이겼다 졌으면 졌다 출력

		System.out.println("0 : 가위, 1 : 바위, 2 : 보 중 선택하세요.");
		int myPickNum = sc.nextInt();

		int ComNum = (int) (Math.random() * 3);

		String myRPS = "";
		String comRPS = "";

		if (ComNum == 0) {
			comRPS = "가위";
		} else if (ComNum == 1) {
			comRPS = "바위";
		} else {
			comRPS = "보";
		}

		if (myPickNum == 0) {
			myRPS = "가위";
		} else if (myPickNum == 1) {
			myRPS = "바위";
		} else {
			myRPS = "보";
		}

		boolean myDefeatFlag1 = myPickNum == 0 && ComNum == 1;
		boolean myDefeatFlag2 = myPickNum == 1 && ComNum == 2;
		boolean myDefeatFlag3 = myPickNum == 2 && ComNum == 0;

		
		if (myPickNum == ComNum) {
			System.out.printf("컴퓨터 : %s, 나 : %s 비겼습니다.", comRPS, myRPS);
		} else if (myDefeatFlag1 || myDefeatFlag2 || myDefeatFlag3) {
			System.out.printf("컴퓨터 : %s, 나 : %s. 졌습니다.", comRPS, myRPS);
		} else if (myPickNum > 2) {
			System.out.println("제대로 된 값을 입력하세요.");
		} else {
			System.err.printf("컴퓨터 : %s, 나 : %s. 이겼습니다.", comRPS, myRPS);
		}

	}
}
