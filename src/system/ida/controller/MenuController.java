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
import system.ida.dto.CodeMenuDTO;
import system.ida.dto.Code_ingredientDTO;
import system.ida.dto.IngredientListDTO;
import system.ida.dto.MenuDTO;
import system.ida.dto.MenuSearchDTO;
import system.ida.service.MenuService;

/**
 * MenuController 클래스 
 * 컨트롤러 클래스 
 * 메뉴에 관련 가상 경로를 설정
 * @author Jo
 */
@Controller
public class MenuController {
	/**
	 * 속성변수 선언
	 */
	private final String path = "Menu/";	// jsp 경로
	@Autowired
	private MenuService menuService;	// MenuService 인터페이스를 구현받은 객체를 생성해서 저장

	/**
	 * 메소드 선언
	 */
	/**
	 * 메뉴 관리 화면을 보여줄 jsp와 메뉴 정보를 보여주는 메소드
	 * 가상주소 /menu_form.ida로 접근하면 호출
	 * @param menu_searchDTO : 메뉴 검색 DTO
	 * @param session : HttpSession 객체
	 * @return mav : /menu_form.ida에 맵핑되는 jsp 파일과 메뉴 정보 목록
	 */
	@RequestMapping(value = "/menu_form.ida")
	public ModelAndView goMenuForm(
			MenuSearchDTO menu_searchDTO
			, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		try {
			String s_id = (String)session.getAttribute("s_id");
			menu_searchDTO.setS_id(s_id);
			
			Code_ingredientDTO code_ingredientDTO = new Code_ingredientDTO();
			code_ingredientDTO.setS_id(s_id);

			int menu_list_all_cnt=this.menuService.getMenuListAllCnt(menu_searchDTO);
			
			if(menu_list_all_cnt>0) {
				int select_page_no = menu_searchDTO.getSelect_page_no();
				// 한 화면에 보여지는 행의 개수 구하기
				int row_cnt_per_page = menu_searchDTO.getRow_cnt_per_page();
				// 검색할 시작행 번호 구하기
				int begin_row_no = select_page_no*row_cnt_per_page-row_cnt_per_page+1;
				// 만약 검색한 총 개수가 검색할 시작행 번호보다 작으면
				// 선택한 페이지 번호를 1로 초기화하기
				if(menu_list_all_cnt < begin_row_no) {
					menu_searchDTO.setSelect_page_no(1);
				}
			}

			List<MenuDTO> menu_list = this.menuService.getMenuList(menu_searchDTO);
			mav.addObject("menu_list", menu_list);
			mav.addObject("menu_list_all_cnt", menu_list_all_cnt);
			mav.addObject("menu_searchDTO", menu_searchDTO);
			
			CodeMenuDTO codemenuDTO = new CodeMenuDTO();
			codemenuDTO.setMa_nameList(this.menuService.getCodeMenuAlpha());
			codemenuDTO.setMb_nameList(this.menuService.getCodeMenuBeta());
			mav.addObject("codemenuDTO", codemenuDTO);
			
			code_ingredientDTO.setIa_nameList(this.menuService.getCodeIngAlpha());
			code_ingredientDTO.setIb_nameList(this.menuService.getCodeIngBeta());
			mav.addObject("code_ingredientDTO",code_ingredientDTO);
			
			IngredientListDTO ingredient_listDTO = new IngredientListDTO();
			ingredient_listDTO.setI_nameList(this.menuService.getIngredientList(code_ingredientDTO));
			ingredient_listDTO.setI_nameList1(this.menuService.getIngredientList1(code_ingredientDTO));
			ingredient_listDTO.setI_nameList2(this.menuService.getIngredientList2(code_ingredientDTO));
			ingredient_listDTO.setI_nameList3(this.menuService.getIngredientList3(code_ingredientDTO));
			ingredient_listDTO.setI_nameList4(this.menuService.getIngredientList4(code_ingredientDTO));
			ingredient_listDTO.setI_nameList5(this.menuService.getIngredientList5(code_ingredientDTO));
			ingredient_listDTO.setI_nameList6(this.menuService.getIngredientList6(code_ingredientDTO));

			mav.setViewName(path + "menu_form");
			mav.addObject("ingredient_listDTO", ingredient_listDTO);
		} catch (Exception e) {
			System.out.println("<goMenuForm 에러발생>");
			System.out.println(e.getMessage());
		}

		return mav;
	}

