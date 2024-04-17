package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.UserService;
import util.ScanUtil;
import util.View;

public class MainController {
	static public Map<String, Object> sessionStorage = new HashMap<>();
	UserService userService = UserService.getInstance();
	
	public static void main(String[] args) {
		new MainController().start();
	}

	private void start() {
		View view = View.MAIN;
		while (true) {
			switch (view) {
			case MAIN:
				view = home();
				break;
			case USER_LOGIN:
				view = login();
				break;
			case USER_JOIN:
				view = join();
				break;
			case USER_LIST:
				view = list();
				break;
			case USER_UPDATE:
				view = update();
				break;
			case USER_DEL:
				view = delete();
				break;
			default:
				break;
			}
		}
	}

	public View delete() {
		System.out.println("---- 회원 탈퇴 ----");

		return View.MAIN;
	}
	
	public View join() {
		System.out.println("---- 회원 가입 ----");
		String id = ScanUtil.nextLine("ID >>");
		String pass = ScanUtil.nextLine("pass >>");
		String name = ScanUtil.nextLine("name >>");
		
		List<Object> param = new ArrayList();
		param.add(id);
		param.add(pass);
		param.add(name);
		userService.join(param);
		
		return View.USER_LOGIN;
	}

	public View update() {
		System.out.println("---- 정보 수정 ----");
		return View.USER_LOGIN;
	}
	
	public View list() {
		System.out.println("---- 유저 리스트 ----");
		List<Map<String,Object>> lst = userService.list();
		
		for (int i = 0; i < lst.size(); i++) {
			System.out.println(lst.get(i));
		}
		
		return View.USER_LOGIN;
	}
	
	public View login() {
		System.out.println("---- 로그인 메뉴 ----");
		// 세션 == 로그인정보를 가짐
		// 로그인이 안 된 경우		
		if(!sessionStorage.containsKey("user")) {
			String id = ScanUtil.nextLine("ID >>");
			String pass = ScanUtil.nextLine("pass >>");
			// MVC모델에서 가장 중요, 뷰 : 사용자 , 모델 : 값? , : 컨트롤러 : 기능
			// [req]Controller(요청관리) - Service(기능수행) - DAO(DB접근) -> JDBCUtil(쿼리실행) -> DB  req
			// [res]DB -> JDBCUtil -> DAO -> Service -> Controller                           send
			List<Object> param = new ArrayList();
			param.add(id);
			param.add(pass);
			boolean login = userService.login(param);
			if(!login) return View.USER_LOGIN;
			// 세션 == 로그인정보를 가짐, 따라서 아래 코드는 현재 저장된 정보를 가진 Map<String,Obejct>라는 말
			// 													세션			 attribute
			Map<String,Object> user = (Map<String,Object>)sessionStorage.get("user");
			System.out.println(user.get("MEM_NAME")+"님 접속");
		}
		// 로그인이 이미 된 경우는 로그인을 다시 하지 않음
		
		System.out.println("1. 회원 리스트 조회");
		System.out.println("2. 정보 수정");
		System.out.println("3. 회원 탈퇴");
		System.out.println("4. 홈");
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		
		// 회원 목록 처리(Controller -> Service)
		// 파라미터, 리턴타입이 무엇인지 먼저 생각해야 함(뭘 하던 간에)
		// 파라미터 : 없음
		// 리턴타입 : 필요없을 거 같은데 List<Map<String,Object>>를 리턴해야 함
		
		switch (sel) {
		case 1:
			return View.USER_LIST;
		case 2:
			return View.USER_UPDATE;
		case 3:
			return View.USER_DEL;
		case 4:
			return View.MAIN;
		default:
			return View.USER_LOGIN;
		}
	}

	private View home() {
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 홈");
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.USER_JOIN;
		case 2:
			return View.USER_LOGIN;
		case 3:
			return View.MAIN;
		default:
			return View.MAIN;
		}
	}
}
