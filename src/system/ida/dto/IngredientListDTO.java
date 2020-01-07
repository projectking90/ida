/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

import java.util.List;

/**
 * MenuDTO 클래스
 * 메뉴를 추가, 수정, 삭제할 때 사용할 DTO
 * @author Jo
 */
public class IngredientListDTO {
	/**
	 * 속성변수 선언
	 */
	private String i_no;
	private String i_name;
	private List<IngredientDTO> i_nameList;	// 데이터베이스에서 가져온 i_name 값
	
	
	public String getI_no() {
		return i_no;
	}
	public void setI_no(String i_no) {
		this.i_no = i_no;
	}
	public String getI_name() {
		return i_name;
	}
	public void setI_name(String i_name) {
		this.i_name = i_name;
	}
	public List<IngredientDTO> getI_nameList() {
		return i_nameList;
	}
	public void setI_nameList(List<IngredientDTO> i_nameList) {
		this.i_nameList = i_nameList;
	}
	

	
	/**
	 * 생성자 선언
	 */
	/**
	 * 접근자, 설정자 선언
	 */

	
}