	/**
	 * 가게 메뉴 추가 기능을 처리할 메소드
	 * 가상주소 /menu_insert.ida로 접근하면 호출
	 * @param menuDTO : 메뉴 DTO
	 * @return insert_result : 메뉴 추가 Query 실행 결과
	 */
	@RequestMapping(value="/menu_insert.ida"
					, method=RequestMethod.POST	
					, produces="application/json;charset=UTF-8")
	@ResponseBody
	public int insertStoreMenu(
			MenuDTO menuDTO) {
		int insert_result = -1;
		
		try {
			insert_result = this.menuService.insertStoreMenu(menuDTO);
		} catch(Exception e) {
			System.out.println("<insertStoreMenu 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return insert_result;
	}

	/**
	 * 메뉴 수정 화면을 보여줄 jsp와 메뉴 정보를 보여주는 메소드
	 * 가상주소 /menu_update_form.ida로 접근하면 호출
	 * @param menu_searchDTO : 메뉴 검색 DTO
	 * @param session : HttpSession 객체
	 * @param mi_no : 메뉴 번호
	 * @return mav : /menu_update_form.ida에 맵핑되는 jsp 파일과 메뉴 정보 목록
	 */
	@RequestMapping(value = "/menu_update_form.ida")
	public ModelAndView goMenuUpdateForm(
			MenuSearchDTO menu_searchDTO
			,HttpSession session
			,@RequestParam(value="mi_no") String mi_no) {
		ModelAndView mav = new ModelAndView();
		
		try {
			String s_id = (String)session.getAttribute("s_id");
			menu_searchDTO.setS_id(s_id);
			menu_searchDTO.setMi_no(mi_no);
			
			MenuDTO menuDTO = this.menuService.getMenuDTO(menu_searchDTO);
			mav.addObject("menuDTO", menuDTO);
			mav.addObject("menu_searchDTO", menu_searchDTO);
			
			CodeMenuDTO codemenuDTO = new CodeMenuDTO();
			codemenuDTO.setMa_nameList(this.menuService.getCodeMenuAlpha());
			codemenuDTO.setMb_nameList(this.menuService.getCodeMenuBeta());
			
			mav.setViewName(path + "menu_update_form");
			mav.addObject("codemenuDTO", codemenuDTO); 
		} catch (Exception e) { // try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goMenuUpdateForm 에러발생>");
			System.out.println(e.getMessage());
		}

		return mav;
	}

	/**
	 * 가게 메뉴 수정 기능을 처리할 메소드
	 * 가상주소 /menu_update.ida로 접근하면 호출
	 * @param menuDTO : 메뉴 DTO
	 * @return update_result : 메뉴 수정 Query 실행 결과
	 */
	@RequestMapping(value="/menu_update.ida"
					, method=RequestMethod.POST	
					, produces="application/json;charset=UTF-8")
	@ResponseBody
	public int updateStoreMenu(
			MenuDTO menuDTO) {
		int update_result = -1;

		try {
			 update_result = this.menuService.updateStoreMenu(menuDTO); 
			
		} catch(Exception e) {
			System.out.println("<updateStoreMenu 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return update_result;
	}

	/**
	 * 메뉴 삭제 화면을 보여줄 jsp와 메뉴 정보를 보여주는 메소드
	 * 가상주소 /menu_delete_form.ida로 접근하면 호출
	 * @param session : HttpSession 객체
	 * @param menu_searchDTO : 메뉴 검색 DTO
	 * @return mav : /menu_delete_form.ida에 맵핑되는 jsp 파일과 메뉴 정보 목록
	 */
	@RequestMapping(value = "/menu_delete_form.ida")
	public ModelAndView goMenuDeleteForm(
			HttpSession session
			, MenuSearchDTO menu_searchDTO) {
		ModelAndView mav = new ModelAndView();

		try {
			String s_id = (String)session.getAttribute("s_id");
			menu_searchDTO.setS_id(s_id);
			
			List<MenuDTO> menu_list = this.menuService.getMenuList(menu_searchDTO);
			mav.addObject("menu_list", menu_list);
			mav.addObject("menu_searchDTO", menu_searchDTO);
			
			mav.setViewName(path + "menu_delete_form");
		} catch (Exception e) {
			System.out.println("<goMenuDeleteForm 에러발생>");
			System.out.println(e.getMessage());
		}

		return mav;
	}
	
	/**
	 * 가게 메뉴 삭제 기능을 처리할 메소드
	 * 가상주소 /menu_delete.ida로 접근하면 호출
	 * @param menu_delete : 메뉴 삭제할 메뉴 번호들
	 * @return delete_result : 메뉴 삭제 Query 실행 결과
	 */
	@RequestMapping(value="/menu_delete.ida")
	@ResponseBody
	public int deleteStoreMenu(
			@RequestParam(value="trArr") ArrayList<String> menu_delete) {
		int delete_result = -1;

		try {
			delete_result = this.menuService.deleteStoreMenu(menu_delete);
		} catch(Exception e) {
			System.out.println("<deleteStoreMenu 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return delete_result;
	}
	
	/**
	 * 메뉴 분석 - 표 화면을 보여줄 jsp와 가게에 등록된 메뉴를 검색 조건에 따라 보여주는 메소드
	 * 가상주소 /menu_analysis_form.ida로 접근하면 호출
	 * @param session : HttpSession 객체
	 * @param menu_searchDTO : 메뉴 검색 DTO
	 * @return mav : /menu_analysis_form.ida에 맵핑되는 jsp 파일과 검색 조건에 맞는 가게 메뉴 리스트
	 */
	@RequestMapping(value="/menu_analysis_form.ida")
	public ModelAndView goMenuAnalysisForm(
		HttpSession session
		, MenuSearchDTO menu_searchDTO) {
		ModelAndView mav = new ModelAndView();
		 
		try {
			String s_id =(String)session.getAttribute("s_id");
			menu_searchDTO.setS_id(s_id);
			
			List<MenuDTO> menu_list = this.menuService.getMenuList(menu_searchDTO);
			mav.addObject("menu_searchDTO",menu_searchDTO);
			mav.addObject("menu_list", menu_list);
			
			mav.setViewName(path + "menu_analysis_form");
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goMenuAnalysisForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	/**
	 * 메뉴 분석 - 차트 화면을 보여줄 jsp와 가게에 등록된 메뉴를 검색 조건에 따라 차트로 보여주는 메소드
	 * 가상주소 /menu_analysis_chart_form.ida로 접근하면 호출
	 * @return mav : /menu_analysis_chart_form.ida에 맵핑되는 jsp 파일과 검색 조건에 맞는 가게 메뉴 차트
	 */
	@RequestMapping(value="/menu_analysis_chart_form.ida")
	public ModelAndView goMenuAnalysisChartForm() {
		ModelAndView mav = new ModelAndView();
		 
		try {
			mav.setViewName(path + "menu_analysis_chart_form");
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goMenuAnalysisChartForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	/**
	 * 메뉴 차트 데이터를 가져올 메소드
	 * 가상주소 /menu_analysis_chart.ida로 접근하면 호출
	 * @param session : HttpSession 객체
	 * @param chart_search : 검색 종류
	 * @return chart_data : 차트 데이터
	 */
	@RequestMapping(value="/menu_analysis_chart.ida")
	@ResponseBody
	public ChartDTO getMenuChartData(
			HttpSession session
			, @RequestParam(value="chart_search") String chart_search) {
		ChartDTO chart_data = new ChartDTO();	// 데이터베이스에 Query 실행 후 결과를 저장

		try {
			String s_id = (String)session.getAttribute("s_id");
			
			if(chart_search.equals("코스트")) {
				List<Map<String,String>> cost_chart = this.menuService.getMenuCostData(s_id);
				List<String> label = new ArrayList<String>();
				
				for(int i=0; i<cost_chart.size(); i++) {
					label.add(cost_chart.get(i).get("label"));
				}
				
				List<String> data1 = new ArrayList<String>();
				
				for(int i=0; i<cost_chart.size(); i++) {
						data1.add(cost_chart.get(i).get("data"));
				}
				
				chart_data.setLabel(label);
				chart_data.setData1(data1);
			}
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<getMenuChartData 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return chart_data;
	}
}