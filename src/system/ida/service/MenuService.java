/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import system.ida.dto.CodeMenuAlphaDTO;
import system.ida.dto.CodeMenuBetaDTO;
import system.ida.dto.Code_IngredientAlphaDTO;
import system.ida.dto.Code_IngredientBetaDTO;
import system.ida.dto.Code_ingredientDTO;
import system.ida.dto.IngredientDTO;
import system.ida.dto.MenuDTO;
import system.ida.dto.MenuSearchDTO;

/**
 * MenuService 인터페이스
 * 서비스 클래스를 사용하기 위해 정의한 인터페이스
 * @author Jo
 */
public interface MenuService {
	/**
	 * 속성변수 선언
	 */

	/**
	 * 메소드 선언
	 */
	List<MenuDTO> getMenuList(MenuSearchDTO menu_searchDTO);	// 가게에 등록된 메뉴를 가져옴
	int getMenuListAllCnt(MenuSearchDTO menu_searchDTO); // 가게에 등록된 메뉴 총 개수를 가져옴
	int insertStoreMenu(MenuDTO menuDTO);	// 가게 메뉴 추가
	List<CodeMenuAlphaDTO> getCodeMenuAlpha();	// 메뉴대분류의 목록을 가져오는 메소드
	List<CodeMenuBetaDTO> getCodeMenuBeta();	// 메뉴대분류의 목록을 가져오는 메소드
	List<IngredientDTO> getIngredientList(Code_ingredientDTO code_ingredientDTO);
	int updateStoreMenu(MenuDTO menuDTO);	// 가게 메뉴 수정
	int deleteStoreMenu(ArrayList<String> menu_delete);	// 가게 메뉴 삭제
	List<Map<String, String>> getMenuCostData(String s_id);
	List<Code_IngredientAlphaDTO> getCodeIngAlpha();
	List<Code_IngredientBetaDTO> getCodeIngBeta();
	
	List<IngredientDTO> getIngredientList1(Code_ingredientDTO code_ingredientDTO);
	List<IngredientDTO> getIngredientList2(Code_ingredientDTO code_ingredientDTO);
	List<IngredientDTO> getIngredientList3(Code_ingredientDTO code_ingredientDTO);
	List<IngredientDTO> getIngredientList4(Code_ingredientDTO code_ingredientDTO);
	List<IngredientDTO> getIngredientList5(Code_ingredientDTO code_ingredientDTO);
	List<IngredientDTO> getIngredientList6(Code_ingredientDTO code_ingredientDTO);
	MenuDTO getMenuDTO(MenuSearchDTO menu_searchDTO);
}