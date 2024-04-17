package kr.or.ddit.HomeWork.home18;

public class priorityAllocation extends Schedular {
	// 3. priorityAllocation
	// getNextCall
	// -> 우선 순위가 높은 상담전화를 대기열에서 가져옴
	// sendCallToAgent
	// -> 업무 스킬이 가장 우수한 상담원에게 상담전화 분배
	public void getNextCall() {
		System.out.println("우선 순위가 높은 상담전화를 대기열에서 가져옴");
	}

	public void sendCallToAgent() {
		System.out.println("업무 스킬이 가장 우수한 상담원에게 상담전화 분배");
	}
}
