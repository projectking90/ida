/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

import java.util.List;

/**
 * Code_ingredientDTO 클래스
 * 식자재 DTO
 * @author Jo
 */
public class Code_ingredientDTO {
	/**
	 * 속성변수 선언
	 */
	private int ia_code;	// 식자재 대분류 코드
	private String ia_name;	// 식자재 대분류 이름
	private List<Code_IngredientAlphaDTO> ia_nameList;	// 식자재 대분류 목록
	private int ib_code;	// 식자재 소분류 코드
	private String ib_name;	// 식자재 소분류 이름
	private List<Code_IngredientBetaDTO> ib_nameList;	// 식자재 소분류 목록
	private int io_code;	// 식자재 원산지 코드
	private String io_name;	// 식자재 원산지 이름
	private List<Code_IngredientOriginDTO> io_nameList;	// 식자재 원산지 목록
	private int a_code;	// 식자재 알레르기 코드
	private String[] a_name;	// 식자재 알레르기 이름
	private List<Code_IngredientAllergieDTO> a_nameList;	// 식자재 알레르기 목록
	private String s_id;	// 아이디

	/**
	 * 접근자, 설정자 선언
	 */
	/**
	 * ia_code 접근자
	 * @return ia_code : 식자재 대분류 코드
	 */
	public int getIa_code() {
		return ia_code;
	}
	/**
	 * ia_code 설정자
	 * @param ia_code : 식자재 대분류 코드
	 */
	public void setIa_code(int ia_code) {
		this.ia_code = ia_code;
	}
	/**
	 * ia_name 접근자
	 * @return ia_name : 식자재 대분류 이름
	 */
	public String getIa_name() {
		return ia_name;
	}
	/**
	 * ia_name 설정자
	 * @param ia_name : 식자재 대분류 이름
	 */
	public void setIa_name(String ia_name) {
		this.ia_name = ia_name;
	}
	/**
	 * ia_nameList 접근자
	 * @return ia_nameList : 식자재 대분류 목록
	 */
	public List<Code_IngredientAlphaDTO> getIa_nameList() {
		return ia_nameList;
	}
	/**
	 * ia_nameList 설정자
	 * @param ia_nameList : 식자재 대분류 목록
	 */
	public void setIa_nameList(List<Code_IngredientAlphaDTO> ia_nameList) {
		this.ia_nameList = ia_nameList;
	}
	/**
	 * ib_code 접근자
	 * @return ib_code : 식자재 소분류 코드
	 */
	public int getIb_code() {
		return ib_code;
	}
	/**
	 * ib_code 설정자
	 * @param ib_code : 식자재 소분류 코드
	 */
	public void setIb_code(int ib_code) {
		this.ib_code = ib_code;
	}
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
	/**
	 * ib_nameList 접근자
	 * @return ib_nameList : 식자재 소분류 목록
	 */
	public List<Code_IngredientBetaDTO> getIb_nameList() {
		return ib_nameList;
	}
	/**
	 * ib_nameList 설정자
	 * @param ib_nameList : 식자재 소분류 목록
	 */
	public void setIb_nameList(List<Code_IngredientBetaDTO> ib_nameList) {
		this.ib_nameList = ib_nameList;
	}
	/**
	 * io_code 접근자
	 * @return io_code : 식자재 원산지 코드
	 */
	public int getIo_code() {
		return io_code;
	}
	/**
	 * io_code 설정자
	 * @param io_code : 식자재 원산지 코드
	 */
	public void setIo_code(int io_code) {
		this.io_code = io_code;
	}
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
	/**
	 * io_nameList 접근자
	 * @return io_nameList : 식자재 원산지 목록
	 */
	public List<Code_IngredientOriginDTO> getIo_nameList() {
		return io_nameList;
	}
	/**
	 * io_nameList 설정자
	 * @param io_nameList : 식자재 원산지 목록
	 */
	public void setIo_nameList(List<Code_IngredientOriginDTO> io_nameList) {
		this.io_nameList = io_nameList;
	}
	/**
	 * a_code 접근자
	 * @return a_code : 식자재 알레르기 코드
	 */
	public int getA_code() {
		return a_code;
	}
	/**
	 * a_code 설정자
	 * @param a_code : 식자재 알레르기 코드
	 */
	public void setA_code(int a_code) {
		this.a_code = a_code;
	}
	/**
	 * a_name 접근자
	 * @return a_name : 식자재 알레르기 이름
	 */
	public String[] getA_name() {
		return a_name;
	}
	/**
	 * a_name 설정자
	 * @param a_name : 식자재 알레르기 이름
	 */
	public void setA_name(String[] a_name) {
		this.a_name = a_name;
	}
	/**
	 * a_nameList 접근자
	 * @return a_nameList : 식자재 알레르기 목록
	 */
	public List<Code_IngredientAllergieDTO> getA_nameList() {
		return a_nameList;
	}
	/**
	 * a_nameList 설정자
	 * @param a_nameList : 식자재 알레르기 목록
	 */
	public void setA_nameList(List<Code_IngredientAllergieDTO> a_nameList) {
		this.a_nameList = a_nameList;
	}
	/**
	 * s_id 접근자
	 * @return s_id : 아이디
	 */
	public String getS_id() {
		return s_id;
	}
	/**
	 * s_id 설정자
	 * @param s_id : 아이디
	 */
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
}