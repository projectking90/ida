/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import system.ida.dto.CodeMenuDTO;
import system.ida.dto.IngredientListDTO;
import system.ida.dto.MenuDTO;
import system.ida.dto.MenuSearchDTO;
import system.ida.service.MenuService;

/**
 * MenuController 클래스 컨트롤러 클래스 메뉴에 관련 가상 경로를 설정
 * 
 * @author Jo
 */
@Controller
public class MenuController {
	/**
	 * 속성변수 선언
	 */
	private final String path = "Menu/"; // jsp 경로
	@Autowired
	private MenuService menuService;	// MenuService 인터페이스를 구현받은 객체를 생성해서 저장

	/**
	 * 메소드 선언
	 */
	/**
	 * 메뉴 관리 화면을 보여줄 jsp와 메뉴 정보를 보여주는 메소드
	 * 가상주소 /menu_form.ida로 접근하면 호출
	 * @return mav : /menu_form.ida에 맵핑되는 jsp 파일과 메뉴 정보 목록
	 */
	@RequestMapping(value = "/menu_form.ida")
	public ModelAndView goMenuForm(
			MenuSearchDTO menu_searchDTO
			,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "menu_form");

		try {
			String s_id = (String)session.getAttribute("s_id");
			menu_searchDTO.setS_id(s_id);

			
			int menu_list_all_cnt=this.menuService.getMenuListAllCnt(menu_searchDTO);
			
			if(menu_list_all_cnt>0) {
				int select_page_no = menu_searchDTO.getSelect_page_no();
				// 한 화면에 보여지는 행의 개수 구하기
				int row_cnt_per_page = menu_searchDTO.getRow_cnt_per_page();
				// 검색할 시작행 번호 구하기
				int begin_row_no = select_page_no*row_cnt_per_page-row_cnt_per_page+1;
				// 만약 검색한 총 개수가 검색할 시작행 번호보다 작으면
				// 선택한 페이지 번호를 1로 초기화하기
				if(menu_list_all_cnt < begin_row_no) {
					menu_searchDTO.setSelect_page_no(1);
				}
			}
			//System.out.println("menu_searchDTO.getRow_cnt_per_page() "+menu_searchDTO.getRow_cnt_per_page());
			//System.out.println("menu_searchDTO.getSelect_page_no() "+menu_searchDTO.getSelect_page_no());
			
			List<MenuDTO> menu_list = this.menuService.getMenuList(menu_searchDTO);
			mav.addObject("menu_list", menu_list);
			mav.addObject("menu_list_all_cnt", menu_list_all_cnt);
			mav.addObject("menu_searchDTO", menu_searchDTO);
			
			CodeMenuDTO codemenuDTO = new CodeMenuDTO();
			codemenuDTO.setMa_nameList(this.menuService.getCodeMenuAlpha());
			codemenuDTO.setMb_nameList(this.menuService.getCodeMenuBeta());
			mav.addObject("codemenuDTO", codemenuDTO); 
			
			IngredientListDTO ingredient_listDTO = new IngredientListDTO();
			ingredient_listDTO.setI_nameList(this.menuService.getIngredientList(s_id));
			mav.addObject("ingredient_listDTO", ingredient_listDTO);
		} catch (Exception e) { // try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goMenuForm 에러발생>");
			System.out.println(e.getMessage());
		}

