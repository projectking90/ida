/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import system.ida.dto.CodeMenuAlphaDTO;
import system.ida.dto.CodeMenuBetaDTO;
import system.ida.dto.Code_IngredientAlphaDTO;
import system.ida.dto.Code_IngredientBetaDTO;
import system.ida.dto.Code_ingredientDTO;
import system.ida.dto.IngredientDTO;
import system.ida.dto.MenuDTO;
import system.ida.dto.MenuSearchDTO;

/**
 * MenuDAOImpl 클래스
 * DAO 클래스, bean 태그로 자동 등록됨
 * @author Jo
 */
@Repository
public class MenuDAOImpl implements MenuDAO {
	/**
	 * 속성변수 선언
	 */
	@Autowired
	private SqlSessionTemplate sqlSession;	// SqlSessionTemplate 객체를 생성하고 저장
	
	/**
	 * 메소드 선언
	 */
	/**
	 * 가게에 등록된 메뉴를 가져옴
	 * @param menu_searchDTO : 메뉴 검색 DTO
	 * @return menu_list : 메뉴 리스트
	 */
	@Override
	public List<MenuDTO> getMenuList(MenuSearchDTO menu_searchDTO) {
		List<MenuDTO> menu_list = this.sqlSession.selectList(
				sqlSessionPath + "getMenuList"
				, menu_searchDTO);
		
		return menu_list;
	}

	/**
	 * 가게 메뉴 정보를 가져옴
	 * @param menu_searchDTO : 메뉴 검색 DTO
	 * @return menuDTO : 메뉴 정보
	 */
	@Override
	public MenuDTO getMenuDTO(MenuSearchDTO menu_searchDTO) {
		MenuDTO menuDTO = this.sqlSession.selectOne(
				sqlSessionPath + "getMenuDTO"
				, menu_searchDTO);

		return menuDTO;
	}
	
	/**
	 * 가게에 등록된 메뉴 총 개수를 가져옴
	 * @param menu_searchDTO : 메뉴 검색을 위해 사용하는 DTO
	 * @return menu_list_all_cnt : 메뉴의 총 개수
	 */
	@Override
	public int getMenuListAllCnt(MenuSearchDTO menu_searchDTO) {
		int menu_list_all_cnt = this.sqlSession.selectOne(
				sqlSessionPath + "getMenuListAllCnt"
				, menu_searchDTO);
		
		return menu_list_all_cnt;
	}
	
	/**
	 * 가게 메뉴 추가 처리
	 * @param menuDTO : 메뉴 DTO
	 * @return insert_result : 메뉴 추가 Query 결과
	 */
	@Override
	public int insertStoreMenu(MenuDTO menuDTO) {
		int insert_result = this.sqlSession.insert(
				sqlSessionPath + "insertStoreMenu"
				, menuDTO);
		
		return insert_result;
	}
	
	/**
	 * 메뉴 식자재 추가 처리
	 * @param menuDTO : 메뉴 DTO
	 * @return menu_ingredient_insert : 식자재 추가 Query 결과
	 */
	@Override
	public int insertMenuIngredient(MenuDTO menuDTO) {
		int menu_ingredient_insert = this.sqlSession.insert(
				sqlSessionPath + "insertMenuIngredient"
				, menuDTO);
		
		return menu_ingredient_insert;
	}

	/**
	 * 메뉴 대분류의 이름을 가져옴
	 * @return ma_nameList : 메뉴 대분류 이름 리스트
	 */
	@Override
	public List<CodeMenuAlphaDTO> getCodeMenuAlpha(){
		List<CodeMenuAlphaDTO> ma_nameList = this.sqlSession.selectList(
				sqlSessionPath + "getCodeMenuAlpha");
		
		return ma_nameList;
	}
	
	/**
	 * 메뉴 소분류의 이름을 가져옴
	 * @return mb_nameList : 메뉴 소분류 이름 리스트
	 */
	@Override
	public List<CodeMenuBetaDTO> getCodeMenuBeta(){
		List<CodeMenuBetaDTO> mb_nameList = this.sqlSession.selectList(
				sqlSessionPath + "getCodeMenuBeta");
		
		return mb_nameList;
	}
	
	/**
	 * 식자재 대분류 첫번째 식자재들을 가져옴
	 * @param code_ingredientDTO : 식자재 대분류 DTO
	 * @return i_nameList1 : 식자재 대분류 첫번째 식자재 리스트
	 */
	@Override
	public List<IngredientDTO> getIngredientList1(Code_ingredientDTO code_ingredientDTO){
		List<IngredientDTO> i_nameList1 = this.sqlSession.selectList(
				sqlSessionPath + "getIngredientList1"
				, code_ingredientDTO);
		
		return i_nameList1;
	}
	
	/**
	 * 식자재 대분류 두번째 식자재들을 가져옴
	 * @param code_ingredientDTO : 식자재 대분류 DTO
	 * @return i_nameList1 : 식자재 대분류 두번째 식자재 리스트
	 */
	@Override
	public List<IngredientDTO> getIngredientList2(Code_ingredientDTO code_ingredientDTO){
		List<IngredientDTO> i_nameList2 = this.sqlSession.selectList(
				sqlSessionPath + "getIngredientList2"
				, code_ingredientDTO);
		
		return i_nameList2;
	}
	
