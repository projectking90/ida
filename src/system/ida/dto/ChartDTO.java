/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

import java.util.List;

/**
 * @author Jo
 */
public class ChartDTO {
	/**
	 * 속성변수 선언
	 */
	private List<String> label;
	private List<String> data;

	/**
	 * 생성자 선언
	 */

	/**
	 * 접근자, 설정자 선언
	 */
	/**
	 * label 접근자
	 * @return label : 
	 */
	public List<String> getLabel() {
		return label;
	}
	/**
	 * label 설정자
	 * @param label : 
	 */
	public void setLabel(List<String> label) {
		this.label = label;
	}
	/**
	 * data 접근자
	 * @return data : 
	 */
	public List<String> getData() {
		return data;
	}
	/**
	 * data 설정자
	 * @param data : 
	 */
	public void setData(List<String> data) {
		this.data = data;
	}
}