/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.service;

import java.util.ArrayList;
import java.util.List;

import system.ida.dto.MenuDTO;
import system.ida.dto.OrderDTO;
import system.ida.dto.OrderUpdateDTO;

/**
 * OrderService 인터페이스
 * 서비스 클래스를 사용하기 위해 정의한 인터페이스
 * @author Jo
 */
public interface OrderService {
	/**
	 * 속성변수 선언
	 */

	/**
	 * 메소드 선언
	 */
	List<OrderUpdateDTO> getOrderList(String s_id);

	List<OrderUpdateDTO> getOrderList_sepa_quan(String s_id);

	List<MenuDTO> getMenuList(String s_id);

	int deleteStoreOrder(ArrayList<String> order_delete);

	int updateStoreOrder(ArrayList<String> order_update);

	int insertStoreOrder(OrderDTO orderDTO);

	int insertOrderMenu(OrderDTO orderDTO);
}