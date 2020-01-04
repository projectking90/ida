/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import system.ida.service.IdaService;

/**
 * IdaController 클래스
 * 컨트롤러 클래스
 * 프로젝트 시작 시 접근 할 경로, 공동으로 접근할 경로를 설정
 * @author Jo
 */
@Controller
public class IdaController {
	/**
	 * 속성변수 선언
	 */
	private final String path = "IDA/";	// jsp 경로
	@Autowired
	private IdaService idaService;	// IdaService 인터페이스를 구현받은 객체를 생성해서 저장
	
	/**
	 * 메소드 선언
	 */
	/**
	 * 시작시 메인을 보여줄 jsp와 가게에 등록된 메뉴를 보여주는 메소드
	 * 가상주소 /start.ida로 접근하면 호출
	 * @return mav : /start.ida에 맵핑되는 jsp 파일과 가게 메뉴 리스트
	 */
	@RequestMapping(value="/test.ida")
	public ModelAndView goStartForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "test");
		
		try {
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goStartForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
}
