/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

/**
 * Code_IngredientBetaDTO 클래스
 * 식재자  소분류 DTO
 * @author Jo
 */
public class Code_IngredientBetaDTO {
	/**
	 * 속성변수 선언
	 */
	private String ib_name;	// 식자재 소분류 이름

	/**
	 * 접근자, 설정자 선언
	 */
	/**
	 * ib_name 접근자
	 * @return ib_name : 식자재 소분류 이름
	 */
	public String getIb_name() {
		return ib_name;
	}
	/**
	 * ib_name 설정자
	 * @param ib_name : 식자재 소분류 이름
	 */
	public void setIb_name(String ib_name) {
		this.ib_name = ib_name;
	}
}