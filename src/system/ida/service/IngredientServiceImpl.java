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
import system.ida.dto.ChartSearchDTO;
import system.ida.dto.Code_IngredientAllergieDTO;
import system.ida.dto.Code_IngredientAlphaDTO;
import system.ida.dto.Code_IngredientBetaDTO;
import system.ida.dto.Code_IngredientOriginDTO;
import system.ida.dto.IngredientDTO;
import system.ida.dto.IngredientSearchDTO;

/**
 * IngredientServiceImpl 클래스
 * 서비스 클래스
 * @author Jo
 */
@Service
@Transactional
public class IngredientServiceImpl implements IngredientService {
	/**
	 * 속성변수 선언
	 */
	@Autowired
	private IngredientDAO ingredientDAO;	// IngredientDAO 인터페이스를 구현받은 객체를 생성해서 저장

	/**
	 * 메소드 선언
	 */
	/**
	 * 식자재 목록 리스트 가져옴
	 * @param ingredient_searchDTO : 식자재 검색 DTO
	 * @return ingredient_list : 식자재 목록
	 */
	@Override
	public List<IngredientDTO> getIngredientList(IngredientSearchDTO ingredient_searchDTO) {
		List<IngredientDTO> ingredient_list = this.ingredientDAO.getIngredientList(ingredient_searchDTO);
		
		return ingredient_list;
	}
	
	/**
	 * 식자재 대분류 이름 가져옴
	 * @return ia_nameList : 식자재 대분류 이름 목록
	 */
	@Override
	public List<Code_IngredientAlphaDTO> getCodeIngAlpha() {
		List<Code_IngredientAlphaDTO> ia_nameList = this.ingredientDAO.getCodeIngAlpha();
		
		return ia_nameList;
	}
	
	/**
	 * 식자재 소분류 이름 가져옴
	 * @return ib_nameList : 식자재 소분류 이름 목록
	 */
	@Override
	public List<Code_IngredientBetaDTO> getCodeIngBeta() {
		List<Code_IngredientBetaDTO> ib_nameList = this.ingredientDAO.getCodeIngBeta();
		
		return ib_nameList;
	}
	
	/**
	 * 식자재 원산지 이름 가져옴
	 * @return io_nameList : 식자재 원산지 이름 목록
	 */
	@Override
	public List<Code_IngredientOriginDTO> getCodeIngOrigin() {
		List<Code_IngredientOriginDTO> io_nameList = this.ingredientDAO.getCodeIngOrigin();
		
		return io_nameList;
	}
	
	/**
	 * 식자재 알레르기 이름 가져옴
	 * @return a_nameList : 식자재 알레르기 이름 목록
	 */
	@Override
	public List<Code_IngredientAllergieDTO> getCodeIngAllergie() {
		List<Code_IngredientAllergieDTO> a_nameList = this.ingredientDAO.getCodeIngAllergie();
		
		return a_nameList;
	}
	
	/**
	 * 식자재 수정 처리
	 * @param ingredientDTO : 식자재 DTO
	 * @return ingredient_update_cnt : 식자재 수정 Query 결과
	 */
	@Override
	public int updateIngredient(IngredientDTO ingredientDTO) {
		int ingredient_update_cnt = this.ingredientDAO.updateIngredient(ingredientDTO);
		
		return ingredient_update_cnt;
	}
	
	/**
	 * 식자재 기록 수정 처리
	 * @param ingredientDTO : 식자재 DTO
	 * @return ingredient_update_cnt : 식자재 기록 수정 Query 결과
	 */
	@Override
	public int updateIngredientRecord(IngredientDTO ingredientDTO) {
		int ingredient_update_cnt = this.ingredientDAO.updateIngredientRecord(ingredientDTO);
		
		return ingredient_update_cnt;
	}

