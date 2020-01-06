/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import system.ida.service.UserService;

/**
 * IdaController 클래스
 * 컨트롤러 클래스
 * 프로젝트 시작 시 접근 할 경로, 공동으로 접근할 경로를 설정
 * @author Jo
 */
@Controller
public class UserController {
	/**
	 * 속성변수 선언
	 */
	private final String path = "User/";	// jsp 경로
	@Autowired
	private UserService userService;	// UserService 인터페이스를 구현받은 객체를 생성해서 저장

	/**
	 * 생성자 선언
	 */

	/**
	 * 메소드 선언
	 */
	/**
	 * 로그인 화면을 보여줄 jsp를 보여주는 메소드
	 * 가상주소 /login.ida로 접근하면 호출
	 * @return mav : /login.ida에 맵핑되는 jsp 파일
	 */
	@RequestMapping(value="/login_form.ida")
	public ModelAndView goLoginForm(
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		try {
			mav.setViewName(path + "login_form");
			session.setAttribute("s_id", "abc123");
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goLoginForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	/**
	 * 회원가입 버튼을 누르면 보여줄 jsp를 보여주는 메소드
	 * 가상주소 /register_form.ida로 접근하면 호출
	 * @return mav : /register_form.ida에 맵핑되는 jsp 파일
	 */
	@RequestMapping(value="/register_form.ida")
	public ModelAndView goReigsterForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "register_form");
		
		try {
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goReigsterForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	/**
	 * 회원정보 변경 버튼을 누르면 보여줄 jsp를 보여주는 메소드
	 * 가상주소 /user_info_update_form.ida로 접근하면 호출
	 * @return mav : /user_info_update_form.ida에 맵핑되는 jsp 파일
	 */
	@RequestMapping(value="/user_info_update_form.ida")
	public ModelAndView goUpdateInfoForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "user_info_update_form");
		
		try {
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goUpdateInfoForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
}