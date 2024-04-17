package kr.or.ddit.study05;

import java.util.Scanner;

public class ArrayExample {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayExample obj = new ArrayExample();
//		obj.method1();
//		obj.method2();
//		obj.method3();
//		obj.method4();
//		obj.method5();
		obj.method6();
	}
	
	public void method6() {
		// 로또 번호 6개 출력
		// 1. 로또 배열 45개 생성
		// 2. 각 배열에 값 넣기
		// 3. 배열 섞기
		// 4. 45개 배열 중 앞에서 6개 출력하기
		
		//1 배열 생성
		int[] lotto = new int[45];
		
		//2 값 넣기
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = i+1;
		}
		
		//3 섞기 
		for (int i = 0; i < 20000; i++) {

			// lotto의 몇번쨰 인덱스의 값을 교체할 것인가를 정함.
			int lRan = (int) (Math.random() * lotto.length);

			int temp = lotto[lRan];
			
			lotto[lRan] = lotto[0];
			
			lotto[0] = temp;
			
			// 1. temp에 뽑은 랜덤의 인덱스에 해당하는 값을 할당
			// 2. 방금 뽑은 랜덤값에 lotto의 0 번째 인덱스 값을 할당 
			//     ㄴ 여기서부터 lotto[lRan]이  쓸모 없어짐
			// 3. 위에서 temp에 할당한 랜덤 값을 다시 lotto[0]에 할당
		}
		
		//4 출력 &&
		//5 배열 길이가 6개인 배열을 생성하여 방금 출력한 로또 번호를 안에 넣기?
		
		int[] arr = new int[6];
		
		for (int i = 0; i < 6; i++) {
			System.out.printf("%d ", lotto[i]);
			arr[i] = lotto[i];
		}
		
		System.out.println("");
		
		for (int i = 0; i < 6; i++) {
			System.out.printf("%d ", arr[i]);
		}
	}
	
	public void method5() {
		// 타입별 초기값
		// bool false
		// char \u0000 == ''
		// byte, short, int, long 0
		// float 0.0f
		// double 0.0
		
		// referenceType : null
		
		boolean[] bArr = new boolean[2];
		
		for(int i = 0; i < bArr.length; i++) {
			System.out.println(bArr[i]);
		}
	}
	
	public void method4() {
		int[] scoreArr = {77,88,99,44,55,66,1222};
		
		// 간단한 Sort(Min Max구하기)
		
		int max = scoreArr[0];
		int min = scoreArr[0];
		
		for(int i = 0; i < scoreArr.length; i++) {
			
			if(max < scoreArr[i]) {
				max = scoreArr[i];
			}
			
			if(min > scoreArr[i]) {
				min = scoreArr[i];
			}
		}
		
		System.err.println("최대값 : " + max + ", 최솟값 : " + min);
	}
	
	public void method3() {
		int[] intArr = {5,4,3,2,1};
		
		for(int i = intArr.length - 1; i >= 0; i--) {
			System.out.println(intArr[i]);
		}
	}
	
	public void method2() {
		int[] intArr = new int[5];
		
		int[] intArr2 = {11,22,33,44,55};
		
	}

	public void method1() {
		// 학생 점수 10개 선언해서 값 저장
		int score1 = 100;
		int score2 = 90;
		int score3 = 70;
		int score4 = 80;
		int score5 = 30;
		int score6 = 90;
		int score7 = 50;
		int score8 = 70;
		int score9 = 80;
		int score10 = 100;

		int totalScore = 0;
		
		int[] scoreArr = { score1, score2, score3, score4, score5, score6, score7, score8, score9, score10 };
		
		for(int i = 0; i < scoreArr.length; i++) {
			totalScore += scoreArr[i];
		}
		
		System.out.println(totalScore);
	}
}
