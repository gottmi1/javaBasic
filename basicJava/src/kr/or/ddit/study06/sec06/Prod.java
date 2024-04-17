package kr.or.ddit.study06.sec06;

public class Prod {
	private int price;
	private String name;
	private String description;

	public void setPrice(int pri) {
		this.price = pri;
	}

	public void setName(String na) {
		this.name = na;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return description;
	}

	@Override
	public String toString() {
		return "상품 [가격 : " + price + ", 품명 : " + name + ", 설명 : " + description + "]";
	}

}
