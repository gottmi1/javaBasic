package kr.or.ddit.study06.sec06;

public class ProdRunner {
	public static void main(String[] args) {

		Prod prod = new Prod();
		prod.setName("선풍기");
		prod.setPrice(1000000000);
		prod.setDescription("비싼 선풍기");

		System.out.println(prod.getName());
		System.out.println(prod.getPrice());
		System.out.println(prod.getDesc());
	}
}
