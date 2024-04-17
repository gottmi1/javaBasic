package kr.or.ddit.study02.sec02;

public class BooleanExample {
	public static void main(String[] args) {

		boolean flag = false;
		int age = 5;

		// 아래 조건 충족시 true가 됨(c#에선 본 적 없는 거 같음)
		flag = (age > 18);

		if (flag) {
			System.out.println("성인");
		} else {
			System.out.println("미성년");
		}

		
		
	}
}
