package kr.or.ddit.Ext;

import java.util.Arrays;
import java.util.Scanner;

public class SortExample {
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int[] arr = { 99, 102, 3929, 142, 56, 3, 664, 221, 433, 2, 7 };
		
		SortExample obj = new SortExample();
		obj.SelectSort(arr);
		
		System.out.println("선택정렬된 배열 : " + Arrays.toString(arr));
	}

	public void SelectSort(int[] arr) {
		int n = arr.length;
		
		// 인자로 받은 arr의 길이 -1 만큼 반복
		for(int i = 0; i < n - 1; i++) {

			// 
			int minIdx = i;
			
			for(int j = i + 1; j < n; j++) {
				
				if(arr[j] < arr[minIdx]) {
					minIdx = j;
				}
				
			}
			
			int temp = arr[minIdx];
			arr[minIdx] = arr[i];
			arr[i] = temp;
		}
	}
}
