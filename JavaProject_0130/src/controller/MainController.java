package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.CartProdService;
import service.ProdService;
import service.UserService;
import util.ScanUtil;
import util.View;
import vo.CartProdVo;
import vo.ProdVo;
import vo.UserVo;

public class MainController {
	static public Map<String, Object> sessionStorage = new HashMap<>();
	UserService userService = UserService.getInstance();
	ProdService prodService = ProdService.getInstance();
	CartProdService cartProdService = CartProdService.getInstance();

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
			case ADMIN_LOGIN:
				view = adminLogin();
				break;
			case PROD_LIST:
				view = prodList();
				break;
			case USER_LIST:
				view = userList();
				break;
			case BUY_LIST:
				view = buyList();
				break;
			case UPDATE_PROD:
				view = prodUpdate();
				break;
			case DELETE_PROD:
				view = prodDelete();
				break;
			case ADD_PROD:
				view = prodAdd();
				break;
			case BUYMEMBER_LIST:
				view = buyMemberList();
				break;
				
			default:
				break;
			}
		}
	}
	

	// 상품 등록 완료
	private View prodAdd() {
		List param = new ArrayList();
		
		String title = ScanUtil.nextLine("등록할 상품의 상품명을 입력하세요 >> ");
		int price = ScanUtil.nextInt("등록할 상품의 가격을 입력하세요 >> ");
		String type = ScanUtil.nextLine("등록할 상품의 분류를 입력하세요 >> ");
		
		param.add(title);
		param.add(price);
		param.add(type);
		
		String chk = ScanUtil.nextLine("등록하려면 y를 입력하세요.");
		if(chk.toLowerCase().equals("y")) {
			prodService.prodAdd(param);
		}else {
			System.out.println("상품 리스트로 돌아갑니다.");
			return View.PROD_LIST;
		}
		
		return View.PROD_LIST;
	}

	// 상품 삭제 완료
	private View prodDelete() {
		int sel = ScanUtil.nextInt("삭제할 상품 번호를 입력하세요.");
		
		String alert = ScanUtil.nextLine("삭제하시려면 y를 입력해주세요.");
		if(alert.toLowerCase().equals("y")) {
			prodService.prodDelete(sel);
		} else {
			System.out.println("유효값을 입력하세요.");
			return View.DELETE_PROD;
		}
				
		return View.PROD_LIST;
	}

	// 상품 정보 수정 완료
	private View prodUpdate() {
		List param = new ArrayList();

		int selProd = ScanUtil.nextInt("수정할 상품 번호를 선택하세요 >>");

		System.out.println("1. 상품명 수정");
		System.out.println("2. 상품 가격 수정");
		System.out.println("3. 상품 타입 수정");
		System.out.println("4. 전체 수정");
		int sel = ScanUtil.nextInt("수정할 정보를 선택하세요 >>");
		
		if(sel == 1 || sel == 4) {
			String title = ScanUtil.nextLine("수정할 제목을 입력하세요 >>");
			param.add(title);
		}
		if(sel == 2 || sel == 4) {
			int price = ScanUtil.nextInt("수정할 가격을 입력하세요 >>");
			param.add(price);
		}
		if(sel == 3 || sel == 4) {
			String type = ScanUtil.nextLine("수정할 타입을 입력하세요 >>");
			param.add(type);
		}
		
		param.add(selProd);
		// 여기서 param은 제목,가격,타입,상품번호 순으로 담김 
		prodService.prodUpdate(param, sel);
		
		return View.PROD_LIST;
	}


	// 이거 끝
	private View prodList() {
		List<ProdVo> prodList = prodService.prodList();

		for (ProdVo vo : prodList) {
			System.out.println(vo);
		}

		System.out.println("1. 상품 등록");
		System.out.println("2. 상품 정보 변경");
		System.out.println("3. 상품 삭제");
		System.out.println("4. 어드민 홈");

		int sel = ScanUtil.nextInt("메뉴 선택 >>");

		switch (sel) {
		case 1:
			return View.ADD_PROD;
		case 2:
			return View.UPDATE_PROD;
		case 3:
			return View.DELETE_PROD;
		case 4:
			return View.HOME;
		default :
			System.out.println("유효값을 입력해 주세요.");
			return View.PROD_LIST;
		}
	}

	private View adminLogin() {

		return null;
	}
	
	private View userList() {
		List<UserVo> userList = userService.userList();

		for (UserVo vo : userList) {
			System.out.println(vo);
		}
		
		int sel = ScanUtil.nextInt("1. 회원별 상품 구매 조회");
		
		if(sel == 1) {
			return View.BUYMEMBER_LIST;
		} else {
			System.out.println("유효한 값을 입력하세요");
			return View.HOME;
		}
		
	}
	
	private View buyMemberList() {
		int sel = ScanUtil.nextInt("구매 이력을 조회할 유저 번호를 입력하세요.");
		
		List lst = userService.buyMemberList(sel);
		
		for (int i = 0; i < lst.size(); i++) {
			System.out.println(lst.get(i));
		}
		
		return View.HOME;
	}

	private View buyList() {
		List<CartProdVo> cartProdList = cartProdService.cartProdList();

		for (CartProdVo vo : cartProdList) {
			System.out.println(vo);
		}

		return View.HOME;
	}

	private View home() {
		System.out.println("☆★☆★☆★☆관리자 메뉴☆★☆★☆★☆");
		System.out.println("1. 전체 상품 조회");
		System.out.println("2. 회원 조회");
		System.out.println("3. 구매 상품 목록 조회");
		System.out.println("4. HOME");

		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.PROD_LIST;
		case 2:
			return View.USER_LIST;
		case 3:
			return View.BUY_LIST;
		default:
			return View.HOME;
		}
	}
}
