package kr.or.ddit.study02.sec02;

public class StringExmaple {
	public static void main(String[] args) {

		// 그냥 초기화
		String name = "이상혁";
		// 그냥 초기환데 귀찮기만 함 Class 인스턴스나 DateTime같은 자료형에 사용
		String name2 = new String("대상혁");

		System.out.println(name + "," + name2);

		// string은 기본타입이 아님

		// \n : 커서 위치 다음 줄로 바꿈
		// \t : 커서 위치 탭 한번 한 위치로 옮김
		// \r : 커서 위치 현재줄의 처음으로 옮김 \n이랑 똑같은데?
		// \" , \' : 큰따옴표, 작은따옴표 출력

		String NameEnter = name2 + "\n\n" + name;
		System.out.println(NameEnter);

		String NameTab = name2 + "\t" + name;
		System.out.println(NameTab);

		String NameTTa = "\"" + name2 + "\t" + name + "\"";
		System.out.println(NameTTa);

		String NameSlash = "\\";
		System.out.println(NameSlash);

		String year = "22" + 20 + 23;
		// 문자열 + int = 걍 문자열임(선언 타입이 String이라)
		// 단  int + int + string 같이 문자열이 나오기 전에 연산 되는 건 int로 연산 됨
		System.out.println(year);
	}
}
