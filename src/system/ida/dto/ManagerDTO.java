/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dto;

/**
 * ManagerDTO 클래스
 * 관리자 정보를 저장할 DTO
 * @author Jo
 */
public class ManagerDTO {
	/**
	 * 속성변수 선언
	 */
	private String m_id;	// 아이디
	private String pwd;	// 비밀번호
	private String m_name;	// 이름
	private String email;	// 이메일

	/**
	 * 생성자 선언
	 */

	/**
	 * 접근자, 설정자 선언
	 */
	/**
	 * m_id 접근자
	 * @return m_id : 아이디
	 */
	public String getM_id() {
		return m_id;
	}
	/**
	 * m_id 설정자
	 * @param m_id : 아이디
	 */
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	/**
	 * pwd 접근자
	 * @return pwd : 비밀번호
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * pwd 설정자
	 * @param pwd : 비밀번호
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * m_name 접근자
	 * @return m_name : 이름
	 */
	public String getM_name() {
		return m_name;
	}
	/**
	 * m_name 설정자
	 * @param m_name : 이름
	 */
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	/**
	 * email 접근자
	 * @return email : 이메일
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * email 설정자
	 * @param email : 이메일
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}