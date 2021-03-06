package system.ida.dao;

import java.util.List;
import java.util.Map;

import system.ida.dto.ChartSearchDTO;
import system.ida.dto.ShareDTO;
import system.ida.dto.ShareSearchDTO;
import system.ida.dto.StockDTO;

/**
 * ShareDAO 인터페이스
 * DAO 클래스를 사용하기 위해 정의한 인터페이스
 * @author Jo
 */
public interface ShareDAO {
	/**
	 * 속성변수 선언
	 */
	String sqlSessionPath = "system.ida.dao.ShareDAO.";	// mapper의 namespace

	/**
	 * 메소드 선언
	 */
	List<ShareDTO> getDifferentShareList(ShareSearchDTO share_searchDTO);	// 타 지점 공유 현황 목록을 가져옴
	List<ShareDTO> getMyShareList(ShareSearchDTO share_searchDTO);	// 내 지점 공유 현황 목록을 가져옴
	List<StockDTO> getStockList(ShareSearchDTO share_searchDTO);	// 공유 재고 추가할 때 필요한 재고 목록을 가져옴
	int insertShare(ShareDTO shareDTO);	// 공유 재고 추가 처리함
	int getInsertedShareCnt(ShareDTO shareDTO);	// 이미 등록된 공유 재고 개수를 가져옴
	int insertStockRecord(ShareDTO shareDTO);	// 재고 기록 테이블에 추가 기록 처리함
	int getDeletedShareCnt(ShareDTO shareDTO);	// 이미 등록되었으나 삭제된 공유 재고 개수를 가져옴
	int changeInsertedShareIsDel(ShareDTO shareDTO);	// is_del='T'를 'F'로 수정 처리함
	ShareDTO getShareDTO(int si_no);	// 공유 정보를 가져옴
	int updateShare(ShareDTO shareDTO);	// 내 지점 공유 재고 수정 처리함
	int getMyShareCnt(ShareDTO shareDTO);	// 수정할 공유 재고 개수를 가져옴
	int deleteShare(ShareDTO shareDTO);	// 내 지점 공유 재고 삭제 처리함
	int requestShare(ShareDTO shareDTO);	// 타 지점의 공유 재고 요청 처리함
	int deleteStockRecord(ShareDTO shareDTO);	// 재고 기록 테이블에 삭제 기록 처리함
	int requestStockRecord(ShareDTO shareDTO);	// 재고 기록 테이블에 요청 기록 처리함
	int requestStockRecorded(ShareDTO shareDTO);	// 같은 공유를 요청을 개수를 가져옴
	List<ShareDTO> getMyShareRequestList(ShareSearchDTO share_searchDTO);	// 내 매장 공유 재고 요청 현황 목록을 가져옴
	List<ShareDTO> getDifferentShareRequestList(ShareSearchDTO share_searchDTO);	// 타 매장 공유 재고 요청 현황 목록을 가져옴
	ShareDTO getShareRequestDTO(ShareDTO shareDTO);	// 내 매장 공유 재고 요청 현황 상세보기를 가져옴
	int approveShare(ShareDTO shareDTO);	// 요청에 대해 수락 처리함
	int approveShareRecord(ShareDTO shareDTO);	// 공유 기록 테이블에 요청 수락 기록 처리함
	int approveShareCount(ShareDTO shareDTO);	// 수락한 공유 재고 개수 가져옴
	int shareDeletedCount(ShareDTO shareDTO);	// 삭제된 공유 재고 개수 가져옴
	List<ShareDTO> getMyShareApproveList(ShareSearchDTO share_searchDTO);	// 내 매장 공유 재고 승인 현황 목록을 가져옴
	List<ShareDTO> getDifferentShareApproveList(ShareSearchDTO share_searchDTO);	// 타 매장 공유 재고 승인 현황 목록을 가져옴
	List<Map<String, String>> getWeekShareInputData(ChartSearchDTO chart_searchDTO);	// 주별 입고 차트 데이터를 가져옴
	List<Map<String, String>> getWeekShareOutputData(ChartSearchDTO chart_searchDTO);	// 주별 출고 차트 데이터를 가져옴
	List<Map<String, String>> getMonthShareInputData(ChartSearchDTO chart_searchDTO);	// 월별 입고 차트 데이터를 가져옴
	List<Map<String, String>> getMonthShareOutputData(ChartSearchDTO chart_searchDTO);	// 월별 출고 차트 데이터를 가져옴
	List<Map<String, String>> getTimeShareInputData(ChartSearchDTO chart_searchDTO);	// 시간별 입고 차트 데이터를 가져옴
	List<Map<String, String>> getTimeShareOutputData(ChartSearchDTO chart_searchDTO);	// 시간별 입고 차트 데이터를 가져옴
	List<Map<String, String>> getAllQuarterShareInputData(ChartSearchDTO chart_searchDTO);	// 모든 분기 입고 차트 데이터를 가져옴
	List<Map<String, String>> getAllQuarterShareOutputData(ChartSearchDTO chart_searchDTO);	// 모든 분기 출고 차트 데이터를 가져옴
	List<Map<String, String>> getQuarterShareInputData(ChartSearchDTO chart_searchDTO);	// 분기별 입고 차트 데이터를 가져옴
	List<Map<String, String>> getQuarterShareOutputData(ChartSearchDTO chart_searchDTO);	// 분기별 출고 차트 데이터를 가져옴
	List<ShareDTO> getShareAnlList(ChartSearchDTO chart_searchDTO);	// 차트 공유 테이블 목록 가져옴
}