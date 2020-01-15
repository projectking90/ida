/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import system.ida.dto.AddrDTO;
import system.ida.service.IdaService;
import system.ida.dto.MenuTrackingDTO;

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
	 * 군 목록을 가져올 메소드
	 * 가상주소 /get_gun.ida로 접근하면 호출
	 * @param addrDTO : 주소 정보를 담은 DTO
	 * @return gun_list : 군 목록
	 */
	@RequestMapping(value="/get_gun.ida")
	@ResponseBody
	public List<AddrDTO> getGunList(
			AddrDTO addrDTO) {
		List<AddrDTO> gun_list = null;
		
		try {
			gun_list = this.idaService.getGunList(addrDTO);
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<getGunList 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return gun_list;
	}

	/**
	 * 구 목록을 가져올 메소드
	 * 가상주소 /get_gu.ida로 접근하면 호출
	 * @param addrDTO : 주소 정보를 담은 DTO
	 * @return gu_list : 구 목록
	 */
	@RequestMapping(value="/get_gu.ida")
	@ResponseBody
	public List<AddrDTO> getGuList(
			AddrDTO addrDTO) {
		List<AddrDTO> gu_list = null;
		
		try {
			gu_list = this.idaService.getGuList(addrDTO);
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<getGuList 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return gu_list;
	}

	/**
	 * 동 목록을 가져올 메소드
	 * 가상주소 /get_dong.ida로 접근하면 호출
	 * @param addrDTO : 주소 정보를 담은 DTO
	 * @return dong_list : 동 목록
	 */
	@RequestMapping(value="/get_dong.ida")
	@ResponseBody
	public List<AddrDTO> getDongList(
			AddrDTO addrDTO) {
		List<AddrDTO> dong_list = null;
		
		try {
			if(addrDTO.getGu().equals("null")) {
				addrDTO.setGu("");
			}
			dong_list = this.idaService.getDongList(addrDTO);
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<getDongList 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return dong_list;
	}
	
	
	
	/**
	 * 메뉴 트래킹 정보를 가져올 메소드
	 * @param path : 경로
	 * @param user_flag : 유저 구분
	 * @return menu_tracking_list : 메뉴 트래킹 정보
	 */
	@RequestMapping(value="/get_path.onm")
	@ResponseBody
	public List<MenuTrackingDTO> getMenuTracking(
			@RequestParam(value="path") String path
			, @RequestParam(value="user_flag") String user_flag) {
		List<MenuTrackingDTO> menu_tracking_list = null;
		
		Map<String, String> path_user_flag = new HashMap<String, String>();
		path_user_flag.put("path", path);
		path_user_flag.put("user_flag", user_flag);
		
		try {
			menu_tracking_list = this.idaService.getMenuTracking(path_user_flag);
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<getMenuTracking 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return menu_tracking_list;
	}
}