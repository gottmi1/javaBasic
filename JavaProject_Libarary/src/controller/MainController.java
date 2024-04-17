package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import print.LibPrint;
import service.LibService;
import service.UserSevice;
import util.ScanUtil;
import util.View;
import vo.BookVo;
// 프린트 하는 메서드를 가진 클래스를 상속받아 옴.
// 컨트롤러에서는 이동만 담당하는 게 좋기 떄문에 출력문 등 다른 게 끼어들면
// 좋지 않기 떄문에 나눴음, 근데 상속보다 스태틱 메서드를 사용해서 하는 게 나을 것 같음.
public class MainController extends LibPrint {
	static public Map<String, Object> sessionStorage = new HashMap<>();
	LibService libService = LibService.getInstance();
	UserSevice userService = UserSevice.getInstance();
	
	public static void main(String[] args) {
		new MainController().start();
	}

	private void start() {
		View view = View.HOME;
		while (true) {
			switch (view) {
			case HOME:
				view = home();
				break;
			case LIB_LIST:
				view = list();
				break;
			case LIB_DETAIL:
				view = detail();
				break;
			case LIB_UPDATE:
				view = update();
				break;
			case LIB_LOGIN:
				view = login();
				break;
			case LIB_DELETE:
				view = delete();
				break;
			case LIB_INSERT:
				view = insert();
				break;
			default:
				break;
			}
		}
	}
	
	private View login() {
		String id = ScanUtil.nextLine("   ID 입력 >> ");
		String pass = ScanUtil.nextLine(" 비밀번호 입력 >> ");
		
		// 유저 서비스로 넘겨줄 리스트
		List param = new ArrayList();
		param.add(id);
		param.add(pass);
		
		boolean loginFlag = userService.login(param);
		
		if(!loginFlag) {
			System.out.println("1. 재 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 홈");
			
			int sel = ScanUtil.menu();
			
			switch (sel) {
			case 1:
				return View.LIB_LOGIN;
			case 2:
				return View.HOME;
			case 3:
				return View.HOME;
			default:
				System.out.println("유효한 값을 입력하세요.");
				return View.LIB_LOGIN;
			}
		}
		
		View view = (View)sessionStorage.get("view");
		if(view == null) return View.HOME;
		return view;
	}

	private View update() {
		// 업데이트 하러 왔는데 로그인이 안 되어있으면 로그인 창으로 보냄
		if(!sessionStorage.containsKey("user")) {
			// 로그인이 시도 된 현재 페이지를 저장하기 위함
			sessionStorage.put("view",View.LIB_UPDATE);
			return View.LIB_LOGIN;
		}
		
		String title = ScanUtil.nextLine("수정할 제목 >>");
		String content = ScanUtil.nextLine("수정할 내용 >>");
		int bookNo = (int)sessionStorage.get("bookNo");
		
		List param = new ArrayList();
		param.add(title);
		param.add(content);
		param.add(bookNo);
		
		libService.update(param);
		
		System.out.println("책 정보가 수정되었습니다.");
		
		return View.LIB_DETAIL;
	}
	
	private View insert() {
		if(!sessionStorage.containsKey("user")) {
			// 로그인이 시도 된 현재 페이지를 저장하기 위함
			sessionStorage.put("view",View.LIB_INSERT);
			return View.LIB_LOGIN;
		}
		
		String title = ScanUtil.nextLine("등록할 책 제목 입력 >> ");
		String content = ScanUtil.nextLine("등록할 책 내용 입력 >> ");
		String writer = ScanUtil.nextLine("등록할 책 저자 입력 >> ");
		String pubDate = ScanUtil.nextLine("등록할 책 출판일 입력 >> ");
		String publisher = ScanUtil.nextLine("등록할 책 출판사 입력 >> ");
		
		List param = new ArrayList();
		param.add(title);
		param.add(content);
		param.add(writer);
		param.add(pubDate);
		param.add(publisher);
		
		libService.insert(param);
		System.err.println("책 등록이 완료되었습니다.");
		
		return View.LIB_LIST;
	}
	
	private View delete() {
		if(!sessionStorage.containsKey("user")) {
			// 로그인이 시도 된 현재 페이지를 저장하기 위함
			sessionStorage.put("view",View.LIB_DELETE);
			return View.LIB_LOGIN;
		}
		
		int bookNo = (int)sessionStorage.get("bookNo");
		List param = new ArrayList();
		param.add(bookNo);
		
		libService.delete(param);
		System.err.println("선택한 번호의 도서가 삭제되었습니다.");
		
		return View.LIB_LIST;
	}
	
	private View detail() {
		int selectBookNo = (int)sessionStorage.get("bookNo");
		BookVo book = libService.detail(selectBookNo);
		
		bookDetailPrint(book);
		
		int sel = ScanUtil.menu();
		
		switch (sel) {
		case 1:
			return View.LIB_UPDATE;
		case 2:
			return View.LIB_DELETE;
		case 3:
			return View.LIB_LIST;
		default:
			System.out.println("유효한 값을 입력하세요.");
			return View.LIB_DETAIL;
		}
	}
	
	private View list() {
		List<BookVo> bookList =libService.list();
		
		for (BookVo bookVo : bookList) {
			System.out.println(bookVo);
		}
		
		System.out.println("1. 도서 상세 조회");
		System.out.println("2. 홈");
		
		int sel = ScanUtil.menu();
		
		switch (sel) {
		case 1:
			int bookNo = ScanUtil.nextInt("도서 번호 선택 : ");
			// 선택한 도서 번호를 스토리지에 저장
			sessionStorage.put("bookNo", bookNo);
			return View.LIB_DETAIL;
		case 2:
			return View.HOME;
		default:
			return View.LIB_LIST;
		}
	}

	private View home() {
		System.out.println("1. 전체 도서 내역 확인");
		System.out.println("2. 신규 도서 등록");
		int sel = ScanUtil.menu();
		
		switch (sel) {
		case 1:
			return View.LIB_LIST;
		case 2:
			return View.LIB_INSERT;
		default:
			System.out.println("유효값 입력");
			return View.HOME;
		}
	}
}
