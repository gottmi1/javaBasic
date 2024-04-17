package kr.or.ddit.HomeWork;

import java.io.FileReader;

public class HomeWork13 {
	// 과제 10을 메서드로 바꿔서 구현
	// 1. dataInput();
	// 클래스에 데이터 입력 및 클래스를 클래스 배열에 담기
	// 2. 평균과 총점을 구하는 메서드
	// 3. 랭크를 구하는 메서드
	// 4. 정렬하는 메서드
	// 5. 출력하는 메서드

	public static void main(String[] args) {
		HomeWork13 hw = new HomeWork13();
		Student[] students = hw.dataInput();

		hw.setValue(students);
		hw.printStudent(students);
	}

	// 출력 메서드
	public void printStudent(Student[] students) {
		for (Student S : students) {
			System.out.printf("%s  국어 : %d점 영어 : %d점 수학 : %d점 총점 : %d점 평균 : %.1f점  등수 : %d\n", S.name, S.kor, S.eng,
					S.math, S.total, S.average, S.rank);
		}
	}

	// 평균 총점 등수 구하는 메서드
	public void sumScore(Student[] students) {
		// 평균 총점 구하기
		for (Student S : students) {
			S.total = S.kor + S.eng + S.math;
			S.average = S.total / 3.0;
		}

		// 등수 구하기
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students.length; j++) {
				if (students[i].total < students[j].total)
					students[i].rank += 1;
			}
		}
	}

	
	
	// 총점 리턴
	public int sumScore(Student stu) {
		return stu.kor + stu.eng + stu.math;
	}

	// 평균 리턴
	public double sumAverage(Student stu) {
		return stu.total / 3.0;
	}

	// 동작
	public void	setValue(Student[] students) {

		// 총점 평균 구함
		for (int i = 0; i < students.length; i++) {
			students[i].total = sumScore(students[i]);
			students[i].average = sumAverage(students[i]);
		}
		
		// 총점순으로 정렬
		for (int i = 0; i < students.length; i++) {
			for (int j = i + 1; j < students.length; j++) {
				if (students[i].total < students[j].total) {
					Student temp = students[i];
					students[i] = students[j];
					students[j] = temp;
				}
			}
		}
		
		// 정렬 후 등수 추가
		setRank(students);
	}
	
	// 소트 후 인덱스에 해당하는 숫자를 등수에 더함
	public void setRank(Student[] stuArr) {
		for (int i = 0; i < stuArr.length; i++) {
			stuArr[i].rank += i;
		}
	}

	// 클래스에 데이터 넣기
	public Student[] dataInput() {
		Student s1 = new Student("차정원", 99, 100, 99);
		Student s2 = new Student("카리나", 79, 70, 91);
		Student s3 = new Student("박새로이", 89, 80, 93);
		Student s4 = new Student("이름뭐", 79, 90, 79);
		Student s5 = new Student("하지", 99, 50, 86);

		Student[] students = { s1, s2, s3, s4, s5 };

		return students;
	}

}