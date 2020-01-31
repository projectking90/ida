/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dao;

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
	int updateIngredient(IngredientDTO ingredientDTO);									//식자재 수정
	int deleteIngredient(Map<String,String> trData);									//식자재 삭제
	int getInsertedIngredientCnt(IngredientDTO ingredientDTO);
	int getInsertedIngredientIsDelCnt(IngredientDTO ingredientDTO);		//등록되었지만 삭제된 식자재 개수 구하기
	int getInsertedIngredientIsDelUp(IngredientDTO ingredientDTO);		//등록되었지만 삭제된 식자재 추가할때 is_del을 'F'로 update하기
	int insertIngredientRecord(IngredientDTO ingredientDTO);			//ingredient_record에 insert 하기
	int updateIngredientRecord(IngredientDTO ingredientDTO);				//ingredient_record에 update 하기
	int getInsertedIngredientPriceCnt(IngredientDTO ingredientDTO);			//추가된 식자재의 가격 가져오기
	List<Code_IngredientAlphaDTO> getCodeIngAlpha();									//식자재 대분류
	List<Code_IngredientBetaDTO> getCodeIngBeta();										//식자재 소분류
	List<Code_IngredientOriginDTO> getCodeIngOrigin();									//식자재 원산지
	List<Code_IngredientAllergieDTO> getCodeIngAllergie();								//식자재 알레르기

	List<IngredientDTO> getIngAnlList(IngredientSearchDTO ingredient_SearchDTO);	//분석에서 식자재 목록 리스트 가져오기
	List<Map<String,String>> getWeekIngredientData(ChartSearchDTO chart_searchDTO);
	List<Map<String,String>> getMonthIngredientData(ChartSearchDTO chart_searchDTO);
	IngredientDTO getIngedientDTO(int i_no);	// 식자재 상세보기
}