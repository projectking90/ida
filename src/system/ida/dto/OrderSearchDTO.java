
package system.ida.dto;

public class OrderSearchDTO {
	
	private String s_id;
	private String[] search_condition;
	private String keyword;

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public String[] getSearch_condition() {
		return search_condition;
	}

	public void setSearch_condition(String[] search_condition) {
		this.search_condition = search_condition;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
