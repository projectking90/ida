/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

/**
 * Code_IngredientOriginDTO 클래스
 * 식자재 원산지 DTO
 * @author Jo
 */
public class Code_IngredientOriginDTO {
	/**
	 * 속성변수 선언
	 */
	private String io_name;	// 식자재 원산지 이름

	/**
	 * 접근자, 설정자 선언
	 */
	/**
	 * io_name 접근자
	 * @return io_name : 식자재 원산지 이름
	 */
	public String getIo_name() {
		return io_name;
	}
	/**
	 * io_name 설정자
	 * @param io_name : 식자재 원산지 이름
	 */
	public void setIo_name(String io_name) {
		this.io_name = io_name;
	}
}