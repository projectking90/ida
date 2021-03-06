/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

import java.util.List;

/**
 * IngredientDTO 클래스
 * 식자재 정보를 담을 DTO
 * @author Jo
 */
public class IngredientDTO {
	/**
	 * 속성변수 선언
	 */
	private int i_no;	// 식자재 번호
	private int s_no;	// 가게 번호
	private String s_id;	// 아이디
	private String ia_name;	// 식자재 대분류
	private String ib_name;	// 식자재 소분류
	private String io_name;	// 식자재 원산지
	private String i_name;	// 식자재 이름
	private String i_size;	// 식자재 규격
	private String i_price;	// 식자재 가격
	private String reg_date;	// 식자재 등록일
	private String is_del;	// 삭제여부
	private List<Code_IngredientAlphaDTO> ia_nameList;	// 식자재 대분류 목록
	private List<Code_IngredientBetaDTO> ib_nameList;	// 식자재 소분류 목록
	private List<Code_IngredientOriginDTO> io_nameList;	// 식자재 원산지 목록

	/**
	 * 접근자, 설정자 선언
	 */
	/**
	 * i_no 접근자
	 * @return i_no : 식자재 번호
	 */
	public int getI_no() {
		return i_no;
	}
	/**
	 * i_no 설정자
	 * @param i_no : 식자재 번호
	 */
	public void setI_no(int i_no) {
		this.i_no = i_no;
	}
	/**
	 * s_no 접근자
	 * @return s_no : 가게 번호
	 */
	public int getS_no() {
		return s_no;
	}
	/**
	 * s_no 설정자
	 * @param s_no : 가게 번호
	 */
	public void setS_no(int s_no) {
		this.s_no = s_no;
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
	/**
	 * ia_name 접근자
	 * @return ia_name : 식자재 대분류
	 */
	public String getIa_name() {
		return ia_name;
	}
	/**
	 * ia_name 설정자
	 * @param ia_name : 식자재 대분류
	 */
	public void setIa_name(String ia_name) {
		this.ia_name = ia_name;
	}
	/**
	 * ib_name 접근자
	 * @return ib_name : 식자재 소분류
	 */
	public String getIb_name() {
		return ib_name;
	}
	/**
	 * ib_name 설정자
	 * @param ib_name : 식자재 소분류
	 */
	public void setIb_name(String ib_name) {
		this.ib_name = ib_name;
	}
	/**
	 * io_name 접근자
	 * @return io_name : 식자재 원산지
	 */
	public String getIo_name() {
		return io_name;
	}
	/**
	 * io_name 설정자
	 * @param io_name : 식자재 원산지
	 */
	public void setIo_name(String io_name) {
		this.io_name = io_name;
	}
	/**
	 * i_name 접근자
	 * @return i_name : 식자재 이름
	 */
	public String getI_name() {
		return i_name;
	}
	/**
	 * i_name 설정자
	 * @param i_name : 식자재 이름
	 */
	public void setI_name(String i_name) {
		this.i_name = i_name;
	}
	/**
	 * i_size 접근자
	 * @return i_size : 식자재 규격
	 */
	public String getI_size() {
		return i_size;
	}
	/**
	 * i_size 설정자
	 * @param i_size : 식자재 규격
	 */
	public void setI_size(String i_size) {
		this.i_size = i_size;
	}
	/**
	 * i_price 접근자
	 * @return i_price : 식자재 가격
	 */
	public String getI_price() {
		return i_price;
	}
	/**
	 * i_price 설정자
	 * @param i_price : 식자재 가격
	 */
	public void setI_price(String i_price) {
		this.i_price = i_price;
	}
	/**
	 * reg_date 접근자
	 * @return reg_date : 식자재 등록일
	 */
	public String getReg_date() {
		return reg_date;
	}
	/**
	 * reg_date 설정자
	 * @param reg_date : 식자재 등록일
	 */
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	/**
	 * is_del 접근자
	 * @return is_del : 삭제여부
	 */
	public String getIs_del() {
		return is_del;
	}
	/**
	 * is_del 설정자
	 * @param is_del : 삭제여부
	 */
	public void setIs_del(String is_del) {
		this.is_del = is_del;
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
}