package kr.or.ddit.study09;

import kr.or.ddit.study09.ClassA.ClassB.ClassC;

public class ClassA {

	public static void main(String[] args) {
		ClassA a = new ClassA();
		ClassB b = a.new ClassB();
		ClassC c = b.new ClassC();
	}

	// 클래스 B의 내용을 숨기고 싶을 때 사용 , 사용할 일은 잘 없고 이런 게 있다 정도
	class ClassB {
		class ClassC {
			
		}
	}

}