	/**
	 * 식자재 대분류 세번째 식자재들을 가져옴
	 * @param code_ingredientDTO : 식자재 대분류 DTO
	 * @return i_nameList1 : 식자재 대분류 세번째 식자재 리스트
	 */
	@Override
	public List<IngredientDTO> getIngredientList3(Code_ingredientDTO code_ingredientDTO){
		List<IngredientDTO> i_nameList3 = this.sqlSession.selectList(
				sqlSessionPath + "getIngredientList3"
				, code_ingredientDTO);
		
		return i_nameList3;
	}
	
	/**
	 * 식자재 대분류 네번째 식자재들을 가져옴
	 * @param code_ingredientDTO : 식자재 대분류 DTO
	 * @return i_nameList1 : 식자재 대분류 네번째 식자재 리스트
	 */
	@Override
	public List<IngredientDTO> getIngredientList4(Code_ingredientDTO code_ingredientDTO){
		List<IngredientDTO> i_nameList4 = this.sqlSession.selectList(
				sqlSessionPath + "getIngredientList4"
				, code_ingredientDTO);
		
		return i_nameList4;
	}
	
	/**
	 * 식자재 대분류 다섯번째 식자재들을 가져옴
	 * @param code_ingredientDTO : 식자재 대분류 DTO
	 * @return i_nameList1 : 식자재 대분류 다섯번째 식자재 리스트
	 */
	@Override
	public List<IngredientDTO> getIngredientList5(Code_ingredientDTO code_ingredientDTO){
		List<IngredientDTO> i_nameList5 = this.sqlSession.selectList(
				sqlSessionPath + "getIngredientList5"
				, code_ingredientDTO);
		
		return i_nameList5;
	}
	
	/**
	 * 식자재 대분류 여섯번째 식자재들을 가져옴
	 * @param code_ingredientDTO : 식자재 대분류 DTO
	 * @return i_nameList1 : 식자재 대분류 여섯번째 식자재 리스트
	 */
	@Override
	public List<IngredientDTO> getIngredientList6(Code_ingredientDTO code_ingredientDTO){
		List<IngredientDTO> i_nameList6 = this.sqlSession.selectList(
				sqlSessionPath + "getIngredientList6"
				, code_ingredientDTO);
		
		return i_nameList6;
	}
	
	/**
	 * 식자재 목록을 가져옴
	 * @param code_ingredientDTO : 식자재 DTO
	 * @return i_nameList : 식자재 목록
	 */
	@Override
	public List<IngredientDTO> getIngredientList(Code_ingredientDTO code_ingredientDTO){
		List<IngredientDTO> i_nameList = this.sqlSession.selectList(
				sqlSessionPath + "getIngredientList"
				, code_ingredientDTO);
		
		return i_nameList;
	}
	
	/**
	 * 식자재 대분류의 이름을 가져옴
	 * @return ia_nameList : 식자재 대분류 이름 리스트
	 */
	@Override
	public List<Code_IngredientAlphaDTO> getCodeIngAlpha() {
		List<Code_IngredientAlphaDTO> ia_nameList = this.sqlSession.selectList(
				sqlSessionPath + "getCodeIngAlpha");
		
		return ia_nameList;
	}

	/**
	 * 식자재 소분류의 이름 가져옴
	 * @return ib_nameList : 식자재 소분류 이름 리스트
	 */
	@Override
	public List<Code_IngredientBetaDTO> getCodeIngBeta() {
		List<Code_IngredientBetaDTO> ib_nameList = this.sqlSession.selectList(
				sqlSessionPath + "getCodeIngBeta");
		
		return ib_nameList;
	}
	
	/**
	 * 가게 메뉴 수정 처리
	 * @param menuDTO : 메뉴 DTO
	 * @return update_result : 메뉴 수정 Query 결과
	 */
	@Override
	public int updateStoreMenu(MenuDTO menuDTO) {
		int update_result = this.sqlSession.update(
				sqlSessionPath + "updateStoreMenu"
				, menuDTO);
		
		return update_result;
	}
	
	/**
	 * 가게에 등록된 메뉴의 개수를 가져옴
	 * @param menuDTO : 메뉴 DTO
	 * @return menu_cnt : 메뉴 개수
	 */
	@Override
	public int getMenuCnt(MenuDTO menuDTO) {
		int menu_cnt = this.sqlSession.selectOne(
				sqlSessionPath + "getMenuCnt"
				, menuDTO);

		return menu_cnt;
	}
	
	/**
	 * 가게 메뉴 삭제 처리
	 * @param trData : 삭제할 메뉴 번호들
	 * @return delete_result : 메뉴 삭제 Query 결과
	 */
	@Override
	public int deleteStoreMenu(Map<String, String> trData) {
		int delete_result = this.sqlSession.update(
				sqlSessionPath + "deleteStoreMenu"
				, trData);
		
		return delete_result;
	}
	
	/**
	 * 메뉴 식자재 삭제 처리
	 * @param trData : 메뉴 식자재 번호들
	 * @return delete_cnt : 메뉴 식자재 삭제 Query 결과
	 */
	@Override
	public int deleteMenuIngredient(Map<String, String> trData) {
		int delete_cnt = this.sqlSession.delete(
				sqlSessionPath + "deleteMenuIngredient"
				, trData);
		
		return delete_cnt;
	}
	
	/**
	 * 메뉴의 코스트를 가져옴
	 * @param s_id : 사용자 아이디
	 * @return cost_chart : 메뉴 코스트 데이터
	 */
	public List<Map<String, String>> getMenuCostData(String s_id) {
		List<Map<String,String>> cost_chart = this.sqlSession.selectList(
				sqlSessionPath + "getMenuCostData"
				, s_id);
		
		return cost_chart;
	}
}