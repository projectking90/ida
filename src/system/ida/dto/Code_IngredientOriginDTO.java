/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

/**
 * IngredientOriginDTO 클래스
 * 식자재 수정 할 때  사용할  원산지 DTO
 * @author Jo
 */
public class Code_IngredientOriginDTO {
	/**
	 * 속성변수 선언
	 */
	private String io_name;		//option 태그의 value 값
	/**
	 * 생성자 선언
	 */


	/**
	 * 접근자, 설정자 선언
	 */
	

	public String getIo_name() {
		return io_name;
	}

	public void setIo_name(String io_name) {
		this.io_name = io_name;
	}

}