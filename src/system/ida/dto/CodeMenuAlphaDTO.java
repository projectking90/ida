/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

/**
 * CodeMenuAlphaDTO 클래스
 * 메뉴 대분류 DTO
 * @author Jo
 */
public class CodeMenuAlphaDTO {
	/**
	 * 속성변수 선언
	 */
	private String ma_name;	// 메뉴 대분류 이름

	/**
	 * 접근자, 설정자 선언
	 */
	/**
	 * ma_name 접근자
	 * @return ma_name : 메뉴 대분류 이름
	 */
	public String getMa_name() {
		return ma_name;
	}
	/**
	 * ma_name 설정자
	 * @param ma_name : 메뉴 대분류 이름
	 */
	public void setMa_name(String ma_name) {
		this.ma_name = ma_name;
	}
}