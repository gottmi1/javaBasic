package kr.or.ddit.HomeWork;

import java.util.Scanner;

public class HomeWork07 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork07 obj = new HomeWork07();
//		obj.process1();
		obj.process2();

	}

	public void process2() {
		// 거스름돈 올바르게 주는 프로그램
		// 75550 -> 만원 7개, 5천원 1개, 500원 1개 50원 1개 이런식으로

		int[] coin = {10000,5000,1000,500,100,50,10};
		int[] moneyArr = new int[7];

		System.out.println("거스름돈 입력");
		int money = sc.nextInt();
		int StartMoney = money;
		
		// 풀이, 배열만 수정해서 자동으로 변경할 수 있어서 좋음
		for (int i = 0; i < coin.length; i++) {
			int count = money / coin[i];
			if(count == 0) continue;
			
			money = money%coin[i];
			System.out.printf("  %d원 %d개   ", coin[i],count);
		}
	}

	public void process1() {
		/*
		 * 5개의 단어 제공, 이 중 임의의 단어가 선택됨 선택된 단어의 철자를 섞어 사용자에게 제시함 사용자는 이를 보고 원래의 단어를 입력함
		 * 사용자가 단어를 맞출 때까지 반복하여 단어를 맞추면 시도 횟수 출력
		 */

		String[] words = { "apple", "banana", "love", "hope", "persimmon" };
		// 시도 횟수
		int cnt = 1;

		// 배열 중 랜덤으로 단어 고를 때 사용하는 랜덤
		int ran = (int) (Math.random() * words.length);

		// 선택된 단어
		String word = words[ran];

		// String => charArr
		// toCharArray메서드 사용

		// 선택된 단어를chArr로 변환
		char[] ch = word.toCharArray();

		// chArr를 무작위로 섞기위한 for문
		for (int i = 0; i < 1000; i++) {

			int cRan = (int) (Math.random() * ch.length);

			// 0번째를 계속 바꿔가면서 섞기
			char temp = ch[cRan];

			ch[cRan] = ch[0];
			ch[0] = temp;
		}

		// 섞인 chArr를 String화 시키기 위함
		String questionWord = "";

		for (int i = 0; i < ch.length; i++) {
			// 섞인 걸 담아줌
			questionWord += ch[i];
		}

		while (true) {

			System.out.printf("제시 단어 %s, 정답을 입력하세요.", questionWord);
			String answer = sc.next();

			if (answer.equals(word)) {
				System.out.println("정답 까지의 총 시도 횟수 " + cnt);
				break;
			} else {
				System.out.println("틀렸습니다. 다시 입력하세요.");
				cnt++;
				continue;
			}

		}

	}
}
