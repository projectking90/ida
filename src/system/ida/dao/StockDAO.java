/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dao;

import java.util.List;
import java.util.Map;

import system.ida.dto.IngredientDTO;
import system.ida.dto.StockDTO;
import system.ida.dto.StockInsertDTO;

/**
 * StockDAO 인터페이스
 * DAO 클래스를 사용하기 위해 정의한 인터페이스
 * @author Jo
 */
public interface StockDAO {
	/**
	 * 속성변수 선언
	 */
	String sqlSessionPath = "system.ida.dao.StockDAO.";

	/**
	 * 메소드 선언
	 */
	List<StockDTO> getStockList();	// 전체 재고 목록 가져오기
	List<IngredientDTO> getIngredientList();	// 식자재 대분류 목록 가져오기
	int insertStock(StockDTO stockDTO);
	int updateStock(Map<String, String> trData);
	int deleteStock(Map<String, String> trData);
	int getInsertedStockCnt(StockDTO stockDTO);
	int getInsertedStockIsDelCnt(StockDTO stockDTO);	// 등록되었지만 삭제된 재고 개수 구하기
	int getInsertedStockIsDelUp(StockDTO stockDTO);	// 등록되었지만 삭제된 재고를 추가할 때 is_del을 'F'로 update하기
	int deleteStockRecord(Map<String, String> trData);	// stock_record에 delete한 것 넣기
	int insertStockRecord(StockDTO stockDTO);	// stock_record에 insert한 것 넣기
}