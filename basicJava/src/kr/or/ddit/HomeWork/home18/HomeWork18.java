package kr.or.ddit.HomeWork.home18;

import java.util.Scanner;

public class HomeWork18 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("전화 상담의 분배 방식 선택");
		System.out.println(" R : RoundRobn");
		System.out.println(" L : LeastJob");
		System.out.println(" P : priorityAllocation");
		System.out.print(" 선택 >> ");
		
		Schedular s = null;
		
		String input = sc.next().toUpperCase();
		
		if(input.equals("R")) s = new RoundRobn();
		if(input.equals("L")) s = new LeastJob();
		if(input.equals("P")) s = new priorityAllocation();
		
		s.getNextCall();
		s.sendCallToAgent();
	}
}
