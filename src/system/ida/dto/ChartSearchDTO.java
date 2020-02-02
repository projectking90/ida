/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

/**
 * ChartSearchDTO 클래스
 * 차트 검색할 때 사용할 DTO
 * @author Jo
 */
public class ChartSearchDTO {
	/**
	 * 속성변수 선언
	 */
	private String s_id;
	private String chart_cnt;
	private String age;
	private String week;
	private String month;
	private String year;
	private String quarter;
	
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
	/**
	 * chart_cnt 접근자
	 * @return chart_cnt : 
	 */
	public String getChart_cnt() {
		return chart_cnt;
	}
	/**
	 * chart_cnt 설정자
	 * @param chart_cnt : 
	 */
	public void setChart_cnt(String chart_cnt) {
		this.chart_cnt = chart_cnt;
	}
	/**
	 * age 접근자
	 * @return age : 
	 */
	public String getAge() {
		return age;
	}
	/**
	 * age 설정자
	 * @param age : 
	 */
	public void setAge(String age) {
		this.age = age;
	}
	/**
	 * week 접근자
	 * @return week : 
	 */
	public String getWeek() {
		return week;
	}
	/**
	 * week 설정자
	 * @param week : 
	 */
	public void setWeek(String week) {
		this.week = week;
	}
	/**
	 * month 접근자
	 * @return month : 
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * month 설정자
	 * @param month : 
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * year 접근자
	 * @return year : 
	 */
	public String getYear() {
		return year;
	}
	/**
	 * year 설정자
	 * @param year : 
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * quarter 접근자
	 * @return quarter : 
	 */
	public String getQuarter() {
		return quarter;
	}
	/**
	 * quarter 설정자
	 * @param quarter : 
	 */
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
}