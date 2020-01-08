/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dao;

import java.util.List;
import java.util.Map;

import system.ida.dto.Code_IngredientAlphaDTO;
import system.ida.dto.Code_IngredientBetaDTO;
import system.ida.dto.Code_IngredientOriginDTO;
import system.ida.dto.IngredientDTO;
import system.ida.dto.IngredientSearchDTO;

/**
 * IngredientDAO 인터페이스
 * DAO 클래스를 사용하기 위해 정의한 인터페이스
 * @author Jo
 */
public interface IngredientDAO {
	/**
	 * 속성변수 선언
	 */
	String sqlSessionPath = "system.ida.dao.IngredientDAO.";

	/**
	 * 메소드 선언
	 */
	List<IngredientDTO> getIngredientList(IngredientSearchDTO ingredient_SearchDTO);
	int insertIngredient(IngredientDTO ingredientDTO);
	int updateIngredient(Map<String, String> trData);
	List<Code_IngredientAlphaDTO> getCodeIngAlpha();
	List<Code_IngredientBetaDTO> getCodeIngBeta();
	List<Code_IngredientOriginDTO> getCodeIngOrigin();
	int deleteIngredient(Map<String,String> trData);
}