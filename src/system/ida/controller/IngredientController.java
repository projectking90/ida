/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import system.ida.service.IngredientService;

/**
 * IngredientController 클래스
 * 컨트롤러 클래스
 * 식자재에 관련된 가상 경로를 설정
 * @author Jo
 */
@Controller
public class IngredientController {
	/**
	 * 속성변수 선언
	 */
	private final String path = "Ingredient/";	// jsp 경로
	@Autowired
	private IngredientService ingredientService;	// IngredientService 인터페이스를 구현받은 객체를 생성해서 저장

	/**
	 * 메소드 선언
	 */
	/**
	 * 식자재 관리 화면을 보여줄 jsp와 가게에 등록된 식자재를 보여주는 메소드
	 * 가상주소 /ingredient_form.ida로 접근하면 호출
	 * @return mav : /ingredient_form.ida에 맵핑되는 jsp 파일과 가게 식자재 리스트
	 */
	@RequestMapping(value="/ingredient_form.ida")
	public ModelAndView goIngredientForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "ingredient_form");
		
		try {
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goIngredientForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}

	/**
	 * 식자재 수정 화면을 보여줄 jsp와 가게에 등록된 식자재를 보여주는 메소드
	 * 가상주소 /ingredient_update_form.ida로 접근하면 호출
	 * @return mav : /ingredient_update_form.ida에 맵핑되는 jsp 파일과 가게 식자재 리스트
	 */
	@RequestMapping(value="/ingredient_update_form.ida")
	public ModelAndView goIngredientUpdateForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "ingredient_update_form");
		
		try {
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goIngredientUpdateForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}

	/**
	 * 식자재 삭제 화면을 보여줄 jsp와 가게에 등록된 식자재를 보여주는 메소드
	 * 가상주소 /ingredient_delete_form.ida로 접근하면 호출
	 * @return mav : /ingredient_delete_form.ida에 맵핑되는 jsp 파일과 가게 식자재 리스트
	 */
	@RequestMapping(value="/ingredient_delete_form.ida")
	public ModelAndView goIngredientDeleteForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "ingredient_delete_form");
		
		try {
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goIngredientDeleteForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
}