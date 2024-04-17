package kr.or.ddit.study07.sec01.pen;

public class BallPen extends Pen{

	private String color;
	
	
	
	@Override
	public String toString() {
		return "BallPen [color=" + color + ", amount" + getAmount() + "]";
	}

	@Override
	public int getAmount() {
		return super.getAmount();
	}
	
	@Override
	public void setAmount(int amount) {
		super.setAmount(amount);
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
