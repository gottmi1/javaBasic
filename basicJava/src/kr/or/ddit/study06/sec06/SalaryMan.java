package kr.or.ddit.study06.sec06;

public class SalaryMan {
	private String name;
	private int age;

	public void setName(String na) {
		this.name = na;
	}

	public void setAge(int ag) {
		if (age < 0 || age > 122) {
			System.out.println("잘못된 입력값");
		} else {
			this.age = ag;
		}
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "SalaryMan [name=" + name + ", age=" + age + "]";
	}
}
