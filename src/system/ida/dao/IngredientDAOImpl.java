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

import system.ida.dto.ChartSearchDTO;
import system.ida.dto.Code_IngredientAllergieDTO;
import system.ida.dto.Code_IngredientAlphaDTO;
import system.ida.dto.Code_IngredientBetaDTO;
import system.ida.dto.Code_IngredientOriginDTO;
import system.ida.dto.IngredientDTO;
import system.ida.dto.IngredientSearchDTO;

/**
 * IngredientDAOImpl 클래스
 * DAO 클래스, bean 태그로 자동 등록됨
 * @author Jo
 */
@Repository
public class IngredientDAOImpl implements IngredientDAO {
	/**
	 * 속성변수 선언
	 */
	@Autowired
	private SqlSessionTemplate sqlSession;	// SqlSessionTemplate 객체를 생성하고 저장

	/**
	 * 메소드 선언
	 */
	/**
	 * 식자재 목록 리스트 가져옴
	 * @param ingredient_SearchDTO : 식자재 검색 DTO
	 * @return ingredient_list : 식자재 리스트
	 */
	@Override
	public List<IngredientDTO> getIngredientList(IngredientSearchDTO ingredient_SearchDTO) {
		List<IngredientDTO> ingredient_list = this.sqlSession.selectList(
				sqlSessionPath + "getIngredientList"
				, ingredient_SearchDTO);
		
		return ingredient_list;
	}

	/**
	 * 식자재 대분류 이름 가져옴
	 * @return ia_nameList : 식자재 대분류 이름 리스트
	 */
	@Override
	public List<Code_IngredientAlphaDTO> getCodeIngAlpha() {
		List<Code_IngredientAlphaDTO> ia_nameList = this.sqlSession.selectList(
			sqlSessionPath + "getCodeIngAlpha");
		
		return ia_nameList;
	}
	
	/**
	 * 식자재 소분류 이름 가져옴
	 * @return ib_nameList : 식자재 소분류 이름 리스트
	 */
	@Override
	public List<Code_IngredientBetaDTO> getCodeIngBeta() {
		List<Code_IngredientBetaDTO> ib_nameList = this.sqlSession.selectList(
			sqlSessionPath + "getCodeIngBeta");
		
		return ib_nameList;
	}

	/**
	 * 식자재 원산지 이름 가져옴
	 * @return io_nameList : 식자재 원산지 이름 리스트
	 */
	@Override
	public List<Code_IngredientOriginDTO> getCodeIngOrigin() {
		List<Code_IngredientOriginDTO> io_nameList = this.sqlSession.selectList(
				sqlSessionPath + "getCodeIngOrigin");
		
		return io_nameList;
	}

	/**
	 * 식자재 알레르기 이름 가져옴
	 * @return a_nameList : 식자재 알레르기 이름 리스트
	 */
	@Override
	public List<Code_IngredientAllergieDTO> getCodeIngAllergie() {
		List<Code_IngredientAllergieDTO> a_nameList = this.sqlSession.selectList(
				sqlSessionPath + "getCodeIngAllergie");
		
		return a_nameList;
	}

	/**
	 * 식자재 수정 처리
	 * @param ingredientDTO : 식자재 DTO
	 * @return ingredient_update_cnt : 식자재 수정 Query 결과
	 */
	@Override
	public int updateIngredient(IngredientDTO ingredientDTO) {
		int ingredient_update_cnt = this.sqlSession.update(
				sqlSessionPath + "updateIngredient"
				, ingredientDTO);
		
		return ingredient_update_cnt;
	}

	/**
	 * 식자재 삭제 처리
	 * @param trData : 식자재 번호들
	 * @return delete_result : 식자재 삭제 Query 결과
	 */
	@Override
	public int deleteIngredient(Map<String, String> trData) {
		int delete_result = this.sqlSession.update(
				sqlSessionPath + "deleteIngredient"
				, trData);
		
		
		return delete_result ;
	}

	/**
	 * 식자재 추가 처리
	 * @param ingredientDTO : 식자재 DTO
	 * @return insert_result : 식자재 추가 Query 결과
	 */
	@Override
	public int insertIngredient(IngredientDTO ingredientDTO) {
		int insert_result = this.sqlSession.insert(
				sqlSessionPath + "insertIngredient"
				, ingredientDTO);
		
		return insert_result;
	}
	
	/**
	 * 분석 표에서 식자재 목록 리스트 가져옴
	 * @param ingredient_SearchDTO : 식자재 검색 DTO
	 * @return ingredient_anl_list : 식자재 리스트
	 */
	@Override
	public List<IngredientDTO> getIngAnlList(IngredientSearchDTO ingredient_SearchDTO) {
		List<IngredientDTO> ingredient_anl_list = this.sqlSession.selectList(
				sqlSessionPath + "getIngAnlList"
				, ingredient_SearchDTO);
		
		return ingredient_anl_list;
	}
	
