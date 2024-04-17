package kr.or.ddit.study07.sec02;

import java.util.Scanner;

public class AnimalMain {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Animal ani = null;
		System.out.println("1은 강아지 2는 고양이");
		int input = sc.nextInt();
		
		// 이 행위를 클래스의 다형성이라고 함
		if(input == 1) ani = new Dog();
		if(input == 2) ani = new Cat();

		ani.cry();
	}
}
