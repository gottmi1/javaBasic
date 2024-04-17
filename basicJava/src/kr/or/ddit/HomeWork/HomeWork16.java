package kr.or.ddit.HomeWork;

import java.util.Scanner;

public class HomeWork16 {
	Scanner sc = new Scanner(System.in);

	Member[] memList = new Member[100];
	int cur = 0;

	public static void main(String[] args) {
		HomeWork16 obj = new HomeWork16();

		obj.process();
	}

	public void process() {
		// 회원관리 시스템
		while (true) {
			System.out.println("1. 회원 가입");
			System.out.println("2. 회원 탈퇴"); // 생략
			System.out.println("3. 정보 수정");
			System.out.println("4. 회원 전체 정보 출력");
			// 1,2,3,4 입력을 받았을 떄 해당하는 메서드 실행
			int input = sc.nextInt();

			if (input == 1) {
				System.out.println("아이디를 입력해 주세요.");
				String id = sc.next();
				System.out.println("이름를 입력해 주세요.");
				String name = sc.next();
				System.out.println("나이를 입력해 주세요.");
				int age = sc.nextInt();
				addMember(id, name, age);
			} else if (input == 2) {
				withdrawal();
			} else if (input == 3) {
				update();
			} else if (input == 4) {
				printList(memList);
			} else {
				System.out.println("잘못된 입력");
				continue;
			}
		}
	}

	public void addMember(String id, String na, int ag) {
		Member mem = new Member();
		// setter로 정보입력
		mem.setId(id);
		mem.setName(na);
		mem.setAge(ag);

		memList[cur++] = mem;
	}

	public void printList(Member[] memList) {

		for (int i = 0; i < cur; i++) {
			System.out.printf("[%d번 회원] id : %s , 이름  : %s , 나이  : %d\n", i + 1, memList[i].getId(),
					memList[i].getName(), memList[i].getAge());
		}
	}

	public void update() {
		printList(memList);
		System.out.println();

		System.out.println("수정할 회원 번호 입력 : ");
		int num = sc.nextInt();
		Member mem = memList[num - 1];
		if (memList[num - 1] == null) {
			System.out.println("해당 회원이 없습니다.");
			return;
		} else {
			System.out.println("1. Id 수정");
			System.out.println("2. 이름 수정");
			System.out.println("3. 나이 수정");
			int selectNum = sc.nextInt();

			if (selectNum == 1) {

				System.out.println("수정할 Id 입력");
				String replaceId = sc.next();
				mem.setId(replaceId);

			} else if (selectNum == 2) {

				System.out.println("수정할 이름 입력");
				String replaceName = sc.next();
				mem.setName(replaceName);

			} else if (selectNum == 3) {

				System.out.println("수정할 나이 입력");
				int replaceAge = sc.nextInt();
				mem.setAge(replaceAge);

			} else {

				System.out.println("잘못된 값 입력");
				return;

			}

			memList[num - 1] = mem;
			System.out.println("값이 수정되었음.");
		}

	}

	public void withdrawal() {
		printList(memList);
		System.out.println("탈퇴할 회원 번호를 입력하세요.");
		int num = sc.nextInt() - 1;

		Member[] tempMemList = new Member[100];
		int cnt = 0;

		for (int i = 0; i < cur; i++) {
			if (num != i) tempMemList[cnt++] = memList[i];
		}
		cur--;
		memList = tempMemList;
	}
}

class Member {
	private String id;
	private String name;
	private int age;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// getter setter 사용하기

}