/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import system.ida.dao.ShareDAO;
import system.ida.dao.StockDAO;
import system.ida.dto.ChartSearchDTO;
import system.ida.dto.IngredientDTO;
import system.ida.dto.ShareDTO;
import system.ida.dto.ShareSearchDTO;
import system.ida.dto.StockDTO;
import system.ida.dto.StockInsertDTO;
import system.ida.dto.StockSearchDTO;

/**
 * StockServiceImpl 클래스
 * 서비스 클래스
 * @author Jo
 */
@Service
@Transactional
public class ShareServiceImpl implements ShareService {
	/**
	 * 속성변수 선언
	 */
	@Autowired
	private ShareDAO shareDAO;	// StockDAO 인터페이스를 구현받은 객체를 생성해서 저장

	/**
	 * 메소드 선언
	 */
	@Override
	public List<ShareDTO> getDifferentShareList(ShareSearchDTO share_searchDTO){
		List<ShareDTO> different_share_list = this.shareDAO.getDifferentShareList(share_searchDTO);
		return different_share_list;
	}
	
	@Override
	public List<ShareDTO> getMyShareList(ShareSearchDTO share_searchDTO){
		List<ShareDTO> my_share_list = this.shareDAO.getMyShareList(share_searchDTO);
		return my_share_list;
	}
	
	@Override
	public List<StockDTO> getStockList(ShareSearchDTO share_searchDTO) {
		List<StockDTO> stock_list = this.shareDAO.getStockList(share_searchDTO);
		//System.out.println("service "+share_searchDTO.getS_id());
		return stock_list;
	}
	
	@Override
	public int insertShare(ShareDTO shareDTO) {
		// 이미 등록된 공유 재고 개수 count
		int inserted_share_cnt=this.shareDAO.getInsertedShareCnt(shareDTO); 
		// 같은 공유 재고가 등록되었지만 삭제된 것 count
		//int deleted_share_cnt=this.shareDAO.getDeletedShareCnt(shareDTO);
		// 이미 같은 상태로 등록된 공유 재고의 개수가 0보다 클 때
		if(inserted_share_cnt>0) {
			return -2;
		}
		// 등록되었지만 삭제된 재고가 있을 때 
		
		/*else if(deleted_share_cnt>0) {
			int share_isDel_update_cnt=this.shareDAO.changeInsertedShareIsDel(shareDTO);
			if(share_isDel_update_cnt>0) {
				// 기록 남기기
				int share_record_insert=this.shareDAO.insertStockRecord(shareDTO);
				if(share_record_insert>0) {
					return -3;	
				}
			}
		}*/
		// 재고가 없을 때
		else { 
			int share_reg_cnt=this.shareDAO.insertShare(shareDTO);
			// 추가 
			if(share_reg_cnt>0) {
				// 기록 남기기
				int share_record_insert=this.shareDAO.insertStockRecord(shareDTO);
				if(share_record_insert>0) {
					return 1;	
				}
			}
		}
		return -1;
	}

	@Override
	public ShareDTO getShareDTO(int si_no) {
		ShareDTO shareDTO = this.shareDAO.getShareDTO(si_no);
		return shareDTO;
	}

	@Override
	public int updateShare(ShareDTO shareDTO) {
		int shareCnt=this.shareDAO.getMyShareCnt(shareDTO);
		System.out.println("shareCnt "+shareCnt);
		if(shareCnt==0) {return -2;}
		
		int share_update_cnt=this.shareDAO.updateShare(shareDTO);
		
		return share_update_cnt;
	}

	@Override
	public int deleteShare(ShareDTO shareDTO) {
		int shareCnt=this.shareDAO.getMyShareCnt(shareDTO);
		if(shareCnt==0) {return -2;}
		
		int share_delete_cnt=this.shareDAO.deleteShare(shareDTO);
		int share_record_delete=this.shareDAO.deleteStockRecord(shareDTO);
		if(share_record_delete==1) {
			return share_delete_cnt;
		}
		return -1;
	}

	@Override
	public int requestShare(ShareDTO shareDTO) {
		int share_request_cnt=0;
		int share_record_request=0;
		int share_recorded_request=this.shareDAO.requestStockRecorded(shareDTO);
		if(share_recorded_request>0) {
			return -2;
		}else {
			share_request_cnt=this.shareDAO.requestShare(shareDTO);
			share_record_request=this.shareDAO.requestStockRecord(shareDTO);
			return share_request_cnt;
		}
	}

	@Override
	public List<ShareDTO> getMyShareRequestList(ShareSearchDTO share_searchDTO) {
		List<ShareDTO> my_share_request_list = this.shareDAO.getMyShareRequestList(share_searchDTO);
		return my_share_request_list;
	}

	@Override
	public List<ShareDTO> getDifferentShareRequestList(ShareSearchDTO share_searchDTO) {
		List<ShareDTO> different_share_request_list = this.shareDAO.getDifferentShareRequestList(share_searchDTO);
		return different_share_request_list;
	}