		return mav;
	}

	/**
	 * 가게 메뉴 추가 기능 실행 시 데이터베이스와 연동 처리할 메소드
	 * 가상주소 /menu_insert.ida로 접근하면 호출
	 * @param menuDTO : 메뉴 추가를 위해 사용하는 DTO
	 * @return insert_result : 메뉴 추가 Query 실행 결과
	 */
	@RequestMapping(value="/menu_insert.ida"
					, method=RequestMethod.POST	
					, produces="application/json;charset=UTF-8")
	@ResponseBody
	public int insertStoreMenu(
			MenuDTO menuDTO
			, HttpServletRequest request) {
		int insert_result = 0;	// 데이터베이스에 Query 실행 후 결과를 저장
		int menu_ingredient_insert = 0;
		
		try {
			insert_result = this.menuService.insertStoreMenu(menuDTO);
			
			menu_ingredient_insert = this.menuService.insertMenuIngredient(menuDTO);
			
			
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<insertStoreMenu 에러발생>");
			System.out.println(e.getMessage());
			return -1;
		}
		
		return insert_result;
	}

	/**
	 * 메뉴 수정 화면을 보여줄 jsp와 메뉴 정보를 보여주는 메소드
	 * 가상주소 /menu_update_form.ida로 접근하면 호출
	 * @return mav : /menu_update_form.ida에 맵핑되는 jsp 파일과 메뉴 정보 목록
	 */
	@RequestMapping(value = "/menu_update_form.ida")
	public ModelAndView goMenuUpdateForm(
			MenuSearchDTO menu_searchDTO
			,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		try {
			mav.setViewName(path + "menu_update_form");
			
			String s_id = (String)session.getAttribute("s_id");
			menu_searchDTO.setS_id(s_id);
			
			List<MenuDTO> menu_list = this.menuService.getMenuList(menu_searchDTO);
			mav.addObject("menu_list", menu_list);
			mav.addObject("menu_searchDTO", menu_searchDTO);
			
			CodeMenuDTO codemenuDTO = new CodeMenuDTO();
			codemenuDTO.setMa_nameList(this.menuService.getCodeMenuAlpha());
			codemenuDTO.setMb_nameList(this.menuService.getCodeMenuBeta());
			mav.addObject("codemenuDTO", codemenuDTO); 
		} catch (Exception e) { // try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goMenuUpdateForm 에러발생>");
			System.out.println(e.getMessage());
		}

		return mav;
	}

	/**
	 * 가게 메뉴 수정 기능 실행 시 데이터베이스와 연동 처리할 메소드
	 * 가상주소 /store_menu_update.onm로 접근하면 호출
	 * @param menuDTO : 메뉴 수정을 위해 사용하는 DTO
	 * @return update_result : 메뉴 수정 Query 실행 결과
	 */
	@RequestMapping(value="/menu_update.ida"
					, method=RequestMethod.POST	
					, produces="application/json;charset=UTF-8")
	@ResponseBody
	public int updateStoreMenu(
			@RequestParam(value="trArr") ArrayList<String> menu_update
	) {
		int update_result = 0;	// 데이터베이스에 Query 실행 후 결과를 저장

		System.out.print("updatecheck");
		try {
			 update_result = this.menuService.updateStoreMenu(menu_update); 
			
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<updateStoreMenu 에러발생>");
			System.out.println(e.getMessage());
			update_result=-1;
		}
		
		return update_result;
	}

	/**
	 * 메뉴 삭제 화면을 보여줄 jsp와 메뉴 정보를 보여주는 메소드
	 * 가상주소 /menu_delete_form.ida로 접근하면 호출
	 * @return mav : /menu_delete_form.ida에 맵핑되는 jsp 파일과 메뉴 정보 목록
	 */
	@RequestMapping(value = "/menu_delete_form.ida")
	public ModelAndView goMenuDeleteForm(
			HttpSession session
			,MenuSearchDTO menu_searchDTO) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "menu_delete_form");
		String s_id = (String)session.getAttribute("s_id");
		menu_searchDTO.setS_id(s_id);
		List<MenuDTO> menu_list = this.menuService.getMenuList(menu_searchDTO);
		mav.addObject("menu_list", menu_list);
		mav.addObject("menu_searchDTO", menu_searchDTO);

		try {
		} catch (Exception e) { // try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goMenuDeleteForm 에러발생>");
			System.out.println(e.getMessage());
		}

		return mav;
	}
	
	/**
	 * 가게 메뉴 삭제 기능 실행 시 데이터베이스와 연동 처리할 메소드
	 * 가상주소 /store_menu_delete.onm로 접근하면 호출
	 * @param menuDTO : 메뉴 삭제를 위해 사용하는 DTO
	 * @return delete_result : 메뉴 삭제 Query 실행 결과
	 */
	@RequestMapping(value="/menu_delete.ida")
	@ResponseBody
	public int deleteStoreMenu(
			MenuDTO menuDTO
			,MenuSearchDTO menu_searchDTO
			,HttpSession session
			,@RequestParam(value="trArr") ArrayList<String> menu_delete) {
		int delete_result = 0;	// 데이터베이스에 Query 실행 후 결과를 저장
		
		for(int index=0; index<menu_delete.size(); index++) {
			System.out.println(menu_delete.get(index));
		}

		try {
			String s_id = (String)session.getAttribute("s_id");
			menu_searchDTO.setS_id(s_id);
			delete_result = this.menuService.deleteStoreMenu(menu_delete);
			System.out.print("del : " + delete_result);
			
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<deleteStoreMenu 에러발생>");
			System.out.println(e.getMessage());
			return -1;
		}
		
		return delete_result;
	}
}