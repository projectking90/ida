/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

/**
 * UserDTO 클래스
 * 사용자 정보를 담을 DTO
 * @author Jo
 */
public class UserDTO {
	/**
	 * 속성변수 선언
	 */
	private String s_id;	// 아이디
	private String pwd;	// 암호
	private String com_name;	// 가게명
	private String s_name;	// 사업자명
	private String s_reg_num;	// 사업자등록번호
	private String s_phone;	// 핸드폰
	private String email;	// 이메일
	private String city;	// 시
	private String gun;	// 군
	private String gu;	// 구
	private String dong;	// 동
	private int addr_code;	// 주소코드
	private String addr_detail;	// 상세주소
	
	/**
	 * 생성자 선언
	 */
	public UserDTO() {
		this.setAddr_code(0);
	}
	
	/**
	 * 접근자, 설정자 선언
	 */
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
	 * pwd 접근자
	 * @return pwd : 암호
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * pwd 설정자
	 * @param pwd : 암호
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * com_name 접근자
	 * @return com_name : 가게명
	 */
	public String getCom_name() {
		return com_name;
	}
	/**
	 * com_name 설정자
	 * @param com_name : 가게명
	 */
	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}
	/**
	 * s_name 접근자
	 * @return s_name : 사업자명
	 */
	public String getS_name() {
		return s_name;
	}
	/**
	 * s_name 설정자
	 * @param s_name : 사업자명
	 */
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	/**
	 * s_reg_num 접근자
	 * @return s_reg_num : 사업자등록번호
	 */
	public String getS_reg_num() {
		return s_reg_num;
	}
	/**
	 * s_reg_num 설정자
	 * @param s_reg_num : 사업자등록번호
	 */
	public void setS_reg_num(String s_reg_num) {
		this.s_reg_num = s_reg_num;
	}
	/**
	 * s_phone 접근자
	 * @return s_phone : 핸드폰
	 */
	public String getS_phone() {
		return s_phone;
	}
	/**
	 * s_phone 설정자
	 * @param s_phone : 핸드폰
	 */
	public void setS_phone(String s_phone) {
		this.s_phone = s_phone;
	}
	/**
	 * email 접근자
	 * @return email : 이메일
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * email 설정자
	 * @param email : 이메일
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * city 접근자
	 * @return city : 시
	 */
	public String getCity() {
		return city;
	}
	/**
	 * city 설정자
	 * @param city : 시
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * gun 접근자
	 * @return gun : 군
	 */
	public String getGun() {
		return gun;
	}
	/**
	 * gun 설정자
	 * @param gun : 군
	 */
	public void setGun(String gun) {
		this.gun = gun;
	}
	/**
	 * gu 접근자
	 * @return gu : 구
	 */
	public String getGu() {
		return gu;
	}
	/**
	 * gu 설정자
	 * @param gu : 구
	 */
	public void setGu(String gu) {
		this.gu = gu;
	}
	/**
	 * dong 접근자
	 * @return dong : 동
	 */
	public String getDong() {
		return dong;
	}
	/**
	 * dong 설정자
	 * @param dong : 동
	 */
	public void setDong(String dong) {
		this.dong = dong;
	}
	/**
	 * addr_code 접근자
	 * @return addr_code : 주소코드
	 */
	public int getAddr_code() {
		return addr_code;
	}
	/**
	 * addr_code 설정자
	 * @param addr_code : 주소코드
	 */
	public void setAddr_code(int addr_code) {
		this.addr_code = addr_code;
	}
	/**
	 * addr_detail 접근자
	 * @return addr_detail : 상세주소
	 */
	public String getAddr_detail() {
		return addr_detail;
	}
	/**
	 * addr_detail 설정자
	 * @param addr_detail : 상세주소
	 */
	public void setAddr_detail(String addr_detail) {
		this.addr_detail = addr_detail;
	}
}