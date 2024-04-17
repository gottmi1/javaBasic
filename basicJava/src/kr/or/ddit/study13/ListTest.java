package kr.or.ddit.study13;

public class ListTest {
	
	private int total = 10;
	private int size = 0;
	
	private String[] arr;
	
	public void ListTest() {
		arr = new String[total];
	}
	
	public void ListTest(int total) {
		this.total = total;
		arr = new String[total];
	}
	
	public void add(String s) {
		
		if(size == total) {
			total += 10;
			String temp[] = arr.clone();
			
			arr = new String[total];
			for (int i = 0; i < temp.length; i++) {
				arr[i] = temp[i];
			}
		}
		arr[size++] = s;
	}
	
	public String get(int index) {
		return arr[index];
	}
	
	public int size() {
		return size;
	}
	
	public String remove(int index) {
		String r = arr[index];
		
		for (int i = index; i < size; i++) {
			arr[i] = arr[i+1];
		}
		
		return r;
	}
	
	public boolean contains(String search) {
		
		for (int i = 0; i < size; i++) {
			if(arr[i].equals(search)) return true;
		}
		return false;
	}
	
}
