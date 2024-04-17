package kr.or.ddit.study05;

public class StackExample {
	public static void main(String[] args) {
		
		int a = 10;
		// 1. Stack에 저장
		
		if(a == 10) {
			int b = 8;
			int c = 7;
			// 2. Stack에 저장
		}
		// if블록 외부로 가게되면 변수가 Stack에서 사라짐**
		
		int d = 5;
		// 3. if문 안에 있던 Stack이 사라짐
	}
}
