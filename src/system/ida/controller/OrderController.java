/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import system.ida.dto.ChartDTO;
import system.ida.dto.ChartSearchDTO;
import system.ida.dto.MenuDTO;
import system.ida.dto.MenuListDTO;
import system.ida.dto.OrderDTO;
import system.ida.dto.OrderSearchDTO;
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
		
		try {
			String s_id = (String)session.getAttribute("s_id");
			orderDTO.setS_id(s_id);
			
			insert_result = this.orderService.insertStoreOrder(orderDTO,mi_names,quantitys, s_id);
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
			, @RequestParam(value="oi_no") String oi_no) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "order_update_form");
		System.out.println(oi_no);
		
		try {
			String s_id = (String)session.getAttribute("s_id");
			
			MenuListDTO menu_listDTO = new MenuListDTO();
			List<MenuDTO> menu_list = this.orderService.getMenuList(s_id);
			menu_listDTO.setMi_nameList(menu_list);
			mav.addObject("menu_listDTO", menu_listDTO);
			List<OrderUpdateDTO> orderUpdateDTOList = this.orderService.getOrderList_sepa_quan(oi_no);
			mav.addObject("orderUpdateDTOList", orderUpdateDTOList);
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
		, OrderSearchDTO ordersearchDTO) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "order_analysis_form");
		try {
			String s_id = (String)session.getAttribute("s_id");
			ordersearchDTO.setS_id(s_id);
			List<OrderDTO> order_list = this.orderService.getOrderList(ordersearchDTO);
			mav.addObject("ordersearchDTO", ordersearchDTO);
			mav.addObject("order_list", order_list);
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
		HttpSession session) {
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
	
	@RequestMapping(value="/order_analysis_chart.ida")
	@ResponseBody
	public ChartDTO getOrderChartData(
			HttpSession session
			,@RequestParam(value="chart_search") String chart_search
			,@RequestParam(value="chart_cnt", required=false) String chart_cnt
			,@RequestParam(value="age", required=false) String age 
			,@RequestParam(value="month", required=false) String month
			,@RequestParam(value="year", required=false) String year
			,@RequestParam(value="quarter", required=false) String quarter
			,@RequestParam(value="week", required=false) String week ) {
		ChartDTO chart_data = new ChartDTO();	// 데이터베이스에 Query 실행 후 결과를 저장
		ChartSearchDTO chart_search_DTO  = new ChartSearchDTO();
		try {
			String s_id = (String)session.getAttribute("s_id");
			chart_search_DTO.setChart_cnt(chart_cnt);
			chart_search_DTO.setS_id(s_id);
			chart_search_DTO.setAge(age);
			chart_search_DTO.setMonth(month);
			chart_search_DTO.setYear(year);
			chart_search_DTO.setQuarter(quarter);
			chart_search_DTO.setWeek(week);
			
			if(chart_search.equals("주")) {
				List<Map<String,String>> week_chart = this.orderService.getWeekData(chart_search_DTO);
				List<Map<String,String>> week_menu_chart = this.orderService.getWeekMenuData(chart_search_DTO);
				
				List<String> label1 = new ArrayList<String>();
				List<String> label2 = new ArrayList<String>();
				for(int i=0; i<week_chart.size(); i++) {
					label1.add(week_chart.get(i).get("label"));
				}
				for(int i=0; i<week_menu_chart.size(); i++) {
					label2.add(week_menu_chart.get(i).get("label"));
				}
				
				List<String> data1 = new ArrayList<String>();
				List<String> data2 = new ArrayList<String>();
				for(int i=0; i<week_chart.size(); i++) {
					data1.add(week_chart.get(i).get("data"));
				}
				for(int i=0; i<week_menu_chart.size(); i++) {
					data2.add(week_menu_chart.get(i).get("data"));
				}
				
				List<String> dataset = new ArrayList<String>();
				dataset.add(week_menu_chart.get(0).get("dataset"));

				chart_data.setDataset(dataset);
				chart_data.setLabel(label1);
				chart_data.setLabel2(label2);
				chart_data.setData1(data1);
				chart_data.setData2(data2);
				
			} else if(chart_search.equals("월")) {
				List<Map<String,String>> month_chart = this.orderService.getMonthData(s_id);
				List<Map<String,String>> month_menu_chart = this.orderService.getMonthMenuData(chart_search_DTO);
				List<String> label1 = new ArrayList<String>();
				List<String> label2 = new ArrayList<String>();
				
				for(int i=0; i<month_chart.size(); i++) {
					label1.add(month_chart.get(i).get("label"));
				}
				for(int i=0; i<month_menu_chart.size(); i++) {
					label2.add(month_menu_chart.get(i).get("label"));
				}
				
				List<String> data1 = new ArrayList<String>();
				List<String> data2 = new ArrayList<String>();
				
				for(int i=0; i<month_chart.size(); i++) {
					data1.add(month_chart.get(i).get("data"));
				}
				for(int i=0; i<month_menu_chart.size(); i++) {
					data2.add(month_menu_chart.get(i).get("data"));
				}
				
				List<String> dataset = new ArrayList<String>();
				dataset.add(month_menu_chart.get(0).get("dataset"));
				
				chart_data.setDataset(dataset);
				chart_data.setLabel(label1);
				chart_data.setLabel2(label2);
				chart_data.setData1(data1);
				chart_data.setData2(data2);
				
			} else if(chart_search.equals("시간")) {
				List<Map<String,String>> hour_chart = this.orderService.getHourData(s_id);
				List<String> label = new ArrayList<String>();
				
				for(int i=0; i<hour_chart.size(); i++) {
					label.add(hour_chart.get(i).get("label"));
				}
				
				List<String> data1 = new ArrayList<String>();
				
				for(int i=0; i<hour_chart.size(); i++) {
					data1.add(hour_chart.get(i).get("data"));
				}
				
				chart_data.setLabel(label);
				chart_data.setData1(data1);
			} else if(chart_search.equals("분기")) {
				List<Map<String,String>> quarter_chart = this.orderService.getQuarterData(s_id);
				List<Map<String,String>> quarter_menu_chart = this.orderService.getQuarterMenuData(chart_search_DTO);
				List<String> label1 = new ArrayList<String>();
				List<String> label2 = new ArrayList<String>();
				
				for(int i=0; i<quarter_chart.size(); i++) {
					label1.add(quarter_chart.get(i).get("label"));
				}
				
				for(int i=0; i<quarter_menu_chart.size(); i++) {
					label2.add(quarter_menu_chart.get(i).get("label"));
				}
				
				List<String> data1 = new ArrayList<String>();
				List<String> data2 = new ArrayList<String>();
				
				for(int i=0; i<quarter_chart.size(); i++) {
					data1.add(quarter_chart.get(i).get("data"));
				}
				
				for(int i=0; i<quarter_menu_chart.size(); i++) {
					data2.add(quarter_menu_chart.get(i).get("data"));
				}
				List<String> dataset = new ArrayList<String>();
				dataset.add(quarter_menu_chart.get(0).get("dataset"));
				
				chart_data.setDataset(dataset);
				chart_data.setLabel(label1);
				chart_data.setLabel2(label2);
				chart_data.setData1(data1);
				chart_data.setData2(data2);
				
			} else if (chart_search.equals("성별")) {
				List<Map<String,String>> gender_chart_m = this.orderService.getGenderData_M(chart_search_DTO);
				List<Map<String,String>> gender_chart_w = this.orderService.getGenderData_W(chart_search_DTO);
				
				List<String> label1 = new ArrayList<String>();
				List<String> label2 = new ArrayList<String>();
				
				for(int i=0; i<gender_chart_m.size(); i++) {
					label1.add(gender_chart_m.get(i).get("label"));
				}
				
				for(int i=0; i<gender_chart_w.size(); i++) {
					label2.add(gender_chart_w.get(i).get("label"));
				}
				
				List<String> data1 = new ArrayList<String>();
				List<String> data2 = new ArrayList<String>();

				for(int i=0; i<gender_chart_m.size(); i++) {
					data1.add(gender_chart_m.get(i).get("data"));
				}

				for(int i=0; i<gender_chart_w.size(); i++) {
					data2.add(gender_chart_w.get(i).get("data"));
				}
				
				List<String> dataset = new ArrayList<String>();
				dataset.add(gender_chart_m.get(0).get("dataset"));
				dataset.add(gender_chart_w.get(0).get("dataset"));
				

				chart_data.setDataset(dataset);
				chart_data.setLabel(label1);
				chart_data.setLabel2(label2);
				chart_data.setData1(data1);
				chart_data.setData2(data2);
				
			} else if (chart_search.equals("나이대")) {
				List<Map<String,String>> age_chart = this.orderService.getAgeData(s_id);
				List<Map<String,String>> age_menu_chart = this.orderService.getAgeMenuData(chart_search_DTO);
				List<String> label1 = new ArrayList<String>();
				List<String> label2 = new ArrayList<String>();
				
				for(int i=0; i<age_chart.size(); i++) {
					label1.add(age_chart.get(i).get("label"));
				}
				for(int i=0; i<age_menu_chart.size(); i++) {
					label2.add(age_menu_chart.get(i).get("label"));
				}
					
				List<String> data1 = new ArrayList<String>();
				List<String> data2 = new ArrayList<String>();
				
				for(int i=0; i<age_chart.size(); i++) {
					data1.add(age_chart.get(i).get("data"));
				}
				
				for(int i=0; i<age_menu_chart.size(); i++) {
					data2.add(age_menu_chart.get(i).get("data"));
				}
				
				List<String> dataset = new ArrayList<String>();
				dataset.add(age_menu_chart.get(0).get("dataset"));

				chart_data.setDataset(dataset);
				chart_data.setLabel(label1);
				chart_data.setLabel2(label2);
				chart_data.setData1(data1);
				chart_data.setData2(data2);
				
			}
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<getOrderChartData 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return chart_data;
	}
}