/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

import java.util.List;

/**
 * ChartDTO 클래스
 * 차트 데이터를 담을 DTO
 * @author Jo
 */
public class ChartDTO {
	/**
	 * 속성변수 선언
	 */

	private List<String> label; // 라벨1
	private List<String> label2; // 라벨2
	private List<String> label3; // 라벨3
	private List<String> label4; // 라벨4
	private List<String> data1; // 데이터1
	private List<String> data2; // 데이터2
	private List<String> data3; // 데이터3
	private List<String> data4; // 데이터4
	private List<String> dataset; // 데이터 세트
	private List<String> dataset2; // 데이터 세트2
	
	/**
	 * 접근자, 설정자 선언
	 */
	
	/**
	 * label 접근자
	 * @return label : 라벨1
	 */
	public List<String> getLabel() {
		return label;
	}

	/**
	 * label 접근자
	 * @return label : 라벨1
	 */
	public void setLabel(List<String> label) {
		this.label = label;
	}

	/**
	 * label2 접근자
	 * @return label2 : 라벨2
	 */
	public List<String> getLabel2() {
		return label2;
	}
	

	/**
	 * label2 접근자
	 * @return label2 : 라벨2
	 */
	public void setLabel2(List<String> label2) {
		this.label2 = label2;
	}

	/**
	 * label3 접근자
	 * @return label3 : 라벨3
	 */
	public List<String> getLabel3() {
		return label3;
	}
	
	/**
	 * label3 접근자
	 * @return label3 : 라벨3
	 */
	public void setLabel3(List<String> label3) {
		this.label3 = label3;
	}
	
	/**
	 * label4 접근자
	 * @return label4 : 라벨4
	 */
	public List<String> getLabel4() {
		return label4;
	}

	/**
	 * label4 접근자
	 * @return label4 : 라벨4
	 */
	public void setLabel4(List<String> label4) {
		this.label4 = label4;
	}

	/**
	 * data1 접근자
	 * @return data1 : 데이터1
	 */
	public List<String> getData1() {
		return data1;
	}

	/**
	 * data1 접근자
	 * @return data1 : 데이터1
	 */
	public void setData1(List<String> data1) {
		this.data1 = data1;
	}

	/**
	 * data2 접근자
	 * @return data2 : 데이터2
	 */
	public List<String> getData2() {
		return data2;
	}

	/**
	 * data2 접근자
	 * @return data2 : 데이터2
	 */
	public void setData2(List<String> data2) {
		this.data2 = data2;
	}

	/**
	 * data3 접근자
	 * @return data3 : 데이터3
	 */
	public List<String> getData3() {
		return data3;
	}

	/**
	 * data3 접근자
	 * @return data3 : 데이터3
	 */
	public void setData3(List<String> data3) {
		this.data3 = data3;
	}

	/**
	 * data4 접근자
	 * @return data4 : 데이터4
	 */
	public List<String> getData4() {
		return data4;
	}

	/**
	 * data4 접근자
	 * @return data4 : 데이터4
	 */
	public void setData4(List<String> data4) {
		this.data4 = data4;
	}

	/**
	 * dataset 접근자
	 * @return dataset : 데이터 세트1
	 */
	public List<String> getDataset() {
		return dataset;
	}

	/**
	 * dataset 접근자
	 * @return dataset : 데이터 세트1
	 */
	public void setDataset(List<String> dataset) {
		this.dataset = dataset;
	}

	/**
	 * dataset2 접근자
	 * @return dataset2 : 데이터 세트2
	 */
	public List<String> getDataset2() {
		return dataset2;
	}

	/**
	 * dataset2 접근자
	 * @return dataset2 : 데이터 세트2
	 */
	public void setDataset2(List<String> dataset2) {
		this.dataset2 = dataset2;
	}

}