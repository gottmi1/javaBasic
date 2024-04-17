package kr.or.ddit.study07.sec01.Phone;

public class IPhone1Gen extends SmartPhone{

	public void abbStore() {
		System.out.println("앱스토어 기능");
	}
	
	// 기존의 CameraPhone의 camera메서드를 수정 -> 부모 클래스의 메서드를 오버라이드
	@Override
	public void camera() {
		// super : 부모 클래스의 해당 요소를 가져오는 것
		// super.camera();
		System.out.println("오버라이드 된 고성능 찰칵");
	}
}
