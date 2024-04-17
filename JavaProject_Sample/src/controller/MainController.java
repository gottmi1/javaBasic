package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.BoardService;
import service.UserSevice;
import util.ScanUtil;
import util.View;
import vo.BoardVo;
import vo.UserVo;

public class MainController {
	static public Map<String, Object> sessionStorage = new HashMap<>();
	BoardService boardService = BoardService.getInstance();
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
			case BOARD_LIST:
				view = list();
				break;
			case BOARD_UPDATE:
				view = update();
				break;
			case BOARD_DELETE:
				view = delete();
				break;
			case USER_LOGIN:
				view = login();
				break;
			default:
				break;
			}
		}
	}

	private View list() {
		// 페이징을 위한 페이지
		int page = 1;
		if(sessionStorage.containsKey("page")) { // 세션 스토리지에 page가 있을 경우() == 페이지를 변경한 이력이 있을 경우
			// 페이지 = 세션 스토리지에서 페이지 키의 밸류값을 가져옴
			page = (int) sessionStorage.get("page");
		}
		// page가 1이면 start 1 end 5
		// page가 2이면 start 6 end 10
		int startNum = 1+5*(page - 1);
		int endNum = 5*page;
		
		// 페이징을 위한 리스트( 몇 번부터 몇 번까지 나오게 할지 )
		List param = new ArrayList();
		param.add(startNum);
		param.add(endNum);
		
		// 위 리스트를 보내서 
		// 현재 몇 번쨰 게시물 부터 몇 번째 게시물 까지 보여주는지 설정 함
		List<BoardVo> lst = boardService.list(param);
		for (BoardVo vo : lst) {
			System.out.println(vo);
		}
		
		// 출력
		System.out.println("1. 다음페이지");
		System.out.println("2. 이전페이지");
		System.out.println("3. 수정");
		System.out.println("4. 삭제");
		System.out.println("5. 홈");
		int sel = ScanUtil.menu();

		if(sel == 1) {
			// 다음페이지, 마지막 페이지가 어딘지는 설정하기 어려워서 패스
			page++;
			sessionStorage.put("page",page);
			return View.BOARD_LIST;
		}else if(sel == 2) {
			// 이전페이지, 1페이지 에선 더이상 - 되지 않도록 함
			if(page != 1) page--;
			sessionStorage.put("page",page);
			return View.BOARD_LIST;
		}else if(sel == 3) {
			int boardNo = ScanUtil.nextInt("수정할 게시판 번호 입력");
			sessionStorage.put("boardNo",boardNo);
			
			// 여기서 page왜 지워주냐면 수정 후 전체 게시판보기를 했을 때
			// 다시 1번 페이지를 봐야하기 때문
			sessionStorage.remove("page");
			return View.BOARD_UPDATE;
		}else if(sel == 4) {
			int boardNo = ScanUtil.nextInt("삭제할 게시판 번호 입력");
			sessionStorage.put("boardNo",boardNo);
			
			// 여기서 page왜 지워주냐면 수정 후 전체 게시판보기를 했을 때
			// 다시 1번 페이지를 봐야하기 때문
			sessionStorage.remove("page");
			return View.BOARD_DELETE;
		}else if(sel == 5) {
			sessionStorage.remove("page");
			return View.HOME;
		}else {
			return View.BOARD_LIST;
		}
	}

	private View update() {
		// 로그인 되어있는지 확인
		if(!sessionStorage.containsKey("user")) {
			// 로그인이 안 되어 있으면 view의 현재 페이지 경로를 담고 로그인 페이지로 보냄
			// (로그인 완료시 현재 페이지로 돌아오기 위함)
			sessionStorage.put("view", View.BOARD_UPDATE);
			return View.USER_LOGIN;
		}
		
		// 내 글인지 체크하는 부분
		// 현재 유저 정보를 user에 할당
		UserVo user = (UserVo)sessionStorage.get("user");
		// 현재 게시글 넘버를 가져옴
		int boardNo = (int)sessionStorage.get("boardNo");
		
		// 그 두개를 넣어서 던지는데, 이 두개가 같아야만 chk가 true가 되도록 함
		List chkList = new ArrayList();
		chkList.add(user.getMem_no());
		chkList.add(boardNo);
		
		boolean chk = boardService.check(chkList);
		
		if(!chk) {
			System.err.println("이 글의 작성자가 아닙니다.");
			return View.BOARD_LIST;
		}
		// 내 글인지 체크하는 부분

		
		System.out.println("어떤 항목을 수정할지 선택하세요.");
		System.out.println("1. 제목");
		System.out.println("2. 내용");
		System.out.println("3. 전체");
		System.out.println("4. 홈");
		
		List param = new ArrayList();
		
		int sel = ScanUtil.menu();
		// 3은 전체 수정이기 때문에 이런 식으로 if문을 사용할 수 있음
		if(sel == 1 || sel == 3) {
			String title = ScanUtil.nextLine("수정할 제목 입력 >>");
			param.add(title);
		}
		if(sel == 2 || sel == 3) {
			String content = ScanUtil.nextLine("수정할 내용 입력 >>");
			param.add(content);
		}
		param.add(boardNo);
		
		// 변경할 항목과 게시물 번호를 담아서 업데이트
		boardService.update(param, sel);
		
		System.err.println("수정이 완료되었습니다.");
		
		return View.BOARD_LIST;
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
			int sel = ScanUtil.nextInt(" 메뉴 >>");
			
			switch (sel) {
			case 1:
				return View.USER_LOGIN;
			case 2:
				return View.HOME;
			case 3:
				return View.HOME;
			default:
				System.out.println("유효한 값을 입력하세요.");
				return View.USER_LOGIN;
			}
		}
		
		View view = (View)sessionStorage.get("view");
		if(view == null) return View.HOME;
		return view;
	}

	private View delete() {
		if(!sessionStorage.containsKey("user")) {
			// 로그인이 안 되어 있으면 view의 현재 페이지 경로를 담고 로그인 페이지로 보냄
			// (로그인 완료시 현재 페이지로 돌아오기 위함)
			sessionStorage.put("view", View.BOARD_DELETE);
			return View.USER_LOGIN;
		}
		
		// 내 글인지 체크하는 부분
		// 현재 유저 정보를 user에 할당
		UserVo user = (UserVo)sessionStorage.get("user");
		// 현재 게시글 넘버를 가져옴
		int boardNo = (int)sessionStorage.get("boardNo");
		
		// 그 두개를 넣어서 던지는데, 이 두개가 같아야만 chk가 true가 되도록 함
		List chkList = new ArrayList();
		chkList.add(user.getMem_no());
		chkList.add(boardNo);
		
		boolean chk = boardService.check(chkList);
		
		if(!chk) {
			System.err.println("이 글의 작성자가 아닙니다.");
			return View.BOARD_LIST;
		}
		// 내 글인지 체크하는 부분
		
		List param = new ArrayList();
		param.add(sessionStorage.get("boardNo"));
		
		// 변경할 항목과 게시물 번호를 담아서 업데이트
		boardService.delete(param);
		
		System.err.println("삭제가 완료되었습니다.");
		
		return View.BOARD_LIST;
	}
	
	private View home() {
		System.out.println("1. 전체 게시판");
		System.out.println("2. 게시판 등록");
		System.out.println("3. 홈");
		System.out.println("4. 관리자 로그인");
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.BOARD_LIST;
		case 2:
			return View.BOARD_JOIN;
		case 3:
			return View.HOME;
		default:
			return View.HOME;
		}
	}
}
