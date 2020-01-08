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
	private String ia;			//선택한 대분류이름
	
	private List<Code_IngredientAlphaDTO> ia_nameList;		//DB에서 가져온 대분류값
	
	private String ib;			//선택한 소분류이름
	
	private List<Code_IngredientBetaDTO> ib_nameList;		//DB에서 가져온 소분류값
	
	private String io;			//선택한 원산지이름
	
	private List<Code_IngredientOriginDTO> io_nameList;	//DB에서 가져온 원산지값
	/**
	 * 생성자 선언
	 */

	/**
	 * 접근자, 설정자 선언
	 */

	public String getIa() {
		return ia;
	}
	public void setIa(String ia) {
		this.ia = ia;
	}
	public List<Code_IngredientAlphaDTO> getIa_nameList() {
		return ia_nameList;
	}
	public void setIa_nameList(List<Code_IngredientAlphaDTO> ia_nameList) {
		this.ia_nameList = ia_nameList;
	}
	public String getIb() {
		return ib;
	}
	public void setIb(String ib) {
		this.ib = ib;
	}
	public List<Code_IngredientBetaDTO> getIb_nameList() {
		return ib_nameList;
	}
	public void setIb_nameList(List<Code_IngredientBetaDTO> ib_nameList) {
		this.ib_nameList = ib_nameList;
	}
	public String getIo() {
		return io;
	}
	public void setIo(String io) {
		this.io = io;
	}
	public List<Code_IngredientOriginDTO> getIo_nameList() {
		return io_nameList;
	}
	public void setIo_nameList(List<Code_IngredientOriginDTO> io_nameList) {
		this.io_nameList = io_nameList;
	}


}