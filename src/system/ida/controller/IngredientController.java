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
import system.ida.dto.Code_IngredientAlphaDTO;
import system.ida.dto.Code_IngredientBetaDTO;
import system.ida.dto.Code_IngredientOriginDTO;
import system.ida.dto.Code_ingredientDTO;
import system.ida.dto.IngredientDTO;
import system.ida.dto.IngredientSearchDTO;
import system.ida.service.IngredientService;

/**
 * IngredientController 클래스
 * 컨트롤러 클래스 /
 * 식자재에 관련된 가상 경로를 설정
 * @author Jo
 */
@Controller
public class IngredientController {
	/**
	 * 속성변수 선언
	 */
	private final String path = "Ingredient/";	// jsp 경로
	@Autowired
	private IngredientService ingredientService;	// IngredientService 인터페이스를 구현받은 객체를 생성해서 저장

	/**
	 * 메소드 선언
	 */
	/**
	 * 식자재 관리 화면을 보여줄 jsp와 가게에 등록된 식자재를 보여주는 메소드
	 * 가상주소 /ingredient_form.ida로 접근하면 호출
	 * @param ingredient_searchDTO : 식자재 검색 DTO
	 * @param session : HttpStssion 객체
	 * @return mav : /ingredient_form.ida에 맵핑되는 jsp 파일과 가게 식자재 리스트
	 */
	@RequestMapping(value="/ingredient_form.ida")
	public ModelAndView goIngredientForm(
		IngredientSearchDTO ingredient_searchDTO
		, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		try {
			String s_id =(String)session.getAttribute("s_id");
			ingredient_searchDTO.setS_id(s_id);
			
			List<IngredientDTO> ingredient_list = this.ingredientService.getIngredientList(ingredient_searchDTO);
			
			Code_ingredientDTO code_ingredientDTO = new Code_ingredientDTO();
			code_ingredientDTO.setIa_nameList(this.ingredientService.getCodeIngAlpha());
			code_ingredientDTO.setIb_nameList(this.ingredientService.getCodeIngBeta());
			code_ingredientDTO.setIo_nameList(this.ingredientService.getCodeIngOrigin());
			code_ingredientDTO.setA_nameList(this.ingredientService.getCodeIngAllergie());

			mav.setViewName(path + "ingredient_form");
			mav.addObject("ingredient_list", ingredient_list);
			mav.addObject("ingredient_searchDTO", ingredient_searchDTO);
			mav.addObject("code_ingredientDTO", code_ingredientDTO);
		} catch(Exception e) {
			System.out.println("<goIngredientForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}

	/**
	 * 식자재 추가 기능을 처리할 메소드
	 * 가상주소 /ingredient_insert.ida로 접근하면 호출
	 * @param ingredientDTO : 식자재 DTO
	 * @param session : HttpSession 객체
	 * @return insert_result : 식자재 추가 Query 실행 결과
	 */
	@RequestMapping(value="/ingredient_insert.ida"
		, method=RequestMethod.POST
		, produces="application/json;charset=UTF-8")
	@ResponseBody
	public int insertIngredient(
		IngredientDTO ingredientDTO
		, HttpSession session) {
		int insert_result = -1;
		
		try {
			String s_id =(String)session.getAttribute("s_id");
			ingredientDTO.setS_id(s_id);
			
			insert_result = this.ingredientService.insertIngredient(ingredientDTO);
		} catch(Exception e) {
			System.out.println("<insertIngredient 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return insert_result;
	}
	
	/**
	 * 식자재 상세보기 화면을 보여줄 jsp와 하나의 식자재 정보를 보여주는 메소드
	 * 가상주소 /ingredient_detail_form.ida로 접근하면 호출
	 * @param i_no : 식자재 번호
	 * @param ingredient_searchDTO : 식자재 검색 DTO
	 * @param session : HttpSessio  객체
	 * @return mav : /ingredient_detail_form.ida에 맵핑 되는 jsp 파일과 가게 식자재 리스트
	 */
	@RequestMapping(value = "/ingredient_detail_form.ida")
	public ModelAndView goIngredientDetailForm(
			@RequestParam(value = "i_no") int i_no
			, IngredientSearchDTO ingredient_searchDTO
			, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		try {
			IngredientDTO ingredientDTO = this.ingredientService.getIngredientDTO(i_no);
			
			String s_id = (String) session.getAttribute("s_id");
			ingredient_searchDTO.setS_id(s_id);
			
			List<Code_IngredientAlphaDTO> alpha = this.ingredientService.getCodeIngAlpha();
			List<Code_IngredientBetaDTO> beta = this.ingredientService.getCodeIngBeta();
			List<Code_IngredientOriginDTO> origin = this.ingredientService.getCodeIngOrigin();
			
			ingredientDTO.setIa_nameList(alpha);
			ingredientDTO.setIb_nameList(beta);
			ingredientDTO.setIo_nameList(origin);
			
			Code_ingredientDTO code_ingredientDTO = new Code_ingredientDTO();
			code_ingredientDTO.setIa_nameList(this.ingredientService.getCodeIngAlpha());
			code_ingredientDTO.setIb_nameList(this.ingredientService.getCodeIngBeta());
			code_ingredientDTO.setIo_nameList(this.ingredientService.getCodeIngOrigin());
			code_ingredientDTO.setA_nameList(this.ingredientService.getCodeIngAllergie());
			
			mav.addObject("ingredientDTO", ingredientDTO);
			mav.addObject("code_ingredientDTO",code_ingredientDTO);
			mav.setViewName(path + "ingredient_detail_form");
		} catch (Exception e) {
			System.out.println("<goIngredientDetailForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	/**
	 * 식자재 수정 기능을 처리 할 메소드
	 * 가상주소  /ingredient_update_proc.ida로 접근하면 호출
	 * @param ingredientDTO : 식자재 DTO
	 * @return ingredient_update_cnt : 식자재 수정 Query 실행 결과
	 */
	@RequestMapping(value="/ingredient_update_proc.ida"
			, method = RequestMethod.POST
			, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public int ingredientUpdateProc(
			IngredientDTO ingredientDTO) {
		int ingredient_update_cnt = -1;

		try {
			ingredient_update_cnt = this.ingredientService.updateIngredient(ingredientDTO);
			
			if(ingredient_update_cnt!=0) {
				this.ingredientService.updateIngredientRecord(ingredientDTO);
			}
		} catch (Exception e) {
			System.out.println("<ingredientUpdateProc 에러발생>");
			System.out.println(e.getMessage());
		}

		return ingredient_update_cnt;
	}
	
	/**
	 * 식자재  삭제 기능을 처리할 메소드
	 * 가상주소 /ingredient_delete.ida로 접근하면 호출
	 * @param ingredient_delete : 삭제하려는 식자재의 번호들
	 * @return delete_result : 식자제 삭제 Query 실행 결과
	 */
	@RequestMapping(value="/ingredient_delete.ida")
	@ResponseBody
	public int deleteIngredient(
			@RequestParam(value="trArr") ArrayList<String> ingredient_delete) {
		int delete_result = -1;

		try {
			delete_result = this.ingredientService.deleteIngredient(ingredient_delete);
		} catch(Exception e) {
			System.out.println("<deleteIngredient 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return delete_result;
	}
	
	/**
	 * 식자재 분석 - 표 화면을 보여줄 jsp와 가게에 등록된 식자재를 검색 조건에 따라 보여주는 메소드
	 * 가상주소 /ingredient_analysis_form.ida로 접근하면 호출
	 * @param ingredient_searchDTO : 식자재 검색 DTO
	 * @param session : HttpSession 객체
	 * @return mav : /ingredient_analysis_form.ida에 맵핑되는 jsp 파일과 검색 조건에 맞는 가게 식자재 리스트
	 */
	@RequestMapping(value="/ingredient_analysis_form.ida")
	public ModelAndView goIngredientAnalysisForm(
			IngredientSearchDTO ingredient_searchDTO
			, HttpSession session
		) {
		ModelAndView mav = new ModelAndView();
		
		try {
			String s_id =(String)session.getAttribute("s_id");
			ingredient_searchDTO.setS_id(s_id);
			
			List<IngredientDTO> ingredient_anl_list = this.ingredientService.getIngAnlList(ingredient_searchDTO);
			
			mav.addObject("ingredient_searchDTO",ingredient_searchDTO);
			mav.addObject("ingredient_anl_list",ingredient_anl_list);
			mav.setViewName(path + "ingredient_analysis_form");
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goIngredientAnalysisForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	/**
	 * 식자재 분석 - 차트화면을 보여줄 jsp와 가게에 등록된 식자재를 검색 조건에 따라 차트로 보여주는 메소드
	 * 가상주소 /ingredient_analysis_chart_form.ida로 접근하면 호출
	 * @param ingredient_searchDTO : 식자재 검색 DTO
	 * @param session : HttpSession 객체
	 * @return mav : /ingredient_analysis_chart_form.ida에 맵핑되는 jsp 파일과 검색 조건에 맞는 가게 식자재 차트
	 */
	@RequestMapping(value="/ingredient_analysis_chart_form.ida")
	public ModelAndView goIngredientAnalysisChartForm(
		IngredientSearchDTO ingredient_searchDTO
		, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		 
		try {
			String s_id = (String)session.getAttribute("s_id");
			ingredient_searchDTO.setS_id(s_id);
			
			List<IngredientDTO> ingredient_anl_list = this.ingredientService.getIngAnlList(ingredient_searchDTO);

			mav.setViewName(path + "ingredient_analysis_chart_form");
			mav.addObject("ingredient_anl_list",ingredient_anl_list);
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goIngredientAnalysisChartForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	/**
	 * 식자재  차트 데이터를 가져올 메소드
	 * 가상주소 /ingredeint_analysis_chart.ida로 접근하면 호출
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
	@RequestMapping(value="/ingredeint_analysis_chart.ida")
	@ResponseBody
	public ChartDTO getIngredientChartData(
			ChartSearchDTO chart_searchDTO
			, HttpSession session
			, @RequestParam(value="chart_search") String chart_search
			, @RequestParam(value="chart_cnt") String chart_cnt
			, @RequestParam(value="week") String week
			, @RequestParam(value="month") String month
			, @RequestParam(value="year") String year
			, @RequestParam(value = "quarter", required=false) String quarter) {
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
				
				List<Map<String,String>> week_ingredient_chart = this.ingredientService.getWeekIngredientData(chart_searchDTO);
				
				for(int i=0; i<week_ingredient_chart.size(); i++) {
					label.add(week_ingredient_chart.get(i).get("LABEL"));
				}
				for(int i=0; i<week_ingredient_chart.size(); i++) {
					data1.add(week_ingredient_chart.get(i).get("DATA"));
				}
				
				dataset.add(week_ingredient_chart.get(0).get("DATASET"));
			} else if(chart_search.equals("월")) {
				chart_searchDTO.setMonth(month);
				chart_searchDTO.setYear(year);
				
				List<Map<String,String>> month_ingredient_chart = this.ingredientService.getMonthIngredientData(chart_searchDTO);
				
				for(int i=0; i<month_ingredient_chart.size(); i++) {
					label.add(month_ingredient_chart.get(i).get("LABEL"));
				}
				for(int i=0; i<month_ingredient_chart.size(); i++) {
					data1.add(month_ingredient_chart.get(i).get("DATA"));
				}
				
				dataset.add(month_ingredient_chart.get(0).get("DATASET"));
			} else if(chart_search.equals("분기")) {
				chart_searchDTO.setQuarter(quarter);

				//pie chart
				List<Map<String,String>> all_quarter_ingredient_chart = this.ingredientService.getAllQuarterIngredientData();
				System.out.println(all_quarter_ingredient_chart);

				for(int i=0; i<all_quarter_ingredient_chart.size(); i++) {
					label.add(all_quarter_ingredient_chart.get(i).get("LABEL"));
				}
				for(int i=0; i<all_quarter_ingredient_chart.size(); i++) {
					data1.add(all_quarter_ingredient_chart.get(i).get("DATA"));
				}

				List<String> label2 = new ArrayList<String>();
				List<String> data2 = new ArrayList<String>();

				// Bar chart
				List<Map<String,String>> quarter_ingredient_chart = this.ingredientService.getQuarterIngredientData(chart_searchDTO);
				System.out.println(quarter_ingredient_chart);

				for(int i=0; i<quarter_ingredient_chart.size(); i++) {
					label2.add(quarter_ingredient_chart.get(i).get("LABEL"));
				}
				for(int i=0; i<quarter_ingredient_chart.size(); i++) {
					data2.add(quarter_ingredient_chart.get(i).get("DATA"));
				}
				dataset.add(quarter_ingredient_chart.get(0).get("DATASET"));

				chart_data.setLabel2(label2);
				chart_data.setData2(data2);
			}
			
			chart_data.setDataset(dataset);
			chart_data.setLabel(label);
			chart_data.setData1(data1);
		} catch(Exception e) {
			System.out.println("<getIngredientChartData 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return chart_data;
	}
}