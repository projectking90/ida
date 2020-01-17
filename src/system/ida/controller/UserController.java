/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.javassist.compiler.ast.BinExpr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import system.ida.dto.AddrDTO;
import system.ida.dto.UserDTO;
import system.ida.dto.UserUpdateDTO;
import system.ida.ida.Aes256;
import system.ida.ida.LoginValidator;
import system.ida.service.IdaService;
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
	@Autowired
	private IdaService idaService;	// IdaService 인터페이스를 구현받은 객체를 생성해서 저장

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
	public ModelAndView goLoginForm() {
		ModelAndView mav = new ModelAndView();
		
		try {
			mav.setViewName(path + "login_form");
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goLoginForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	/**
	 * 로그인 화면을 보여줄 jsp를 보여주는 메소드
	 * 가상주소 /login_proc.ida로 접근하면 호출
	 * @param userDTO : 사용자 정보 DTO
	 * @param session : HttpSession 객체
	 * @return mav : /login.ida에 맵핑되는 jsp 파일
	 */
	@RequestMapping(value="/login_proc.ida")
	@ResponseBody
	public int goLoginProc(
			UserDTO userDTO
			, HttpSession session
			//, BindingResult bindingResult
			) {
		//new LoginValidator().validate(userDTO, bindingResult);
		
		int loginCnt = 0;
		
		//if(bindingResult.hasErrors()) {
		//	loginCnt = -1;
		//} else {
		try {
			Aes256 aes = new Aes256();
			userDTO.setPwd(aes.encrypt(userDTO.getPwd()));
			
			loginCnt = this.userService.getLoginCnt(userDTO);
			
			if(loginCnt==1) {
				session.setAttribute("s_id", userDTO.getS_id());
				session.setAttribute("user_flag", "s");
			}
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goLoginProc 에러발생>");
			System.out.println(e.getMessage());
		}
		//}
		
		return loginCnt;
	}
	
	/**
	 * 회원가입 버튼을 누르면 보여줄 jsp를 보여주는 메소드
	 * 가상주소 /register_form.ida로 접근하면 호출
	 * @return mav : /register_form.ida에 맵핑되는 jsp 파일
	 */
	@RequestMapping(value="/register_form.ida")
	public ModelAndView goRegForm() {
		ModelAndView mav = new ModelAndView();
		
		try {
			mav.setViewName(path + "register_form");
			
			List<AddrDTO> city_list = this.idaService.getCityList();
			
			mav.addObject("city_list", city_list);
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goRegForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	/**
	 * 회원가입을 처리할 메소드
	 * 가상주소 /register_user_proc.ida로 접근하면 호출
	 * @return insertCnt : 회원등록 성공 결과
	 */
	@RequestMapping(value="/register_user_proc.ida")
	@ResponseBody
	public int insertRegUser(
			UserDTO userDTO) {
		int insertCnt = 0;
		
		try {
			int addr_code = this.userService.getAddrCode(userDTO);
			userDTO.setAddr_code(addr_code);
			Aes256 aes = new Aes256();
			userDTO.setPwd(aes.encrypt(userDTO.getPwd()));
			
			insertCnt = this.userService.insertRegUser(userDTO);
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<insertRegUser 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return insertCnt;
	}
	
	/**
	 * 회원정보 변경 버튼을 누르면 보여줄 jsp를 보여주는 메소드
	 * 가상주소 /user_info_update_form.ida로 접근하면 호출
	 * @param session : HttpSession 객체
	 * @return mav : /user_info_update_form.ida에 맵핑되는 jsp 파일
	 */
	@RequestMapping(value="/user_info_update_form.ida")
	public ModelAndView goUpdateInfoForm(
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "user_info_update_form");
		
		try {
			String s_id = (String)session.getAttribute("s_id");
			UserUpdateDTO user_updateDTO = this.userService.getUserInfo(s_id);
			AddrDTO addrDTO = new AddrDTO();
			addrDTO.setCity(user_updateDTO.getCity());
			addrDTO.setGun(user_updateDTO.getGun());
			addrDTO.setGu(user_updateDTO.getGu());
			addrDTO.setDong(user_updateDTO.getDong());

			List<AddrDTO> city_list = this.idaService.getCityList();
			List<AddrDTO> gun_list = this.idaService.getGunList(addrDTO);
			List<AddrDTO> gu_list = this.idaService.getGuList(addrDTO);
			List<AddrDTO> dong_list = this.idaService.getDongList(addrDTO);

			user_updateDTO.setCity_list(city_list);
			user_updateDTO.setGun_list(gun_list);
			user_updateDTO.setGu_list(gu_list);
			user_updateDTO.setDong_list(dong_list);
			
			mav.addObject("user_info", user_updateDTO);
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goUpdateInfoForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	/**
	 * 회원 정보를 변경할 메소드
	 * 가상주소 /update_user_proc.ida로 접근하면 호출
	 * @param user_updateDTO : 변경하려는 회원 정보를 저장한 DTO
	 * @param session : HttpSession 객체
	 * @return updateCnt : 회원정보 수정 결과
	 */
	@RequestMapping(value="/update_user_proc.ida")
	@ResponseBody
	public int updateUserInfo(
			UserUpdateDTO user_updateDTO
			, HttpSession session) {
		int updateCnt = 0;
		
		try {
			String s_id = (String)session.getAttribute("s_id");
			user_updateDTO.setS_id(s_id);

			int addr_code = this.userService.getAddrCode(user_updateDTO);
			user_updateDTO.setAddr_code(addr_code);
			
			Aes256 aes = new Aes256();
			user_updateDTO.setPwd(aes.encrypt(user_updateDTO.getPwd()));
			user_updateDTO.setNewPwd(aes.encrypt(user_updateDTO.getNewPwd()));
			
			updateCnt = this.userService.updateUserInfo(user_updateDTO);
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<updateUserInfo 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return updateCnt;
	}
	
	/**
	 * 로그아웃 화면을 보여줄 jsp를 보여주는 메소드
	 * 가상주소 /logout_form.ida로 접근하면 호출
	 * @param session : HttpSession 객체
	 * @return mav : /logout_form.ida에 맵핑되는 jsp 파일
	 */
	@RequestMapping(value="/logout_form.ida")
	public ModelAndView goLoginOutForm(
			HttpSession session
			, HttpServletRequest request
			, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		Cookie[] cookies = request.getCookies();
		
		try {
			session.invalidate();	// session 객체의 수명을 0으로 만듬
			
			if(cookies != null) {
				for(int i=0; i<cookies.length; i++) {
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
				}
			}
			
			mav.setViewName(path + "logout_form");
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goLoginOutForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
}