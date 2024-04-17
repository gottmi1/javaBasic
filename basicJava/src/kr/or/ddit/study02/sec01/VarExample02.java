package kr.or.ddit.study02.sec01;

public class VarExample02 {

	static int a1 = 10;
	// static이 아니면 내부에 있는 main함수에서도 사용할 수가 없음

	public static void main(String[] args) {
		int a2 = 11;

		System.out.println(a1);
		System.out.println(a2);

		VarExample02 ve = new VarExample02();
		// 얘는 본인 클래스 내부에 있는 메서드를 부를 때도
		// 본인을 새로 생성해서 하는 듯??
		ve.method01();
	}

	public void method01() {
		
		int a3 = 12;

		System.out.println(a1);
		System.out.println(a3);
		{
			int a4 = 13;
			System.out.println(a4);
		}
		
		int a4 = 15;
		System.out.println(a4);
	}

}
