package kr.or.ddit.study05;

public class ReferenceType {
	public static void main(String[] args) {
		String str1 = "홍길동";
		String str2 = "홍길동";
		String str3 = "강감찬";
		String str4 = new String("강감찬");
		String str5 = new String("강감찬");
		// Stack영역의 값을 비교함
		// 참조 타입의 경우 주소값이 비교 됨 = 4와 5는 기본타입이 아닌
		// new로 할당했기 때문에 주소가 서로 다름

		System.out.println(str1 == str2); // true
		System.out.println(str3 == str4); // false
		System.out.println(str4 == str5); // false
		// String비교할 떄 이것보다 아래 equals로 비교하는 게 좋다고 함

		System.out.println(str3.equals(str4));
		// 주소 값이 아니라 Stack에 저장된 값이 같은지 비교
		
		Student s1 = new Student();
		System.out.println(s1);
		
		String str6 = "";   // 데이터는 없지만 주소가 할당은 되어있음.
		String str7 = null; // 주소 값이 없다(Heap에 업음)
		String str8;        // 위와 같음, 아무 것도 할당되지 않았을 경우 기본적으로 null이 들어감
	}
}

class Student {
	String name;
	int age;

	Student() {
		name = "홍길동";
		age = 99;
	}
	
	public void Hi() {
		System.out.println(age + "살 " + name + "입니다.");
	}
	//	alt + shift + s하면 제너레이트 함수가 선택해서 생성할 수 있음

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
}
