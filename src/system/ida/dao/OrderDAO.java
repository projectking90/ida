/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dao;

import java.util.List;
import java.util.Map;

import system.ida.dto.MenuDTO;
import system.ida.dto.OrderDTO;
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
	String sqlSessionPath = "system.ida.dao.OrderDAO.";

	/**
	 * 메소드 선언
	 */
	List<OrderUpdateDTO> getOrderList(String s_id);

	List<OrderUpdateDTO> getOrderList_sepa_quan(String s_id);

	List<MenuDTO> getMenuList(String s_id);

	int deleteStoreOrder(Map<String, String> trData);

	int deleteOrderMenu(Map<String, String> trData);

	int updateStoreOrder(Map<String, String> trData);

	int insertOrderMenu(Map<String, String> trData);
	
	int insertOrderMenu(OrderDTO orderDTO);

	int insertStoreOrder(OrderDTO orderDTO);
}