	/**
	 * 식자재 총 개수를 가져옴
	 * @param ingredientDTO : 식자재 DTO
	 * @return inserted_ingredient_cnt : 식자재 총 개수
	 */
	@Override
	public int getInsertedIngredientCnt(IngredientDTO ingredientDTO) {
		int inserted_ingredient_cnt = this.sqlSession.selectOne(
				sqlSessionPath + "getInsertedIngredientCnt"
				, ingredientDTO);
		
		return inserted_ingredient_cnt;
	}

	/**
	 * 등록되었지만 삭제된 식자재 개수를 가져옴
	 * @param ingredientDTO : 식자재 DTO
	 * @return inserted_ingredient_cnt : 등록되었지만 삭제된 식자재 개수
	 */
	@Override
	public int getInsertedIngredientIsDelCnt(IngredientDTO ingredientDTO) {
		int inserted_ingredient_cnt = this.sqlSession.selectOne(
				sqlSessionPath + "getInsertedIngredientIsDelCnt"
				, ingredientDTO);
		
		return inserted_ingredient_cnt;
	}

	/**
	 * 등록되었지만 삭제된 식자재 추가할때 is_del을 'F'로 변경
	 * @param ingredientDTO : 식자재 DTO
	 * @return inserted_ingredient_is_del_up : 식자재 수정 Query 결과
	 */
	@Override
	public int getInsertedIngredientIsDelUp(IngredientDTO ingredientDTO) {
		int inserted_ingredient_is_del_up = this.sqlSession.update(
				sqlSessionPath + "getInsertedIngredientIsDelUp"
				, ingredientDTO);
		
		return inserted_ingredient_is_del_up;
	}

	/**
	 * 식자재 기록에 추가 처리
	 * @param ingredientDTO : 식자재 DTO
	 * @return ingredient_record_insert : 식자재 기록 추가 Query 결과
	 */
	@Override
	public int insertIngredientRecord(IngredientDTO ingredientDTO) {
		int ingredient_record_insert = this.sqlSession.insert(
				sqlSessionPath + "insertIngredientRecord"
				, ingredientDTO);
		
		return ingredient_record_insert;
	}

	/**
	 * 식자재 기록에 수정 처리
	 * @param ingredientDTO : 식자재 DTO
	 * @return updated_ingredient_record : 식자재 기록 수정 Query 결과
	 */
	@Override
	public int updateIngredientRecord(IngredientDTO ingredientDTO) {
		int updated_ingredient_record = this.sqlSession.insert(
				sqlSessionPath + "updateIngredientRecord"
				, ingredientDTO);
		
		return updated_ingredient_record;
	}

	/**
	 * 분석 차트에서 식자재 주 데이터 가져옴
	 * @param chart_searchDTO : 차트 검색 DTO
	 * @return week_ingredient_chart : 식자재 주 데이터
	 */
	@Override
	public List<Map<String, String>> getWeekIngredientData(ChartSearchDTO chart_searchDTO) {
		List<Map<String, String>> week_ingredient_chart = this.sqlSession.selectList(
				sqlSessionPath + "getWeekIngredientData"
				, chart_searchDTO);
		
		return week_ingredient_chart;
	}

	/**
	 * 분석 차트에서 식자재 월 데이터 가져옴
	 * @param chart_searchDTO : 차트 검색 DTO
	 * @return month_ingredient_chart : 식자재 월 데이터
	 */
	@Override
	public List<Map<String, String>> getMonthIngredientData(ChartSearchDTO chart_searchDTO) {
		List<Map<String,String>> month_ingredient_chart = this.sqlSession.selectList(
				sqlSessionPath + "getMonthIngredientData"
				, chart_searchDTO);
		
		return month_ingredient_chart;
	}

	/**
	 * 식자재 상세보기 가져옴
	 * @param i_no : 식자재 번호
	 * @return ingredientDTO : 식자재 정보
	 */
	@Override
	public IngredientDTO getIngedientDTO(int i_no) {
		IngredientDTO ingredientDTO = this.sqlSession.selectOne(
				sqlSessionPath + "getIngedientDTO"
				, i_no);
		
		return ingredientDTO;
	}

	/**
	 * 추가된 식자재의 가격 가져옴
	 * @param ingredientDTO : 식자재 DTO
	 * @return ingredient_price : 식자재 가격
	 */
	@Override
	public int getInsertedIngredientPriceCnt(IngredientDTO ingredientDTO) {
		int ingredient_price = this.sqlSession.selectOne(
				sqlSessionPath + "getInsertedIngredientPriceCnt"
				, ingredientDTO);
		
		return ingredient_price;
	}
}