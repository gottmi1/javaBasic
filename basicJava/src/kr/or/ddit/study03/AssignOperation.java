package kr.or.ddit.study03;

public class AssignOperation {
	public static void main(String[] args) {
		
		AssignOperation obj = new AssignOperation();
//		obj.method1();
		obj.method2();
		
	}
	
	public void method1() {
		int a = 10;
		int b = 4;
		
		System.out.println(a += b);
		System.out.println(a -= b); 
		System.out.println(a *= b);
		System.out.println(a /= b);
		System.out.println(a %= b);
	}
	
	public void method2() {
		int a = 5;
		int b = 4;
		
		int result = a + b;
		
		System.out.println(result *= b);
		System.out.println(result += a);
		System.out.println(result %= a);
	}
}
