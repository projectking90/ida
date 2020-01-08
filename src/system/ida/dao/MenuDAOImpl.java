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
	 * @param menu_searchDTO : 메뉴 검색을 위해 사용하는 DTO
	 * @return menu_list : 검색된 메뉴 정보
	 */
	@Override
	public List<MenuDTO> getMenuList(MenuSearchDTO menu_searchDTO) {
		List<MenuDTO> menu_list = this.sqlSession.selectList(
				"system.ida.dao.MenuDAO.getMenuList"	// 실행할 SQL 구문의 위치 지정
				,menu_searchDTO				
				);
		
		return menu_list;
	}

	/**
	 * 가게에 등록된 메뉴 총 개수를 가져옴
	 * @param menu_searchDTO : 메뉴 검색을 위해 사용하는 DTO
	 * @return menu_list_all_cnt : 메뉴의 총 개수
	 */
	@Override
	public int getMenuListAllCnt(MenuSearchDTO menu_searchDTO) {
		int menu_list_all_cnt = this.sqlSession.selectOne(
				"system.ida.dao.MenuDAO.getMenuListAllCnt"
				, menu_searchDTO
				);
		
		return menu_list_all_cnt;	
	}
	
	/**
	 * 가게 메뉴 추가
	 * @param menuDTO : 메뉴 추가를 위해 사용하는 DTO
	 * @return insert_result : 메뉴 추가 적용 개수
	 */
	@Override
	public int insertStoreMenu(MenuDTO menuDTO) {
		int insert_result = sqlSession.insert(
				"system.ida.dao.MenuDAO.insertStoreMenu",
				menuDTO
				);
		
		return insert_result;
	}
	
	@Override
	public List<CodeMenuAlphaDTO> getCodeMenuAlpha(){
		List<CodeMenuAlphaDTO> ma_nameList = this.sqlSession.selectList(
				sqlSessionPath + "getCodeMenuAlpha"		
		);
		
		return ma_nameList;
	}
	
	@Override
	public List<CodeMenuBetaDTO> getCodeMenuBeta(){
		List<CodeMenuBetaDTO> mb_nameList = this.sqlSession.selectList(
				sqlSessionPath + "getCodeMenuBeta"		
		);
		
		return mb_nameList;
	}
	
	@Override
	public List<IngredientDTO> getIngredientList(String s_id){
		List<IngredientDTO> i_nameList = this.sqlSession.selectList(
				sqlSessionPath + "getIngredientList"
				,s_id
		);
		return i_nameList;
	}
	/**
	 * 가게 메뉴 수정
	 * @param menuDTO : 메뉴 추가를 위해 사용하는 DTO
	 * @return update_result : 메뉴 수정 적용 개수
	 */
	@Override
	public int updateStoreMenu(Map<String, String> trData) {
		int update_result = 0;
		update_result = this.sqlSession.update(
				sqlSessionPath + "updateStoreMenu"
				,trData
		);
		
		return update_result;
	}
	
	/**
	 * 가게 메뉴 삭제
	 * @param menuDTO : 메뉴 추가를 위해 사용하는 DTO
	 * @return delete_result : 메뉴 삭제 적용 개수
	 */
	@Override
	public int deleteStoreMenu(Map<String, String> trData) {
		int delete_result = 0;
		delete_result = this.sqlSession.update(
				sqlSessionPath + "deleteStoreMenu"
				,trData
				
		);
		
		return delete_result;
	}
	
	@Override
	public int insertMenuIngredient(MenuDTO menuDTO) {
		int menu_ingredient_insert = this.sqlSession.insert(
				"system.ida.dao.MenuDAO.insertMenuIngredient"
				,menuDTO
		);
		
		return menu_ingredient_insert;
	}

	/**
	 * 가게 메뉴 삭제 시 식자재도 삭제
	 * @param trData : 메뉴 번호
	 * @return deleteCnt : 식자재 삭제 행 개수
	 */
	@Override
	public int deleteMenuIngredient(Map<String, String> trData) {
		int deleteCnt = this.sqlSession.delete(
				sqlSessionPath + "deleteMenuIngredient"
				, trData);
		
		return deleteCnt;
	}
}