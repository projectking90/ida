package system.ida.dto;

/**
 * OrderSearchDTO 클래스
 * 주문 검색 DTO
 * @author Jo
 */
public class OrderSearchDTO {
	/**
	 * 속성변수 선언
	 */
	private String s_id;	// 아이디
	private String[] search_condition;	// 검색 조건
	private String keyword;	// 키워드
	
	/**
	 * 메소드 선언
	 */
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
}