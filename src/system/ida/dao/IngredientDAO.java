/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dao;

import java.util.List;
import java.util.Map;

import system.ida.dto.Code_IngredientAllergieDTO;
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
	List<IngredientDTO> getIngredientList(IngredientSearchDTO ingredient_SearchDTO);	//식자재 목록 리스트
	int insertIngredient(IngredientDTO ingredientDTO);									//식자재 추가
	int updateIngredient(Map<String, String> trData);									//식자재 수정
	int deleteIngredient(Map<String,String> trData);									//식자재 삭제
	int insertIngRecord(IngredientDTO ingredientDTO);							// 식자재 추가 기록 
	int updateIngRecord(Map<String, String> trData);							// 식자재 수정 기록
	List<Code_IngredientAlphaDTO> getCodeIngAlpha();									//식자재 대분류
	List<Code_IngredientBetaDTO> getCodeIngBeta();										//식자재 소분류
	List<Code_IngredientOriginDTO> getCodeIngOrigin();									//식자재 원산지
	List<Code_IngredientAllergieDTO> getCodeIngAllergie();								//식자재 알레르기
	List<Map<String,String>> getWeekData(String s_id);

	List<IngredientDTO> getIngAnlList(
			IngredientSearchDTO ingredient_SearchDTO);/*
														 * List<Map<String,String>> getMonthData(String s_id);
														 */
}