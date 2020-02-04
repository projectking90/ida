/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

/**
 * CodeMenuBetaDTO 클래스
 * 메뉴 소분류 DTO
 * @author Jo
 */
public class CodeMenuBetaDTO {
	/**
	 * 속성변수 선언
	 */
	private String mb_name;	// 메뉴 소분류 이름
	
	/**
	 * 접근자, 설정자 선언
	 */
	/**
	 * mb_name 접근자
	 * @return mb_name : 메뉴 소분류 이름
	 */
	public String getMb_name() {
		return mb_name;
	}
	/**
	 * mb_name 설정자
	 * @param mb_name : 메뉴 소분류 이름
	 */
	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}
}