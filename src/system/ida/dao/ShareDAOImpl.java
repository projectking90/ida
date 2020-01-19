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
 * StockDAOImpl 클래스
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
	@Override
	public List<ShareDTO> getDifferentShareList(ShareSearchDTO share_searchDTO) {
		List<ShareDTO> different_share_list=this.sqlSession.selectList(sqlSessionPath+"getDifferentShareList", share_searchDTO);
		return different_share_list;
	}

	@Override
	public List<ShareDTO> getMyShareList(ShareSearchDTO share_searchDTO) {
		List<ShareDTO> my_share_list=this.sqlSession.selectList(sqlSessionPath+"getMyShareList", share_searchDTO);
		return my_share_list;
	}

	@Override
	public List<StockDTO> getStockList(ShareSearchDTO share_searchDTO) {
		List<StockDTO> shock_list = this.sqlSession.selectList(sqlSessionPath+"getStockList", share_searchDTO);
		//System.out.println("DAO "+share_searchDTO.getS_id());
		return shock_list;
	}

	@Override
	public int insertShare(ShareDTO shareDTO) {
		int share_reg_cnt=this.sqlSession.insert(
				sqlSessionPath+"insertShare"
				, shareDTO);
		
		return share_reg_cnt;
	}

	@Override
	public int getInsertedShareCnt(ShareDTO shareDTO) {
		int inserted_share_cnt=this.sqlSession.selectOne(
				sqlSessionPath+"getInsertedShareCnt"
				, shareDTO);
		
		return inserted_share_cnt;
	}

	@Override
	public int insertStockRecord(ShareDTO shareDTO) {
		int share_record_insert=this.sqlSession.insert(
				sqlSessionPath+"insertStockRecord"
				, shareDTO);
		
		return share_record_insert;
	}

	@Override
	public ShareDTO getShareDTO(int si_no) {
		ShareDTO shareDTO = this.sqlSession.selectOne(
				sqlSessionPath+"getShareDTO"
				, si_no
		);
		return shareDTO;
	}

	@Override
	public int updateShare(ShareDTO shareDTO) {
		int share_update_cnt=this.sqlSession.update(
				sqlSessionPath+"updateShare"
				,shareDTO
		);
		return share_update_cnt;
	}

	@Override
	public int getMyShareCnt(ShareDTO shareDTO) {
		int shareCnt=this.sqlSession.selectOne(
				sqlSessionPath+"getMyShareCnt"
				,shareDTO
		);
		return shareCnt;
	}

	@Override
	public int deleteShare(ShareDTO shareDTO) {
		int share_delete_cnt=this.sqlSession.update(
				sqlSessionPath+"deleteShare"
				,shareDTO
		);
		return share_delete_cnt;
		
	}

	@Override
	public int requestShare(ShareDTO shareDTO) {
		int share_request_cnt=this.sqlSession.update(
				sqlSessionPath+"requestShare"
				,shareDTO
		);
		return share_request_cnt;
	}

	@Override
	public int deleteStockRecord(ShareDTO shareDTO) {
		int share_record_delete=this.sqlSession.insert(
				sqlSessionPath+"deleteStockRecord"
				, shareDTO);
		
		return share_record_delete;
	}

	@Override
	public int requestStockRecord(ShareDTO shareDTO) {
		int share_record_request=this.sqlSession.insert(
				sqlSessionPath+"requestStockRecord"
				, shareDTO);
		
		return share_record_request;
	}

	@Override
	public int requestStockRecorded(ShareDTO shareDTO) {
		int share_recorded_request = this.sqlSession.selectOne(
				sqlSessionPath+"requestStockRecorded"
				, shareDTO
		);
		return share_recorded_request;
	}

	@Override
	public List<ShareDTO> getMyShareRequestList(ShareSearchDTO share_searchDTO) {
		List<ShareDTO> my_share_request_list=this.sqlSession.selectList(
				sqlSessionPath+"getMyShareRequestList"
				, share_searchDTO
		);
		return my_share_request_list;
	}

	@Override
	public List<ShareDTO> getDifferentShareRequestList(ShareSearchDTO share_searchDTO) {
		List<ShareDTO> different_share_request_list=this.sqlSession.selectList(
				sqlSessionPath+"getDifferentShareRequestList"
				, share_searchDTO)
		;
		return different_share_request_list;
	}
}