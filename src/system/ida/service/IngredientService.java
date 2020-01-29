/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import system.ida.dto.ChartSearchDTO;
import system.ida.dto.Code_IngredientAllergieDTO;
import system.ida.dto.Code_IngredientAlphaDTO;
import system.ida.dto.Code_IngredientBetaDTO;
import system.ida.dto.Code_IngredientOriginDTO;
import system.ida.dto.IngredientDTO;
import system.ida.dto.IngredientSearchDTO;

/**
 * IngredientService 인터페이스
 * 서비스 클래스를 사용하기 위해 정의한 인터페이스
 * @author Jo
 */
public interface IngredientService {
	/**
	 * 속성변수 선언
	 */

	/**
	 * 메소드 선언
	 */
	List<IngredientDTO> getIngredientList(IngredientSearchDTO ingredient_SearchDTO);	// 식자재리스트를 가져옴
	List<Code_IngredientAlphaDTO> getCodeIngAlpha();					//식자재 대분류를 가져오는 메소드
	List<Code_IngredientBetaDTO> getCodeIngBeta();						//식자재 소분류를 가져오는 메소드
	List<Code_IngredientOriginDTO> getCodeIngOrigin();					//식자재 원산지를 가져오는 메소드
	List<Code_IngredientAllergieDTO> getCodeIngAllergie();				//식자재 알레르기 가져오는 메소드
	int insertIngredient(IngredientDTO ingredientDTO);					//식자재 추가 메소드
	int updateIngredient(ArrayList<String> ingredient_update);			//식자재 수정 메소드
	int deleteIngredient(ArrayList<String> ingredient_delete);			//식자재 삭제 메소드

	List<IngredientDTO> getIngAnlList(IngredientSearchDTO ingredient_SearchDTO);
	List<Map<String,String>> getWeekIngredientData(ChartSearchDTO chart_searchDTO);
	List<Map<String,String>> getMonthIngredientData(ChartSearchDTO chart_searchDTO);
}