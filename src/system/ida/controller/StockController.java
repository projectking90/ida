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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import system.ida.dto.ChartDTO;
import system.ida.dto.ChartSearchDTO;
import system.ida.dto.IngredientDTO;
import system.ida.dto.StockDTO;
import system.ida.dto.StockSearchDTO;
import system.ida.service.StockService;

/**
 * StockController 클래스
 * 컨트롤러 클래스 /
 * 재고에 관련 가상 경로를 설정
 * @author Jo
 */
@Controller
public class StockController {
	/**
	 * 속성변수 선언
	 */
	private final String path = "Stock/";	// jsp 경로
	@Autowired
	private StockService stockService;	// StockService 인터페이스를 구현받은 객체를 생성해서 저장

	/**
	 * 메소드 선언
	 */
	/**
	 * 재고 관리 화면을 보여줄 jsp와 재고 정보를 보여주는 메소드
	 * 가상주소 /stock_form.ida로 접근하면 호출
	 * @param stock_searchDTO : 재고 검색 DTO
	 * @param session : HttpSession 객체
	 * @return mav : /stock_form.ida에 맵핑되는 jsp 파일과 재고 정보 목록
	 */
	@RequestMapping(value="/stock_form.ida")
	public ModelAndView goStockForm(
			StockSearchDTO stock_searchDTO
			, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		try {
			String s_id = (String)session.getAttribute("s_id");
			stock_searchDTO.setS_id(s_id);
			
			List<StockDTO> stock_list = this.stockService.getStockList(stock_searchDTO);
			List<IngredientDTO> ingredient_list=this.stockService.getIngredientList(stock_searchDTO);
			mav.addObject("stock_list", stock_list);
			mav.addObject("ingredient_list", ingredient_list);
			
			mav.setViewName(path + "stock_form");
		} catch(Exception e) {
			System.out.println("<goStockForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	/**
	 * 재고 상세보기 화면을 보여줄 jsp와 재고 정보를 보여주는 메소드
	 * 가상주소 /stock_content_form.ida로 접근하면 호출
	 * @param st_no : 재고 번호
	 * @return mav : /stock_content_form.ida에 맵핑되는 jsp 파일과 재고 정보 목록
	 */
	@RequestMapping(value="/stock_content_form.ida")
	public ModelAndView goStockContentForm(
			@RequestParam(value="st_no") int st_no) {
		ModelAndView mav = new ModelAndView();
		
		try {
			StockDTO stockDTO = this.stockService.getStockDTO(st_no);
			mav.addObject("stockDTO", stockDTO);
			
			mav.setViewName(path + "stock_content_form");
		} catch(Exception e) {
			System.out.println("<goStockContentForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	/**
	 * 재고 추가 기능을 처리할 메소드
	 * 가상주소 /insert_stock_reg.ida로 접근하면 호출
	 * @param stockDTO : 재고 DTO
	 * @param session : HttpSession 객체
	 * @return stock_reg_cnt : 주문 수정 Query 실행 결과
	 */
	@RequestMapping(value="/insert_stock_reg.ida"
			, method = RequestMethod.POST
			, produces="application/json;charset=UTF-8")
	@ResponseBody
	public int insertStockReg(
			StockDTO stockDTO
			, HttpSession session) {
		int stock_reg_cnt = -1;
		
		try {
			String s_id = (String)session.getAttribute("s_id");
			stockDTO.setS_id(s_id);
			
			stock_reg_cnt=this.stockService.insertStock(stockDTO);
		} catch(Exception e) {
			System.out.println("<insertStockReg 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return stock_reg_cnt;
	}

	/**
	 * 재고 수정 화면을 보여줄 jsp와 재고 정보를 보여주는 메소드
	 * 가상주소 /stock_update_form.ida로 접근하면 호출
	 * @param st_no : 재고 번호
	 * @param session : HttpSession 객체
	 * @return mav : /stock_update_form.ida에 맵핑되는 jsp 파일과 재고 정보 목록
	 */
	@RequestMapping(value="/stock_update_form.ida")
	public ModelAndView goStockUpdateForm(
			@RequestParam(value="st_no") int st_no
			, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		try {
			StockDTO stockDTO = this.stockService.getStockDTO(st_no);
			mav.addObject("stockDTO", stockDTO);
			
			mav.setViewName(path + "stock_update_form");
		} catch(Exception e) {
			System.out.println("<goStockUpdateForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	/**
	 * 재고 수정 기능을 처리할 메소드
	 * 가상주소 /stock_update_proc.ida로 접근하면 호출
	 * @param stockDTO : 재고 DTO
	 * @return stock_update_cnt : 재고 수정 Query 실행 결과
	 */
	@RequestMapping(value="/stock_update_proc.ida")
	@ResponseBody
	public int stockUpdateProc(
			StockDTO stockDTO){
		int stock_update_cnt = -1;
		
		try {
			stock_update_cnt = this.stockService.updateStock(stockDTO);
		} catch(Exception e) {
			System.out.println("<stockUpdateProc 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return stock_update_cnt;
	}

	/**
	 * 재고 삭제 화면을 보여줄 jsp와 재고 정보를 보여주는 메소드
	 * 가상주소 /stock_delete_form.ida로 접근하면 호출
	 * @param stock_searchDTO : 재고 검색 DTO
	 * @param session : HttpSession 객체
	 * @return mav : /stock_delete_form.ida에 맵핑되는 jsp 파일과 재고 정보 목록
	 */
	@RequestMapping(value="/stock_delete_form.ida")
	public ModelAndView goStockDeleteForm(
			StockSearchDTO stock_searchDTO
			, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		try {
			String s_id = (String)session.getAttribute("s_id");
			stock_searchDTO.setS_id(s_id);
			
			List<StockDTO> stock_list = this.stockService.getStockList(stock_searchDTO);
			mav.addObject("stock_list", stock_list);

			mav.setViewName(path + "stock_delete_form");
		} catch(Exception e) {
			System.out.println("<goStockDeleteForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	/**
	 * 재고 삭제 기능을 처리할 메소드
	 * 가상주소 /stock_delete_proc.ida로 접근하면 호출
	 * @param stock_delete : 재고 번호들
	 * @return stock_delete_cnt : 재고 삭제 Query 실행 결과
	 */
	@RequestMapping(value="/stock_delete_proc.ida")
	@ResponseBody
	public int stockDeleteProc(
			@RequestParam(value="trArr") ArrayList<String> stock_delete){
		int stock_delete_cnt = -1;
		
		try {
			stock_delete_cnt = this.stockService.deleteStock(stock_delete);
		} catch(Exception e) {
			System.out.println("<stockDeleteProc 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return stock_delete_cnt;
	}
	
	/**
	 * 재고 분석 - 표 화면을 보여줄 jsp와 가게에 등록된 재고를 검색 조건에 따라 보여주는 메소드
	 * 가상주소 /stock_analysis_form.ida로 접근하면 호출
	 * @param chart_searchDTO : 차트 검색 DTO
	 * @param session : HttpSession 객체
	 * @return mav : /stock_analysis_form.ida에 맵핑되는 jsp 파일과 검색 조건에 맞는 가게 재고 리스트
	 */
	@RequestMapping(value="/stock_analysis_form.ida")
	public ModelAndView goStockAnalysisForm(
			ChartSearchDTO chart_searchDTO
			, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		 
		try {
			String s_id =(String)session.getAttribute("s_id");
			chart_searchDTO.setS_id(s_id);
			
			List<StockDTO> stock_anl_list = this.stockService.getStockAnlList(chart_searchDTO);
			mav.addObject("stock_anl_list",stock_anl_list);
			
			mav.setViewName(path + "stock_analysis_form");
		} catch(Exception e) {
			System.out.println("<goStockAnalysisForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	
	/**
	 * 재고 분석 - 차트화면을 보여줄 jsp와 가게에 등록된 재고를 검색 조건에 따라 차트로 보여주는 메소드
	 * 가상주소 /stock_analysis_chart_form.ida로 접근하면 호출
	 * @param chart_searchDTO : 재고 검색 DTO
	 * @param session : HttpSession 객체
	 * @return mav : /stock_analysis_chart_form.ida에 맵핑되는 jsp 파일과 검색 조건에 맞는 가게 재고 차트
	 */
	@RequestMapping(value="/stock_analysis_chart_form.ida")
	public ModelAndView goStockAnalysisChartForm(
			ChartSearchDTO chart_searchDTO
			, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		try {
			String s_id =(String)session.getAttribute("s_id");
			chart_searchDTO.setS_id(s_id);
			
			List<StockDTO> stock_anl_list = this.stockService.getStockAnlList(chart_searchDTO);
			mav.addObject("stock_anl_list",stock_anl_list);
			
			mav.setViewName(path + "stock_analysis_chart_form");
		} catch(Exception e) {
			System.out.println("<goStockAnalysisChartForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}

	/**
	 * 재고  차트 데이터를 가져올 메소드
	 * 가상주소 /stock_analysis_chart.ida로 접근하면 호출
	 * @param chart_searchDTO : 차트 검색 DTO
	 * @param session : HttpSession 객체
	 * @param chart_search : 검색 종류
	 * @param chart_cnt : 검색 갯수
	 * @param week : 주
	 * @param month : 월
	 * @param year : 년
	 * @param quarter : 분기
	 * @return chart_data : 차트 데이터
	 */
	@RequestMapping(value="/stock_analysis_chart.ida")
	@ResponseBody
	public ChartDTO getStockChartData(
			ChartSearchDTO chart_searchDTO
			, HttpSession session
			, @RequestParam(value="chart_search", required=false) String chart_search
			, @RequestParam(value="chart_cnt", required=false) String chart_cnt
			, @RequestParam(value="week", required=false) String week
			, @RequestParam(value="month", required=false) String month
			, @RequestParam(value="year", required=false) String year
			, @RequestParam(value="quarter", required=false) String quarter) {
		ChartDTO chart_data = new ChartDTO();

		try {
			String s_id = (String)session.getAttribute("s_id");
			chart_searchDTO.setS_id(s_id);
			chart_searchDTO.setChart_cnt(chart_cnt);
			
			List<String> label = new ArrayList<String>();
			List<String> data1=new ArrayList<String>();
			List<String> dataset = new ArrayList<String>();
			
			if(chart_search.equals("주")) {
				chart_searchDTO.setWeek(week);
				List<Map<String, String>> week_stock_chart = this.stockService.getWeekStockData(chart_searchDTO);
				
				for(int i=0; i<week_stock_chart.size(); i++) {
					label.add(week_stock_chart.get(i).get("LABEL"));
				}
				for(int i=0; i<week_stock_chart.size(); i++) {
					data1.add(week_stock_chart.get(i).get("DATA"));
				}
				
				dataset.add(week_stock_chart.get(0).get("DATASET"));
			} else if(chart_search.equals("월")) {
				chart_searchDTO.setMonth(month);
				chart_searchDTO.setYear(year);
				List<Map<String, String>> month_stock_chart = this.stockService.getMonthStockData(chart_searchDTO);
				
				for(int i=0; i<month_stock_chart.size(); i++) {
					label.add(month_stock_chart.get(i).get("LABEL"));
				}
				for(int i=0; i<month_stock_chart.size(); i++) {
					data1.add(month_stock_chart.get(i).get("DATA"));
				}
				
				dataset.add(month_stock_chart.get(0).get("DATASET"));
			} else if (chart_search.equals("시간")) {
				List<Map<String, String>> time_stock_chart = this.stockService.getTimeStockData(chart_searchDTO);

				for(int i=0; i<time_stock_chart.size(); i++) {
					label.add(time_stock_chart.get(i).get("LABEL"));
				}

				for(int i=0; i<time_stock_chart.size(); i++) {
					data1.add(time_stock_chart.get(i).get("DATA"));
				}

				dataset.add("시간별 재고 입/출고 데이터");
			} else if (chart_search.equals("분기")) {
				chart_searchDTO.setQuarter(quarter);
				
				// Pie Chart
				List<Map<String, String>> all_quarter_stock_chart = this.stockService.getAllQuarterStockData(chart_searchDTO);
				
				for(int i=0; i<all_quarter_stock_chart.size(); i++) {
					label.add(all_quarter_stock_chart.get(i).get("LABEL"));
				}
				for(int i=0; i<all_quarter_stock_chart.size(); i++) {
					data1.add(all_quarter_stock_chart.get(i).get("DATA"));
				}

				List<String> label2 = new ArrayList<String>();
				List<String> data2 =new ArrayList<String>();
				
				// Bar Chart
				List<Map<String, String>> quarter_stock_chart = this.stockService.getQuarterStockData(chart_searchDTO);

				for(int i=0; i<quarter_stock_chart.size(); i++) {
					label2.add(quarter_stock_chart.get(i).get("LABEL"));
				}
				for(int i=0; i<quarter_stock_chart.size(); i++) {
					data2.add(quarter_stock_chart.get(i).get("DATA"));
				}
				
				dataset.add(quarter_stock_chart.get(0).get("DATASET"));

				chart_data.setLabel2(label2);
				chart_data.setData2(data2);
			}

			chart_data.setDataset(dataset);
			chart_data.setLabel(label);
			chart_data.setData1(data1);
		} catch(Exception e) {
			System.out.println("<getStockChartData 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return chart_data;
	}
}