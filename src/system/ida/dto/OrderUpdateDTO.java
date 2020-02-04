/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

import java.util.List;

/**
 * OrderUpdateDTO 클래스
 * 주문 수정할 정보를 담을 DTO
 * @author Jo
 */
public class OrderUpdateDTO {
	/**
	 * 속성변수 선언
	 */
	private String oi_no;	// 주문 번호
	private int s_no;	// 사용자 번호
	private String s_id;	// 아이디
	private String c_phone;	// 핸드폰
	private String gender;	// 성별
	private String age;	// 나이
	private String order_time;	// 주문시간
	private String pickup_time;	// 픽업시간
	private String is_del;	// 삭제여부
	private String order_menus;	// 주문 메뉴들
	private String quantity;	// 수량
	private String mi_name;	// 메뉴 이름
	private List<MenuDTO> mi_nameList;	// 메뉴 목록
	
	/**
	 * 접근자, 설정자 선언
	 */
	/**
	 * oi_no 접근자
	 * @return oi_no : 주문 번호
	 */
	public String getOi_no() {
		return oi_no;
	}
	/**
	 * oi_no 설정자
	 * @param oi_no : 주문 번호
	 */
	public void setOi_no(String oi_no) {
		this.oi_no = oi_no;
	}
	/**
	 * s_no 접근자
	 * @return s_no : 사용자 번호
	 */
	public int getS_no() {
		return s_no;
	}
	/**
	 * s_no 설정자
	 * @param s_no : 사용자 번호
	 */
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	/**
	 * s_id 접근자
	 * @return s_id : 아이디
	 */
	public String getS_id() {
		return s_id;
	}
	/**
	 * s_id 설정자
	 * @param s_id : 아이디
	 */
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	/**
	 * c_phone 접근자
	 * @return c_phone : 핸드폰
	 */
	public String getC_phone() {
		return c_phone;
	}
	/**
	 * c_phone 설정자
	 * @param c_phone : 핸드폰
	 */
	public void setC_phone(String c_phone) {
		this.c_phone = c_phone;
	}
	/**
	 * gender 접근자
	 * @return gender : 성별
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * gender 설정자
	 * @param gender : 성별
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * age 접근자
	 * @return age : 나이
	 */
	public String getAge() {
		return age;
	}
	/**
	 * age 설정자
	 * @param age : 나이
	 */
	public void setAge(String age) {
		this.age = age;
	}
	/**
	 * order_time 접근자
	 * @return order_time : 주문시간
	 */
	public String getOrder_time() {
		return order_time;
	}
	/**
	 * order_time 설정자
	 * @param order_time : 주문시간
	 */
	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}
	/**
	 * pickup_time 접근자
	 * @return pickup_time : 픽업시간
	 */
	public String getPickup_time() {
		return pickup_time;
	}
	/**
	 * pickup_time 설정자
	 * @param pickup_time : 픽업시간
	 */
	public void setPickup_time(String pickup_time) {
		this.pickup_time = pickup_time;
	}
	/**
	 * is_del 접근자
	 * @return is_del : 삭제여부
	 */
	public String getIs_del() {
		return is_del;
	}
	/**
	 * is_del 설정자
	 * @param is_del : 삭제여부
	 */
	public void setIs_del(String is_del) {
		this.is_del = is_del;
	}
	/**
	 * order_menus 접근자
	 * @return order_menus : 주문 메뉴들
	 */
	public String getOrder_menus() {
		return order_menus;
	}
	/**
	 * order_menus 설정자
	 * @param order_menus : 주문 메뉴들
	 */
	public void setOrder_menus(String order_menus) {
		this.order_menus = order_menus;
	}
	/**
	 * quantity 접근자
	 * @return quantity : 수량
	 */
	public String getQuantity() {
		return quantity;
	}
	/**
	 * quantity 설정자
	 * @param quantity : 수량
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	/**
	 * mi_name 접근자
	 * @return mi_name : 메뉴 이름
	 */
	public String getMi_name() {
		return mi_name;
	}
	/**
	 * mi_name 설정자
	 * @param mi_name : 메뉴 이름
	 */
	public void setMi_name(String mi_name) {
		this.mi_name = mi_name;
	}
	/**
	 * mi_nameList 접근자
	 * @return mi_nameList : 메뉴 목록
	 */
	public List<MenuDTO> getMi_nameList() {
		return mi_nameList;
	}
	/**
	 * mi_nameList 설정자
	 * @param mi_nameList : 메뉴 목록
	 */
	public void setMi_nameList(List<MenuDTO> mi_nameList) {
		this.mi_nameList = mi_nameList;
	}
}