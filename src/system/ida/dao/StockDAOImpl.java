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
import system.ida.dto.IngredientDTO;
import system.ida.dto.StockDTO;
import system.ida.dto.StockSearchDTO;

/**
 * StockDAOImpl 클래스
 * DAO 클래스, bean 태그로 자동 등록됨
 * @author Jo
 */
@Repository
public class StockDAOImpl implements StockDAO {
	/**
	 * 속성변수 선언
	 */
	@Autowired
	private SqlSessionTemplate sqlSession;	// SqlSessionTemplate 객체를 생성하고 저장
	
	/**
	 * 메소드 선언
	 */
	/**
	 * 전체 재고 목록을 가져옴
	 * @param stock_searchDTO : 재고 검색 DTO
	 * @return stock_list : 재고 목록
	 */
	@Override
	public List<StockDTO> getStockList(StockSearchDTO stock_searchDTO){
		List<StockDTO> stock_list = this.sqlSession.selectList(
				sqlSessionPath + "getStockList"
				, stock_searchDTO);
		
		return stock_list;
	}

	/**
	 * 재고 추가 처리함
	 * @param stockDTO : 재고 DTO
	 * @return stock_reg_cnt : 재고 추가 Query 결과
	 */
	@Override
	public int insertStock(StockDTO stockDTO) {
		int stock_reg_cnt = this.sqlSession.insert(
				sqlSessionPath + "insertStock"
				, stockDTO);
		
		return stock_reg_cnt;
	}
	
	/**
	 * 식자재 대분류 목록을 가져옴
	 * @param stock_searchDTO : 재고 검색 DTO
	 * @return ingredient_list : 식자재 대분류 목록
	 */
	@Override
	public List<IngredientDTO> getIngredientList(StockSearchDTO stock_searchDTO){
		List<IngredientDTO> ingredient_list = this.sqlSession.selectList(
				sqlSessionPath + "getIngredientList"
				, stock_searchDTO);
		
		return ingredient_list;
	}

	/**
	 * 재고 수정 처리함
	 * @param stockDTO : 재고 DTO
	 * @return stock_update_cnt : 재고 수정 Query 결과
	 */
	@Override
	public int updateStock(StockDTO stockDTO) {
		int stock_update_cnt = this.sqlSession.update(
				sqlSessionPath + "updateStock"
				, stockDTO);
		
		return stock_update_cnt;
	}
	
	/**
	 * 재고 삭제 처리함
	 * @param trData : 재고 번호들
	 * @return stock_delete_cnt : 재고 삭제 Query 결과
	 */
	@Override
	public int deleteStock(Map<String, String> trData) {
		int stock_delete_cnt = this.sqlSession.update(
				sqlSessionPath + "deleteStock"
				, trData);
		
		return stock_delete_cnt;
	}
	
	/**
	 * 등록된 재고 개수를 가져옴
	 * @param stockDTO : 재고 DTO
	 * @return inserted_stock_cnt : 등록된 재고 개수
	 */
	@Override
	public int getInsertedStockCnt(StockDTO stockDTO) {
		int inserted_stock_cnt = this.sqlSession.selectOne(
				sqlSessionPath + "getInsertedStockCnt"
				, stockDTO);
		
		return inserted_stock_cnt;
	}

	/**
	 * 등록되었지만 삭제된 재고 개수를 가져옴
	 * @param stockDTO : 재고 DTO
	 * @return inserted_stock_cnt : 등록되었지만 삭제된 재고 개수
	 */
	@Override
	public int getInsertedStockIsDelCnt(StockDTO stockDTO) {
		int inserted_stock_cnt = this.sqlSession.selectOne(
				sqlSessionPath + "getInsertedStockIsDelCnt"
				, stockDTO);
		
		return inserted_stock_cnt;
	}

	/**
	 * 등록되었지만 삭제된 재고를 추가할 때 is_del을 'F'로 처리함
	 * @param stockDTO : 재고 DTO
	 * @return inserted_stock_is_del_up : 등록된 재고 추가시 수정 Query 결과
	 */
	@Override
	public int getInsertedStockIsDelUp(StockDTO stockDTO) {
		int inserted_stock_is_del_up = this.sqlSession.update(
				sqlSessionPath + "getInsertedStockIsDelUp"
				, stockDTO);
		
		return inserted_stock_is_del_up;
	}
	
	/**
	 * 재고 기록에 삭제 기록 처리함
	 * @param trData : 삭제하려는 재고 정보들
	 * @return stock_record_delete : 재고 기록에 삭제 기록 Query 결과
	 */
	@Override
	public int deleteStockRecord(Map<String, String> trData) {
		int stock_record_delete = this.sqlSession.insert(
				sqlSessionPath + "deleteStockRecord"
				, trData);
		
		return stock_record_delete;
	}

