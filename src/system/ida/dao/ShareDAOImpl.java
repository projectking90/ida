/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import system.ida.dto.ShareDTO;
import system.ida.dto.ShareSearchDTO;
import system.ida.dto.StockDTO;

/**
 * ShareDAOImpl 클래스
 * DAO 클래스, bean 태그로 자동 등록됨
 * @author Jo
 */
@Repository
public class ShareDAOImpl implements ShareDAO {
	/**
	 * 속성변수 선언
	 */
	@Autowired
	private SqlSessionTemplate sqlSession;	// SqlSessionTemplate 객체를 생성하고 저장
	
	/**
	 * 메소드 선언
	 */
	/**
	 * 타 지점 공유 현황 목록을 가져옴
	 * @param share_searchDTO : 공유 검색 DTO
	 * @return different_share_list : 타 지점 공유 현황 목록
	 */
	@Override
	public List<ShareDTO> getDifferentShareList(ShareSearchDTO share_searchDTO) {
		List<ShareDTO> different_share_list = this.sqlSession.selectList(
				sqlSessionPath + "getDifferentShareList"
				, share_searchDTO);
		
		return different_share_list;
	}

	/**
	 * 내 지점 공유 현황 목록을 가져옴
	 * @param share_searchDTO : 공유 검색 DTO
	 * @return my_share_list : 내 지점 공유 현황 목록
	 */
	@Override
	public List<ShareDTO> getMyShareList(ShareSearchDTO share_searchDTO) {
		List<ShareDTO> my_share_list = this.sqlSession.selectList(
				sqlSessionPath + "getMyShareList"
				, share_searchDTO);
		
		return my_share_list;
	}

	/**
	 * 공유 재고 추가할 때 필요한 재고 목록을 가져옴
	 * @param share_searchDTO : 공유 검색 DTO
	 * @return shock_list : 재고 목록
	 */
	@Override
	public List<StockDTO> getStockList(ShareSearchDTO share_searchDTO) {
		List<StockDTO> shock_list = this.sqlSession.selectList(
				sqlSessionPath + "getStockList"
				, share_searchDTO);
		
		return shock_list;
	}

	/**
	 * 공유 재고 추가 처리함
	 * @param shareDTO : 공유 DTO
	 * @return share_reg_cnt : 공유 추가 Query 결과
	 */
	@Override
	public int insertShare(ShareDTO shareDTO) {
		int share_reg_cnt = this.sqlSession.insert(
				sqlSessionPath + "insertShare"
				, shareDTO);
		
		return share_reg_cnt;
	}

	/**
	 * 이미 등록된 공유 재고 개수를 가져옴
	 * @param shareDTO : 공유 DTO
	 * @return inserted_share_cnt : 이미 등록된 공유 재고 개수
	 */
	@Override
	public int getInsertedShareCnt(ShareDTO shareDTO) {
		int inserted_share_cnt = this.sqlSession.selectOne(
				sqlSessionPath + "getInsertedShareCnt"
				, shareDTO);
		
		return inserted_share_cnt;
	}

	/**
	 * 재고 기록 테이블에 추가 기록 처리함
	 * @param shareDTO : 공유 DTO
	 * @return share_record_insert : 재고 기록 테이블에 추가 기록 Query 결과
	 */
	@Override
	public int insertStockRecord(ShareDTO shareDTO) {
		int share_record_insert = this.sqlSession.insert(
				sqlSessionPath + "insertStockRecord"
				, shareDTO);
		
		return share_record_insert;
	}
	
	/**
	 * 이미 등록되었으나 삭제된 공유 재고 개수를 가져옴
	 * @param shareDTO : 공유 DTO
	 * @return share_record_insert : 이미 등록되었으나 삭제된 공유 재고 개수
	 */
	@Override
	public int getDeletedShareCnt(ShareDTO shareDTO) {
		int share_record_insert = this.sqlSession.selectOne(
				sqlSessionPath + "getDeletedShareCnt"
				, shareDTO);

		return share_record_insert;
	}

