package kr.or.ddit.study06.sec04;

import java.util.Date;

public class Recursion {
	public static void main(String[] args) {
		Recursion r = new Recursion();
		long fact = r.factorial(3);
		System.out.println(fact);
		
		int n = r.sum(10);
		System.out.println(n);
		
		Date d1 = new Date();
		long febo = r.febo(66);
		Date d2 = new Date();
		System.out.println(d2.getTime() - d1.getTime()+ "ms");
		System.out.println(febo);
	}
	
	long[] result = new long[100];
	
	public long febo(int num) {
		if(num == 1 || num == 2) return 1;
		
		// 중복되는 애는 계산안하고 값이 없는 애만 계산해서 넣어주겠다는 뜻
		if(result[num] != 0) {
			return result[num];
		}else {
			long i = febo(num-1) + febo(num-2);
			result[num] = i;
			return i;
		}
	}
	
	public long factorial(int i) {
		if(i == 1) return 1;
		return factorial(i - 1) * i;
	}
	
	public int sum(int num) {
		// for문사용 없이 재귀함수 구조로 1+2+3... +num총합 구하기
		if(num == 1) return 1;
		return sum(num - 1) + num;
	}
	
}
