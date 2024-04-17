package kr.or.ddit.study07.sec01.Phone;

public class PhoneMain {
	public static void main(String[] args) {

//		System.out.println("폴더폰");
//		FolderPhone fp = new FolderPhone();
//		fp.call();
//
//		System.out.println();
//		System.out.println("카메라폰");
//		CameraPhone cp = new CameraPhone();
//		cp.camera();
//		cp.call();
//
//		System.out.println();
//		System.out.println("스마트폰");
//		SmartPhone sp = new SmartPhone();
//		sp.call();
		
		System.out.println();
		System.out.println("아이폰");
		IPhone1Gen ip = new IPhone1Gen();
		ip.camera();
		ip.abbStore();
		ip.touch();
	}
}
