package kr.or.ddit.study05;

import java.util.Scanner;

public class ArrayExample02 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// 디버깅 브레이크포인트 찍고 f11

		ArrayExample02 obj = new ArrayExample02();
//		obj.m1(); // 기본 버블정렬
//		obj.m2(); // 향상된 버블정렬
//		obj.m3(); // 기본 버블정렬 직접 써보기
//		obj.m4(); // 선택 정렬
//		obj.m5(); // 얕은 복사 = 주소가 같아서 원본에 손상이 갈 수 있음
//		obj.m6(); // 깊은 복사
//		obj.m7(); // 로또 arraycopy로 복사하고 버블정렬
		obj.m8(); // 향상된 for문
	}

	public void m8() {
		String[] str = { "a", "b", "C" };

		for (String s : str) {
			System.out.print(s + " ");
		}

		System.out.println();
		
		int[] intArr = {1,2,3,4,3,2,1};

		for (int n : intArr) {
			System.out.print(n + " ");
		}
	}

	public void m7() {
		// 모든 번호
		int[] lotto = new int[45];
		// 선택된 로또 번호 가져올 배열
		int[] tempArr = new int[6];

		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = i + 1;
		}

		// 번호 섞기
		for (int i = 0; i < 20000; i++) {
			int lRan = (int) (Math.random() * lotto.length);
			int temp = lotto[lRan];
			lotto[lRan] = lotto[0];
			lotto[0] = temp;
		}

		// 선택된 번호 출력
		System.out.println("로또 번호");
		for (int i = 0; i < tempArr.length; i++) {
			System.out.printf("%d ", lotto[i]);
		}

		// 선택된 번호 6개 카피
		System.arraycopy(lotto, 0, tempArr, 0, tempArr.length);
		System.out.println();

		// 내림차순 정렬
		for (int i = 0; i < tempArr.length - 1; i++) {
			boolean flag = true;
			for (int j = 0; j < tempArr.length - 1; j++) {

				if (tempArr[j] > tempArr[j + 1]) {
					int temp = tempArr[j];
					tempArr[j] = tempArr[j + 1];
					tempArr[j + 1] = temp;
					// 바뀐게 있을 때 flag를 false로
					flag = false;
				}
			}
			// 바뀐게 없으면 == flag가 true면 break
			if (flag)
				break;

		}

		// 카피한 배열 출력
		System.out.println("정렬 된 번호");
		for (int i = 0; i < tempArr.length; i++) {
			System.out.printf("%d ", tempArr[i]);
		}

	}

	public void m6() {
		// 배열 복사
		// 2. 깊은 복사(deep copy)
		// 배열 공간을 별도로 확보(heap 영역에)
		// 2. 1 반복문 이용
		// 2. 2 System.arraycopy
		// 2. 3 clone

		// 1. 반복문 이용
		int[] source = { 1, 2, 3, 4, 5 };
		// 별도의 공간을 확보하여 주소를 공유하지 않음
		int[] target = new int[source.length];

		for (int i = 0; i < source.length; i++) {
			target[i] = source[i];
		}

		target[1] = 22;

		System.out.println("원본 배열");

		for (int i = 0; i < target.length; i++) {
			System.out.print(source[i] + " ");
		}

		System.out.println("\n");
		System.out.println("2 - 1 반복문 카피 배열");

		for (int i = 0; i < target.length; i++) {
			System.out.print(target[i] + " ");
		}

		// 2. System.arraycopy(소스변수, 복사시작할 인덱스, dest변수, 할당 시작할 인덱스, 카피할 길이(length))
		// 일부만 복사할 때 유용함
		int[] target2 = new int[5];
		System.arraycopy(source, 0, target2, 0, source.length);
		target2[1] = 222;

		System.out.println("\n");
		System.out.println("2 - 2 arraycopy 카피 배열");

		for (int i = 0; i < target2.length; i++) {
			System.out.print(target2[i] + " ");
		}

		// 3. clone() 메서드 사용하여 카피
		int[] target3 = source.clone();

		target3[1] = 2222;

		System.out.println("\n");
		System.out.println("2 - 3 clone 카피 배열");

		for (int i = 0; i < target3.length; i++) {
			System.out.print(target3[i] + " ");
		}
	}

	public void m5() {
		// 배열 복사
		// 1. 얕은 복사(shallow copy)
		// 복사된 배열이나 원본 배열이 변경될 때 서로간의 값이 같이 변경
		// 주소값이 같아서 원본에 손상이 옴

		int[] source = { 1, 2, 3, 4, 5 };
		int[] target = source;

		target[1] = 10;

		System.out.println("원본 배열");
		for (int i = 0; i < target.length; i++) {
			System.out.print(source[i] + " ");
		}
		System.out.println(" ");
		System.out.println("복사 배열");
		for (int i = 0; i < target.length; i++) {
			System.out.print(target[i] + " ");
		}

	}

	public void m4() {
		// 선택 정렬
		// 배열에서 최소값을 찾아서 0번이랑 교체

		int[] num = { 70, 65, 44, 100, 86, 32 };

		for (int i = 0; i < num.length - 1; i++) {

			// 현재 인덱스에 해당하는 값을 min으로 설정
			int min = num[i];
			// 그 인덱스를 iDx에 저장
			int iDx = i;

			for (int j = i; j < num.length; j++) {
				// min이 num[j]보다 클 때 min과 Idx에 다른 값을 재할당
				if (min > num[j]) {
					min = num[j];
					iDx = j;
				}
			}

			int temp = num[i];
			// 위에서 찾은 최소 값을 num[i]에 할당
			num[i] = num[iDx];
			// 배열의 iDx값은 num[i]에 들어있던 값을 할당
			num[iDx] = temp;
		}

		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
	}

	public void m3() {
		int[] score = { 70, 65, 44, 100, 86, 32 };

		for (int i = 0; i < score.length - 1; i++) {

			for (int j = 0; j < score.length - 1; j++) {

				if (score[j] < score[j + 1]) {
					int temp = score[j];
					score[j] = score[j + 1];
					score[j + 1] = temp;
				}
			}
		}

		// 오름차 순으로 출력
		for (int i = 0; i < score.length; i++) {
			System.out.print(score[i] + " ");
		}
		// min max
		System.out.printf("\nMin 값 : %d , Max 값 : %d", score[score.length - 1], score[0]);

	}

	public void m2() {
		// 향상된 버블 정렬
		// 버블 정렬 진행 중 더이상 값이 바뀌지 않을 때 중단
		int[] num = { 95, 87, 45, 15, 98, 62, 85 };

		for (int i = 0; i < num.length; i++) {

			boolean flag = true;

			for (int j = 0; j < num.length - 1; j++) {

				if (num[j] < num[j + 1]) {
					int temp = num[j];

					num[j] = num[j + 1];

					num[j + 1] = temp;
					flag = false;
				}

			}
			if (flag)
				break;
		}

		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
	}

	public void m1() {

		// 버블 정렬

		int[] num = { 95, 87, 45, 15, 98, 62, 85 };

		for (int i = 0; i < num.length; i++) {

			// 현재 인덱스와 현재 인덱스 + 1을 계산해야 하므로 num.length - 1만큼 반복
			for (int j = 0; j < num.length - 1; j++) {

				// 현재 인덱스보다 뒤 인덱스가 클 경우
				if (num[j] > num[j + 1]) {

					// temp에 현재 인덱스 값을 넣고
					int temp = num[j];

					// 현재 인덱스에 다음 인덱스 값을 할당
					num[j] = num[j + 1];

					// 다음 인덱스에 temp(현재 인덱스 값)을 할당
					num[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}

	}
}
