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
import system.ida.dto.MenuDTO;
import system.ida.dto.OrderDTO;
import system.ida.dto.OrderSearchDTO;
import system.ida.dto.OrderUpdateDTO;

/**
 * OrderDAOImpl 클래스
 * DAO 클래스, bean 태그로 자동 등록됨 / 
 * 직접 데이터베이스와 연동해 Query를 수행
 * @author Jo
 */
@Repository
public class OrderDAOImpl implements OrderDAO {
	/**
	 * 속성변수 선언
	 */
	@Autowired
	private SqlSessionTemplate sqlSession;	// SqlSessionTemplate 객체를 생성하고 저장
	
	/**
	 * 메소드 선언
	 */
	/**
	 * 주문 목록을 가져옴
	 * @param s_id : 사용자 아이디
	 * @return : order_list : 주문 리스트
	 */
	@Override
	public List<OrderUpdateDTO> getOrderList(String s_id){
		List<OrderUpdateDTO> order_list = this.sqlSession.selectList(
				sqlSessionPath + "getOrderList"
				, s_id);
		
		return order_list;
	}
	
	/**
	 * 주문 목록 중 수량만 가져옴
	 * @param oi_no : 주문 번호
	 * @return orderUpdateDTOList : 주문 목록의 수량 리스트
	 */
	@Override
	public List<OrderUpdateDTO> getOrderList_sepa_quan(String oi_no){
		List<OrderUpdateDTO> orderUpdateDTOList = this.sqlSession.selectList(
				sqlSessionPath + "getOrderList_sepa_quan"
				, oi_no);
		
		return orderUpdateDTOList;
	}
	
	/**
	 * 메뉴 목록을 가져옴
	 * @param s_id : 사용자 아이디
	 * @return mi_nameList : 메뉴 리스트
	 */
	@Override
	public List<MenuDTO> getMenuList(String s_id){
		List<MenuDTO> mi_nameList = this.sqlSession.selectList(
				sqlSessionPath + "getMenuList"
				, s_id);
		
		return mi_nameList;
	}
	
	/**
	 * 주문 추가 처리함
	 * @param orderDTO : 주문 DTO
	 * @return insert_result : 메뉴 추가 Query 결과
	 */
	@Override
	public int insertStoreOrder(OrderDTO orderDTO) {
		int insert_result = sqlSession.insert(
				sqlSessionPath + "insertStoreOrder"
				, orderDTO);
		
		return insert_result;
	}
	
	/**
	 * 주문 메뉴들 추가 처리함
	 * @param trData : 메뉴 정보들
	 * @return order_menu_insert : 주문 메뉴 추가 Query 결과
	 */
	@Override
	public int insertOrderMenuOne(Map<String, String> trData) {
		int order_menu_insert = this.sqlSession.insert(
				sqlSessionPath + "insertOrderMenuOne"
				, trData);
		
		return order_menu_insert;
	}

	/**
	 * 주문 관련 재고 변경 처리
	 * @param trData : 메뉴, 수량 정보들
	 * @return stock_update_result : 주문 관련 재고 변경 Query 결과
	 */
	@Override
	public int updateStockQuantity(Map<String, String> trData) {
		int stock_update_result = this.sqlSession.update(
				sqlSessionPath + "updateStockQuantity"
				, trData);

		return stock_update_result;
	}
	
	/**
	 * 주문 관련시 재고 수량을 가져옴
	 * @param trData : 메뉴 정보들
	 * @return stock_quantity_cnt : 재고 수량
	 */
	@Override
	public int getStockQuantity(Map<String, String> trData) {
		int stock_quantity_cnt = this.sqlSession.selectOne(
				sqlSessionPath + "getStockQuantity"
				, trData);
		
		return stock_quantity_cnt;
	}
	
	/**
	 * 주문 수정 처리함
	 * @param trData : 메뉴 정보들
	 * @return update_result : 주문 수정 Query 결과
	 */
	@Override
	public int updateStoreOrder(Map<String, String> trData) {
		int update_result = this.sqlSession.update(
				sqlSessionPath + "updateStoreOrder"
				, trData);
		
		return update_result;
	}
	
	/**
	 * 주문 메뉴 추가 처리함
	 * @param trData : 메뉴 정보들
	 * @return insert_order_menu : 주문 추가 Query 결과
	 */
	@Override
	public int insertOrderMenu(Map<String, String> trData) {
		int insert_order_menu = this.sqlSession.insert(
				sqlSessionPath + "insertOrderMenu"
				, trData);
		
		return insert_order_menu;
	}
	
	/**
	 * 주문 삭제 처리함
	 * @param trData : 주문 번호들
	 * @return delete_result : 주문 삭제 Query 결과
	 */
	@Override
	public int deleteStoreOrder(Map<String, String> trData) {
		int delete_result = this.sqlSession.update(
				sqlSessionPath + "deleteStoreOrder"
				, trData);
		
		return delete_result;
	}
	
	/**
	 * 주문 메뉴 삭제 처리함
	 * @param trData : 메뉴 정보들
	 * @return delete_order_menu : 주문 메뉴 삭제 Query 결과
	 */
	@Override
	public int deleteOrderMenu(Map<String, String> trData) {
		int delete_order_menu = this.sqlSession.delete(
				sqlSessionPath + "deleteOrderMenu"
				, trData);
		
		return delete_order_menu;
	}
	
