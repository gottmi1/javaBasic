package kr.or.ddit.study06.sec04;

public class MethodExample04 {
	public static void main(String[] args) {
		MethodExample04 me = new MethodExample04();
		
		// 메서드 오버로딩 : 파라미터에 따라 호출되는 메서드가 다름
		// 메서드 오버라이딩 : 부모 클래스에서 정의한 내용을 재정의 함
		
		me.method("10");
		me.method();
		me.method(1,2);
		me.method(10);
	}

	public void method() {
		System.out.println("1");
	}

	public void method(int n) {
		System.out.println("2");
	}

	public void method(String s) {
		System.out.println("3");
	}
	
	public void method(int a, int b) {
		System.out.println("4");
	}
}
