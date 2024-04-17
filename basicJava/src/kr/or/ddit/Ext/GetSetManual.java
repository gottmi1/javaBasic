package kr.or.ddit.Ext;

public class GetSetManual {

	public static void main(String[] args) {
		// public 변수 할당
		noGetSet ngs = new noGetSet();
		ngs.name = "차정원";
		ngs.age = 33;
		System.out.printf("이름 : %s , 나이 : %d\n", ngs.name, ngs.age);

		// private 변수할당
		GetSet gs = new GetSet();
		gs.setName("권은비");
		gs.setAge(28);
		System.out.printf("이름 : %s , 나이 : %d\n", gs.getName(), gs.getAge());

		// 위 두 방식은 같은 동작을 함
		// 그렇다면 왜 굳이 게터세터를 사용하는가?
//		
//		1. 캡슐화 (Encapsulation): private 변수와 getter/setter 메서드를 사용함으로써 캡슐화를 실현할 수 있습니다. 캡슐화는 데이터와 해당 데이터를 조작하는 메서드를 하나의 단일 단위로 묶어 관리하는 것을 의미합니다. 이를 통해 객체의 내부 상태를 외부에서 직접 조작하지 못하도록 제한할 수 있습니다.
//		2. 정보 은닉 (Information Hiding): private 변수는 외부에서 직접 접근할 수 없기 때문에 객체의 내부 구현을 숨길 수 있습니다. 이는 객체의 내부 동작에 대한 세부 정보를 숨기고, 객체 간 인터페이스만 노출함으로써 시스템의 유지보수성과 확장성을 높일 수 있습니다.
//		3. 유효성 검사 (Validation): setter 메서드를 사용하여 private 변수에 값을 할당할 때, 유효성 검사 코드를 추가할 수 있습니다. 이를 통해 올바르지 않은 값이 변수에 할당되는 것을 방지할 수 있습니다.
//		4. 코드 변경 용이성: 클래스 내부의 구현을 변경할 때, getter와 setter를 통한 접근을 유지하면서 내부 구현을 수정할 수 있습니다. 이는 외부에서 사용되는 코드에 영향을 최소화하며 유연성을 제공합니다.
//		5. 종속성 감소 (Reduced Dependency): public 변수를 사용하면 다른 클래스가 직접 해당 변수에 접근할 수 있으므로, 변수의 이름이나 타입 변경 등이 영향을 미칠 수 있습니다. 그러나 getter와 setter를 통한 간접 접근을 사용하면 내부 구현을 변경할 때 다른 클래스에 미치는 영향을 최소화할 수 있습니다.
//		6.보안 강화: private 변수를 사용하면 외부에서 직접 접근할 수 없어 정보 누출을 방지하고, getter와 setter 메서드를 통해 제어된 접근을 제공함으로써 보안을 강화할 수 있습니다.
//		이러한 이유 때문이라고 함
	}
}

// getter setter를 사용하지 않은 public 변수를 가진 클래스
class noGetSet {
	public String name;
	public int age;
}

// getter setter를 사용해야 하는 private 변수를 가진 클래스
class GetSet {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}