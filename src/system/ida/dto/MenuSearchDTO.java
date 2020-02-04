/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

/**
 * MenuSearchDTO 클래스
 * 메뉴 검색 DTO
 * @author Jo
 */
public class MenuSearchDTO {
	/**
	 * 속성변수 선언
	 */
	private String keyword;	// 키워드
	private int select_page_no;	// 페이지 번호
	private int row_cnt_per_page;	// 행 갯수
	private String s_id;	// 아이디
	private String mi_no;	// 메뉴 번호
	private String[] search_condition;	// 검색 조건

	/**
	 * 생성자 선언
	 */
	public MenuSearchDTO() {
		this.setSelect_page_no(1);
		this.setRow_cnt_per_page(10);
	}
	
	/**
	 * 접근자, 설정자 선언
	 */
	/**
	 * keyword 접근자
	 * @return keyword : 키워드
	 */
	public String getKeyword() {
		return keyword;
	}
	/**
	 * keyword 설정자
	 * @param keyword : 키워드
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	/**
	 * select_page_no 접근자
	 * @return select_page_no : 페이지 번호
	 */
	public int getSelect_page_no() {
		return select_page_no;
	}
	/**
	 * select_page_no 설정자
	 * @param select_page_no : 페이지 번호
	 */
	public void setSelect_page_no(int select_page_no) {
		this.select_page_no = select_page_no;
	}
	/**
	 * row_cnt_per_page 접근자
	 * @return row_cnt_per_page : 행 갯수
	 */
	public int getRow_cnt_per_page() {
		return row_cnt_per_page;
	}
	/**
	 * row_cnt_per_page 설정자
	 * @param row_cnt_per_page : 행 갯수
	 */
	public void setRow_cnt_per_page(int row_cnt_per_page) {
		this.row_cnt_per_page = row_cnt_per_page;
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
	 * mi_no 접근자
	 * @return mi_no : 메뉴 번호
	 */
	public String getMi_no() {
		return mi_no;
	}
	/**
	 * mi_no 설정자
	 * @param mi_no : 메뉴 번호
	 */
	public void setMi_no(String mi_no) {
		this.mi_no = mi_no;
	}
	/**
	 * search_condition 접근자
	 * @return search_condition : 검색 조건
	 */
	public String[] getSearch_condition() {
		return search_condition;
	}
	/**
	 * search_condition 설정자
	 * @param search_condition : 검색 조건
	 */
	public void setSearch_condition(String[] search_condition) {
		this.search_condition = search_condition;
	}
}