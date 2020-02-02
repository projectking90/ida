/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dao;

import java.util.List;
import java.util.Map;

import system.ida.dto.ChartSearchDTO;
import system.ida.dto.MenuDTO;
import system.ida.dto.OrderDTO;
import system.ida.dto.OrderSearchDTO;
import system.ida.dto.OrderUpdateDTO;

/**
 * OrderDAO 인터페이스
 * DAO 클래스를 사용하기 위해 정의한 인터페이스
 * @author Jo
 */
public interface OrderDAO {
	/**
	 * 속성변수 선언
	 */
	String sqlSessionPath = "system.ida.dao.OrderDAO.";	// mapper의 namespace

	/**
	 * 메소드 선언
	 */
	List<OrderUpdateDTO> getOrderList(String s_id);	// 주문 목록을 가져옴
	List<OrderUpdateDTO> getOrderList_sepa_quan(String oi_no);	// 주문 목록 중 수량만 가져옴
	List<MenuDTO> getMenuList(String s_id);	// 메뉴 목록을 가져옴
	int deleteStoreOrder(Map<String, String> trData);	// 주문 삭제 처리함
	int deleteOrderMenu(Map<String, String> trData);	// 주문 메뉴 삭제 처리함
	int updateStoreOrder(Map<String, String> trData);	// 주문 수정 처리함
	int insertOrderMenu(Map<String, String> trData);	// 주문 메뉴 추가 처리함
	int insertOrderMenuOne(Map<String, String> trData);	// 주문 메뉴들 추가 처리함
	int insertStoreOrder(OrderDTO orderDTO);	// 주문 추가 처리함
	List<Map<String, String>> getGenderData(String s_id);	// 성별 주문 차트 데이터를 가져옴
	List<Map<String, String>> getAgeData(String s_id);	// 나이별 주문 차트 데이터를 가져옴
	List<Map<String, String>> getMonthData(String s_id);	// 월별 주문 차트 데이터를 가져옴
	List<OrderDTO> getOrderList(OrderSearchDTO ordersearchDTO);	// 주문 차트 데이터를 가져옴
	List<Map<String, String>> getHourData(String s_id);	// 시간별 주문 차트 데이터를 가져옴
	List<Map<String, String>> getQuarterData(String s_id);	// 분기별 주문 차트 데이터를 가져옴
	List<Map<String, String>> getWeekData(ChartSearchDTO chart_search_DTO);	// 주별 주문 차트 데이터를 가져옴
	List<Map<String, String>> getGenderData_W(ChartSearchDTO chart_search_DTO);	// 여자별 주문 차트 데이터를 가져옴
	List<Map<String, String>> getGenderData_M(ChartSearchDTO chart_search_DTO);	// 남자별 주문 차트 데이터를 가져옴
	List<Map<String, String>> getAgeMenuData(ChartSearchDTO chart_search_DTO);	// 나이별 주문 메뉴 차트 데이터를 가져옴
	List<Map<String, String>> getMonthMenuData(ChartSearchDTO chart_search_DTO);	// 월별  주문 메뉴 차트 데이터를 가져옴
	List<Map<String, String>> getQuarterMenuData(ChartSearchDTO chart_search_DTO);	// 분기별 주문 메뉴 차트 데이터를 가져옴
	List<Map<String, String>> getWeekMenuData(ChartSearchDTO chart_search_DTO);	// 주별 주문 메뉴 차트 데이터를 가져옴
	int updateStockQuantity(Map<String, String> trData);	// 주문 관련 재고 변경 처리
	int getStockQuantity(Map<String, String> trData);	// 주문 관련시 재고 수량을 가져옴
}