	/**
	 * 성별 주문 차트 데이터를 가져옴
	 * @param s_id : 사용자 아이디
	 * @return gender_chart : 성별 주문 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getGenderData(String s_id) {
		List<Map<String,String>> gender_chart = this.sqlSession.selectList(
				sqlSessionPath + "getGenderData"
				, s_id);
		
		return gender_chart;
	}
	
	/**
	 * 남자별 주문 차트 데이터를 가져옴
	 * @param chart_search_DTO : 차트 검색 DTO
	 * @return gender_chart_m : 남자별 주문 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getGenderData_M(ChartSearchDTO chart_search_DTO) {
		List<Map<String,String>> gender_chart_m = this.sqlSession.selectList(
				sqlSessionPath + "getGenderData_M"
				, chart_search_DTO);
		
		return gender_chart_m;
	}

	/**
	 * 여자별 주문 차트 데이터를 가져옴
	 * @param chart_search_DTO : 차트 검색 DTO
	 * @return gender_chart_w : 여자별 주문 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getGenderData_W(ChartSearchDTO chart_search_DTO) {
		List<Map<String,String>> gender_chart_w = this.sqlSession.selectList(
				sqlSessionPath + "getGenderData_W"
				,chart_search_DTO
		);
		
		return gender_chart_w;
	}

	/**
	 * 나이별 주문 차트 데이터를 가져옴
	 * @param s_id : 사용자 아이디
	 * @return age_chart : 나이별 주문 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getAgeData(String s_id) {
		List<Map<String,String>> age_chart = this.sqlSession.selectList(
				sqlSessionPath + "getAgeData"
				, s_id);
		
		return age_chart;
	}

	/**
	 * 나이별 주문 메뉴 차트 데이터를 가져옴
	 * @param chart_search_DTO : 차트 검색 DTO
	 * @return age_menu_chart : 나이별 주문 메뉴 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getAgeMenuData(ChartSearchDTO chart_search_DTO) {
		List<Map<String,String>> age_menu_chart = this.sqlSession.selectList(
				sqlSessionPath + "getAgeMenuData"
				, chart_search_DTO);
		
		return age_menu_chart;
	}

	/**
	 * 월별 주문 차트 데이터를 가져옴
	 * @param s_id : 사용자 아이디
	 * @return month_chart : 월별 주문 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getMonthData(String s_id) {
		List<Map<String,String>> month_chart = this.sqlSession.selectList(
				sqlSessionPath + "getMonthData"
				, s_id);
		
		return month_chart;
	}

	/**
	 * 월별  주문 메뉴 차트 데이터를 가져옴
	 * @param chart_search_DTO : 차트 검색 DTO
	 * @return month_menu_chart : 월별  주문 메뉴 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getMonthMenuData(ChartSearchDTO chart_search_DTO) {
		List<Map<String,String>> month_menu_chart = this.sqlSession.selectList(
				sqlSessionPath + "getMonthMenuData"
				, chart_search_DTO);
		
		return month_menu_chart;
	}

	/**
	 * 주문 차트 데이터를 가져옴
	 * @param order_searchDTO : 주문 검색 DTO
	 * @return order_list : 주문 리스트
	 */
	@Override
	public List<OrderDTO> getOrderList(OrderSearchDTO order_searchDTO){
		List<OrderDTO> order_list = this.sqlSession.selectList(
				sqlSessionPath + "getOrderList_analy"
				, order_searchDTO);
		
		return order_list;
	}

	/**
	 * 시간별 주문 차트 데이터를 가져옴
	 * @param s_id : 사용자 아이디
	 * @return hour_chart : 시간별 주문 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getHourData(String s_id) {
		List<Map<String,String>> hour_chart = this.sqlSession.selectList(
				sqlSessionPath + "getHourData"
				, s_id);
		
		return hour_chart;
	}

	/**
	 * 분기별 주문 차트 데이터를 가져옴
	 * @param s_id : 사용자 아이디
	 * @return quarter_chart : 분기별 주문 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getQuarterData(String s_id) {
		List<Map<String,String>> quarter_chart = this.sqlSession.selectList(
				sqlSessionPath + "getQuarterData"
				, s_id);
		
		return quarter_chart;
	}

	/**
	 * 분기별 주문 메뉴 차트 데이터를 가져옴
	 * @param chart_search_DTO : 차트 검색 DTO
	 * @return quarter_menu_chart : 분기별 주문 메뉴 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getQuarterMenuData(ChartSearchDTO chart_search_DTO) {
		List<Map<String,String>> quarter_menu_chart = this.sqlSession.selectList(
				sqlSessionPath + "getQuarterMenuData"
				, chart_search_DTO);
		
		return quarter_menu_chart;
	}

	/**
	 * 주별 주문 차트 데이터를 가져옴
	 * @param chart_search_DTO : 차트 검색 DTO
	 * @return week_chart : 주별 주문 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getWeekData(ChartSearchDTO chart_search_DTO) {
		List<Map<String,String>> week_chart = this.sqlSession.selectList(
				sqlSessionPath + "getWeekData"
				, chart_search_DTO);
		
		return week_chart;
	}

	/**
	 * 주별 주문 메뉴 차트 데이터를 가져옴
	 * @param chart_search_DTO : 차트 검색 DTO
	 * @return week_menu_chart : 주별 주문 메뉴 차트 데이터
	 */
	@Override
	public List<Map<String, String>> getWeekMenuData(ChartSearchDTO chart_search_DTO) {
		List<Map<String,String>> week_menu_chart = this.sqlSession.selectList(
				sqlSessionPath + "getWeekMenuData"
				, chart_search_DTO);
		
		return week_menu_chart;
	}
}