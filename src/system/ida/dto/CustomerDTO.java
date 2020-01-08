/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

/**
 * CustomerDTO 클래스
 * 고객의 정보를 저장할 DTO
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
}