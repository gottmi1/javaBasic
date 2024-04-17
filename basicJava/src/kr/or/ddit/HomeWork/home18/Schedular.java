package kr.or.ddit.HomeWork.home18;
// 추상클래스
public abstract class Schedular {
	// 추상메소드
	// 클래스와 메서드가 abstract면 여기서 구현하지 않고 상속한 메드에서 사용하겠다는 뜻
	
	// 추상클래스에도 일반 메서드를 만들 수는 있음.
	public void test() {
		
	}
	
	// abstract로 선언된 메서드는 이 클래스를 상속받은 클래스에서 반드시 오버라이딩 되어야 함
	// 자식 클래스가 이걸 오버라이딩 하지 않으면 에러가 뜨는데, 이걸 해결하려면 오버라이딩 하거나
	// 자식클래스도 abstract클래스여야 함
	public abstract void getNextCall();

	public abstract void sendCallToAgent();
}
