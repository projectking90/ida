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
 * 컨트롤러 클래스
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
	 * @return mav : /ingredient_form.ida에 맵핑되는 jsp 파일과 가게 식자재 리스트
	 */
	@RequestMapping(value="/ingredient_form.ida")
	public ModelAndView goIngredientForm(
		IngredientSearchDTO ingredient_searchDTO
		,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "ingredient_form");
		
		try {
			String s_id =(String)session.getAttribute("s_id");
			ingredient_searchDTO.setS_id(s_id);
			List<IngredientDTO> ingredient_list = this.ingredientService.getIngredientList(ingredient_searchDTO);
			
			Code_ingredientDTO code_ingredientDTO = new Code_ingredientDTO();
			code_ingredientDTO.setIa_nameList(this.ingredientService.getCodeIngAlpha());
			code_ingredientDTO.setIb_nameList(this.ingredientService.getCodeIngBeta());
			code_ingredientDTO.setIo_nameList(this.ingredientService.getCodeIngOrigin());
			code_ingredientDTO.setA_nameList(this.ingredientService.getCodeIngAllergie());
			
			mav.addObject("ingredient_list",ingredient_list);
			mav.addObject("ingredient_searchDTO",ingredient_searchDTO);
			mav.addObject("code_ingredientDTO",code_ingredientDTO);
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goIngredientForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}

	/**
	 * 식자재 추가 기능 실행시 데이터베이스와 연동 처리할 메소드
	 * 가상주소 /ingredient_insert.ida로 접근하면 호출
	 * @param IngredientDTO : 식자재 추가를 위해 사용하는 DTO
	 * @return insert_result : 식자재 추가 Query 실행 결과
	 */
	@RequestMapping(value="/ingredient_insert.ida"
		, method=RequestMethod.POST
		, produces="application/json;charset=UTF-8")
	@ResponseBody
	public int insertIngredient(
		IngredientDTO ingredientDTO
		,HttpSession session) {
		int insert_result =0; 		//데이터베이스 실행 후 결과를 저장
		
		try {
			String s_id =(String)session.getAttribute("s_id");
			ingredientDTO.setS_id(s_id);
			insert_result = this.ingredientService.insertIngredient(ingredientDTO);
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goIngredientInsertForm 에러발생>");
			System.out.println(e.getMessage());
			return -1;
		}
		
		return insert_result;
	}
	
	/**
	 * 식자재 수정 화면을 보여줄 jsp와 가게에 등록된 식자재를 보여주는 메소드
	 * 가상주소 /ingredient_update_form.ida로 접근하면 호출
	 * @return mav : /ingredient_update_form.ida에 맵핑되는 jsp 파일과 가게 식자재 리스트
	 */
	@RequestMapping(value="/ingredient_update_form.ida")
	public ModelAndView goIngredientUpdateForm(
			IngredientSearchDTO ingredient_searchDTO
			,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "ingredient_update_form");
		
		try {
			String s_id =(String)session.getAttribute("s_id");
			ingredient_searchDTO.setS_id(s_id);
			List<IngredientDTO> ingredient_list = this.ingredientService.getIngredientList(ingredient_searchDTO);
			List<Code_IngredientAlphaDTO> alpha = this.ingredientService.getCodeIngAlpha();
			List<Code_IngredientBetaDTO> beta = this.ingredientService.getCodeIngBeta();
			List<Code_IngredientOriginDTO> origin = this.ingredientService.getCodeIngOrigin();
			
			for(IngredientDTO temp : ingredient_list) {
				temp.setIa_nameList(alpha);
				temp.setIb_nameList(beta);
				temp.setIo_nameList(origin);
			}
			
			mav.addObject("ingredient_list",ingredient_list);
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goIngredientUpdateForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}

	/**
	 * 식자재 수정 기능 실행시 보여줄 데이터베이스와 연동처리 할 메소드
	 * 가상주소 : ingredient_update_proc.ida 로 접근하면 호출
	 * @param ingredient_update
	 * @return
	 */
	@RequestMapping(value="/ingredient_update_proc.ida")
	@ResponseBody
	public int tableUpdateProc(
			@RequestParam(value="trArr") ArrayList<String> ingredient_update
	) 
	{
		int ingredient_update_cnt = 0;
		
		try {				 
			ingredient_update_cnt = this.ingredientService.updateIngredient(ingredient_update);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
		
		return ingredient_update_cnt;
	}
	
	/**
	 * 식자재 삭제 화면을 보여줄 jsp와 가게에 등록된 식자재를 보여주는 메소드
	 * 가상주소 /ingredient_delete_form.ida로 접근하면 호출
	 * @return mav : /ingredient_delete_form.ida에 맵핑되는 jsp 파일과 가게 식자재 리스트
	 */
	@RequestMapping(value="/ingredient_delete_form.ida")
	public ModelAndView goIngredientDeleteForm(
		HttpSession session
		,IngredientSearchDTO ingredient_searchDTO) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "ingredient_delete_form");
		 
		try {
			String s_id =(String)session.getAttribute("s_id");
			ingredient_searchDTO.setS_id(s_id);
			List<IngredientDTO> ingredient_list = this.ingredientService.getIngredientList(ingredient_searchDTO);
			mav.addObject("ingredient_list",ingredient_list);
			mav.addObject("ingredient_searchDTO",ingredient_searchDTO);
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goIngredientDeleteForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	/**
	 * 식자재  삭제 기능 실행 시 데이터베이스와 연동 처리할 메소드
	 * 가상주소 /ingredeint_delete.onm로 접근하면 호출
	 * @param IngredientDTO : 식자재 삭제를 위해 사용하는 DTO
	 * @return delete_result : 식자제 삭제 Query 실행 결과
	 */
	@RequestMapping(value="/ingredeint_delete.ida")
	@ResponseBody
	public int deleteIngredient(
			IngredientDTO ingredientDTO
			,IngredientSearchDTO ingredient_searchDTO
			,HttpSession session
			,@RequestParam(value="trArr") ArrayList<String> ingredient_delete) {
		int delete_result = 0;	// 데이터베이스에 Query 실행 후 결과를 저장

		try {
			String s_id = (String)session.getAttribute("s_id");
			ingredient_searchDTO.setS_id(s_id);
			delete_result = this.ingredientService.deleteIngredient(ingredient_delete);
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<deleteStoreMenu 에러발생>");
			System.out.println(e.getMessage());
			return -1;
		}
		
		return delete_result;
	}
	
	/**
	 * 식자재 분석 화면을 보여줄 jsp와 가게에 등록된 식자재를 검색 조건에 따라 보여주는 메소드
	 * 가상주소 /ingredient_analysis_form.ida로 접근하면 호출
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
	 * @return mav : /ingredient_analysis_chart_form.ida에 맵핑되는 jsp 파일과 검색 조건에 맞는 가게 식자재 차트
	 */
	@RequestMapping(value="/ingredient_analysis_chart_form.ida")
	public ModelAndView goIngredientAnalysisChartForm(
		IngredientSearchDTO ingredient_searchDTO
		,HttpSession session
		) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "ingredient_analysis_chart_form");
		 
		try {
			String s_id =(String)session.getAttribute("s_id");
			List<IngredientDTO> ingredient_anl_list = this.ingredientService.getIngAnlList(ingredient_searchDTO);
			mav.addObject("ingredient_anl_list",ingredient_anl_list);
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goIngredientAnalysisChartForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	/**
	 * 식자재  차트
	 * 가상주소 /ingredeint_analysis_chart.ida로 접근하면 호출
	 */
	@RequestMapping(value="/ingredeint_analysis_chart.ida")
	@ResponseBody
	public ChartDTO getIngredientChartData(
			ChartSearchDTO chart_searchDTO
			,HttpSession session
			, @RequestParam(value="chart_search") String chart_search
			, @RequestParam(value="chart_cnt") String chart_cnt
			, @RequestParam(value="week") String week
			, @RequestParam(value="month") String month
			, @RequestParam(value="year") String year
			) {
		ChartDTO chart_data = new ChartDTO();	// 데이터베이스에 Query 실행 후 결과를 저장

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

			}else if(chart_search.equals("월")) {
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
			}else if (chart_search.equals("시간")) {
				
			}else if(chart_search.equals("분기")) {
				
			}
			chart_data.setDataset(dataset);
			chart_data.setLabel(label);
			chart_data.setData1(data1);


		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<getIngredientChartData 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return chart_data;
	}
}