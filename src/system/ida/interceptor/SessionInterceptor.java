/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * SessionInterceptor 클래스
 * URL 접속 시 컨트롤러 클래스의 메소드 호출 전 또는 후에 실행될 메소드를 선언
 * * @author Jo
 */
public class SessionInterceptor extends HandlerInterceptorAdapter {
	/**
	 * 메소드 선언
	 */
	/**
	 * URL에 로그인 후 접속하는지 확인하는 메소드
	 * @param request : HttpServletRequest 객체
	 * @param response : HttpServletResponse 객체
	 * @param handler : ?
	 * @return true : 로그인 함 | false : 로그인 하지 않음
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/*
		 * HttpSession session = request.getSession(); // Session 객체 얻기 String admin_id
		 * = (String) session.getAttribute("admin_id"); // Session 객체에서 키값이 admin_id 로
		 * 저장된 데이터 꺼냄(즉 로그인 정보 꺼냄) String uri = request.getRequestURI(); // 접속 uri 구하기
		 * String ctRoot = request.getContextPath(); // 컨택스트 류트명 구하기
		 */		
		return true;
		
		/*
		 * if (admin_id == null) { // 로그인 정보가 없으면 false 리턴 // HttpServletResponse 객체의
		 * sendRedirect 메솓 호출로 로그인 화면으로 이동. // <주의> 이동 URL 주소에서 컨택스루트명인 /erp 를 빼지 말것
		 * //session.setAttribute("msg", "로그인 필수"); //response.sendRedirect(ctRoot +
		 * "/loginForm.do"); response.sendRedirect(ctRoot + "/logout.do"); // 클라이언트가
		 * logout.do로 접속하라고 설정 System.out.println("접속 실패 : " + uri);
		 * 
		 * return false; // false 리턴 시 Controller 클래스의 메소드는 호출되지 않음 } else { // 로그인 정보가
		 * 있으면 true 리턴 return true; // true 리턴 시 Controller 클래스의 메소드 호출 }
		 */
	}
}
