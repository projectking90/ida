/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

/**
 * IngredientBetaDTO 클래스
 * 식재자 수정 할 때  사용할  소분류 DTO
 * @author Jo
 */
public class Code_IngredientBetaDTO {
	/**
	 * 속성변수 선언
	 */
	private String ib_name;		//option 태그의 value 값
	/**
	 * 생성자 선언
	 */

	/**
	 * 접근자, 설정자 선언
	 */
	

	public String getIb_name() {
		return ib_name;
	}

	public void setIb_name(String ib_name) {
		this.ib_name = ib_name;
	}

}