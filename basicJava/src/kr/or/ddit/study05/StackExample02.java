package kr.or.ddit.study05;

public class StackExample02 {
	public static void main(String[] args) {

		int a = 5;
		// 1 stack

		if (a == 5) {
			char b = 'a';
			// 2 stack

			if (b == 'a') {
				String c = "test";
				// 3 Heap에 test라는 객체가 생성 되고
				// 그 주소 값을 가져와 Stack영역의 String c에 들어감
			}
			// 3 사라짐

			if (true) {
				String d = "test";
				// 4 Heap에 test라는 객체가 생성 되고
				// 그 주소 값을 가져와 Stack영역의 String d에 들어감
			}
			// 4 사라짐

		}
		// 2 사라짐

		double e = 10.7;
		// 5 stack
	}
}
