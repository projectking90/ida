/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

/**
 * Code_IngredientAllergieDTO 클래스
 * 식자재  알레르기 DTO
 * @author Jo
 */
public class Code_IngredientAllergieDTO {
	/**
	 * 속성변수 선언
	 */
	private String a_name;	// 식자재 알레르기 이름


	/**
	 * 접근자, 설정자 선언
	 */
	/**
	 * a_name 접근자
	 * @return a_name : 식자재 알레르기 이름
	 */
	public String getA_name() {
		return a_name;
	}
	/**
	 * a_name 설정자
	 * @param a_name : 식자재 알레르기 이름
	 */
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
}