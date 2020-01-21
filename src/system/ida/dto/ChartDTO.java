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
	private List<String> data1;
	private List<String> data2;
	private List<String> dataset;
	public List<String> getLabel() {
		return label;
	}
	public void setLabel(List<String> label) {
		this.label = label;
	}
	public List<String> getData1() {
		return data1;
	}
	public void setData1(List<String> data1) {
		this.data1 = data1;
	}
	public List<String> getData2() {
		return data2;
	}
	public void setData2(List<String> data2) {
		this.data2 = data2;
	}
	public List<String> getDataset() {
		return dataset;
	}
	public void setDataset(List<String> dataset) {
		this.dataset = dataset;
	}
	

	/**
	 * 생성자 선언
	 */


	


}