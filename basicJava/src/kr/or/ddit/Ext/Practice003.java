package kr.or.ddit.Ext;

public class Practice003 {
	public static void main(String[] args) {
		// ▽ 실행
		
	}
}

class Student{
	String name;
	int kor;
	int eng;
	int math;
	
	int totlaScore; // 총점
	double average; // 평균점수
	
	
	
	// 1. name과 kor eng math를 매개변수로 받는 생성자 생성
	
	// 2. 리턴값이 int인 총점 반환 메서드 생성
	
	// 3. 리턴값이 double인 평균점수 반환 메서드 생성
	
	// 4. 
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", totlaScore="
				+ totlaScore + ", average=" + average + "]";
	}
}
