package kr.or.ddit.study11;

public class StringLang {
	public static void main(String[] args) {

		StringLang s1 = new StringLang();
//		s1.method1();
//		s1.method2();
//		s1.method3();
//		s1.method4();
//		s1.method5();
//		s1.method6();
//		s1.method7();
		s1.method8();
	}

	public void method8() {
		String test = "스플릿 테스트, test1, test2, test3, test4";
		System.out.println(test);

		String[] testArr = test.split(",");
		for (String s : testArr) {
			System.out.println(s.trim());
		}
	}

	public void method7() {
		String str = null;

		// isEmpty가 먼저 나올 수 없음
		if (str == null || str.isEmpty()) {
			System.out.println("문자열이 비어 있음");
		}
	}

	public void method6() {
		String test = "가나다라마바 phone";

		test = test.replace("phone", "핸드폰");
		System.out.println(test);

		// 정규식 사용
//		test.replaceAll(regex(표현식),바꿀단어);
	}

	public void method1() {
		String test = "문자열 test";

		for (int i = 0; i < test.length(); i++) {
			System.out.println(test.charAt(i));
		}

		for (char c : test.toCharArray()) {
			System.out.println(c);
		}
	}

	public void method2() {
		String test = "문자열 test";
		String search = "test";

		if (test.contains(search)) {
			System.out.println(search + "값이 포함되어 있음");
		}

		search = test;
		if (test.equals(search)) {
			System.out.println(search + "값이 동일함");
		}
	}

	public void method3() {
		String test = "문자열 test 입니다.";

		String start = "문자열";
		if (test.startsWith(start)) {
			System.out.println(start + "로 시작합니다.");
		}

		String end = "입니다.";
		if (test.endsWith(end)) {
			System.out.println(end + "로 끝납니다.");
		}
	}

	public void method4() {
		String test = "abcd";
		System.out.println(test);
		test = test.toUpperCase();
		if (test.contains("ABCD")) {
			System.out.println("포함");
		}
		System.out.println(test);

		System.err.println("----------");
		test = "대문자 ABCD";
		System.out.println(test);
		test = test.toLowerCase();
		System.out.println(test);
	}

	public void method5() {
		String test = "        문자 테스트";
		System.out.println(test);
		System.out.println("-------");
		test = test.trim(); // 앞뒤 공백을 제거하는데 많이 쓰인다고 함??
		System.out.println(test);
		System.out.println("-------");
	}
}
