/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

import java.util.List;

/**
 * OrderDTO 클래스
 * 주문 검색할 때 사용할 DTO
 * @author Jo
 */
public class OrderDTO {
	/**
	 * 속성변수 선언
	 */
	private int oi_no;
	private int s_no;
	private String s_id;
	private String c_phone;
	private String gender;
	private String age;
	private String order_time;
	private String pickup_time;
	private String is_del;
	private String order_menus;
	private String[] quantity;
	private String[] mi_name;

	
	/**
	 * 생성자 선언
	 */
	/**
	 * 접근자, 설정자 선언
	 */

	public int getOi_no() {
		return oi_no;
	}
	public void setOi_no(int oi_no) {
		this.oi_no = oi_no;
	}
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public String getC_phone() {
		return c_phone;
	}
	public void setC_phone(String c_phone) {
		this.c_phone = c_phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getOrder_time() {
		return order_time;
	}
	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}
	public String getPickup_time() {
		return pickup_time;
	}
	public void setPickup_time(String pickup_time) {
		this.pickup_time = pickup_time;
	}
	public String getIs_del() {
		return is_del;
	}
	public void setIs_del(String is_del) {
		this.is_del = is_del;
	}

	public String getOrder_menus() {
		return order_menus;
	}
	public void setOrder_menus(String order_menus) {
		this.order_menus = order_menus;
	}
	public String[] getQuantity() {
		return quantity;
	}
	public void setQuantity(String[] quantity) {
		this.quantity = quantity;
	}
	public String[] getMi_name() {
		return mi_name;
	}
	public void setMi_name(String[] mi_name) {
		this.mi_name = mi_name;
	}
	/**
	 * s_id 접근자
	 * @return s_id : 
	 */
	public String getS_id() {
		return s_id;
	}
	/**
	 * s_id 설정자
	 * @param s_id : 
	 */
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
}