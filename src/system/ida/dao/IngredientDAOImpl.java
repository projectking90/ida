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
	//식자재목록
	@Override
	public List<IngredientDTO> getIngredientList(IngredientSearchDTO ingredient_SearchDTO) {
		List<IngredientDTO> ingredient_list = this.sqlSession.selectList(
				sqlSessionPath+"getIngredientList"
				,ingredient_SearchDTO
		);

		return ingredient_list;
	}

	
	//대분류
	@Override
	public List<Code_IngredientAlphaDTO> getCodeIngAlpha() {
		List<Code_IngredientAlphaDTO> ia_nameList = this.sqlSession.selectList(
			sqlSessionPath+"getCodeIngAlpha"
		);
		return ia_nameList;
	}
	
	//소분류
	@Override
	public List<Code_IngredientBetaDTO> getCodeIngBeta() {
		List<Code_IngredientBetaDTO> ib_nameList = this.sqlSession.selectList(
			sqlSessionPath+"getCodeIngBeta"
		);
		return ib_nameList;
	}

	//원산지
	@Override
	public List<Code_IngredientOriginDTO> getCodeIngOrigin() {
		List<Code_IngredientOriginDTO> io_nameList = this.sqlSession.selectList(
				sqlSessionPath+"getCodeIngOrigin"
			);
			return io_nameList;
	}


	//수정
	@Override
	public int updateIngredient(Map<String, String> trData) {
		
		int ingredient_update_cnt = this.sqlSession.update(
				sqlSessionPath+"updateIngredient"
				,trData
		);
				
		return ingredient_update_cnt;
	}


	//삭제

	@Override
	public int deleteIngredient(Map<String, String> trData) {
		int delete_result = 0;
		delete_result = this.sqlSession.update(
			sqlSessionPath+"deleteIngredient"
			,trData
		);
		return delete_result ;
		
	}

	/**
	 * 식자재 추가
	 * @param IngredientDTO : 식자재 추가하기 위해 사용하는 DTO
	 * @return insert_result : 식자재 추가 적용 개수
	 */
	@Override
	public int insertIngredient(IngredientDTO ingredientDTO) {
		int insert_result = this.sqlSession.insert(
			sqlSessionPath+"insertIngredient"
			,ingredientDTO
		);
		return insert_result;
	}
}