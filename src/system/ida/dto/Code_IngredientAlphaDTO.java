/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

/**
 * IngredientAlphaDTO 클래스
 * 식자재 수정할 때  사용할  대분류 DTO
 * @author Jo
 */
public class Code_IngredientAlphaDTO {
	/**
	 * 속성변수 선언
	 */
	private String ia_name;		//option 태그의 value 값
	/**
	 * 생성자 선언
	 */

	/**
	 * 접근자, 설정자 선언
	 */

	public String getIa_name() {
		return ia_name;
	}

	public void setIa_name(String ia_name) {
		this.ia_name = ia_name;
	}

	
}