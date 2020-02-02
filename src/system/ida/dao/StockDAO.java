/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dao;

import java.util.List;
import java.util.Map;

import system.ida.dto.ChartSearchDTO;
import system.ida.dto.IngredientDTO;
import system.ida.dto.StockDTO;
import system.ida.dto.StockSearchDTO;

/**
 * StockDAO 인터페이스
 * DAO 클래스를 사용하기 위해 정의한 인터페이스
 * @author Jo
 */
public interface StockDAO {
	/**
	 * 속성변수 선언
	 */
	String sqlSessionPath = "system.ida.dao.StockDAO.";	// mapper의 namespace

	/**
	 * 메소드 선언
	 */
	List<StockDTO> getStockList(StockSearchDTO stock_searchDTO);	// 전체 재고 목록을 가져옴
	List<IngredientDTO> getIngredientList(StockSearchDTO stock_searchDTO);	// 식자재 대분류 목록을 가져옴
	int insertStock(StockDTO stockDTO);	// 재고 추가 처리함
	int updateStock(StockDTO stockDTO);	// 재고 수정 처리함
	int deleteStock(Map<String, String> trData);	// 재고 삭제 처리함
	int getInsertedStockCnt(StockDTO stockDTO);	// 등록된 재고 개수를 가져옴
	int getInsertedStockIsDelCnt(StockDTO stockDTO);	// 등록되었지만 삭제된 재고 개수를 가져옴
	int getInsertedStockIsDelUp(StockDTO stockDTO);	// 등록되었지만 삭제된 재고를 추가할 때 is_del을 'F'로 처리함
	int deleteStockRecord(Map<String, String> trData);	// 재고 기록에 삭제 기록 처리함
	int insertStockRecord(StockDTO stockDTO);	// 재고 기록에 추가 기록 처리함
	int getInsertedStockQuantityCnt(StockDTO stockDTO);	// 추가된 재고의 수량 가져옴
	int updateStockRecord(StockDTO stockDTO);	// 재고 수량이 수정될 때 재고 기록에  차이 만큼값을 기록 처리함
	List<StockDTO> getStockAnlList(StockSearchDTO stock_searchDTO);	// 차트 재고 테이블 목록 가져옴
	List<Map<String, String>> getWeekStockData(ChartSearchDTO chart_searchDTO);	// 주별 재고 차트 데이터 가져옴
	List<Map<String, String>> getMonthStockData(ChartSearchDTO chart_searchDTO);	// 월별 재고 차트 데이터 가져옴
	List<Map<String, String>> getAllQuarterStockData();	// 모든 분기 재고 차트 데이터 가져옴
	List<Map<String, String>> getQuarterStockData(ChartSearchDTO chart_searchDTO);	// 분기별 재고 차트 데이터 가져옴
	StockDTO getStockDTO(int st_no);	// 재고 정보 가져옴
}