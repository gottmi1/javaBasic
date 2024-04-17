package kr.or.ddit.study06.sec04;

import java.util.Arrays;

public class SortMethod {
	public static void main(String[] args) {

		SortMethod me = new SortMethod();

		int[] sortArr = { 6, 34, 7, 5, 7, 4, 246, 2346, 236, 236, 233, 3, 31, 2, 3, 2, 1 };

		me.Sort(sortArr, 1);
		System.out.println(Arrays.toString(sortArr));
		System.out.println(me.toArrayString(sortArr));

		me.Sort(sortArr, 2);
		System.out.println(Arrays.toString(sortArr));
		System.out.println(me.toArrayString(sortArr));
	}

	// 리턴타입 String 파라미터 배열
	public String toArrayString(int[] arr) {

		String result = "[";

		for (int i = 0; i < arr.length; i++) {

			if (i == arr.length - 1) {
				result += arr[i] + "] 만든 메서드";
			} else {
				result += arr[i] + ", ";
			}
		}
		return result;
	}

	// 파라미터로 int배열,int sel(값 1,2)
	// sel이 1일 때는 오름차순
	// sel이 2일 때는 내림차순
	public int[] Sort(int[] arr, int sel) {
		if (sel == 1)
			return Sort(arr);
		else
			return reverseSort(arr);
	}

	// int 배열을 파라미터로 받고 버블정렬로 오름차순으로 정렬 후 배열을 리턴
	public int[] Sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		return arr;
	}

	// int 배열을 파라미터로 받고 버블정렬로 오름차순으로 정렬 후 배열을 리턴
	public int[] reverseSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		return arr;
	}
}
