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
	//식자재 목록
	@Override
	public List<IngredientDTO> getIngredientList(IngredientSearchDTO ingredient_SearchDTO) {
		List<IngredientDTO> ingredient_list = this.sqlSession.selectList(
				sqlSessionPath+"getIngredientList"
				,ingredient_SearchDTO
		);
		return ingredient_list;
	}
	
	/*
	 * //등록된 식자재의 총 개수
	 * 
	 * @Override public int getIngredientListAllCnt(IngredientSearchDTO
	 * ingredientSearchDTO) { int ingredient_list_all_cnt =
	 * this.sqlSession.selectOne( sqlSessionPath+"getIngredientListAllCnt"
	 * ,ingredientSearchDTO ); return ingredient_list_all_cnt; }
	 */


	//식자재 대분류
	@Override
	public List<Code_IngredientAlphaDTO> getCodeIngAlpha() {
		List<Code_IngredientAlphaDTO> ia_nameList = this.sqlSession.selectList(
			sqlSessionPath+"getCodeIngAlpha"
		);
		return ia_nameList;
	}
	
	//식자재 소분류
	@Override
	public List<Code_IngredientBetaDTO> getCodeIngBeta() {
		List<Code_IngredientBetaDTO> ib_nameList = this.sqlSession.selectList(
			sqlSessionPath+"getCodeIngBeta"
		);
		return ib_nameList;
	}

	//식자재 원산지
	@Override
	public List<Code_IngredientOriginDTO> getCodeIngOrigin() {
		List<Code_IngredientOriginDTO> io_nameList = this.sqlSession.selectList(
				sqlSessionPath+"getCodeIngOrigin"
			);
			return io_nameList;
	}

	//식자재 알레르기
	@Override
	public List<Code_IngredientAllergieDTO> getCodeIngAllergie() {
		List<Code_IngredientAllergieDTO> a_nameList = this.sqlSession.selectList(
				sqlSessionPath+"getCodeIngAllergie"
		);
		return a_nameList;
	}

	//식자재 수정
	@Override
	public int updateIngredient(Map<String, String> trData) {
		int ingredient_update_cnt = this.sqlSession.update(
				sqlSessionPath+"updateIngredient"
				,trData
		);
		return ingredient_update_cnt;
	}

	//식자재 삭제
	@Override
	public int deleteIngredient(Map<String, String> trData) {
		int delete_result = 0;
		delete_result = this.sqlSession.update(
			sqlSessionPath+"deleteIngredient"
			,trData
		);
		return delete_result ;
	}

	//식자재 추가
	@Override
	public int insertIngredient(IngredientDTO ingredientDTO) {
		System.out.println(ingredientDTO);
		int insert_result = this.sqlSession.insert(
			sqlSessionPath+"insertIngredient"
			,ingredientDTO
		);
		return insert_result;
	}

	@Override
	public List<Map<String, String>> getWeekData(String s_id) {
		List<Map<String,String>> ing_week_chart = this.sqlSession.selectList(
			sqlSessionPath+"getWeekData"
			,s_id
		);
		return ing_week_chart;
	}

	@Override
	public List<IngredientDTO> getIngAnlList(IngredientSearchDTO ingredient_SearchDTO) {
		List<IngredientDTO> ingredient_anl_list = this.sqlSession.selectList(
				sqlSessionPath+"getIngAnlList"
				,ingredient_SearchDTO
		);
		return ingredient_anl_list;
	}
	/*
	 * @Override public List<Map<String, String>> getMonthData(String s_id) {
	 * List<Map<String,String>> ing_month_chart = this.sqlSession.selectList(
	 * sqlSessionPath+"getMonthData" ,s_id ); return ing_month_chart; }
	 */
	
	
	// ingredient_record에 추가한 것 기록하기
		
		@Override public int insertIngRecord(IngredientDTO ingredientDTO) { int
		ing_record_insert = this.sqlSession.insert( sqlSessionPath+"insertIngRecord"
		,ingredientDTO ); return ing_record_insert; }
		
		// ingredient_record에 수정한 것 기록하기
		
		@Override public int updateIngRecord(Map<String, String> trData) { int
		ing_record_update = this.sqlSession.insert( sqlSessionPath+"updateIngRecord"
		,trData ); return ing_record_update; }
		
		
	/*
	 * // 이미 등록되어 있는 식자재 총 개수
	 * 
	 * @Override public int getInsertedIngCnt(IngredientDTO ingredientDTO) { int
	 * inserted_ing_cnt = this.sqlSession.selectOne(
	 * sqlSessionPath+"getInsertedIngCnt" ,ingredientDTO ); return inserted_ing_cnt;
	 * }
	 * 
	 * 
	 * 
	 * 
	
	/*
	 * // 삭제된 식자재의 총 개수 구하기
	 * 
	 * @Override public int getDeleteIngIsDelCnt(IngredientDTO ingredientDTO) { int
	 * delete_ing_cnt = this.sqlSession.selectOne(
	 * sqlSessionPath+"getDeleteIngIsDelCnt" ,ingredientDTO ); return
	 * delete_ing_cnt; }
	 */


	
	/*
	 * // ingredient_record 에 삭제한 것 기록하기 ( 주의 insert임)
	 * 
	 * @Override public int deleteIngRecord(Map<String, String> trData) { int
	 * ing_record_delete = this.sqlSession.insert( sqlSessionPath+"deleteIngRecord"
	 * ,trData ); return ing_record_delete; }
	 */
}