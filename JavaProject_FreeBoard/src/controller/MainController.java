package controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.FreeService;
import util.ScanUtil;
import util.View;

public class MainController {
	static public Map<String, Object> sessionStorage = new HashMap<>();
	FreeService freeService = FreeService.getInstance();
	
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
			case FREE_LIST:
				view = list();
				break;
			case FREE_DETAIL:
				view = detail();
				break;
			case FREE_UPDATE:
				view = update();
				break;
			case FREE_DELETE:
				view = delete();
				break;
			case FREE_INSERT:
				view = insert();
				break;
			default:
				break;
			}
		}
	}
	
	private View update() {
		// 제목 내용부터 받고
		String title = ScanUtil.nextLine("제목 : ");
		String content = ScanUtil.nextLine("내용 : ");
		// 방금 선택한 게시판 번호 받고
		int boardNo = (int)sessionStorage.get("boardNo");
		
		// 리스트에 담아서 JDBC의 update메서드로 실행
		List<Object> param = new ArrayList();
		param.add(title);
		param.add(content);
		param.add(boardNo);
		
		freeService.freeUpdate(param);
		System.out.println("수정 완료 \t");
		
		return View.FREE_LIST;
	}
	
	private View insert() {
		
		String title = ScanUtil.nextLine("제목 : ");
		String content = ScanUtil.nextLine("내용 : ");
		String writer = ScanUtil.nextLine("작성자 : ");
		
		List param  = new ArrayList();
		param.add(title);
		param.add(content);
		param.add(writer);
		
		freeService.freeInsert(param);
		
		return View.FREE_LIST;
	}
	
	private View delete() {
		int boardNo = (int)sessionStorage.get("boardNo");
		
		freeService.freeDelete(boardNo);
		System.out.println("삭제 완료");
		
		return View.FREE_LIST;
	}
	
	private View detail() {
		List lst = new ArrayList();
		lst.add(sessionStorage.get("boardNo"));
		Map map = freeService.freeDetail(lst);
		
		System.out.println("선택한 게시판 : "+ map.get("BOARD_NO") + "번 게시판 ( " + map + " )");
		
		System.out.println("1. 수정");
		System.out.println("2. 삭제");
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		
		switch (sel) {
		case 1:
			return View.FREE_UPDATE;
		case 2:
			return View.FREE_DELETE;
		default:
			System.out.println("유효 값을 입력하세요.");
			return View.FREE_DETAIL;
		}
	}
	
	private View list() {
		List lst = freeService.freeList();
		
		System.out.println("NO\t제목\t내용\t작성자\t작성일");
		for (int i = 0; i < lst.size(); i++) {
			Map map = (Map) lst.get(i);
			// sql 넘버 == java BigDecimal
			BigDecimal boardNum = (BigDecimal)map.get("BOARD_NO");
			//boardNum.intValue() 빅 데시멀 타입 int,long,double등 바로 캐스팅해서 꺼낼 수 있음
			String title = (String)map.get("TITLE");
			String content = (String)map.get("CONTENT");
			String writer = (String)map.get("WRITER");
			// sql Date == java Timestamp
			String date = (String)map.get("REG_DATE");
			
			System.out.println(boardNum.intValue()+"\t"+title+"\t"+content+"\t"+writer+"\t"+date);
//			System.out.println(map);
		}
		
		System.out.println("1. 게시판 상세 조회");
		System.out.println("2. 홈");
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			int boardNo = ScanUtil.nextInt("게시판 번호 선택 : ");
			// 이미 선택한 게시판에 해당하는 값을 스토리지에 저장
			sessionStorage.put("boardNo", boardNo);
			return View.FREE_DETAIL;
		case 2:
			return View.HOME;
		default:
			return View.HOME;
		}
	}

	private View home() {
		System.out.println("1. 전체 게시판 조회");
		System.out.println("2. 게시판 등록");
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.FREE_LIST;
		case 2:
			return View.FREE_INSERT;
		default:
			System.out.println("유효값 입력");
			return View.HOME;
		}
	}
}
