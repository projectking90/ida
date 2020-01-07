/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

/**
 * AddrDTO 클래스
 * 주소 정보를 담을 DTO
 * @author Jo
 */
public class AddrDTO {
	/**
	 * 속성변수 선언
	 */
	private String city;	// 시
	private String gun;	// 군
	private String gu;	// 구
	private String dong;	// 동

	/**
	 * 접근자, 설정자 선언
	 */
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
}