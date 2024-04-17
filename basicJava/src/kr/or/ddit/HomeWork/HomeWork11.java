package kr.or.ddit.HomeWork;

public class HomeWork11 {
	
	public static void main(String[] args) {
		/*
		 * 1. 생성자를 통해 x, y, 높이, 너비를 입력 받고 
		 * area 값은 자동으로 계산 하도록 하자. 
		 * area 넓이 값은 높이 * 너비
		 */
		
		// 1번, 인자로 값 다 받아서 area 계산
		Rectangle r1 = new Rectangle(10, 20, 20, 20);
		System.out.println(r1);

		/*
		 * 2. 생성자를 통해 Point, 높이, 너비를 입력 받고 point 클래스에서 꺼낸
			x, y 값을 통해 1번 문제에 생성자를 호출 해보도록 하자.
		 */
		
		// 2번, point 높이 너비 받아서 출력
		Point p1 = new Point(50, 50);

		Rectangle r2 = new Rectangle(p1, 30, 60);
		System.out.println(r2);

	}
}

class Rectangle {
	int area;
	int x;
	int y;
	int height;
	int width;

	@Override
	public String toString() {
		return "Rectangle [area=" + area + ", x=" + x + ", y=" + y + ", height=" + height + ", width=" + width + "]";
	}

	public Rectangle(int x, int y, int height, int width) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;

		this.area = this.height * this.width;
	}

	public Rectangle(Point point, int height, int width) {
		this(point.x, point.y, height, width);
	}

}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