	/**
	 * is_del='T'를 'F'로 수정 처리함
	 * @param shareDTO : 공유 DTO
	 * @return share_record_insert : is_del 수정 Query 결과
	 */
	@Override
	public int changeInsertedShareIsDel(ShareDTO shareDTO) {
		int share_record_insert = this.sqlSession.update(
				sqlSessionPath + "changeInsertedShareIsDel"
				, shareDTO);

		return share_record_insert;
	};

	/**
	 * 공유 정보를 가져옴
	 * @param si_no : 공유 번호
	 * @return shareDTO : 공유 정보
	 */
	@Override
	public ShareDTO getShareDTO(int si_no) {
		ShareDTO shareDTO = this.sqlSession.selectOne(
				sqlSessionPath + "getShareDTO"
				, si_no);
		
		return shareDTO;
	}

	/**
	 * 내 지점 공유 재고 수정 처리함
	 * @param shareDTO : 공유 DTO
	 * @return share_update_cnt : 내 지점 공유 재고 수정 Query 결과
	 */
	@Override
	public int updateShare(ShareDTO shareDTO) {
		int share_update_cnt = this.sqlSession.update(
				sqlSessionPath + "updateShare"
				, shareDTO);
		
		return share_update_cnt;
	}

	/**
	 * 수정할 공유 재고 개수를 가져옴
	 * @param shareDTO : 공유 DTO
	 * @return shareCnt : 수정할 공유 재고 개수
	 */
	@Override
	public int getMyShareCnt(ShareDTO shareDTO) {
		int shareCnt = this.sqlSession.selectOne(
				sqlSessionPath + "getMyShareCnt"
				, shareDTO);
		
		return shareCnt;
	}

	/**
	 * 내 지점 공유 재고 삭제 처리함
	 * @param shareDTO : 공유 DTO
	 * @return share_delete_cnt : 내 지점 공유 재고 삭제 Query 결과
	 */
	@Override
	public int deleteShare(ShareDTO shareDTO) {
		int share_delete_cnt = this.sqlSession.update(
				sqlSessionPath + "deleteShare"
				, shareDTO);
		
		return share_delete_cnt;
	}

	/**
	 * 타 지점의 공유 재고 요청 처리함
	 * @param shareDTO : 공유 DTO
	 * @return share_request_cnt : 타 지점의 공유 재고 요청 Query 결과
	 */
	@Override
	public int requestShare(ShareDTO shareDTO) {
		int share_request_cnt = this.sqlSession.update(
				sqlSessionPath + "requestShare"
				, shareDTO);
		
		return share_request_cnt;
	}

	/**
	 * 재고 기록 테이블에 삭제 기록 처리함
	 * @param shareDTO : 공유 DTO
	 * @return share_record_delete : 재고 기록 테이블에 삭제 기록 Query 결과
	 */
	@Override
	public int deleteStockRecord(ShareDTO shareDTO) {
		int share_record_delete = this.sqlSession.insert(
				sqlSessionPath + "deleteStockRecord"
				, shareDTO);
		
		return share_record_delete;
	}

	/**
	 * 재고 기록 테이블에 요청 기록 처리함
	 * @param shareDTO : 공유 DTO
	 * @return share_record_request : 재고 기록 테이블에 요청 기록 Query 결과
	 */
	@Override
	public int requestStockRecord(ShareDTO shareDTO) {
		int share_record_request = this.sqlSession.insert(
				sqlSessionPath + "requestStockRecord"
				, shareDTO);
		
		return share_record_request;
	}

	/**
	 * 같은 공유를 요청을 개수를 가져옴
	 * @param shareDTO : 공유 DTO
	 * @return share_recorded_request : 같은 공유를 요청을 개수
	 */
	@Override
	public int requestStockRecorded(ShareDTO shareDTO) {
		int share_recorded_request = this.sqlSession.selectOne(
				sqlSessionPath + "requestStockRecorded"
				, shareDTO);
		
		return share_recorded_request;
	}

	/**
	 * 내 매장 공유 재고 요청 현황 목록을 가져옴
	 * @param share_searchDTO : 공유 검색 DTO
	 * @return my_share_request_list : 내 매장 공유 재고 요청 현황 목록
	 */
	@Override
	public List<ShareDTO> getMyShareRequestList(ShareSearchDTO share_searchDTO) {
		List<ShareDTO> my_share_request_list = this.sqlSession.selectList(
				sqlSessionPath + "getMyShareRequestList"
				, share_searchDTO);
		
		return my_share_request_list;
	}