	/**
	 * 재고 기록에 추가 기록 처리함
	 * @param stockDTO : 재고 DTO
	 * @return stock_record_insert : 재고 기록에 추가 기록 Query 결과
	 */
	@Override
	public int insertStockRecord(StockDTO stockDTO) {
		int stock_record_insert = this.sqlSession.insert(
				sqlSessionPath + "insertStockRecord"
				, stockDTO);
		
		return stock_record_insert;
	}
	
	/**
	 * 추가된 재고의 수량 가져옴
	 * @param stockDTO : 재고 DTO
	 * @return stock_inserted_quantity_cnt : 추가된 재고의 수량
	 */
	@Override
	public int getInsertedStockQuantityCnt(StockDTO stockDTO) {
		int stock_inserted_quantity_cnt = this.sqlSession.selectOne(
				sqlSessionPath + "getInsertedStockQuantityCnt"
				, stockDTO);
		
		return stock_inserted_quantity_cnt;
	}
	
	/**
	 * 재고 수량이 수정될 때 재고 기록에  차이 만큼값을 기록 처리함
	 * @param stockDTO : 재고 DTO
	 * @return updated_stock_record : 재고 기록에  차이 기록 Query 결과
	 */
	@Override
	public int updateStockRecord(StockDTO stockDTO) {
		int updated_stock_record = this.sqlSession.insert(
				sqlSessionPath + "updateStockRecord"
				, stockDTO);
		
		return updated_stock_record;
	}

	/**
	 * 차트 재고 테이블 목록 가져옴
	 * @param stock_searchDTO : 재고 검색 DTO
	 * @return stock_anl_list : 차트 재고 테이블 목록
	 */
	@Override
	public List<StockDTO> getStockAnlList(StockSearchDTO stock_searchDTO) {
		List<StockDTO> stock_anl_list = this.sqlSession.selectList(
				sqlSessionPath + "getStockAnlList"
				, stock_searchDTO);
		
		return stock_anl_list;
	}

	/**
	 * 주별 재고 차트 데이터 가져옴
	 * @param chart_searchDTO : 차트 검색 DTO
	 * @return week_stock_chart : 주별 재고 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getWeekStockData(ChartSearchDTO chart_searchDTO) {
		List<Map<String,String>> week_stock_chart = this.sqlSession.selectList(
				sqlSessionPath + "getWeekStockData"
				, chart_searchDTO);
		
		return week_stock_chart;
	}

	/**
	 * 월별 재고 차트 데이터 가져옴
	 * @param chart_searchDTO : 차트 검색 DTO
	 * @return month_stock_chart : 월별 재고 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getMonthStockData(ChartSearchDTO chart_searchDTO) {
		List<Map<String,String>> month_stock_chart = this.sqlSession.selectList(
				sqlSessionPath + "getMonthStockData"
				, chart_searchDTO);
		
		return month_stock_chart;
	}

	/**
	 * 모든 분기 재고 차트 데이터 가져옴
	 * @return all_quarter_stock_chart : 모든 분기 재고 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getAllQuarterStockData() {
		List<Map<String,String>> all_quarter_stock_chart = this.sqlSession.selectList(
				sqlSessionPath + "getAllQuarterStockData");
		
		return all_quarter_stock_chart;
	}
	
	/**
	 * 시간별 재고 차트 데이터 가져옴
	 * @param chart_searchDTO : 차트 검색 DTO
	 * @return time_stock_chart : 시간별 재고 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getTimeStockData(ChartSearchDTO chart_searchDTO){
		List<Map<String,String>> time_stock_chart = this.sqlSession.selectList(
				sqlSessionPath + "getTimeStockData"
				, chart_searchDTO);

		return time_stock_chart;
	}

	/**
	 * 분기별 재고 차트 데이터 가져옴
	 * @param chart_searchDTO : 차트 검색 DTO
	 * @return quarter_stock_chart : 분기별 재고 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getQuarterStockData(ChartSearchDTO chart_searchDTO) {
		List<Map<String,String>> quarter_stock_chart = this.sqlSession.selectList(
				sqlSessionPath + "getQuarterStockData"
				, chart_searchDTO);
		
		return quarter_stock_chart;
	}

	/**
	 * 재고 정보 가져옴
	 * @param st_no : 재고 번호
	 * @return stockDTO : 재고 정보
	 */
	@Override
	public StockDTO getStockDTO(int st_no) {
		StockDTO stockDTO = this.sqlSession.selectOne(
				sqlSessionPath + "getStockDTO"
				, st_no);
		
		return stockDTO;
	}
}