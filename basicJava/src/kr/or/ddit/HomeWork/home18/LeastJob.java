package kr.or.ddit.HomeWork.home18;

public class LeastJob extends Schedular {
	// 2. LeastJob
	// getNextCall
	// -> 상담 전화를 대기열에서 차례대로 가져옴
	// sendCallToAgent
	// -> 대기열이 가장 짧은 상담원에게 상담전화를 분배
	public void getNextCall() {
		System.out.println("상담 전화를 대기열에서 차례대로 가져옴");
	}

	public void sendCallToAgent() {
		System.out.println("대기열이 가장 짧은 상담원에게 상담전화를 분배");
	}
}
