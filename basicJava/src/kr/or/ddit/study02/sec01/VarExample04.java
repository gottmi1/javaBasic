

package kr.or.ddit.study02.sec01;

public class VarExample04 {

	static int x = 10;
	static int y = 10;
	static int z = 10;

	public static void main(String[] args) {

		VarExample04 ve = new VarExample04();
		ve.method01();
	}

	// 전역 변수 x,y,z를 출력하는 메서드
	public void method01() {
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
	}

}
