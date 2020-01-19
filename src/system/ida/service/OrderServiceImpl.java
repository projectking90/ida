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

import system.ida.dao.OrderDAO;
import system.ida.dto.MenuDTO;
import system.ida.dto.OrderDTO;
import system.ida.dto.OrderSearchDTO;
import system.ida.dto.OrderUpdateDTO;

/**
 * OrderServiceImpl 클래스
 * 서비스 클래스
 * @author Jo
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	/**
	 * 속성변수 선언
	 */
	@Autowired
	private OrderDAO orderDAO;	// OrderDAO 인터페이스를 구현받은 객체를 생성해서 저장

	/**
	 * 메소드 선언
	 */
	public List<OrderUpdateDTO> getOrderList(String s_id){
		List<OrderUpdateDTO> order_list = this.orderDAO.getOrderList(s_id);
		
		return order_list;
	}
	
	public List<OrderUpdateDTO> getOrderList_sepa_quan(String s_id){
		List<OrderUpdateDTO> order_list = this.orderDAO.getOrderList_sepa_quan(s_id);
		
		return order_list;
	}
	
	@Override
	public List<MenuDTO> getMenuList(String s_id){
		List<MenuDTO> mi_nameList = this.orderDAO.getMenuList(s_id);
		return mi_nameList;
	}
	
	/**
	 * 주문 추가
	 * @param orderDTO : 주문 추가를 위해 사용하는 DTO
	 * @return insert_result : 메뉴 추가 적용 개수
	 */
	@Override
	public int insertStoreOrder(OrderDTO orderDTO) {
		int insert_result = this.orderDAO.insertStoreOrder(orderDTO);
		
		return insert_result;
	}

	@Override
	public int insertOrderMenuOne(ArrayList<String> mi_names, ArrayList<String> quantitys, String s_id) {
		Map<String, String> trData = new HashMap<String, String>();
		int order_menu_insert = 0;
		
		for(int i=0; i<mi_names.size(); i++) {
				trData.put("mi_name", mi_names.get(i));
				trData.put("quantity", quantitys.get(i));
				trData.put("s_id", s_id);
				order_menu_insert += this.orderDAO.insertOrderMenuOne(trData);
				System.out.println("order_menu_insert : "+order_menu_insert);
		}
		
		return order_menu_insert;
	}
	
	/**
	 * 주문 수정
	 * @param order_update : 주문 수정을 위해 사용하는 ArrayList
	 * @return update_result : 메뉴 수정 적용 개수
	 */
	@Override
	public int updateStoreOrder(ArrayList<String> order_update) {
		Map<String, String> trData = new HashMap<String, String>();
		int update_result = 0;
		
		for(int i=0; i<order_update.size(); i++) {
			if(i%8==0) {
				trData.put("oi_no", order_update.get(i));
			}else if(i%8==1) {
				trData.put("c_phone", order_update.get(i));
			}else if(i%8==2) {
				trData.put("mi_name", order_update.get(i));
			}else if(i%8==3) {
				trData.put("quantity", order_update.get(i));
			}else if(i%8==4) {
				trData.put("gender", order_update.get(i));
			}else if(i%8==5) {
				trData.put("age", order_update.get(i));
			}else if(i%8==6) {
				trData.put("pickup_time", order_update.get(i));
			}else if(i%8==7) {
				trData.put("s_id", order_update.get(i));
				update_result += this.orderDAO.updateStoreOrder(trData);
				//System.out.println("stock_update_cnt : "+stock_update_cnt);
			}
		}
		
		int delete_order_menu = 0;

		
		for(int i=0; i<order_update.size(); i++) {
			if(i%8==0) {
				trData.put("oi_no", order_update.get(i));
			}else if(i%8==1) {
				trData.put("c_phone", order_update.get(i));
			}else if(i%8==2) {
				trData.put("mi_name", order_update.get(i));
			}else if(i%8==3) {
				trData.put("quantity", order_update.get(i));
			}else if(i%8==4) {
				trData.put("gender", order_update.get(i));
			}else if(i%8==5) {
				trData.put("age", order_update.get(i));
			}else if(i%8==6) {
				trData.put("pickup_time", order_update.get(i));
			}else if(i%8==7) {
				trData.put("s_id", order_update.get(i));
				delete_order_menu += this.orderDAO.deleteOrderMenu(trData);
				//System.out.println("stock_update_cnt : "+stock_update_cnt);
			}
		}
		
		int insert_order_menu = 0;
		
		for(int i=0; i<order_update.size(); i++) {
			if(i%8==0) {
				trData.put("oi_no", order_update.get(i));
			}else if(i%8==1) {
				trData.put("c_phone", order_update.get(i));
			}else if(i%8==2) {
				trData.put("mi_name", order_update.get(i));
			}else if(i%8==3) {
				trData.put("quantity", order_update.get(i));
			}else if(i%8==4) {
				trData.put("gender", order_update.get(i));
			}else if(i%8==5) {
				trData.put("age", order_update.get(i));
			}else if(i%8==6) {
				trData.put("pickup_time", order_update.get(i));
			}else if(i%8==7) {
				trData.put("s_id", order_update.get(i));
				insert_order_menu += this.orderDAO.insertOrderMenu(trData);
			}
		}

		return update_result;
	}
	
	/**
	 * 가게 주문 삭제
	 * @param orderDTO : 메뉴 추가를 위해 사용하는 DTO
	 * @return delete_result : 주문 삭제 적용 개수
	 */
	@Override
	public int deleteStoreOrder(ArrayList<String> order_delete) {
		Map<String, String> trData = new HashMap<String, String>();
		int delete_result=0;
		
		for(int i=0; i<order_delete.size(); i++) {
			trData.put("oi_no", order_delete.get(i));
			delete_result += this.orderDAO.deleteStoreOrder(trData);
		}
		
		int delete_order_menu = 0;
		
		for(int i=0; i<order_delete.size(); i++) {
			trData.put("oi_no", order_delete.get(i));
			delete_order_menu += this.orderDAO.deleteOrderMenu(trData);
		}
		
		return delete_result;
	}
	public List<Map<String, String>> getGenderData(String s_id) {
		List<Map<String,String>> gender_chart = this.orderDAO.getGenderData(s_id);
		
		return gender_chart;
	}
	
	public List<Map<String, String>> getAgeData(String s_id) {
		List<Map<String,String>> age_chart = this.orderDAO.getAgeData(s_id);
		
		return age_chart;
	}
	
	public List<Map<String, String>> getMonthData(String s_id) {
		List<Map<String,String>> month_chart = this.orderDAO.getMonthData(s_id);
		
		return month_chart;
	}
	
	public List<OrderDTO> getOrderList(OrderSearchDTO ordersearchDTO){
		List<OrderDTO> order_list = this.orderDAO.getOrderList(ordersearchDTO);
		
		return order_list;
	}
}