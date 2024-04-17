package kr.or.ddit.HomeWork;

public class homeWork {
	public static void main(String[] args) {
		/*
		 * 지구 공전 주기 1년은 정확히 365일이 아니라 365.2422 일이다.
		 * 
		 * 해당 시간을 다음과 같이 나타내보자. 1년은 ?일 ?시간 ?분 ? 초 입니다. 출력.
		 * 
		 */

		double day = 365.2422;
		int days = (int) day;
		
		double hours = (day - days) * 24;
		int hour = (int)hours;
		
		double mins = (hours - hour) * 60;
		int min = (int)mins;
		
		double secs = (mins - min) * 60;
		int sec = (int)secs;
		
		System.out.println("1년은 " + days +"일 " + hour + "시간 " + min + "분 " + sec + "초 이다."  );
		
		
	}
}