	@Override
	public ShareDTO getShareRequestDTO(ShareDTO shareDTO) {
		shareDTO = this.shareDAO.getShareRequestDTO(shareDTO);
		return shareDTO;
	}

	@Override
	public int approveShare(ShareDTO shareDTO) {
		int share_approve_cnt=0;
		int share_record_approve=0;
		int share_recorded_approve=this.shareDAO.approveShareCount(shareDTO); // 수락한 공유재고 count
		int share_delete_cnt=this.shareDAO.shareDeletedCount(shareDTO);
		// 이미 수락한 공유재고가 있을 경우
		if(share_recorded_approve>0) {
			return -2;
		}
		// 삭제된 공유재고가 있을 경우
		else if(share_delete_cnt>0) {
			return -3;
		}
		// 수락한 공유재고가 없을 경우
		else {
			// 수락한 것을 share_ingredient table에 update하는 메소드
			share_approve_cnt=this.shareDAO.approveShare(shareDTO);
			// 수락한 것을 share_ingredient_record table에 insert하는 메소드
			share_record_approve=this.shareDAO.approveShareRecord(shareDTO);
			
			return share_approve_cnt;
		}
	}

	@Override
	public List<ShareDTO> getMyShareApproveList(ShareSearchDTO share_searchDTO) {
		List<ShareDTO> my_share_approve_list = this.shareDAO.getMyShareApproveList(share_searchDTO);
		return my_share_approve_list;
	}

	@Override
	public List<ShareDTO> getDifferentShareApproveList(ShareSearchDTO share_searchDTO) {
		List<ShareDTO> different_share_approve_list = this.shareDAO.getDifferentShareApproveList(share_searchDTO);
		return different_share_approve_list;
	}

	@Override
	public List<Map<String, String>> getWeekShareInputData(ChartSearchDTO chart_searchDTO) {
		List<Map<String,String>> week_share_input_chart = this.shareDAO.getWeekShareInputData(chart_searchDTO);
		return week_share_input_chart;
	}

	@Override
	public List<Map<String, String>> getWeekShareOutputData(ChartSearchDTO chart_searchDTO) {
		List<Map<String,String>> week_share_output_chart = this.shareDAO.getWeekShareOutputData(chart_searchDTO);
		return week_share_output_chart;
	}

	@Override
	public List<Map<String, String>> getMonthShareInputData(ChartSearchDTO chart_searchDTO) {
		List<Map<String,String>> month_share_input_chart = this.shareDAO.getMonthShareInputData(chart_searchDTO);
		return month_share_input_chart;
	}

	@Override
	public List<Map<String, String>> getMonthShareOutputData(ChartSearchDTO chart_searchDTO) {
		List<Map<String,String>> month_share_output_chart = this.shareDAO.getMonthShareOutputData(chart_searchDTO);
		return month_share_output_chart;
	}

	@Override
	public List<Map<String, String>> getTimeShareInputData(ChartSearchDTO chart_searchDTO) {
		List<Map<String,String>> time_share_input_chart = this.shareDAO.getTimeShareInputData(chart_searchDTO);
		return time_share_input_chart;
	}

	@Override
	public List<Map<String, String>> getTimeShareOutputData(ChartSearchDTO chart_searchDTO) {
		List<Map<String,String>> time_share_output_chart = this.shareDAO.getTimeShareOutputData(chart_searchDTO);
		return time_share_output_chart;
	}

	@Override
	public List<Map<String, String>> getAllQuarterShareInputData(ChartSearchDTO chart_searchDTO) {
		List<Map<String,String>> all_quarter_share_input_chart = this.shareDAO.getAllQuarterShareInputData(chart_searchDTO);
		return all_quarter_share_input_chart;
	}

	@Override
	public List<Map<String, String>> getAllQuarterShareOutputData(ChartSearchDTO chart_searchDTO) {
		List<Map<String,String>> all_quarter_share_output_chart = this.shareDAO.getAllQuarterShareOutputData(chart_searchDTO);
		return all_quarter_share_output_chart;
	}

	@Override
	public List<Map<String, String>> getQuarterShareInputData(ChartSearchDTO chart_searchDTO) {
		List<Map<String,String>> quarter_share_input_chart = this.shareDAO.getQuarterShareInputData(chart_searchDTO);
		return quarter_share_input_chart;
	}

	@Override
	public List<Map<String, String>> getQuarterShareOutputData(ChartSearchDTO chart_searchDTO) {
		List<Map<String,String>> quarter_share_output_chart = this.shareDAO.getQuarterShareOutputData(chart_searchDTO);
		return quarter_share_output_chart;
	}

	@Override
	public List<ShareDTO> getShareAnlList(ChartSearchDTO chart_searchDTO) {
		List<ShareDTO> share_anl_list = this.shareDAO.getShareAnlList(chart_searchDTO);
		return share_anl_list;
	}
}