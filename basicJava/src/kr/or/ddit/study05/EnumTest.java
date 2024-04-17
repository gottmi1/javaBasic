package kr.or.ddit.study05;

public class EnumTest {
	public static void main(String[] args) {
		EnumTest et = new EnumTest();

		et.weekDay(Week.MON);
//		et.weekDay("MON");

		for (Week w : Week.values()) {
			System.out.println(w.s);
		}
	}

	public void weekDay(String day) {
		if (day.equals("FRI")) {
			System.out.println("금요일입니다");
		} else if (day.equals("MON")) {
			System.out.println("월요일입니다");
		} else if (day.equals("TUE")) {
			System.out.println("화요일입니다");
		} else if (day.equals("WED")) {
			System.out.println("수요일입니다");
		} else if (day.equals("THU")) {
			System.out.println("금요일입니다");
		} else if (day.equals("SAT")) {
			System.out.println("토요일입니다");
		} else if (day.equals("SUN")) {
			System.out.println("일요일입니다");
		} else {
			System.out.println("ㅗ");
		}
	}

	public void weekDay(Week day) {
		System.out.println("enum" + day.s + "입니다. ");
	}
}
