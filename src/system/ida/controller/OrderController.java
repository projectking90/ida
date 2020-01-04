/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import system.ida.service.OrderService;

/**
 * OrderController 클래스
 * 컨트롤러 클래스
 * 주문에에 관련 가상 경로를 설정
 * @author Jo
 */
@Controller
public class OrderController {
	/**
	 * 속성변수 선언
	 */
	private final String path = "Order/"; // jsp 경로
	@Autowired
	private OrderService orderService;	// OrderService 인터페이스를 구현받은 객체를 생성해서 저장

	/**
	 * 메소드 선언
	 */
	/**
	 * 주문 관리 화면을 보여줄 jsp와 주문 정보를 보여주는 메소드
	 * 가상주소 /order_form.ida로 접근하면 호출
	 * @return mav : /order_form.ida에 맵핑되는 jsp 파일과 주문 정보 목록
	 */
	@RequestMapping(value = "/order_form.ida")
	public ModelAndView goOrderForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "order_form");

		try {
		} catch (Exception e) { // try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goOrderForm 에러발생>");
			System.out.println(e.getMessage());
		}

		return mav;
	}

	/**
	 * 메뉴 수정 화면을 보여줄 jsp와 메뉴 정보를 보여주는 메소드
	 * 가상주소 /order_update_form.ida로 접근하면 호출
	 * @return mav : /order_update_form.ida에 맵핑되는 jsp 파일과 메뉴 정보 목록
	 */
	@RequestMapping(value = "/order_update_form.ida")
	public ModelAndView goOrderUpdateForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "order_update_form");

		try {
		} catch (Exception e) { // try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goOrderUpdateForm 에러발생>");
			System.out.println(e.getMessage());
		}

		return mav;
	}

	/**
	 * 메뉴 삭제 화면을 보여줄 jsp와 메뉴 정보를 보여주는 메소드
	 * 가상주소 /order_delete_form.ida로 접근하면 호출
	 * @return mav : /order_delete_form.ida에 맵핑되는 jsp 파일과 메뉴 정보 목록
	 */
	@RequestMapping(value = "/order_delete_form.ida")
	public ModelAndView goOrderDeleteForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "order_delete_form");

		try {
		} catch (Exception e) { // try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goOrderDeleteForm 에러발생>");
			System.out.println(e.getMessage());
		}

		return mav;
	}
}