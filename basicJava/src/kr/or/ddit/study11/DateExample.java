package kr.or.ddit.study11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateExample {

	static boolean deb = true;
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		DateExample de = new DateExample();

//		de.m1();
//		de.m2();
//		de.m3();
//		de.m4();
//		de.m5();
//		de.m6();
		de.m7();
	}

	private void m7() {
		Calendar cal = Calendar.getInstance();
		
//		cal.set(Calendar.YEAR, 2023);
		// Month는 0부터 시작함
//		cal.set(Calendar.MONTH, 0);
		cal.add(Calendar.DATE, 364);
		
		Date d = cal.getTime();
		System.out.println(d);
	}

	private void m6() {
		// 오늘 날짜로부터 스캐너를 통해 입력받은 날짜 만큼 더하기
		// ex input이 10이면 output은 2024/01/27
		System.out.println("오늘로부터 n일 지난 일 수를 구함");
		String inputStr = sc.next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		Date d1 = new Date();
		Date d2 = new Date(d1.getTime()+1000*60*60*24*Long.parseLong(inputStr));
		
		String result1 = sdf.format(d1);
		String result2 = sdf.format(d2);
		
		System.out.println("오늘 날짜 "+ result1);
		System.out.println("결과 날짜 "+ result2);
	}

	private void m5() {
		// 날짜입력 받고 오늘 날짜랑 며칠 차이나는지
		System.out.println("입력 형식 : 2020/01/01");
		String curTime = sc.next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		try {
			Date date = sdf.parse(curTime);
			System.out.println(date);
			
			Date currentTime = new Date();
			
			long time = date.getTime() - currentTime.getTime();
			double days = (double)time/86400/1000;
			System.out.println(days);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void m4() {
		String dateStr = "2024/01/17";
		// 형식을 맞춰야 바꿀 수 있음
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		Date date;
		try {
			date = sdf.parse(dateStr);
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void m3() {
		// SimpleDateFormat
		// String -> Date
		// Date -> String
		
		// Date 객체를 원하는 포맷으로 변경하는 클래스
		
		// 2024/01/17
		// 2024.01.17
		// 2024-01-17
		
		Date d = new Date();
		
		// 소문자 m은 min을 의미하기 때문에 달은 M으로 입력해야 함
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd/ HH:mm:ss");
		String result = sdf1.format(d);
		System.out.println(result);
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		result = sdf2.format(d);
		System.out.println(result);
		
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		result = sdf3.format(d);
		System.out.println(result);
		
		SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy년MM월dd일 HH시간mm분ss초");
		result = sdf4.format(d);
		System.out.println(result);
	}

	private void m2() {
		Date d = new Date();
		System.out.println(d);
		// 세계표준시간 기준으로 1970년 1월 1일 0시 기준으로 몇 ms가 지났는지
		long time = d.getTime() / 1000;

		long min = 60;
		long hour = min * 60;
		long day = hour * 24;
		long year = day * 365;

		int years = (int) (time / year);
		System.out.println(years);
		time %= year;

		int days = (int) (time / day);
		System.out.println(days);
		time %= day;

		int hours = (int) (time / hour);
		System.out.println(hours);
		time %= hour;

		int mins = (int) (time / min);
		System.out.println(mins);
		time %= min;

		System.out.printf("%d년  %d일 %d시간 %d분 %d초 지남", years, days, hours, mins, time);

	}

	public void m1() {
		Date d1 = new Date();
		System.out.println(d1);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Date d2 = new Date();
		System.out.println(d2);

		long time = d2.getTime() - d1.getTime();
		System.out.println(time / 1000 + "초");

//		System.out.println(d1.getTime());
	}
}
