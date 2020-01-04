/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView goMenuForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "menu_form");

		try {
		} catch (Exception e) { // try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goMenuForm 에러발생>");
			System.out.println(e.getMessage());
		}

		return mav;
	}

	/**
	 * 메뉴 수정 화면을 보여줄 jsp와 메뉴 정보를 보여주는 메소드
	 * 가상주소 /menu_update_form.ida로 접근하면 호출
	 * @return mav : /menu_update_form.ida에 맵핑되는 jsp 파일과 메뉴 정보 목록
	 */
	@RequestMapping(value = "/menu_update_form.ida")
	public ModelAndView goMenuUpdateForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "menu_update_form");

		try {
		} catch (Exception e) { // try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goMenuUpdateForm 에러발생>");
			System.out.println(e.getMessage());
		}

		return mav;
	}

	/**
	 * 메뉴 삭제 화면을 보여줄 jsp와 메뉴 정보를 보여주는 메소드
	 * 가상주소 /menu_delete_form.ida로 접근하면 호출
	 * @return mav : /menu_delete_form.ida에 맵핑되는 jsp 파일과 메뉴 정보 목록
	 */
	@RequestMapping(value = "/menu_delete_form.ida")
	public ModelAndView goMenuDeleteForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "menu_delete_form");

		try {
		} catch (Exception e) { // try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goMenuDeleteForm 에러발생>");
			System.out.println(e.getMessage());
		}

		return mav;
	}
}