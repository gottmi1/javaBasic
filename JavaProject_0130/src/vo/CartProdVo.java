package vo;

import lombok.Data;

@Data
public class CartProdVo {
	private int cart_no;
	private int prod_no;
	private int qty;
	
//	public int getCart_no() {
//		return cart_no;
//	}
//	public void setCart_no(int cart_no) {
//		this.cart_no = cart_no;
//	}
//	public int getProd_no() {
//		return prod_no;
//	}
//	public void setProd_no(int prod_no) {
//		this.prod_no = prod_no;
//	}
//	public int getQty() {
//		return qty;
//	}
//	public void setQty(int qty) {
//		this.qty = qty;
//	}
//	@Override
//	public String toString() {
//		return "CartProdVo [cart_no=" + cart_no + ", prod_no=" + prod_no + ", qty=" + qty + "]";
//	}
}
