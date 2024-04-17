package kr.or.ddit.HomeWork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HomeWork20 {
	public static void main(String[] args) {

		HomeWork20 hw = new HomeWork20();
		hw.process();
	}

	public void process() {
		List<Map> parkList = dataInput();
//		System.out.println(parkList);

		String carNum = "5961";
		// 입력한 차량 주차 시간 계산
		// 입력한 차량 주차 요금 계산
		getMin(parkList, carNum);
//		int a =getMin2(parkList, carNum);
//		System.out.println("총 주차 시간 : " + a + "분");
//		System.out.println("총 주차 요금 : " + pay(a) + "원");
	}

	// 주차 요금 계산 - 완
	public int pay(int min) {
		// 기본 시간 기본 요금 단위 단위 요금
		// 60분 2000원 10분 300원
		int pay = 0;

		if (min <= 60) {
			pay = 2000;
			return pay;
		} else {
			while (true) {
				if (min >= 60 && pay == 0) {
					pay += 2000;
					min -= 60;
				} else if (min >= 10) {
					pay += 300;
					min -= 10;
				} else {
					if (min == 0) {
						break;
					} else {
						pay += 300;
						break;
					}
				}
			}
		}

		return pay;
	}

	public int getMin2(List<Map> parkList, String carNum) {
		int sum = 0;
		int temp = 0;
		
		for (int i = 0; i < parkList.size(); i++) {
			
			Map map = parkList.get(i);
			
			String time = (String)map.get("시각");
			String num = (String)map.get("차량번호");
			String inout = (String)map.get("내역");
			
			if(!carNum.equals(num)) continue;
			
			if(inout.equals("입차")) {
				temp = getTime(time);
			}
			else if(inout.equals("출차")) {
				sum += getTime(time) - temp;
			}
		}
		return sum;
	}
	
	public void getMin(List<Map> parkList, String carNum) {

		// 차량번호(carNum)에 해당하는 주차 시간 계산(분)
		// 부서별 총합 구한 것 처럼 구하면 됨

		// 들어온 시간
		int inTime = 0;
		// 나간 시간
		int outTime = 0;

		// 몇 번째 사용 요금인지 카운트(없어도 됨)
		int cnt = 1;

		for (int i = 0; i < parkList.size(); i++) {
			// List의 현재 인덱스에 해당하는 Map 가져옴
			Map map = parkList.get(i);

			if (map.get("차량번호").equals(carNum)) {

				if (map.get("내역").equals("입차")) {
					inTime = getTime((String) map.get("시각"));
				}

				if (map.get("내역").equals("출차")) {
					outTime = getTime((String) map.get("시각"));

					int resultTime = outTime - inTime;
					System.out.println("낼 돈 :" + pay(resultTime));
					System.out.println("주차 시간 :" + resultTime);
				}
			}

			// 처음 문제였던 부분,
			// int time = getTime((String)map.get("시각"))
			// 으로 이걸 첨부터 겟타임으로 시간 변경해줘서 1047 - 345 이딴 값이 들어왔음
			// 그 값으로 inTime이랑 outTime에서 한번 더 해주니까 될 턱이 없었음

			// 차량번호가 carNum과 같을 때
//			if (map.get("차량번호").equals(carNum)) {
//				// 내역이 입차일 때
//				if(map.get("내역").equals("입차")){
//					// 현재 시각을 inTime에 저장
//					inTime = getTime((String)map.get("시각"));
//				}
//				// 내역이 출차일 때
//				if(map.get("내역").equals("출차")) {
//					// 현재 시각을 outTime에 저장
//					outTime = getTime((String)map.get("시각"));
//					
//					// outTime에서 inTime을 뺀 값을 변수로 저장
//					int resultTime = outTime - inTime;
//					
//					// 출차시 출력용
//					System.out.println("--------------------------------------------");
//					System.out.println(cnt + "번째 사용 시간 : " + resultTime + " 분");
//					System.out.println(cnt + "번째 사용 요금 : " + pay(resultTime) + " 원");
//					System.out.println("--------------------------------------------");
//					// 출차시 출력용
//					// 몇 번째 주차인지 표시하기 위함(없어도 됨)
//					cnt++;
//				} 
				System.out.println(map);
		}

	}

	// 입차시간,출차시간 구하는 메서드 - 완
	public int getTime(String time) {
		int hour = Integer.parseInt(time.split(":")[0]);
		int min = Integer.parseInt(time.split(":")[1]);

		return hour * 60 + min;
	}

	// map만들어서 list담아주기 - 완
	public List<Map> dataInput() {
		List<Map> lst = new ArrayList<Map>();
		// 주차리스트 데이터
		// 시각 차량번호 내역
		// 05:34 5961 입차
		Map m1 = new HashMap();
		m1.put("시각", "05:34");
		m1.put("차량번호", "5961");
		m1.put("내역", "입차");
		// 06:00 0000 입차
		Map m2 = new HashMap();
		m2.put("시각", "06:00");
		m2.put("차량번호", "0000");
		m2.put("내역", "입차");
		// 06:34 0000 출차
		Map m3 = new HashMap();
		m3.put("시각", "06:34");
		m3.put("차량번호", "0000");
		m3.put("내역", "출차");
		// 07:59 5961 출차
		Map m4 = new HashMap();
		m4.put("시각", "07:59");
		m4.put("차량번호", "5961");
		m4.put("내역", "출차");
		// 07:59 0148 입차
		Map m5 = new HashMap();
		m5.put("시각", "07:59");
		m5.put("차량번호", "0148");
		m5.put("내역", "입차");
		// 18:59 0000 입차
		Map m6 = new HashMap();
		m6.put("시각", "18:59");
		m6.put("차량번호", "0000");
		m6.put("내역", "입차");
		// 19:09 0148 출차
		Map m7 = new HashMap();
		m7.put("시각", "19:09");
		m7.put("차량번호", "0148");
		m7.put("내역", "출차");
		// 22:59 5961 입차
		Map m8 = new HashMap();
		m8.put("시각", "22:59");
		m8.put("차량번호", "5961");
		m8.put("내역", "입차");
		// 23:00 5961 출차
		Map m9 = new HashMap();
		m9.put("시각", "23:00");
		m9.put("차량번호", "5961");
		m9.put("내역", "출차");
		// 23:00 0000 출차
		Map m10 = new HashMap();
		m10.put("시각", "23:00");
		m10.put("차량번호", "0000");
		m10.put("내역", "출차");

		lst.add(m1);
		lst.add(m2);
		lst.add(m3);
		lst.add(m4);
		lst.add(m5);
		lst.add(m6);
		lst.add(m7);
		lst.add(m8);
		lst.add(m9);
		lst.add(m10);

		return lst;
	}
}
