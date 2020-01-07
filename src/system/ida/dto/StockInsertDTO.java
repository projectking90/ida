package system.ida.dto;

public class StockInsertDTO {
	private int st_no;
	private int i_no;
	private int quantity;
	private String st_state;
	
	public int getSt_no() {
		return st_no;
	}
	public void setSt_no(int st_no) {
		this.st_no = st_no;
	}
	public int getI_no() {
		return i_no;
	}
	public void setI_no(int i_no) {
		this.i_no = i_no;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getSt_state() {
		return st_state;
	}
	public void setSt_state(String st_state) {
		this.st_state = st_state;
	}	
	
}
