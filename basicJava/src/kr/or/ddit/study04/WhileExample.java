package kr.or.ddit.study04;

import java.util.Scanner;

public class WhileExample {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		WhileExample obj = new WhileExample();
//		obj.method1();
		obj.method2();
//		obj.method3();
//		obj.method4();
//		obj.method5();
	}
	
	public void method5() {
		asd : while(true) {
			System.out.println("외부 와일문");
			while(true) {
				System.out.println("내부 와일문");
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break asd;
				// 여기 브레이크 넣으면 해당 스코프만 break돼서 
				// 외부 와일문으로 빠져나가 다시 계속 반복 됨
				// 그럴 때 while문에 label을 붙여서 어떤 while문을 종료시킬지
				// 선택할 수 있음
			}
		}
	}

	public void method4() {
		// do While문, 조건이 어찌됐던 한 번은 실행되어야 할 때 사용
		do {
			System.out.println("한 번은 실행");
		}
		while(false);
	}
	
	public void method3() {
		int i = 1;
		// 해당 타입의 +,-범위를 넘어서게 되면 오버플로우.언더플로우가 발생함
		while(i > 0) {
			i += 10000;
			System.out.println(i);
		}

	}

	public void method2() {
		// 커피 매장
		// 메뉴
		// 아메리카노 : 1000
		// 카페라떼 : 1500
		// 자바칩 프라푸치노 : 2000

		int Price = 0;
		int ame = 0;
		int latte = 0;
		int frappuccino = 0;

		while (true) {
			System.out.println("====메뉴====");
			System.out.println("1. 아메리카노           : 1000");
			System.out.println("2. 카페라떼              : 1500");
			System.out.println("3. 자바칩 프라푸치노 : 2000");
			System.out.println("4. 주문 완료.");
			System.out.println("====메뉴====");
			int select = sc.nextInt();

			if (select == 1) {
				Price += 1000;
				ame++;
				System.err.println("아메리카노 주문, 총 가격은" + Price + "원 입니다.");
			} else if (select == 2) {
				Price += 1500;
				latte++;
				System.err.println("카페라떼 주문, 총 가격은" + Price + "원 입니다.");
			} else if (select == 3) {
				Price += 2000;
				frappuccino++;
				System.err.println("자바칩 프라푸치노 주문, 총 가격은" + Price + "원 입니다.");
			} else if (select == 4) {
				System.out.printf("주문 끝, 아메리카노 %d잔, 라떼 %d잔, 프라푸치노 %d잔, 총 %d잔의 음료의 가격은 %d원 입니다.", ame, latte,
						frappuccino, ame + latte + frappuccino, Price);
				break;
			} else {
				System.out.println("유효값을 입력해주세요.");
				continue;
			}
		}
	}

	public void method1() {
		// 조건이 만족하는 한 무한 루프
		// 조건이 true일 땐 무한반복 == for(;;)

		int a = 4;

		while (a >= 1) {
			System.out.println("반복중");
			a -= 1;
		}

		System.out.println("와일문 종료");

	}
}
