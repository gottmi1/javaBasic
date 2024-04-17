package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.synth.Region;

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
			case ADMIN_HOME:
				view = adminHome();
				break;
			case MEMBER_LOGIN:
				view = memLogin();
				break;
			case MEMBER_HOME:
				view = memHome();
				break;
			case PROD_LIST:
				view = prodList();
				break;
			case BUY_LIST:
				view = cartList();
				break;
			case PROD_SEARCH:
				view = search();
				break;
			case PROD_CART:
				view = prodCart();
				break;
			case ADMIN_PROD_LIST:
				view = adminProdList();
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
			case USER_LIST:
				view = userList();
				break;
			case BUYMEMBER_LIST:
				view = buyMemberList();
				break;
			default:
				break;
			}
		}
	}
	
	// 관리자 홈 메뉴
	private View adminHome() {
		System.out.println("☆★☆★☆★☆관리자 메뉴☆★☆★☆★☆");
		System.out.println("1. 전체 상품 조회");
		System.out.println("2. 회원 조회");
		System.out.println("3. 구매 상품 목록 조회");
		System.out.println("4. 로그아웃");

		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.ADMIN_PROD_LIST;
		case 2:
			return View.USER_LIST;
		case 3:
			return View.BUY_LIST;
		default:
			sessionStorage.remove("admin");
			return View.HOME;
		}
	}

	// 관리자 전용 회원 정보 메뉴
	private View adminProdList() {
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
			return View.ADMIN_HOME;
		default :
			System.out.println("유효값을 입력해 주세요.");
			return View.ADMIN_PROD_LIST;
		}
	}
	
	// 상품 등록 메뉴
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
			return View.ADMIN_PROD_LIST;
		}
		System.err.println("상품 추가 완료");
		
		return View.ADMIN_PROD_LIST;
	}

	// 상품 삭제 메뉴
	private View prodDelete() {
		int sel = ScanUtil.nextInt("삭제할 상품 번호를 입력하세요.");
		
		String alert = ScanUtil.nextLine("삭제하시려면 y를 입력해주세요.");
		if(alert.toLowerCase().equals("y")) {
			prodService.prodDelete(sel);
		} else {
			System.out.println("유효값을 입력하세요.");
			return View.DELETE_PROD;
		}
		System.err.println("상품 삭제 완료");		
		
		return View.ADMIN_PROD_LIST;
	}

	// 상품 정보 수정 메뉴
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
		
		System.err.println("상품 수정 완료");
		
		return View.ADMIN_PROD_LIST;
	}
	
	// 유저 정보 조회
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
			return View.ADMIN_HOME;
		}
		
	}
	
	// 유저 구매 내역 조회
	private View buyMemberList() {
		int sel = ScanUtil.nextInt("구매 이력을 조회할 유저 번호를 입력하세요.");
		
		List lst = userService.buyMemberList(sel);
		
		for (int i = 0; i < lst.size(); i++) {
			System.out.println(lst.get(i));
		}
		
		return View.ADMIN_HOME;
	}
	
	// endregion 관리자 메뉴
	
	private View memHome() {
		System.out.println("1. 전체 상품 조회");
		System.out.println("2. 구매 상품 조회");
		System.out.println("3. 로그아웃");

		int sel = ScanUtil.nextInt("메뉴 선택 >> ");
		switch (sel) {
		case 1:
			return View.PROD_LIST;
		case 2:
			return View.BUY_LIST;
		case 3:
			sessionStorage.remove("user");
			return View.HOME;
		default:
			return View.MEMBER_HOME;
		}
	}

	private View search() {
		System.out.println("1. 이름 검색");
		System.out.println("2. 타입 검색");

		// Service로 보내 줄 파라미터 리스트
		List<Object> param = new ArrayList();

		// 어떤 걸 검색할지 선택
		int sel = ScanUtil.nextInt("선택 >> ");

		if (sel == 1) {
			String name = ScanUtil.nextLine("이름 : ");
			param.add(name);
		}
		if (sel == 2) {
			String type = ScanUtil.nextLine("타입 : ");
			param.add(type);
		}

		// param의 쿼리에 해당하는 리스트 받아오기
		List<ProdVo> prodList = prodService.search(param, sel);
		// 출력
		for (ProdVo vo : prodList) {
			System.out.println(vo);
		}

		System.out.println("1. 상품 선택");
		System.out.println("2. 전체 리스트");

		sel = ScanUtil.nextInt("메뉴 >> ");

		switch (sel) {
		case 1:
			return View.PROD_CART;
		case 2:
			return View.PROD_LIST;
		default:
			System.out.println("유효값 입력하세요.");
			return View.PROD_SEARCH;
		}
	}

	private View prodCart() {
		// 구매할 상품과 수량이 담긴 list(param)가 담긴 list
		List<List<Object>> paramList = new ArrayList();
		
		// -------------------------- 구매를 반복할 수 있도록 와일문 사용
		while (true) {
			// -------------------------- 상품 리스트 출력
			List<ProdVo> lst = prodService.prodList();
			for (ProdVo vo : lst) {
				System.out.println("상품번호 : " + vo.getProd_no() + ", 상품명 : " + vo.getProd_name() + ", 상품 가격 : "
						+ vo.getProd_price() + ", 상품 타입 : " + vo.getProd_type());
			}
			// -------------------------- 상품 리스트 출력

			// -------------------------- 구매할 상품 번호를 선택하는 영역
			System.out.println("구매할 상품을 선택하세요.");
			int prodNo = ScanUtil.nextInt("상품 번호 선택 >> ");
			// -------------------------- 구매할 상품 번호를 선택하는 영역
			
			
			// -------------------------- 상품이 존재하는지 확인하는 영역
			boolean chk = false;
			// Vo가 담긴 lst의 사이즈만큼 반복
			for (ProdVo vo : lst) {
				// lst에 담긴 vo의 prodNo이 nextInt로 받은 숫자와 같을 때만 true(없는 상품번호 예외 처리)
				if(vo.getProd_no() == prodNo) {
					chk = true;
					break;
				}
			}
			// 상품 번호가 없을 경우
			if(!chk) {
				System.out.println("선택한 상품번호의 상품이 없습니다.");
				continue;
			}
			int qty = ScanUtil.nextInt("구매할 수량 >> ");
			// -------------------------- 상품이 존재하는지 확인하는 영역
			
			
			// 선택 상품과 수량을 담을 list
			List<Object> param = new ArrayList();
			param.add(prodNo);
			param.add(qty);
			
			paramList.add(param);
						
			// 계속 구매할지 선택
			String yn = ScanUtil.nextLine("추가구매 하시겠습니까?(y/n)").toLowerCase();
			if(yn.equals("n")) {
				break;
			}
		}
		
		// 총 구매금액에 사용 될 값
		int sum = 0;
		
		System.out.println("상품명 \t 상품가격 \t 구매수량");
		
		List<ProdVo> lst = prodService.prodList();
		for (ProdVo vo : lst) {
			// 파람을 담은 리스트에서 파람을 하나씩 꺼내는 반복문
			for (List param : paramList) {
				// 꺼낸 param의 상품 번호와 수량을 추출
				int prodNo = (int)param.get(0);
				int qty = (int)param.get(1);
				// 추출한 상품번호와 vo의 상품 번호가 같을 때
				if(prodNo == vo.getProd_no()) {
					// 총 가격에 해당 상품의 가격 * 수량을 더함
					sum += vo.getProd_price() * qty;
					System.out.println(vo.getProd_name() + "\t" + vo.getProd_price() + "\t" + qty);
					break;
				}
			}
		}
		System.out.println("상품 총 구매 금액 : " + sum);
		
		// ----------------------- cart테이블에 저장, 테이블 관계상 cart에 먼저 들어가야 함
		
		// 현재 접속한 유저의 Vo정보를 가져와서 리스트에 담고 cartInsert해줌
		UserVo user = (UserVo)sessionStorage.get("user");
		List param = new ArrayList();
		param.add(user.getMem_no());
		prodService.cartInsert(param);
		
		// cartProd 테이블에 저장
		for(List param2 : paramList) {
			prodService.cartProdInsert(param2);
		}
		
		return View.PROD_LIST;
	}

	private View prodList() {
		List<ProdVo> lst = prodService.prodList();

		for (ProdVo vo : lst) {
			System.out.println("상품번호 : " + vo.getProd_no() + ", 상품명 : " + vo.getProd_name() + ", 상품 가격 : "
					+ vo.getProd_price() + ", 상품 타입 : " + vo.getProd_type());
		}

		System.out.println("1. 상품 검색");
		System.out.println("2. 상품 선택");
		int sel = ScanUtil.nextInt("메뉴 선택 >> ");
		switch (sel) {
		case 1:
			return View.PROD_SEARCH;
		case 2:
			return View.PROD_CART;
		default:
			System.out.println("유효한 값을 입력하세요.");
			return View.PROD_LIST;
		}
	}

	private View cartList() {
		// 구매된 정보 리스트를 출력
		// JAVA_CART_PROD 테이블을 출력하면 될 것 같은데,
		// 상품번호를 상품명으로 가져오는 방법은 무엇일까?
		List<CartProdVo> cartList = prodService.cartProdList();
		
		for( CartProdVo vo : cartList) {
			System.out.println(vo);
		}
		
		return View.HOME;
	}

	private View adminLogin() {
		System.out.println("관리자 로그인");
		String id = ScanUtil.nextLine("관리자 id를 입력하세요 >>");
		String pass = ScanUtil.nextLine("관리자 패스워드를 입력하세요 >>");

		if (!id.equals("admin") || !pass.equals("admin")) {
			System.out.println("관리자가 아닙니다. 메인 화면으로 ㄱ");
			return View.HOME;
		}

		List param = new ArrayList();
		param.add(id);
		param.add(pass);

		UserVo admin = userService.login(param);

		sessionStorage.put("admin",admin);
		return View.ADMIN_HOME;
	}

	private View memLogin() {
		String id = ScanUtil.nextLine("id를 입력하세요 >>");
		String pass = ScanUtil.nextLine("패스워드를 입력하세요 >>");

		List<Object> param = new ArrayList();
		param.add(id);
		param.add(pass);

		UserVo user = userService.login(param);

		if (user == null) {
			System.out.println("로그인 실패 다시 시도하세요ㅗ");
			return View.MEMBER_LOGIN;
		}

		System.out.println(user.getMem_name() + "님 환영합니다.");

		return View.MEMBER_HOME;
	}

	private View home() {
		System.out.println("1. 관리자 로그인");
		System.out.println("2. 일반 회원 로그인");

		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.ADMIN_LOGIN;
		case 2:
			return View.MEMBER_LOGIN;
		case 3:
			return View.HOME;
		default:
			return View.HOME;
		}
	}
}
