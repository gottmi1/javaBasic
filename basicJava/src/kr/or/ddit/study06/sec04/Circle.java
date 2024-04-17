package kr.or.ddit.study06.sec04;

public class Circle {

	double pie = 3.141592653589793238462643383279;

	public static void main(String[] args) {
		Circle circle = new Circle();

		System.out.println(circle.area(19));
		System.out.println(circle.area(19.832));
		System.out.println(circle.circumference(19));
		System.out.println(circle.circumference(19.832));
	}

	// 넓이 구하는 메서드
	// 파라미터 r , pie * r * r
	public double area(double r) {
		return r * r * pie;
	}

	// 길이 구하는 메서드
	// 파라미터 r , 길이는 pie * 2 * r
	public double circumference(double r) {
		return r * 2 * pie;
	}
}
