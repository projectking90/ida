/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import system.ida.dto.MenuDTO;
import system.ida.dto.MenuListDTO;
import system.ida.dto.OrderDTO;
import system.ida.dto.OrderUpdateDTO;
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
	public ModelAndView goOrderForm(
			HttpSession session
			, OrderDTO orderDTO) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "order_form");

		try {
			String s_id = (String)session.getAttribute("s_id");
			List<OrderUpdateDTO> order_list = this.orderService.getOrderList(s_id);
			mav.addObject("order_list", order_list);
			
			MenuListDTO menu_listDTO = new MenuListDTO();
			menu_listDTO.setMi_nameList(this.orderService.getMenuList(s_id));
			mav.addObject("menu_listDTO", menu_listDTO);
		} catch (Exception e) { // try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goOrderForm 에러발생>");
			System.out.println(e.getMessage());
		}

		return mav;
	}

	/**
	 * 주문 추가 기능 실행 시 데이터베이스와 연동 처리할 메소드
	 * 가상주소 /menu_insert.ida로 접근하면 호출
	 * @param menuDTO : 메뉴 추가를 위해 사용하는 DTO
	 * @return insert_result : 메뉴 추가 Query 실행 결과
	 */
	@RequestMapping(value="/order_insert.ida"
					, method=RequestMethod.POST	)
	@ResponseBody
	public int insertOrderMenu(
			OrderDTO orderDTO
			,@RequestParam(value="minameArr") ArrayList<String> mi_names
			,@RequestParam(value="quantityArr") ArrayList<String> quantitys
			, HttpSession session
			) {
		
		int insert_result = 0;	// 데이터베이스에 Query 실행 후 결과를 저장
		int order_menu_insert = 0;
		
		try {
			insert_result = this.orderService.insertStoreOrder(orderDTO);
			String s_id = (String)session.getAttribute("s_id");
			
			order_menu_insert = this.orderService.insertOrderMenuOne(mi_names,quantitys, s_id);
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<insertOrderMenu 에러발생>");
			System.out.println(e.getMessage());
			return -1;
		}
		
		return insert_result;
	}

	/**
	 * 메뉴 수정 화면을 보여줄 jsp와 메뉴 정보를 보여주는 메소드
	 * 가상주소 /order_update_form.ida로 접근하면 호출
	 * @return mav : /order_update_form.ida에 맵핑되는 jsp 파일과 메뉴 정보 목록
	 */
	@RequestMapping(value = "/order_update_form.ida")
	public ModelAndView goOrderUpdateForm(
			HttpSession session
			,OrderDTO orderDTO) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "order_update_form");

		try {
			String s_id = (String)session.getAttribute("s_id");
			
			MenuListDTO menu_listDTO = new MenuListDTO();
			List<MenuDTO> menu_list = this.orderService.getMenuList(s_id);
			menu_listDTO.setMi_nameList(menu_list);
			mav.addObject("menu_listDTO", menu_listDTO);
			
			
			List<OrderUpdateDTO> order_list = this.orderService.getOrderList_sepa_quan(s_id);
			mav.addObject("order_list", order_list);
		} catch (Exception e) { // try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goOrderUpdateForm 에러발생>");
			System.out.println(e.getMessage());
		}

		return mav;
	}

	/**
	 * 주문 수정 기능 실행 시 데이터베이스와 연동 처리할 메소드
	 * 가상주소 /order_update.ida로 접근하면 호출
	 * @param menuDTO : 메뉴 수정을 위해 사용하는 DTO
	 * @return update_result : 메뉴 수정 Query 실행 결과
	 */
	@RequestMapping(value="/order_update.ida")
	@ResponseBody
	public int updateStoreOrder(
			@RequestParam(value="trArr") ArrayList<String> order_update
	) {
		int update_result = 0;	// 데이터베이스에 Query 실행 후 결과를 저장

		System.out.print("updatecheck");
		try {
			 update_result = this.orderService.updateStoreOrder(order_update); 
			
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<updateStoreMenu 에러발생>");
			System.out.println(e.getMessage());
			update_result=-1;
		}
		
		return update_result;
	}

	/**
	 * 메뉴 삭제 화면을 보여줄 jsp와 메뉴 정보를 보여주는 메소드
	 * 가상주소 /order_delete_form.ida로 접근하면 호출
	 * @return mav : /order_delete_form.ida에 맵핑되는 jsp 파일과 메뉴 정보 목록
	 */
	@RequestMapping(value = "/order_delete_form.ida")
	public ModelAndView goOrderDeleteForm(
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "order_delete_form");

		try {
			String s_id = (String)session.getAttribute("s_id");
			List<OrderUpdateDTO> order_list = this.orderService.getOrderList(s_id);
			mav.addObject("order_list", order_list);
		} catch (Exception e) { // try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goOrderDeleteForm 에러발생>");
			System.out.println(e.getMessage());
		}

		return mav;
	}

	/**
	 * 주문 삭제 기능 실행 시 데이터베이스와 연동 처리할 메소드
	 * 가상주소 /order_delete.ida로 접근하면 호출
	 * @param menuDTO : 메뉴 삭제를 위해 사용하는 DTO
	 * @return delete_result : 메뉴 삭제 Query 실행 결과
	 */
	@RequestMapping(value="/order_delete.ida")
	@ResponseBody
	public int deleteStoreOrder(
			OrderDTO orderDTO
			,HttpSession session
			,@RequestParam(value="trArr") ArrayList<String> order_delete) {
		int delete_result = 0;	// 데이터베이스에 Query 실행 후 결과를 저장
		
		/*
		 * for(int index=0; index<order_delete.size(); index++) {
		 * System.out.println(order_delete.get(index)); }
		 */

		try {
			String s_id = (String)session.getAttribute("s_id");
			orderDTO.setS_id(s_id);
			delete_result = this.orderService.deleteStoreOrder(order_delete);
			//System.out.print("del");
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<deleteStoreMenu 에러발생>");
			System.out.println(e.getMessage());
			return -1;
		}
		
		return delete_result;
	}
	
	/**
	 * 주문 분석 화면을 보여줄 jsp와 가게에 등록된 주문을 검색 조건에 따라 보여주는 메소드
	 * 가상주소 /order_analysis_form.ida로 접근하면 호출
	 * @return mav : /order_analysis_form.ida에 맵핑되는 jsp 파일과 검색 조건에 맞는 가게 주문 리스트
	 */
	@RequestMapping(value="/order_analysis_form.ida")
	public ModelAndView goOrderAnalysisForm(
		HttpSession session
		) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "order_analysis_form");
		 
		try {
			String s_id =(String)session.getAttribute("s_id");
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goOrderAnalysisForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	/**
	 * 주문 분석 - 차트화면을 보여줄 jsp와 가게에 등록된 주문을 검색 조건에 따라 차트로 보여주는 메소드
	 * 가상주소 /order_analysis_chart_form.ida로 접근하면 호출
	 * @return mav : /order_analysis_chart_form.ida에 맵핑되는 jsp 파일과 검색 조건에 맞는 가게 주문 차트
	 */
	@RequestMapping(value="/order_analysis_chart_form.ida")
	public ModelAndView goOrderAnalysisChartForm(
		HttpSession session
		) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "order_analysis_chart_form");
		 
		try {
			String s_id =(String)session.getAttribute("s_id");
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goOrderAnalysisChartForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
}