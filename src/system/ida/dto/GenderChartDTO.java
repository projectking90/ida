/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

import java.util.List;

/**
 * GenderChartDTO 클래스
 * 성별 차트 DTO
 * @author Jo
 */
public class GenderChartDTO {
	/**
	 * 속성변수 선언
	 */
	private List<String> label1;	// 라벨 1
	private List<String> label2;	// 라벨 2
	private List<String> data1;	// 데이터 1
	private List<String> data2;	// 데이터 2
	private List<String> dataset;	// 데이터 셋트
	
	/**
	 * 접근자, 설정자 선언
	 */
	/**
	 * label1 접근자
	 * @return label1 : 라벨 1
	 */
	public List<String> getLabel1() {
		return label1;
	}
	/**
	 * label1 설정자
	 * @param label1 : 라벨 1
	 */
	public void setLabel1(List<String> label1) {
		this.label1 = label1;
	}
	/**
	 * label2 접근자
	 * @return label2 : 라벨 2
	 */
	public List<String> getLabel2() {
		return label2;
	}
	/**
	 * label2 설정자
	 * @param label2 : 라벨 2
	 */
	public void setLabel2(List<String> label2) {
		this.label2 = label2;
	}
	/**
	 * data1 접근자
	 * @return data1 : 데이터 1
	 */
	public List<String> getData1() {
		return data1;
	}
	/**
	 * data1 설정자
	 * @param data1 : 데이터 1
	 */
	public void setData1(List<String> data1) {
		this.data1 = data1;
	}
	/**
	 * data2 접근자
	 * @return data2 : 데이터 2
	 */
	public List<String> getData2() {
		return data2;
	}
	/**
	 * data2 설정자
	 * @param data2 : 데이터 2
	 */
	public void setData2(List<String> data2) {
		this.data2 = data2;
	}
	/**
	 * dataset 접근자
	 * @return dataset : 데이터 셋트
	 */
	public List<String> getDataset() {
		return dataset;
	}
	/**
	 * dataset 설정자
	 * @param dataset : 데이터 셋트
	 */
	public void setDataset(List<String> dataset) {
		this.dataset = dataset;
	}
}