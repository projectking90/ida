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

import system.ida.dao.IngredientDAO;
import system.ida.dto.Code_IngredientAlphaDTO;
import system.ida.dto.Code_IngredientBetaDTO;
import system.ida.dto.Code_IngredientOriginDTO;
import system.ida.dto.IngredientDTO;
import system.ida.dto.IngredientSearchDTO;

/**
 * IngredientServiceImpl 클래스 서비스 클래스
 * 
 * @author Jo
 */
@Service
@Transactional
public class IngredientServiceImpl implements IngredientService {
	/**
	 * 속성변수 선언
	 */
	@Autowired
	private IngredientDAO ingredientDAO; // IngredientDAO 인터페이스를 구현받은 객체를 생성해서 저장

	/**
	 * 메소드 선언
	 */
	@Override
	public List<IngredientDTO> getIngredientList(IngredientSearchDTO ingredient_SearchDTO) {
		List<IngredientDTO> ingredient_list = this.ingredientDAO.getIngredientList(ingredient_SearchDTO);
		return ingredient_list;
	}

	/**
	 * 식자재 대분류
	 */
	@Override
	public List<Code_IngredientAlphaDTO> getCodeIngAlpha() {
		List<Code_IngredientAlphaDTO> ia_nameList = this.ingredientDAO.getCodeIngAlpha();
		return ia_nameList;
	}

	/**
	 * 식자재 소분류
	 */
	@Override
	public List<Code_IngredientBetaDTO> getCodeIngBeta() {
		List<Code_IngredientBetaDTO> ib_nameList = this.ingredientDAO.getCodeIngBeta();
		return ib_nameList;
	}

	/**
	 * 식자재 원산지
	 */
	@Override
	public List<Code_IngredientOriginDTO> getCodeIngOrigin() {
		List<Code_IngredientOriginDTO> io_nameList = this.ingredientDAO.getCodeIngOrigin();
		return io_nameList;
	}

	/**
	 * 식자재 수정
	 */
	@Override
	public int updateIngredient(ArrayList<String> ingredient_update) {

		Map<String, String> trData = new HashMap<String, String>();
		int ingredient_update_cnt = 0;

		for (int i = 0; i < ingredient_update.size(); i++) {
			if (i % 6 == 0) {
				trData.put("i_no", ingredient_update.get(i));
			} else if (i % 6 == 1) {
				trData.put("ia_name", ingredient_update.get(i));
			} else if (i % 6 == 2) {
				trData.put("ib_name", ingredient_update.get(i));
			} else if (i % 6 == 3) {
				trData.put("io_name", ingredient_update.get(i));
			} else if (i % 6 == 4) {
				trData.put("i_name", ingredient_update.get(i));
			} else if (i % 6 == 5) {
				trData.put("i_size", ingredient_update.get(i));
				ingredient_update_cnt += this.ingredientDAO.updateIngredient(trData);
				// System.out.println("stock_update_cnt : "+stock_update_cnt);
			}
		}

		return ingredient_update_cnt;
	}

	/**
	 * 식자재 삭제
	 */
	@Override
	public int deleteIngredient(ArrayList<String> ingredient_delete) {
		Map<String, String> trData = new HashMap<String, String>();
		int delete_result = 0;
		for (int i = 0; i < ingredient_delete.size(); i++) {
			trData.put("i_no", ingredient_delete.get(i));
			delete_result += this.ingredientDAO.deleteIngredient(trData);
		}
		return delete_result;
	}

	/**
	 * 식자재 추가
	 */
	@Override
	public int insertIngredient(IngredientDTO ingredientDTO) {
		int insert_result = this.ingredientDAO.insertIngredient(ingredientDTO);
		return insert_result;
	}
}