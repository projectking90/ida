/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

import java.util.List;

/**
 * IngredientOriginDTO 클래스
 * 식자재 수정 할 때  사용할  원산지 DTO
 * @author Jo
 */
public class Code_ingredientDTO {
	/**
	 * 속성변수 선언
	 */
	private int ia_code;
	private String ia_name;
	private List<Code_IngredientAlphaDTO> ia_nameList;		//DB에서 가져온 대분류값
	
	private int ib_code;
	private String ib_name;
	
	private List<Code_IngredientBetaDTO> ib_nameList;		//DB에서 가져온 소분류값

	private int io_code;
	private String io_name;
	
	private List<Code_IngredientOriginDTO> io_nameList;	//DB에서 가져온 원산지값
	
	private int a_code;
	private String[] a_name;
	private List<Code_IngredientAllergieDTO> a_nameList;	//DB에서 가져온 알레르기 값
	
	private String s_id;
	/**
	 * 생성자 선언
	 */

	public int getIa_code() {
		return ia_code;
	}

	public void setIa_code(int ia_code) {
		this.ia_code = ia_code;
	}

	public String getIa_name() {
		return ia_name;
	}

	public void setIa_name(String ia_name) {
		this.ia_name = ia_name;
	}

	public List<Code_IngredientAlphaDTO> getIa_nameList() {
		return ia_nameList;
	}

	public void setIa_nameList(List<Code_IngredientAlphaDTO> ia_nameList) {
		this.ia_nameList = ia_nameList;
	}

	public int getIb_code() {
		return ib_code;
	}

	public void setIb_code(int ib_code) {
		this.ib_code = ib_code;
	}

	public String getIb_name() {
		return ib_name;
	}

	public void setIb_name(String ib_name) {
		this.ib_name = ib_name;
	}

	public List<Code_IngredientBetaDTO> getIb_nameList() {
		return ib_nameList;
	}

	public void setIb_nameList(List<Code_IngredientBetaDTO> ib_nameList) {
		this.ib_nameList = ib_nameList;
	}

	public int getIo_code() {
		return io_code;
	}

	public void setIo_code(int io_code) {
		this.io_code = io_code;
	}

	public String getIo_name() {
		return io_name;
	}

	public void setIo_name(String io_name) {
		this.io_name = io_name;
	}

	public List<Code_IngredientOriginDTO> getIo_nameList() {
		return io_nameList;
	}

	public void setIo_nameList(List<Code_IngredientOriginDTO> io_nameList) {
		this.io_nameList = io_nameList;
	}

	public int getA_code() {
		return a_code;
	}

	public void setA_code(int a_code) {
		this.a_code = a_code;
	}

	public String[] getA_name() {
		return a_name;
	}

	public void setA_name(String[] a_name) {
		this.a_name = a_name;
	}

	public List<Code_IngredientAllergieDTO> getA_nameList() {
		return a_nameList;
	}

	public void setA_nameList(List<Code_IngredientAllergieDTO> a_nameList) {
		this.a_nameList = a_nameList;
	}

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	
}