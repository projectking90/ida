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

import system.ida.dto.MenuDTO;
import system.ida.dto.OrderDTO;
import system.ida.dto.OrderSearchDTO;
import system.ida.dto.OrderUpdateDTO;

/**
 * OrderDAOImpl 클래스
 * DAO 클래스, bean 태그로 자동 등록됨
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
	public List<OrderUpdateDTO> getOrderList(String s_id){
		List<OrderUpdateDTO> order_list = this.sqlSession.selectList(
				"system.ida.dao.OrderDAO.getOrderList"	// 실행할 SQL 구문의 위치 지정
				,s_id
				);
		
		return order_list;
	}
	public List<OrderUpdateDTO> getOrderList_sepa_quan(String s_id){
		List<OrderUpdateDTO> order_list = this.sqlSession.selectList(
				"system.ida.dao.OrderDAO.getOrderList_sepa_quan"	// 실행할 SQL 구문의 위치 지정
				,s_id
				);
		
		return order_list;
	}
	
	@Override
	public List<MenuDTO> getMenuList(String s_id){
		List<MenuDTO> mi_nameList = this.sqlSession.selectList(
				sqlSessionPath + "getMenuList"
				,s_id
		);
		return mi_nameList;
	}
	
	/**
	 * 주문 추가
	 * @param orderDTO : 메뉴 추가를 위해 사용하는 DTO
	 * @return insert_result : 메뉴 추가 적용 개수
	 */
	@Override
	public int insertStoreOrder(OrderDTO orderDTO) {
		int insert_result = sqlSession.insert(
				"system.ida.dao.OrderDAO.insertStoreOrder",
				orderDTO
				);
		
		return insert_result;
	}
	
	@Override
	public int insertOrderMenuOne(Map<String, String> trData) {
		int order_menu_insert = this.sqlSession.insert(
				"system.ida.dao.OrderDAO.insertOrderMenuOne"
				,trData
		);
		
		return order_menu_insert;
	}
	
	/**
	 * 가게 주문 수정
	 * @param trData : 주문 수정을 위해 사용하는 Map
	 * @return update_result : 주문 수정 적용 개수
	 */
	@Override
	public int updateStoreOrder(Map<String, String> trData) {
		int update_result = 0;
		update_result = this.sqlSession.update(
				sqlSessionPath + "updateStoreOrder"
				,trData
		);
		
		return update_result;
	}
	
	/**
	 * 주문 수정 추가
	 * @param trData : 주문 수정을 위해 사용하는 Map
	 * @return insert_order_menu : 주문 수정 적용 개수
	 */
	@Override
	public int insertOrderMenu(Map<String, String> trData) {
		int insert_order_menu = 0;
		insert_order_menu = this.sqlSession.insert(
				sqlSessionPath + "insertOrderMenu"
				,trData
		);
		
		return insert_order_menu;
	}
	
	/**
	 * 가게 주문 삭제
	 * @param orderDTO : 주문 삭제를 위해 사용하는 DTO
	 * @return delete_result : 주문 삭제 적용 개수
	 */
	@Override
	public int deleteStoreOrder(Map<String, String> trData) {
		int delete_result = 0;
		delete_result = this.sqlSession.update(
				sqlSessionPath + "deleteStoreOrder"
				,trData
				
		);
		
		return delete_result;
	}
	
	/**
	 * 가게 주문 삭제
	 * @param orderDTO : 주문 삭제를 위해 사용하는 DTO
	 * @return delete_result : 주문 삭제 적용 개수
	 */
	@Override
	public int deleteOrderMenu(Map<String, String> trData) {
		int delete_order_menu = 0;
		delete_order_menu = this.sqlSession.delete(
				sqlSessionPath + "deleteOrderMenu"
				,trData
		);
		
		return delete_order_menu;
	}
	
	public List<Map<String, String>> getGenderData(String s_id) {
		List<Map<String,String>> gender_chart = this.sqlSession.selectList(
				sqlSessionPath + "getGenderData"
				,s_id
		);
		
		return gender_chart;
	}
	
	public List<Map<String, String>> getAgeData(String s_id) {
		List<Map<String,String>> age_chart = this.sqlSession.selectList(
				sqlSessionPath + "getAgeData"
				,s_id
		);
		
		return age_chart;
	}
	
	public List<Map<String, String>> getMonthData(String s_id) {
		List<Map<String,String>> month_chart = this.sqlSession.selectList(
				sqlSessionPath + "getMonthData"
				,s_id
		);
		
		return month_chart;
	}
	
	public List<OrderDTO> getOrderList(OrderSearchDTO ordersearchDTO){
		List<OrderDTO> order_list = this.sqlSession.selectList(
				sqlSessionPath + "getOrderList_analy"
				,ordersearchDTO);
		
		return order_list;
	}
	
	public List<Map<String, String>> getHourData(String s_id) {
		List<Map<String,String>> hour_chart = this.sqlSession.selectList(
				sqlSessionPath + "getHourData"
				,s_id
		);
		
		return hour_chart;
	}
	
	public List<Map<String, String>> getQuarterData(String s_id) {
		List<Map<String,String>> quarter_chart = this.sqlSession.selectList(
				sqlSessionPath + "getQuarterData"
				,s_id
		);
		
		return quarter_chart;
	}
	public List<Map<String, String>> getWeekData(String s_id) {
		List<Map<String,String>> week_chart = this.sqlSession.selectList(
				sqlSessionPath + "getWeekData"
				,s_id
		);
		
		return week_chart;
	}
}