	/**
	 * 식자재 알레르기 추가 처리
	 * @param ingredientDTO : 식자재 DTO
	 * @return ingredient_allergie_insert_cnt : 식자재 알레르기 추가 Query 결과
	 */
	@Override
	public int insertIngredientAllergie(IngredientDTO ingredientDTO) {
		int ingredient_allergie_insert_cnt = this.ingredientDAO.insertIngredientAllergie(ingredientDTO);
		
		return ingredient_allergie_insert_cnt;
	}

	/**
	 * 모든 분기 식자재 차트 데이터 가져옴
	 * @return all_quarter_ingredient_chart : 모든 분기 식자재 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getAllQuarterIngredientData() {
		List<Map<String, String>> all_quarter_ingredient_chart = this.ingredientDAO.getAllQuarterIngredientData();
		
		return all_quarter_ingredient_chart;
	}

	/**
	 * 분기별 식자재 차트 데이터 가져옴
	 * @param chart_searchDTO : 차트 검색 DTO
	 * @return quarter_ingredient_chart : 분기별 식자재 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getQuarterIngredientData(ChartSearchDTO chart_searchDTO) {
		List<Map<String, String>>  quarter_ingredient_chart = this.ingredientDAO.getQuarterIngredientData(chart_searchDTO);
		
		return quarter_ingredient_chart;
	}
	
	/**
	 * 식자재 삭제 처리
	 * @param ingredient_delete : 삭제할 식자재 번호들
	 * @return delete_result : 식자재 삭제 Query 결과
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
	 * 식자재 추가 처리
	 * @param ingredientDTO : 식자재 DTO
	 * @return inserted_ingredient_cnt : 식자재 추가 Query 결과
	 */
	@Override
	public int insertIngredient(IngredientDTO ingredientDTO) {
		int inserted_ingredient_cnt = this.ingredientDAO.getInsertedIngredientCnt(ingredientDTO);
		
		if(inserted_ingredient_cnt>0) {
			int ingredient_reg_cnt = this.ingredientDAO.insertIngredient(ingredientDTO);
			
			if(ingredient_reg_cnt>0) {
				int ingredient_record_insert = this.ingredientDAO.insertIngredientRecord(ingredientDTO);
				
				if(ingredient_record_insert>0) {
					return 1;
				}
			}
		}

		return inserted_ingredient_cnt;
	}

	/**
	 * 분석 표에서 식자재 목록 리스트 가져옴
	 * @param ingredient_SearchDTO : 식자재 검색 DTO
	 * @return ingredient_anl_list : 식자재 목록
	 */
	@Override
	public List<IngredientDTO> getIngAnlList(IngredientSearchDTO ingredient_SearchDTO) {
		List<IngredientDTO> ingredient_anl_list = this.ingredientDAO.getIngAnlList(ingredient_SearchDTO);
		
		return ingredient_anl_list;
	}
	
	/**
	 * 주별 식자재 차트 데이터 가져옴
	 * @param chart_searchDTO : 차트 검색 DTO
	 * @return week_ingredient_chart : 주별 식자재 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getWeekIngredientData(ChartSearchDTO chart_searchDTO) {
		List<Map<String, String>> week_ingredient_chart = this.ingredientDAO.getWeekIngredientData(chart_searchDTO);
		
		return week_ingredient_chart;
	}

	/**
	 * 월별 식자재 차트 데이터 가져옴
	 * @param chart_searchDTO : 차트 검색 DTO
	 * @return month_ingredient_chart : 월별 식자재 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getMonthIngredientData(ChartSearchDTO chart_searchDTO) {
		List<Map<String,String>> month_ingredient_chart = this.ingredientDAO.getMonthIngredientData(chart_searchDTO);
		
		return month_ingredient_chart;
	}

	/**
	 * 식자재 상세보기 가져옴
	 * @param i_no : 식자재 번호
	 * @return ingredientDTO : 식자재 정보
	 */
	@Override
	public IngredientDTO getIngredientDTO(int i_no) {
		IngredientDTO ingredientDTO = this.ingredientDAO.getIngedientDTO(i_no);
		
		return ingredientDTO;
	}
}