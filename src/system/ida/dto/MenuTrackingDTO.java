/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

/**
 * MenuTrackingDTO 클래스
 * 메뉴 트래킹 정보를 담은 DTO
 * @author Jo
 */
public class MenuTrackingDTO {
	/**
	 * 속성변수 선언
	 */
	private String path;	// 경로
	private String label;	// 메뉴명
	private String before_path;	// 이전경로

	/**
	 * 접근자, 설정자 선언
	 */
	/**
	 * path 접근자
	 * @return path : 경로
	 */
	public String getPath() {
		return path;
	}
	/**
	 * path 설정자
	 * @param path : 경로
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * label 접근자
	 * @return label : 메뉴명
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * label 설정자
	 * @param label : 메뉴명
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	/**
	 * before_path 접근자
	 * @return before_path : 이전경로
	 */
	public String getBefore_path() {
		return before_path;
	}
	/**
	 * before_path 설정자
	 * @param before_path : 이전경로
	 */
	public void setBefore_path(String before_path) {
		this.before_path = before_path;
	}
}