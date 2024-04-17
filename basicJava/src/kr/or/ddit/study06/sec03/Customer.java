package kr.or.ddit.study06.sec03;

public class Customer {
	// 이름 국가 나이
	String name;
	String nation;
	int age;

	@Override
	public String toString() {
		return "Customer [name=" + name + ", nation=" + nation + ", age=" + age + "]";
	}

	// 기본 생성자, 자동으로 만들어지지만 다른 생성자를 만들 경우 자동생성이 안 되기 때문에 명시해줘야 함
	public Customer() {

	}

	public Customer(String name, int age) {
		this.nation = "한국";
		this.name = name;
		this.age = age;
	}

	// 매개변수를 다르게 줘서 생성자에 다른 기능 추가 가능
	public Customer(String name, String nation, int age) {
		this.name = name;
		this.nation = nation;
		this.age = age;
	}
}
