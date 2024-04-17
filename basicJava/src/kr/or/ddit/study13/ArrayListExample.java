package kr.or.ddit.study13;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
	public static void main(String[] args) {
		// ArrayList
		// - 1차원 배열구조
		// - 중복을 허용하고 순서화 제공
		// - List 타입의 대표 컬렉션
		
		// 주요메소드
		// .add(object)
		// .clear()
		// .contains(object)
		// .get(index)
		// .remove(index) , 삭제 하기 전에 반환도 함
		
		List lst = new ArrayList();
		
		lst.add("가");
		lst.add("가");
		lst.add("나");
		lst.add("다");
		lst.add("라");
		lst.add("마");
		
		String str = (String)lst.remove(1);
		System.out.println("삭제 : " + str);
		
		
		for (int i = 0; i < lst.size(); i++) {
			System.out.println(lst.get(i));
		}
		
	}
}
