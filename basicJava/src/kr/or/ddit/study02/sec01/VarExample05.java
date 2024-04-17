package kr.or.ddit.study02.sec01;

// 임포트는 패키지 아래에 해야 함
import java.time.LocalDateTime;

public class VarExample05 {
	public static void main(String[] args) {
		// 변수 이름 규칙

		// 1. 첫 번째 글자는 문자이거나 $ 혹은 _ 이어야 함 숫자로 시작하면 안 됨
		int a;
		int $a;
		int _a;

		// 2. 대소문자 구분
		int Value = 1;
		int value = 2;

		System.out.println(Value);
		System.out.println(value);
		
		// 3. 카멜케이스 사용
		int camelCase;

		// 변수 길이에 제한은 없으며 예약어는 사용 불가
		int dgkdnfgknsdgksdnfgkdlj43o3wjfs09gf3ewokvsldkv;
		//int int; << 사용 불가
		
		System.out.println(LocalDateTime.now());
	}
}
