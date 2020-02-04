package system.ida.dto;

/**
 * ShareDTO 클래스
 * 공유 정보를 담을 DTO
 * @author Jo
 */
public class ShareDTO {
	/**
	 * 속성변수 선언
	 */
	private int si_no;	// 공유 번호
	private int st_no;	// 재고 번호
	private int s_no;	// 사용자 번호
	private String com_name;	// 사용자 이름
	private String city;	// 시
	private String gun;	// 군
	private String gu;	// 구
	private String dong;	// 동
	private String ri;	// 리
	private String addr_detail;	// 상세 주소
	private String ia_name;	// 식자재 대분류 이름
	private String ib_name;	// 식자재 소분류 이름
	private String io_name;	// 식자재 원산지 이름
	private String i_name;	// 식자재 이름
	private int si_quantity;	// 공유 수량
	private String sr_state;	// 점입출상태
	private String reg_date;	// 등록일
	private String deal;	// 거래 조건
	private String s_id;	// 아이디
	private String r_reg_date;	// 요청 날짜
	private String a_reg_date;	// 승인 날짜
	private String s_phone;	// 핸드폰
	
	/**
	 * 메소드 선언
	 */
	/**
	 * si_no 접근자
	 * @return si_no : 공유 번호
	 */
	public int getSi_no() {
		return si_no;
	}
	/**
	 * si_no 설정자
	 * @param si_no : 공유 번호
	 */
	public void setSi_no(int si_no) {
		this.si_no = si_no;
	}
	/**
	 * st_no 접근자
	 * @return st_no : 재고 번호
	 */
	public int getSt_no() {
		return st_no;
	}
	/**
	 * st_no 설정자
	 * @param st_no : 재고 번호
	 */
	public void setSt_no(int st_no) {
		this.st_no = st_no;
	}
	/**
	 * s_no 접근자
	 * @return s_no : 사용자 번호
	 */
	public int getS_no() {
		return s_no;
	}
	/**
	 * s_no 설정자
	 * @param s_no : 사용자 번호
	 */
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	/**
	 * com_name 접근자
	 * @return com_name : 사용자 이름
	 */
	public String getCom_name() {
		return com_name;
	}
	/**
	 * com_name 설정자
	 * @param com_name : 사용자 이름
	 */
	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}
	/**
	 * city 접근자
	 * @return city : 시
	 */
	public String getCity() {
		return city;
	}
	/**
	 * city 설정자
	 * @param city : 시
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * gun 접근자
	 * @return gun : 군
	 */
	public String getGun() {
		return gun;
	}
	/**
	 * gun 설정자
	 * @param gun : 군
	 */
	public void setGun(String gun) {
		this.gun = gun;
	}
	/**
	 * gu 접근자
	 * @return gu : 구
	 */
	public String getGu() {
		return gu;
	}
	/**
	 * gu 설정자
	 * @param gu : 구
	 */
	public void setGu(String gu) {
		this.gu = gu;
	}
	/**
	 * dong 접근자
	 * @return dong : 동
	 */
	public String getDong() {
		return dong;
	}
	/**
	 * dong 설정자
	 * @param dong : 동
	 */
	public void setDong(String dong) {
		this.dong = dong;
	}
	/**
	 * ri 접근자
	 * @return ri : 리
	 */
	public String getRi() {
		return ri;
	}
	/**
	 * ri 설정자
	 * @param ri : 리
	 */
	public void setRi(String ri) {
		this.ri = ri;
	}
	/**
	 * addr_detail 접근자
	 * @return addr_detail : 상세 주소
	 */
	public String getAddr_detail() {
		return addr_detail;
	}
	/**
	 * addr_detail 설정자
	 * @param addr_detail : 상세 주소
	 */
	public void setAddr_detail(String addr_detail) {
		this.addr_detail = addr_detail;
	}
	/**
	 * ia_name 접근자
	 * @return ia_name : 식자재 대분류 이름
	 */
	public String getIa_name() {
		return ia_name;
	}
	/**
	 * ia_name 설정자
	 * @param ia_name : 식자재 대분류 이름
	 */
	public void setIa_name(String ia_name) {
		this.ia_name = ia_name;
	}
	/**
	 * ib_name 접근자
	 * @return ib_name : 식자재 소분류 이름
	 */
	public String getIb_name() {
		return ib_name;
	}
	/**
	 * ib_name 설정자
	 * @param ib_name : 식자재 소분류 이름
	 */
	public void setIb_name(String ib_name) {
		this.ib_name = ib_name;
	}
	/**
	 * io_name 접근자
	 * @return io_name : 식자재 원산지 이름
	 */
	public String getIo_name() {
		return io_name;
	}
	/**
	 * io_name 설정자
	 * @param io_name : 식자재 원산지 이름
	 */
	public void setIo_name(String io_name) {
		this.io_name = io_name;
	}
	/**
	 * i_name 접근자
	 * @return i_name : 식자재 이름
	 */
	public String getI_name() {
		return i_name;
	}
	/**
	 * i_name 설정자
	 * @param i_name : 식자재 이름
	 */
	public void setI_name(String i_name) {
		this.i_name = i_name;
	}
	/**
	 * si_quantity 접근자
	 * @return si_quantity : 공유 수량
	 */
	public int getSi_quantity() {
		return si_quantity;
	}
	/**
	 * si_quantity 설정자
	 * @param si_quantity : 공유 수량
	 */
	public void setSi_quantity(int si_quantity) {
		this.si_quantity = si_quantity;
	}
	/**
	 * sr_state 접근자
	 * @return sr_state : 점입출상태
	 */
	public String getSr_state() {
		return sr_state;
	}
	/**
	 * sr_state 설정자
	 * @param sr_state : 점입출상태
	 */
	public void setSr_state(String sr_state) {
		this.sr_state = sr_state;
	}
	/**
	 * reg_date 접근자
	 * @return reg_date : 등록일
	 */
	public String getReg_date() {
		return reg_date;
	}
	/**
	 * reg_date 설정자
	 * @param reg_date : 등록일
	 */
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	/**
	 * deal 접근자
	 * @return deal : 거래 조건
	 */
	public String getDeal() {
		return deal;
	}
	/**
	 * deal 설정자
	 * @param deal : 거래 조건
	 */
	public void setDeal(String deal) {
		this.deal = deal;
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
	 * r_reg_date 접근자
	 * @return r_reg_date : 요청 날짜
	 */
	public String getR_reg_date() {
		return r_reg_date;
	}
	/**
	 * r_reg_date 설정자
	 * @param r_reg_date : 요청 날짜
	 */
	public void setR_reg_date(String r_reg_date) {
		this.r_reg_date = r_reg_date;
	}
	/**
	 * a_reg_date 접근자
	 * @return a_reg_date : 승인 날짜
	 */
	public String getA_reg_date() {
		return a_reg_date;
	}
	/**
	 * a_reg_date 설정자
	 * @param a_reg_date : 승인 날짜
	 */
	public void setA_reg_date(String a_reg_date) {
		this.a_reg_date = a_reg_date;
	}
	/**
	 * s_phone 접근자
	 * @return s_phone : 핸드폰
	 */
	public String getS_phone() {
		return s_phone;
	}
	/**
	 * s_phone 설정자
	 * @param s_phone : 핸드폰
	 */
	public void setS_phone(String s_phone) {
		this.s_phone = s_phone;
	}
}