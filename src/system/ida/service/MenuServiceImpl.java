/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import system.ida.dao.MenuDAO;
import system.ida.dto.CodeMenuAlphaDTO;
import system.ida.dto.CodeMenuBetaDTO;
import system.ida.dto.Code_IngredientAlphaDTO;
import system.ida.dto.Code_IngredientBetaDTO;
import system.ida.dto.Code_ingredientDTO;
import system.ida.dto.IngredientDTO;
import system.ida.dto.MenuDTO;
import system.ida.dto.MenuSearchDTO;

/**
 * MenuServiceImpl 클래스
 * 서비스 클래스
 * @author Jo
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {
	/**
	 * 속성변수 선언
	 */
	@Autowired
	private MenuDAO menuDAO;	// MenuDAO 인터페이스를 구현받은 객체를 생성해서 저장

	/**
	 * 메소드 선언
	 */
	/**
	 * 가게에 등록된 메뉴를 가져옴
	 * @param menu_searchDTO : 메뉴 검색을 위해 사용하는 DTO
	 * @return menu_list : 검색된 메뉴 정보
	 */
	@Override
	public List<MenuDTO> getMenuList(MenuSearchDTO menu_searchDTO) {
		List<MenuDTO> menu_list = this.menuDAO.getMenuList(menu_searchDTO);
		
		return menu_list;
	}
	
	@Override
	public MenuDTO getMenuDTO(MenuSearchDTO menu_searchDTO) {
		MenuDTO menuDTO = this.menuDAO.getMenuDTO(menu_searchDTO);

		return menuDTO;
	}
	
	/**
	 * 가게에 등록된 메뉴 총 개수를 가져옴
	 * @param menu_searchDTO : 메뉴 검색을 위해 사용하는 DTO
	 * @return menu_list_all_cnt : 메뉴 총 개수
	 */
	@Override
	public int getMenuListAllCnt(MenuSearchDTO menu_searchDTO) {
		int menu_list_all_cnt = this.menuDAO.getMenuListAllCnt(menu_searchDTO);

		return menu_list_all_cnt;
	}
	/**
	 * 가게 메뉴 추가
	 * @param menuDTO : 메뉴 추가를 위해 사용하는 DTO
	 * @return insert_result : 메뉴 추가 적용 개수
	 */
	@Override
	public int insertStoreMenu(MenuDTO menuDTO) {
		int insert_result = this.menuDAO.insertStoreMenu(menuDTO);
		
		this.menuDAO.insertMenuIngredient(menuDTO);
		
		return insert_result;
	}
	
	@Override
	public List<CodeMenuAlphaDTO> getCodeMenuAlpha(){
		List<CodeMenuAlphaDTO> ma_nameList = this.menuDAO.getCodeMenuAlpha();
		
		return ma_nameList;
	}

	@Override
	public List<CodeMenuBetaDTO> getCodeMenuBeta(){
		List<CodeMenuBetaDTO> mb_nameList = this.menuDAO.getCodeMenuBeta();
		return mb_nameList;
	}

	@Override
	public List<IngredientDTO> getIngredientList(Code_ingredientDTO code_ingredientDTO){
		
		List<IngredientDTO> i_nameList = this.menuDAO.getIngredientList(code_ingredientDTO);
		return i_nameList;
	}
	
	@Override
	public List<IngredientDTO> getIngredientList1(Code_ingredientDTO code_ingredientDTO){
		
		List<IngredientDTO> i_nameList1 = this.menuDAO.getIngredientList1(code_ingredientDTO);
		return i_nameList1;
	}
	@Override
	public List<IngredientDTO> getIngredientList2(Code_ingredientDTO code_ingredientDTO){
		
		List<IngredientDTO> i_nameList2 = this.menuDAO.getIngredientList2(code_ingredientDTO);
		return i_nameList2;
	}

	@Override
	public List<IngredientDTO> getIngredientList3(Code_ingredientDTO code_ingredientDTO){
		
		List<IngredientDTO> i_nameList3 = this.menuDAO.getIngredientList3(code_ingredientDTO);
		return i_nameList3;
	}

	@Override
	public List<IngredientDTO> getIngredientList4(Code_ingredientDTO code_ingredientDTO){
		
		List<IngredientDTO> i_nameList4 = this.menuDAO.getIngredientList4(code_ingredientDTO);
		return i_nameList4;
	}

	@Override
	public List<IngredientDTO> getIngredientList5(Code_ingredientDTO code_ingredientDTO){
		
		List<IngredientDTO> i_nameList5 = this.menuDAO.getIngredientList5(code_ingredientDTO);
		return i_nameList5;
	}

	@Override
	public List<IngredientDTO> getIngredientList6(Code_ingredientDTO code_ingredientDTO){
		
		List<IngredientDTO> i_nameList6 = this.menuDAO.getIngredientList6(code_ingredientDTO);
		return i_nameList6;
	}
	
	
	/**
	 * 식자재 대분류
	 */
	@Override
	public List<Code_IngredientAlphaDTO> getCodeIngAlpha() {
		List<Code_IngredientAlphaDTO> ia_nameList = this.menuDAO.getCodeIngAlpha();
		return ia_nameList;
	}

	/**
	 * 식자재 소분류
	 */
	@Override
	public List<Code_IngredientBetaDTO> getCodeIngBeta() {
		List<Code_IngredientBetaDTO> ib_nameList = this.menuDAO.getCodeIngBeta();
		return ib_nameList;
	}


	/**
	 * 가게 메뉴 수정
	 * @param menuDTO : 메뉴 추가를 위해 사용하는 DTO
	 * @return update_result : 메뉴 수정 적용 개수
	 */
	@Override
	public int updateStoreMenu(MenuDTO menuDTO) {
		Map<String, String> trData = new HashMap<String, String>();
		int update_result = 0;
		int menu_cnt = this.menuDAO.getMenuCnt(menuDTO);
		
		if(menu_cnt<=0) {
			return 2;
		}else {
			update_result = this.menuDAO.updateStoreMenu(menuDTO);
		}
		return update_result;
	}

	/**
	 * 가게 메뉴 삭제
	 * @param menuDTO : 메뉴 추가를 위해 사용하는 DTO
	 * @return delete_result : 메뉴 삭제 적용 개수
	 */
	@Override
	public int deleteStoreMenu(ArrayList<String> menu_delete) {
		Map<String, String> trData = new HashMap<String, String>();
		int delete_result=0;
		
		for(int i=0; i<menu_delete.size(); i++) {
			trData.put("mi_no", menu_delete.get(i));
			delete_result += this.menuDAO.deleteStoreMenu(trData);
			this.menuDAO.deleteMenuIngredient(trData);
		}
		
		return delete_result;
	}
	
	public List<Map<String, String>> getMenuCostData(String s_id) {
		List<Map<String,String>> cost_chart = this.menuDAO.getMenuCostData(s_id);
		
		return cost_chart;
	}
}