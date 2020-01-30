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
	private String ia_name;
	private List<Code_IngredientAlphaDTO> ia_nameList;		//DB에서 가져온 대분류값
	
	private String ib_name;
	
	private List<Code_IngredientBetaDTO> ib_nameList;		//DB에서 가져온 소분류값
	
	private String io_name;
	
	private List<Code_IngredientOriginDTO> io_nameList;	//DB에서 가져온 원산지값
	
	private String[] a_name;
	private List<Code_IngredientAllergieDTO> a_nameList;	//DB에서 가져온 알레르기 값
	
	private String s_id;
	/**
	 * 생성자 선언
	 */

	/**
	 * 접근자, 설정자 선언
	 */
	/**
	 * ia_code 접근자
	 * @return ia_code : 
	 */

	/**
	 * ia_name 접근자
	 * @return ia_name : 
	 */
	public String getIa_name() {
		return ia_name;
	}

	/**
	 * ia_name 설정자
	 * @param ia_name : 
	 */
	public void setIa_name(String ia_name) {
		this.ia_name = ia_name;
	}

	/**
	 * ia_nameList 접근자
	 * @return ia_nameList : 
	 */
	public List<Code_IngredientAlphaDTO> getIa_nameList() {
		return ia_nameList;
	}

	/**
	 * ia_nameList 설정자
	 * @param ia_nameList : 
	 */
	public void setIa_nameList(List<Code_IngredientAlphaDTO> ia_nameList) {
		this.ia_nameList = ia_nameList;
	}

	/**
	 * ib_code 접근자
	 * @return ib_code : 
	 */
	

	/**
	 * ib_name 접근자
	 * @return ib_name : 
	 */
	public String getIb_name() {
		return ib_name;
	}

	/**
	 * ib_name 설정자
	 * @param ib_name : 
	 */
	public void setIb_name(String ib_name) {
		this.ib_name = ib_name;
	}

	/**
	 * ib_nameList 접근자
	 * @return ib_nameList : 
	 */
	public List<Code_IngredientBetaDTO> getIb_nameList() {
		return ib_nameList;
	}

	/**
	 * ib_nameList 설정자
	 * @param ib_nameList : 
	 */
	public void setIb_nameList(List<Code_IngredientBetaDTO> ib_nameList) {
		this.ib_nameList = ib_nameList;
	}

	/**
	 * io_code 접근자
	 * @return io_code : 
	 */

	/**
	 * io_name 접근자
	 * @return io_name : 
	 */
	public String getIo_name() {
		return io_name;
	}

	/**
	 * io_name 설정자
	 * @param io_name : 
	 */
	public void setIo_name(String io_name) {
		this.io_name = io_name;
	}

	/**
	 * io_nameList 접근자
	 * @return io_nameList : 
	 */
	public List<Code_IngredientOriginDTO> getIo_nameList() {
		return io_nameList;
	}

	/**
	 * io_nameList 설정자
	 * @param io_nameList : 
	 */
	public void setIo_nameList(List<Code_IngredientOriginDTO> io_nameList) {
		this.io_nameList = io_nameList;
	}

	/**
	 * a_code 접근자
	 * @return a_code : 
	 */
	/**
	 * a_name 접근자
	 * @return a_name : 
	 */
	public String[] getA_name() {
		return a_name;
	}

	/**
	 * a_name 설정자
	 * @param a_name : 
	 */
	public void setA_name(String[] a_name) {
		this.a_name = a_name;
	}

	/**
	 * a_nameList 접근자
	 * @return a_nameList : 
	 */
	public List<Code_IngredientAllergieDTO> getA_nameList() {
		return a_nameList;
	}

	/**
	 * a_nameList 설정자
	 * @param a_nameList : 
	 */
	public void setA_nameList(List<Code_IngredientAllergieDTO> a_nameList) {
		this.a_nameList = a_nameList;
	}

	/**
	 * s_id 접근자
	 * @return s_id : 
	 */
	public String getS_id() {
		return s_id;
	}

	/**
	 * s_id 설정자
	 * @param s_id : 
	 */
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
}