package kr.or.ddit.HomeWork;

public class HomeWork14 {
	public static void main(String[] args) {
//		HomeWork14 hw = new HomeWork14();

		Deck deck = new Deck();
		Card[] cardList = deck.cardList();
//		deck.print(cardList);
		deck.shuffle(cardList);
//		deck.print(cardList);

		deck.win(cardList);
	}
}

class Card {
	String type;
	int num;

	public Card(String type, int num) {
		this.type = type;
		this.num = num;
	}

	@Override
	public String toString() {
		String n = "";
		if (num == 1)
			n = "A";
		else if (num == 10)
			n = "T";
		else if (num == 11)
			n = "J";
		else if (num == 12)
			n = "Q";
		else if (num == 13)
			n = "K";
		else
			n += num;
		return type + n;
	}

}

class Deck {
//	Card[] cardList;

	public Card[] cardList() {
		Card[] cardList = new Card[52];

		for (int i = 1; i <= cardList.length; i++) {
			int num = i % 13;
			if (num == 0)
				num = 13;
			String type = "";
			if ((i - 1) / 13 == 0)
				type = "♠";
			if ((i - 1) / 13 == 1)
				type = "◈";
			if ((i - 1) / 13 == 2)
				type = "♥";
			if ((i - 1) / 13 == 3)
				type = "♣";
			cardList[i - 1] = new Card(type, num);
		}
		return cardList;
	}

	public void print(Card[] cardList) {
		for (Card card : cardList) {
			System.out.println(card);
		}
	}

	// 카드 섞기
	public void shuffle(Card[] cardList) {
		for (int i = 0; i < 50000; i++) {

			int lRan = (int) (Math.random() * cardList.length);
			// int IRan = new Random().nextInt(cardList.length); 위 아래 같음
			Card temp = cardList[lRan];
			cardList[lRan] = cardList[0];
			cardList[0] = temp;
		}
	}

	// 이겼는지 확인
	public void win(Card[] cardList) {

		Card mine = cardList[0];

		int random = (int) (Math.random() * cardList.length - 1) + 1;

		Card enermyCard = cardList[random];

		if (mine.num >= enermyCard.num) {
			if (mine.num == 1 && enermyCard.num != 1) {
				System.out.println("내가 뽑은 카드 : " + mine + " 상대방이 뽑은 카드 : " + enermyCard + " 결과 : 승리");
				return;
			} else if (enermyCard.num == 1 && mine.num != 1) {
				System.out.println("내가 뽑은 카드 : " + mine + " 상대방이 뽑은 카드 : " + enermyCard + " 결과 : 패배");
				return;
			}

			if (mine.type.equals("♠")) {
				System.out.println("내가 뽑은 카드 : " + mine + " 상대방이 뽑은 카드 : " + enermyCard + " 결과 : 승리");
			} else if (mine.type.equals("◈")
					&& (enermyCard.type.equals("♥") || enermyCard.type.equals("♣") || enermyCard.type.equals("◈"))) {
				System.out.println("내가 뽑은 카드 : " + mine + " 상대방이 뽑은 카드 : " + enermyCard + " 결과 : 승리");
			} else if (mine.type.equals("♥") && (enermyCard.type.equals("♣") || enermyCard.type.equals("♥"))) {
				System.out.println("내가 뽑은 카드 : " + mine + " 상대방이 뽑은 카드 : " + enermyCard + " 결과 : 승리");
			} else {
				System.out.println("내가 뽑은 카드 : " + mine + " 상대방이 뽑은 카드 : " + enermyCard + " 결과 : 패배");
			}

//			System.out.println("내가 뽑은 카드 : " + mine + " 상대방이 뽑은 카드 : " + enermyCard + " 결과 : 승리");
		} else {
			System.out.println("내가 뽑은 카드 : " + mine + " 상대방이 뽑은 카드 : " + enermyCard + " 결과 : 패배");
		}
	}
}