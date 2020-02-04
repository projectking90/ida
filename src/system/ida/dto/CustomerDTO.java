/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

/**
 * CustomerDTO 클래스
 * 고객 정보를 담은 DTO
 * @author Jo
 */
public class CustomerDTO {
	/**
	 * 속성변수 선언
	 */
	private int oi_no;	// 주문번호
	private String c_phone;	// 핸드폰
	private String gender;	// 성별
	private String age;	// 나이대
	private String order_time;	// 주문시간
	private String pickup_time;	// 픽업시간
	
	/**
	 * 접근자, 설정자 선언
	 */
	/**
	 * oi_no 접근자
	 * @return oi_no : 주문번호
	 */
	public int getOi_no() {
		return oi_no;
	}
	/**
	 * oi_no 설정자
	 * @param oi_no : 주문번호
	 */
	public void setOi_no(int oi_no) {
		this.oi_no = oi_no;
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
	 * @return age : 나이대
	 */
	public String getAge() {
		return age;
	}
	/**
	 * age 설정자
	 * @param age : 나이대
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
}