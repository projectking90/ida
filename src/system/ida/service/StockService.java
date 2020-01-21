/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.service;

import java.util.ArrayList;
import java.util.List;

import system.ida.dto.IngredientDTO;
import system.ida.dto.StockDTO;
import system.ida.dto.StockInsertDTO;
import system.ida.dto.StockSearchDTO;

/**
 * StockService 인터페이스
 * 서비스 클래스를 사용하기 위해 정의한 인터페이스
 * @author Jo
 */
public interface StockService {
	/**
	 * 속성변수 선언
	 */



	/**
	 * 메소드 선언
	 */
	List<StockDTO> getStockList(StockSearchDTO stock_searchDTO);	// 전체 재고 목록 가져오기
	List<IngredientDTO> getIngredientList(StockSearchDTO stock_searchDTO);	// 식자재 목록 가져오기
	int insertStock(StockDTO stockDTO);	// 재고 추가
	int updateStock(ArrayList<String> stock_update);	// 재고 수정
	int deleteStock(ArrayList<String> stock_delete);	// 재고 삭제
	//List<Map<String, String>> getStockWeekData(String s_id); // 주간 데이터 재고 수량 차트 데이터 가져오기
	List<StockDTO> getStockAnlList(StockSearchDTO stock_searchDTO); // 차트 재고 테이블 목록 가져오기
}