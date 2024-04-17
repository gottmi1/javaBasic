package kr.or.ddit.HomeWork;

public class HomeWork10 {
	public static void main(String[] args) {

		// for문으로 담아줄 점수,이름 등의 배열 생성
		int[] korScore = { 90, 97, 100, 70, 88 };
		int[] engScore = { 88, 68, 98, 98, 99 };
		int[] mathScore = { 100, 90, 77, 99, 77 };
		String[] nameArr = { "사람1", "사람2", "사람3", "사람4", "사람5" };

		// 인스턴스 생성
		Student st1 = new Student();
		Student st2 = new Student();
		Student st3 = new Student();
		Student st4 = new Student();
		Student st5 = new Student();

		// 배열에 담아줌
		Student[] score = { st1, st2, st3, st4, st5 };

		// 생성한 인스턴스에 각각 값 할당
		for (int i = 0; i < score.length; i++) {
			score[i].name = nameArr[i];
			score[i].kor = korScore[i];
			score[i].eng = engScore[i];
			score[i].math = mathScore[i];
			score[i].sumScore();
		}

		// 기본 출력
		System.out.println("기본 출력");
		for (int i = 0; i < score.length; i++) {
			System.out.println(score[i]);
		}

		// 총점 순으로 정렬
		for (int i = 0; i < score.length - 1; i++) {
			for (int j = 0; j < score.length - 1; j++) {
				if (score[j].total < score[j + 1].total) {
					Student temp = score[j];
					score[j] = score[j + 1];
					score[j + 1] = temp;
				}
			}
		}

		// 중첩 for문으로 등수 정렬
//		for (int i = 0; i < score.length; i++) {
//			for (int j = 0; j < score.length; j++) {
//				if(score[j].total < score[i].total) {
//					score[j].rank++;
//				}
//			}
//		}

		// 정렬된 배열 index에 따른 등수 추가
		for (int i = 0; i < score.length; i++) {
			score[i].rank += i;
		}

		// 총점 순으로 정렬한 결과 출력
		System.out.println("총점순으로 정렬한 출력");
		for (int i = 0; i < score.length; i++) {
			System.out.println(score[i]);
		}
	}
}

// 숙제용으로 사용할 클래스를 이 클래스 안에 생성 함
class Student {
	// 국어 영어 수학 총점 평균 등수
	// 이름
	String name;

	int kor;
	int eng;
	int math;
	int total;

	double average;

	int rank = 1;

	// 총점 평균 구하는 메서드
	public void sumScore() {
		this.total = this.kor + this.eng + this.math;
		this.average = this.total / 3.0;
	}

	@Override
	public String toString() {
		return "Student [이름 =" + name + ", 국어=" + kor + ", 영어=" + eng + ", 수학=" + math + ", 총점=" + total + ", 평균="
				+ Math.round(average * 10.0) / 10.0 + ", 등수=" + rank + "등]";
	}

	public Student() {

	}

	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

}