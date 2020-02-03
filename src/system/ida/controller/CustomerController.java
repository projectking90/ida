/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import system.ida.dto.ChartDTO;
import system.ida.dto.ChartSearchDTO;
import system.ida.dto.CustomerDTO;
import system.ida.dto.CustomerSearchDTO;
import system.ida.service.CustomerService;

/**
 * CustomerController 클래스
 * 컨트롤러 클래스
 * 고객에 관련 가상 경로를 설정
 * @author Jo
 */
@Controller
public class CustomerController {
	/**
	 * 속성변수 선언
	 */
	private final String path = "Customer/"; // jsp 경로
	@Autowired
	private CustomerService customerService;	// CustomerService 인터페이스를 구현받은 객체를 생성해서 저장

	/**
	 * 메소드 선언
	 */
	/**
	 * 고객 관리 화면을 보여줄 jsp와 주문 정보를 보여주는 메소드
	 * 가상주소 /customer_form.ida로 접근하면 호출
	 * @return mav : /customer_form.ida에 맵핑되는 jsp 파일과 주문 정보 목록
	 */
	@RequestMapping(value = "/customer_form.ida")
	public ModelAndView goCustomerForm(
		CustomerSearchDTO customer_SearchDTO) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "customer_form");

		try {
			List<CustomerDTO> customer_list = this.customerService.getCustomerList(customer_SearchDTO);
			mav.addObject("customer_list", customer_list);
		} catch (Exception e) { // try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goCustomerForm 에러발생>");
			System.out.println(e.getMessage());
		}

		return mav;
	}
	
	/**
	 * 고객 분석 화면을 보여줄 jsp와 가게에 등록된 고객을 검색 조건에 따라 보여주는 메소드
	 * 가상주소 /customer_analysis_form.ida로 접근하면 호출
	 * @return mav : /customer_analysis_form.ida에 맵핑되는 jsp 파일과 검색 조건에 맞는 가게 고객 리스트
	 */
	@RequestMapping(value="/customer_analysis_form.ida")
	public ModelAndView goCustomerAnalysisForm(
		HttpSession session
		) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "customer_analysis_form");
		 
		try {
			String s_id =(String)session.getAttribute("s_id");
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goCustomerAnalysisForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	/**
	 * 고객 분석 - 차트화면을 보여줄 jsp와 가게에 등록된 고객을 검색 조건에 따라 차트로 보여주는 메소드
	 * 가상주소 /customer_analysis_chart_form.ida로 접근하면 호출
	 * @return mav : /customer_analysis_chart_form.ida에 맵핑되는 jsp 파일과 검색 조건에 맞는 가게 고객 차트
	 */
	@RequestMapping(value="/customer_analysis_chart_form.ida")
	public ModelAndView goCustomerAnalysisChartForm(
		HttpSession session
		) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "customer_analysis_chart_form");
		 
		try {
			String s_id =(String)session.getAttribute("s_id");
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goCustomerAnalysisChartForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}

@RequestMapping(value="/customer_analysis_chart.ida")
@ResponseBody
public ChartDTO getCustomerChartData(
		HttpSession session
		, @RequestParam(value="chart_search") String chart_search
		, @RequestParam(value="chart_cnt") String chart_cnt
		,@RequestParam(value="age") String age) {
	ChartDTO chart_data = new ChartDTO();	// 데이터베이스에 Query 실행 후 결과를 저장
	ChartSearchDTO chart_search_DTO  = new ChartSearchDTO();
	try {
		String s_id = (String)session.getAttribute("s_id");
		chart_search_DTO.setChart_cnt(chart_cnt);
		chart_search_DTO.setS_id(s_id);
		chart_search_DTO.setAge(age);
		

			
		if (chart_search.equals("성별")) {
			List<Map<String,String>> gender_chart = this.customerService.getGenderData(s_id);
			List<String> label1 = new ArrayList<String>();
			for(int i=0; i<gender_chart.size(); i++) {
				label1.add(gender_chart.get(i).get("label"));
			}
			List<String> data1 = new ArrayList<String>();
			for(int i=0; i<gender_chart.size(); i++) {
				data1.add(gender_chart.get(i).get("data"));
			}
			chart_data.setLabel(label1);
			chart_data.setData1(data1);
		} else if(chart_search.equals("나이대")) {
			List<Map<String,String>> age_chart = this.customerService.getAgeData(s_id);
			List<String> label1 = new ArrayList<String>();
			
			for(int i=0; i<age_chart.size(); i++){
				label1.add(age_chart.get(i).get("label"));
			}
			List<String> data1 = new ArrayList<String>();
			for(int i=0; i<age_chart.size(); i++) {
				data1.add(age_chart.get(i).get("data"));
			}
			chart_data.setLabel(label1);
			chart_data.setData1(data1);
		}
	} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
		System.out.println("<getCustomerChartData 에러발생>");
		System.out.println(e.getMessage());
	}
	
	return chart_data;
}
}