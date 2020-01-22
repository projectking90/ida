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

import system.ida.dto.IngredientDTO;
import system.ida.dto.StockDTO;
import system.ida.dto.StockInsertDTO;
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
	@Override
	public List<StockDTO> getStockList(StockSearchDTO stock_searchDTO){
		List<StockDTO> stock_list = this.sqlSession.selectList(
				sqlSessionPath+"getStockList"
				, stock_searchDTO);
		
		//System.out.println("!" + stock_list.size());
		
		return stock_list;
	}

	@Override
	public int insertStock(StockDTO stockDTO) {
		int stock_reg_cnt=this.sqlSession.insert(
				sqlSessionPath+"insertStock"
				, stockDTO);
		
		return stock_reg_cnt;
	}
	
	@Override	
	public List<IngredientDTO> getIngredientList(StockSearchDTO stock_searchDTO){
		List<IngredientDTO> ingredient_list=this.sqlSession.selectList(
				sqlSessionPath+"getIngredientList"
				, stock_searchDTO);
		
		return ingredient_list;
	}

	@Override
	public int updateStock(Map<String, String> trData) {
		int stock_update_cnt=this.sqlSession.update(
				sqlSessionPath+"updateStock"
				, trData);
		
		return stock_update_cnt;
	}
	
	@Override
	public int deleteStock(Map<String, String> trData) {
		int stock_delete_cnt=this.sqlSession.update(
				sqlSessionPath+"deleteStock"
				, trData);
		
		return stock_delete_cnt;	
	}
	
	@Override
	public int getInsertedStockCnt(StockDTO stockDTO) {
		int inserted_stock_cnt=this.sqlSession.selectOne(
				sqlSessionPath+"getInsertedStockCnt"
				, stockDTO);
		
		return inserted_stock_cnt;
	}

	@Override
	public int getInsertedStockIsDelCnt(StockDTO stockDTO) {
		int inserted_stock_cnt=this.sqlSession.selectOne(
				sqlSessionPath+"getInsertedStockIsDelCnt"
				, stockDTO);
		
		return inserted_stock_cnt;
	}

	@Override
	public int getInsertedStockIsDelUp(StockDTO stockDTO) {
		int inserted_stock_is_del_up=this.sqlSession.update(
				sqlSessionPath+"getInsertedStockIsDelUp"
				, stockDTO);
		
		return inserted_stock_is_del_up;
	}
	
	@Override
	public int deleteStockRecord(Map<String, String> trData) {
		int stock_record_delete=this.sqlSession.insert(
				sqlSessionPath+"deleteStockRecord"
				, trData);
		
		return stock_record_delete;
	}

	@Override
	public int insertStockRecord(StockDTO stockDTO) {
		int stock_record_insert=this.sqlSession.insert(
				sqlSessionPath+"insertStockRecord"
				, stockDTO);
		
		return stock_record_insert;
	}
	
	@Override
	public int getInsertedStockQuantityCnt(Map<String, String> trData) {
		int stock_inserted_quantity_cnt=this.sqlSession.selectOne(sqlSessionPath+"getInsertedStockQuantityCnt", trData);
		return stock_inserted_quantity_cnt;
	}
	
	@Override
	public int updateStockRecord(Map<String, String> trData) {
		int updated_stock_record=this.sqlSession.insert(sqlSessionPath+"updateStockRecord", trData);
		return updated_stock_record;
	}
/*
	@Override
	public List<Map<String, String>> getStockWeekData(String s_id) {
		List<Map<String,String>> week_chart = this.sqlSession.selectList(
				sqlSessionPath + "getStockWeekData"
				,s_id);
		
		return week_chart;
	}
*/
	@Override
	public List<StockDTO> getStockAnlList(StockSearchDTO stock_searchDTO) {
		List<StockDTO> stock_anl_list = this.sqlSession.selectList(
				sqlSessionPath+"getStockAnlList"
				, stock_searchDTO);
		
		
		return stock_anl_list;
	}

}