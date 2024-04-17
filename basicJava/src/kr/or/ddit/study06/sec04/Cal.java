package kr.or.ddit.study06.sec04;

public class Cal {
	public static void main(String[] args) {
		Cal cal = new Cal();

		int add = cal.add(10, 20);
		System.out.println(add);
		
		double add2 = cal.add(10.093, 252.5252);
		System.out.println(add2);

		int minus = cal.minus(23, 7);
		System.out.println(minus);
		
		double divide = cal.divide(10, 3);
		System.out.println(divide);
		
		int multiply = cal.multiply(10, 10);
		System.out.println(multiply);
		
		int rest = cal.rest(17, 10);
		System.out.println(rest);
	}

	public int add(int a, int b) {
		return a + b;
	}

	public double add(double a, double b) {
		return a + b;
	}
	
	public int minus(int a, int b) {
		return a - b;
	}

	public double divide(int a, int b) {
		return a / (double)b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}
	
	public int rest (int a, int b) {
		return a % b;
	}
}
