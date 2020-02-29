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

import system.ida.dao.StockDAO;
import system.ida.dto.ChartSearchDTO;
import system.ida.dto.IngredientDTO;
import system.ida.dto.StockDTO;
import system.ida.dto.StockSearchDTO;

/**
 * StockServiceImpl 클래스
 * 서비스 클래스 / 
 * 트랜잭션을 걸어 DAO 클래스에 데이터베이스 연동을 요청
 * @author Jo
 */
@Service
@Transactional
public class StockServiceImpl implements StockService {
	/**
	 * 속성변수 선언
	 */
	@Autowired
	private StockDAO stockDAO;	// StockDAO 인터페이스를 구현받은 객체를 생성해서 저장

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
		List<StockDTO> stock_list = this.stockDAO.getStockList(stock_searchDTO);
		
		return stock_list;
	}
	
	/**
	 * 식자재 대분류 목록을 가져옴
	 * @param stock_searchDTO : 재고 검색 DTO
	 * @return ingredient_list : 식자재 대분류 목록
	 */
	@Override
	public List<IngredientDTO> getIngredientList(StockSearchDTO stock_searchDTO){
		List<IngredientDTO> ingredient_list=this.stockDAO.getIngredientList(stock_searchDTO);
		
		return ingredient_list;
	}
	
	/**
	 * 재고 추가 처리함
	 * @param stockDTO : 재고 DTO
	 * @return stock_reg_cnt : 재고 추가 Query 결과
	 */
	@Override
	public int insertStock(StockDTO stockDTO) {
		// 이미 등록된 재고 개수 count
		int inserted_stock_cnt = this.stockDAO.getInsertedStockCnt(stockDTO);
		
		if(inserted_stock_cnt>0) {	// 이미 등록된 재고의 개수가 0보다 클 때
			// 등록된 후 is_del='T'의 재고 개수 count
			int inserted_stock_is_del_cnt=this.stockDAO.getInsertedStockIsDelCnt(stockDTO);
			
			if(inserted_stock_is_del_cnt>0) {	// 등록된 후 is_del='T'의 재고 개수가 0보다 클 때
				// is_del='F'로 바꾼 재고 개수
				int inserted_stock_is_del_up=this.stockDAO.getInsertedStockIsDelUp(stockDTO);
				
				if(inserted_stock_is_del_up>0) {	// is_del='F'로 바꾼 재고 개수가 0보다 클 때
					int stock_record_insert=this.stockDAO.insertStockRecord(stockDTO);
					
					if(stock_record_insert>0) {
						return -3;	
					}
					
				}
			} else {	// 이미 등록된 재고이고, is_del='F'일 때
				return -2;
			}
		} else {	// 등록된 재고가 없을 때
			int stock_reg_cnt = this.stockDAO.insertStock(stockDTO);
			
			if(stock_reg_cnt>0) {	// 추가
				int stock_record_insert = this.stockDAO.insertStockRecord(stockDTO);
				
				if(stock_record_insert>0) {
					return 1;	
				}
			}
		}
		
		return -1;
	}

	/**
	 * 재고 수정 처리함
	 * @param stockDTO : 재고 DTO
	 * @return stock_update_cnt : 재고 수정 Query 결과
	 */
	@Override
	public int updateStock(StockDTO stockDTO) {
		// 기존 수량 값
		int stock_inserted_quantity_cnt=this.stockDAO.getInsertedStockQuantityCnt(stockDTO);
		// 업데이트 성공 개수
		int stock_update_cnt=0;
		// 수정 값-기존 값
		int update_quantity=stockDTO.getQuantity();
		int change_quantity=update_quantity-stock_inserted_quantity_cnt;
		
		if(change_quantity!=0) {	// 삭제 여부 확인 cnt=1 재고 존재, cnt=0 재고 존재X
			int getIsDelStockCnt=this.stockDAO.getInsertedStockIsDelCnt(stockDTO);
			
			if(getIsDelStockCnt==0) {
				// 기록 성공 개수
				stock_update_cnt=this.stockDAO.updateStock(stockDTO);
				stockDTO.setQuantity(change_quantity);
				int stock_update_record_cnt=this.stockDAO.updateStockRecord(stockDTO);
				
				if(stock_update_record_cnt==1 && stock_update_cnt==1) {
					return stock_update_cnt;
				} else { 
					return -1; 
				}
			}else {	// 삭제됨
				return -2;
			}
		}
		
		return stock_update_cnt;
	}
	
	/**
	 * 재고 삭제 처리함
	 * @param stock_delete : 삭제할 재고 번호들
	 * @return stock_delete_cnt : 재고 삭제 Query 결과
	 */
	@Override
	public int deleteStock(ArrayList<String> stock_delete) {
		Map<String, String> trData = new HashMap<String, String>();
		int stock_delete_cnt=0;
		
		for(int i=0; i<stock_delete.size(); i++) {
			trData.put("st_no", stock_delete.get(i));
			stock_delete_cnt += this.stockDAO.deleteStock(trData);
		}
		
		if(stock_delete_cnt>0) {
			int stock_record_delete=this.stockDAO.deleteStockRecord(trData);
			
			if(stock_record_delete>0) {
				return 1;	
			}
		}
		
		return stock_delete_cnt;
	}

	/**
	 * 차트 재고 테이블 목록 가져옴
	 * @param chart_searchDTO : 차트 검색 DTO
	 * @return stock_anl_list : 재고 목록
	 */
	@Override
	public List<StockDTO> getStockAnlList(ChartSearchDTO chart_searchDTO) {
		List<StockDTO> stock_anl_list = this.stockDAO.getStockAnlList(chart_searchDTO);
		
		return stock_anl_list;
	}

	/**
	 * 주별 재고 차트 데이터 가져옴
	 * @param chart_searchDTO : 차트 검색 DTO
	 * @return week_stock_chart : 주별 재고 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getWeekStockData(ChartSearchDTO chart_searchDTO) {
		List<Map<String,String>> week_stock_chart = this.stockDAO.getWeekStockData(chart_searchDTO);
		
		return week_stock_chart;
	}

	/**
	 * 월별 재고 차트 데이터 가져옴
	 * @param chart_searchDTO : 차트 검색 DTO
	 * @return month_stock_chart : 월별 재고 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getMonthStockData(ChartSearchDTO chart_searchDTO) {
		List<Map<String,String>> month_stock_chart = this.stockDAO.getMonthStockData(chart_searchDTO);
		
		return month_stock_chart;
	}
	
	/**
	 * 시간별 재고 차트 데이터 가져옴
	 * @param chart_searchDTO : 차트 검색 DTO
	 * @return time_stock_chart : 시간별 재고 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getTimeStockData(ChartSearchDTO chart_searchDTO) {
		List<Map<String,String>> time_stock_chart = this.stockDAO.getTimeStockData(chart_searchDTO);
		
		return time_stock_chart;
	}

	/**
	 * 모든 분기 재고 차트 데이터 가져옴
	 * @param chart_searchDTO : 차트 검색 DTO
	 * @return all_quarter_stock_chart : 모든 분기 재고 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getAllQuarterStockData(ChartSearchDTO chart_searchDTO) {
		List<Map<String,String>> all_quarter_stock_chart = this.stockDAO.getAllQuarterStockData(null);
		
		return all_quarter_stock_chart;
	}

	/**
	 * 분기별 재고 차트 데이터 가져옴
	 * @param chart_searchDTO : 차트 검색 DTO
	 * @return quarter_stock_chart : 분기별 재고 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getQuarterStockData(ChartSearchDTO chart_searchDTO) {
		List<Map<String,String>> quarter_stock_chart = this.stockDAO.getQuarterStockData(chart_searchDTO);
		
		return quarter_stock_chart;
	}

	/**
	 * 재고 정보 가져옴
	 * @param st_no : 재고번호
	 * @return stockDTO : 재고 정보
	 */
	@Override
	public StockDTO getStockDTO(int st_no) {
		StockDTO stockDTO = this.stockDAO.getStockDTO(st_no);
		
		return stockDTO;
	}
}