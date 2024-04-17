package kr.or.ddit.study06.sec03;

public class Student {
	String nation;
	String room;
	String name;
	int age;

	
	
	@Override
	public String toString() {
		return "Student [nation=" + nation + ", room=" + room + ", name=" + name + ", age=" + age + "]";
	}

	public Student(String nation, String room, String name, int age) {
		this.nation = nation;
		this.room = room;
		this.name = name;
		this.age = age;
	}

	public Student(String room, String name, int age) {
		this("한국", room, name, age);
	}

	public Student(String name, int age) {
		this("305호", name, age);
	}
}
