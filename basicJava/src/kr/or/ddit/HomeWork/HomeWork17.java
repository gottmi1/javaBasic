package kr.or.ddit.HomeWork;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class HomeWork17 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomeWork17 obj = new HomeWork17();
		obj.process();
	}

	public void process() {

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");

		while (true) {

			Date date = cal.getTime();

			cal.set(Calendar.DATE, 1);

			int day = cal.get(Calendar.DAY_OF_WEEK);

			String currentYearMonth = sdf.format(date);

			System.out.println("----------------------------------------------------");
			System.out.println("  이전달  1<\t\t   " + currentYearMonth + "   \t\t>2 다음달   ");
			System.out.println("----------------------------------------------------");
			System.err.print("일\t월\t화\t수\t목\t금\t토");

			int lastDay = cal.getActualMaximum(Calendar.DATE);

			int startDay = 1;

			for (int i = 0; i < lastDay + day; i++) {
				if (i < day) {
					System.out.print("\t");
				}
				if (i >= day) {
					System.out.print(startDay++ + "\t");
				}
				if (i % 7 == 0) {
					System.out.println();
				}
				if (i == lastDay + day - 1) {
					System.out.println();
				}
			}

			System.out.println("이전달으로 가려면 1을 다음 달으로 가려면 2를 입력.");
			int input = sc.nextInt();
			
			int currentMonth = cal.get(Calendar.MONTH);

			if (input == 1) {
				cal.set(Calendar.MONTH, --currentMonth);
			} else if (input == 2) {
				cal.set(Calendar.MONTH, ++currentMonth);
			}
		}
	}
}
