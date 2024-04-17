package kr.or.ddit.study13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class SetExample {
	
	public static void main(String[] args) {
		// 컬렉션 명
		// HashSet
		// Set 타입의 대표 컬렉션
		
		// 특징
		// key로 이루어짐
		// key값은 중복을 허용하지 않고 순서가 보장되지 않음
		
		// 주요 메소드
		// .add(key)       		<< 값 추가
		// .remove(key)    		<< 값 제거
		// .contains(key)    	<< 포함 여부
		// .iterator()    		<< 전체 출력을 위한 이터레이터
		
//		HashSet set1 = new HashSet();
		Set set = new HashSet(); // Set이 인터페이스고 HashSet이 그걸 상속받은 놈
		set.add("가");
		set.add("가");
		set.add(1);
		set.add("a");
		set.add("라");
		set.add(10.5);

		set.remove("라");

		System.out.println(set.contains("가"));
		
		Iterator it = set.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();
		
		
		Set lotto = new HashSet();
		while(lotto.size()<6) {
			lotto.add(new Random().nextInt(45) + 1);
		}
		
		Iterator it2 = lotto.iterator();
		while(it2.hasNext()) {
			System.out.print(it2.next() + "\t");
		}
		
 	}
	
	
}
