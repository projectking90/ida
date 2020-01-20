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
	public List<IngredientDTO> getIngredientList(String s_id){
		List<IngredientDTO> i_nameList = this.menuDAO.getIngredientList(s_id);
		return i_nameList;
	}

	/**
	 * 가게 메뉴 수정
	 * @param menuDTO : 메뉴 추가를 위해 사용하는 DTO
	 * @return update_result : 메뉴 수정 적용 개수
	 */
	@Override
	public int updateStoreMenu(ArrayList<String> menu_update) {
		Map<String, String> trData = new HashMap<String, String>();
		int update_result = 0;
		
		for(int i=0; i<menu_update.size(); i++) {
			if(i%7==0) {
				trData.put("mi_no", menu_update.get(i));
			}else if(i%7==1) {
				trData.put("ma_code", menu_update.get(i));
			}else if(i%7==2) {
				trData.put("mb_code", menu_update.get(i));
			}else if(i%7==3) {
				trData.put("mi_name", menu_update.get(i));
			}else if(i%7==4) {
				trData.put("price", menu_update.get(i));
			}else if(i%7==5) {
				trData.put("mi_comment", menu_update.get(i));
			}else if(i%7==6) {
				trData.put("s_id", menu_update.get(i));
				update_result += this.menuDAO.updateStoreMenu(trData);
				//System.out.println("stock_update_cnt : "+stock_update_cnt);
			}
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