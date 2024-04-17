package kr.or.ddit.study13;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExample {
	public static void main(String[] args) {
		/*
		 * Hash Map
		 * Key와 Value로 이루어짐
		 * 
		 * ket 값은 중복을 허용하지 않고 순서가 보장되지 않음
		 * Map타입 컬렉션
		 * 
		 * 주요메서드
		 * 
		 * .put(key, value) : 데이터 입력 key값은 중복되지 않음 value는 중복될 수 있음
		 * .get(key)  	    : 입력받은 value값을 key값을 통해 꺼내올 수 있음
		 * .keySet()		: key로 이루어진 hashSet 값을 가져옴
		 * 
		 * */
		
		HashMap map = new HashMap();
		// hash라는 것에 대해 공부해보면 좋음(중요한 키워드라고 함)
		
		// 형식 map.put(key, value), value는 중복가능, key는 중복 불가
		map.put("차정원","305호");
		map.put("권은비","305호");
		map.put("유지민","996호");
		
		String str = (String)map.get("차정원"); // 강제 형변환이 필요
		
		// put한 타입과 get하는 타입이 같아야 함
//		System.out.println(map.get("차정원"));
//		System.out.println(map.get("유지민"));
		
		
		// 제네릭(어떤 값을 받을지 처음에 설정함)
		// 제네릭 장점 : 키나 밸류가 의도하지 않은 타입으로 저장되는 것을 방지
		// 변수에 할당할 때 강제 형변환할 필요가 없어짐
		Map<String, String> map2 = new HashMap<String, String>();
		
		map2.put("차정원","305호");
		map2.put("권은비","305호");
		map2.put("유지민","996호");
		
		String str2 = map2.get("차정원"); // 제네릭으로 타입을 지정해줬으므로 형변환 필요없음
		
		Set set = map2.keySet();
		
		// 얘도 제네릭을 지정해주지 않으면 key를 할당할 때 강제형변환이 필요함.
		Iterator<String> it = set.iterator();
		// it.hasNext() : 다음 값이 있으면 true 리턴, 없으면 false == 루프 종료
		while(it.hasNext()) {
			// it.next는 리턴값이 이터레이트에 있는 현재 값이고, 순서를 다음으로 바꿔주는 역할을 하는 듯
			String key = it.next();
			String value = map2.get(key);
			System.out.println("key : " + key + ", value : " + value);
		}
	}
}