	/**
	 * 타 매장 공유 재고 요청 현황 목록을 가져옴
	 * @param share_searchDTO : 공유 검색 DTO
	 * @return different_share_request_list : 타 매장 공유 재고 요청 현황 목록
	 */
	@Override
	public List<ShareDTO> getDifferentShareRequestList(ShareSearchDTO share_searchDTO) {
		List<ShareDTO> different_share_request_list = this.sqlSession.selectList(
				sqlSessionPath + "getDifferentShareRequestList"
				, share_searchDTO);
		
		return different_share_request_list;
	}
	
	/**
	 * 내 매장 공유 재고 요청 현황 상세보기를 가져옴
	 * @param shareDTO : 공유 DTO
	 * @return shareDTO : 내 매장 공유 재고 요청 현황 상세보기
	 */
	@Override
	public ShareDTO getShareRequestDTO(ShareDTO shareDTO) {
		shareDTO = this.sqlSession.selectOne(
				sqlSessionPath + "getShareRequestDTO"
				, shareDTO);
		
		return shareDTO;
	}

	/**
	 * 요청에 대해 수락 처리함
	 * @param shareDTO : 공유 DTO
	 * @return share_approve_cnt : 요청에 대한 수락 Query 결과
	 */
	@Override
	public int approveShare(ShareDTO shareDTO) {
		int share_approve_cnt = this.sqlSession.update(
				sqlSessionPath + "approveShare"
				, shareDTO);
		
		return share_approve_cnt;
	}

	/**
	 * 공유 기록 테이블에 요청 수락 기록 처리함
	 * @param shareDTO : 공유 DTO
	 * @return share_record_approve : 공유 기록 테이블에 요청 수락 기록 Query 결과
	 */
	@Override
	public int approveShareRecord(ShareDTO shareDTO) {
		int share_record_approve = this.sqlSession.insert(
				sqlSessionPath + "approveShareRecord"
				, shareDTO);

		return share_record_approve;
	}

	/**
	 * 수락한 공유 재고 개수 가져옴
	 * @param shareDTO : 공유 DTO
	 * @return share_recorded_approve : 수락한 공유 재고 개수
	 */
	@Override
	public int approveShareCount(ShareDTO shareDTO) {
		int share_recorded_approve = this.sqlSession.selectOne(
				sqlSessionPath + "approveShareCount"
				, shareDTO);

		return share_recorded_approve;
	}

	/**
	 * 삭제된 공유 재고 개수 가져옴
	 * @param shareDTO : 공유 DTO
	 * @return share_delete_cnt : 삭제된 공유 재고 개수
	 */
	@Override
	public int shareDeletedCount(ShareDTO shareDTO) {
		int share_delete_cnt = this.sqlSession.selectOne(
				sqlSessionPath + "shareDeletedCount"
				, shareDTO);

		return share_delete_cnt;
	}

	/**
	 * 내 매장 공유 재고 승인 현황 목록을 가져옴
	 * @param share_searchDTO : 공유 검색 DTO
	 * @return my_share_approve_list : 내 매장 공유 재고 승인 현황 목록
	 */
	@Override
	public List<ShareDTO> getMyShareApproveList(ShareSearchDTO share_searchDTO) {
		List<ShareDTO> my_share_approve_list = this.sqlSession.selectList(
				sqlSessionPath + "getMyShareApproveList"
				, share_searchDTO);
		
		return my_share_approve_list;
	}

	/**
	 * 타 매장 공유 재고 승인 현황 목록을 가져옴
	 * @param share_searchDTO : 공유 검색 DTO
	 * @return different_share_approve_list : 타 매장 공유 재고 승인 현황 목록
	 */
	@Override
	public List<ShareDTO> getDifferentShareApproveList(ShareSearchDTO share_searchDTO) {
		List<ShareDTO> different_share_approve_list = this.sqlSession.selectList(
				sqlSessionPath + "getDifferentShareApproveList"
				, share_searchDTO);
		
		return different_share_approve_list;
	}
}