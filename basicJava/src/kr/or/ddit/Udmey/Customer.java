package kr.or.ddit.Udmey;

public class Customer {
	private String name;
	private Address homeAddress;
	private Address workAddress;
	
	public Customer(String na, Address homeAdd) {
		this.name = na;
		this.homeAddress = homeAdd;
	}
}
