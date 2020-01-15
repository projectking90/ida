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
public class MenuListDTO {
	/**
	 * 속성변수 선언
	 */
	private String mi_no;
	private String mi_name;
	private List<MenuDTO> mi_nameList;	// 데이터베이스에서 가져온 mi_name 값
	
	public String getMi_no() {
		return mi_no;
	}
	public void setMi_no(String mi_no) {
		this.mi_no = mi_no;
	}
	public String getMi_name() {
		return mi_name;
	}
	public void setMi_name(String mi_name) {
		this.mi_name = mi_name;
	}
	public List<MenuDTO> getMi_nameList() {
		return mi_nameList;
	}
	public void setMi_nameList(List<MenuDTO> mi_nameList) {
		this.mi_nameList = mi_nameList;
	}
	

	

	
	/**
	 * 생성자 선언
	 */
	/**
	 * 접근자, 설정자 선언
	 */

	
}