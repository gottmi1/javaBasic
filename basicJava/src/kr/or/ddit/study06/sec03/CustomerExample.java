package kr.or.ddit.study06.sec03;

public class CustomerExample {
	public static void main(String[] args) {
		Customer cs1 = new Customer("박새로이",27);
		
		Customer cs2 = new Customer();
		cs2.name = "다마네기";
		cs2.nation = "일본";
		cs2.age = 17;
		
		Customer cs3 = new Customer("샤오후","중국",27);
		
		System.out.println(cs1);
		System.out.println(cs2);
		System.out.println(cs3);
	}
}
