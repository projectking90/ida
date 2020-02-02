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
	private List<IngredientDTO> i_nameList1;
	private List<IngredientDTO> i_nameList2;
	private List<IngredientDTO> i_nameList3;
	private List<IngredientDTO> i_nameList4;
	private List<IngredientDTO> i_nameList5;
	private List<IngredientDTO> i_nameList6;
	
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
	 * i_nameList1 접근자
	 * @return i_nameList1 : 
	 */
	public List<IngredientDTO> getI_nameList1() {
		return i_nameList1;
	}
	/**
	 * i_nameList1 설정자
	 * @param i_nameList1 : 
	 */
	public void setI_nameList1(List<IngredientDTO> i_nameList1) {
		this.i_nameList1 = i_nameList1;
	}
	/**
	 * i_nameList2 접근자
	 * @return i_nameList2 : 
	 */
	public List<IngredientDTO> getI_nameList2() {
		return i_nameList2;
	}
	/**
	 * i_nameList2 설정자
	 * @param i_nameList2 : 
	 */
	public void setI_nameList2(List<IngredientDTO> i_nameList2) {
		this.i_nameList2 = i_nameList2;
	}
	/**
	 * i_nameList3 접근자
	 * @return i_nameList3 : 
	 */
	public List<IngredientDTO> getI_nameList3() {
		return i_nameList3;
	}
	/**
	 * i_nameList3 설정자
	 * @param i_nameList3 : 
	 */
	public void setI_nameList3(List<IngredientDTO> i_nameList3) {
		this.i_nameList3 = i_nameList3;
	}
	/**
	 * i_nameList4 접근자
	 * @return i_nameList4 : 
	 */
	public List<IngredientDTO> getI_nameList4() {
		return i_nameList4;
	}
	/**
	 * i_nameList4 설정자
	 * @param i_nameList4 : 
	 */
	public void setI_nameList4(List<IngredientDTO> i_nameList4) {
		this.i_nameList4 = i_nameList4;
	}
	/**
	 * i_nameList5 접근자
	 * @return i_nameList5 : 
	 */
	public List<IngredientDTO> getI_nameList5() {
		return i_nameList5;
	}
	/**
	 * i_nameList5 설정자
	 * @param i_nameList5 : 
	 */
	public void setI_nameList5(List<IngredientDTO> i_nameList5) {
		this.i_nameList5 = i_nameList5;
	}
	/**
	 * i_nameList6 접근자
	 * @return i_nameList6 : 
	 */
	public List<IngredientDTO> getI_nameList6() {
		return i_nameList6;
	}
	/**
	 * i_nameList6 설정자
	 * @param i_nameList6 : 
	 */
	public void setI_nameList6(List<IngredientDTO> i_nameList6) {
		this.i_nameList6 = i_nameList6;
	}
	

	
	/**
	 * 생성자 선언
	 */
	/**
	 * 접근자, 설정자 선언
	 */

	
}