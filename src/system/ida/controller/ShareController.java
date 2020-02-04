package system.ida.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import system.ida.dto.ShareDTO;
import system.ida.dto.ShareSearchDTO;
import system.ida.dto.StockDTO;
import system.ida.service.ShareService;

/**
 * ShareController 클래스
 * 컨트롤러 클래스
 * 공유에 관련 가상 경로를 설정
 * @author Jo
 */
@Controller
public class ShareController {
	/**
	 * 속성변수 선언
	 */
	private final String path = "Share/";	// jsp 경로
	@Autowired
	private ShareService shareService;	// Share =Service 인터페이스를 구현받은 객체를 생성해서 저장
	
	/**
	 * 메소드 선언
	 */
	/**
	 * 공유 관리 화면을 보여줄 jsp와 공유 정보를 보여주는 메소드
	 * 가상주소 /share_form.ida로 접근하면 호출
	 * @param share_searchDTO : 공유 검색 DTO
	 * @param session : HttpSession 객체
	 * @return mav : /share_form.ida에 맵핑되는 jsp 파일과 공유 정보 목록
	 */
	@RequestMapping(value="/share_form.ida")
	public ModelAndView goShareForm(
			ShareSearchDTO share_searchDTO
			, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		try {
			String s_id = (String)session.getAttribute("s_id");
			share_searchDTO.setS_id(s_id);
			
			List<ShareDTO> my_share_list=this.shareService.getMyShareList(share_searchDTO);
			List<ShareDTO> different_share_list = this.shareService.getDifferentShareList(share_searchDTO);
			List<StockDTO> stock_list = this.shareService.getStockList(share_searchDTO);
			mav.addObject("my_share_list", my_share_list);
			mav.addObject("different_share_list", different_share_list);
			mav.addObject("stock_list", stock_list);
			
			mav.setViewName(path + "share_form");
		}catch(Exception e) {
			System.out.println("<goShareForm 에러발생>");
			System.out.println(e.getMessage());
		}
		return mav;
	}
	
	/**
	 * 공유 추가 기능을 처리할 메소드
	 * @param shareDTO : 공유 DTO
	 * @param session : HttpSession 객체
	 * 가상주소 /insert_share_reg.ida로 접근하면 호출
	 * @return insert_result : 공유 추가 Query 실행 결과
	 */
	@RequestMapping(value="/insert_share_reg.ida"
			, method = RequestMethod.POST
			, produces="application/json;charset=UTF-8")
	@ResponseBody
	public int insertShare(
			ShareDTO shareDTO
			, HttpSession session) {
		int insert_result = -1;
		
		try {
			String s_id = (String)session.getAttribute("s_id");
			shareDTO.setS_id(s_id);
			
			insert_result = this.shareService.insertShare(shareDTO);
		}catch(Exception e){
			System.out.println("<insertShare 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return insert_result;
	}
	
	/**
	 * 다른 가게 공유 상세보기 화면을 보여줄 jsp와 다른 가게 공유 정보를 보여주는 메소드
	 * 가상주소 /different_share_content_form.ida로 접근하면 호출
	 * @param si_no : 공유 번호
	 * @return mav : /different_share_content_form.ida에 맵핑되는 jsp 파일과  다른 가게 공유 정보
	 */
	@RequestMapping(value="/different_share_content_form.ida")
	public ModelAndView differentShareContentForm(
			@RequestParam(value="si_no") int si_no) {
		ModelAndView mav=new ModelAndView();
		
		try {
			ShareDTO shareDTO = this.shareService.getShareDTO(si_no);
			mav.addObject("shareDTO", shareDTO);

			mav.setViewName(path + "different_share_content_form");
		}catch(Exception e) {
			System.out.println("<differentShareContentForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	/**
	 * 내 가게 공유 상세보기 화면을 보여줄 jsp와 내 가게 공유 정보를 보여주는 메소드
	 * 가상주소 /my_share_content_form.ida로 접근하면 호출
	 * @param si_no : 공유 번호
	 * @return mav : /my_share_content_form.ida에 맵핑되는 jsp 파일과  내 가게 공유 정보
	 */
	@RequestMapping(value="/my_share_content_form.ida")
	public ModelAndView myShareContentForm(
			@RequestParam(value="si_no") int si_no) {
		ModelAndView mav = new ModelAndView();

		try {
			ShareDTO shareDTO = this.shareService.getShareDTO(si_no);
			mav.addObject("shareDTO", shareDTO);
			
			mav.setViewName(path + "my_share_content_form");
		}catch(Exception e) {
			System.out.println("<myShareContentForm 에러발생>");
			System.out.println(e.getMessage());
		}
		return mav;
	}
	
	/**
	 * 내 가게 공유 수정 화면을 보여줄 jsp와 내 가게 공유 정보를 보여주는 메소드
	 * 가상주소 /my_share_update_form.ida로 접근하면 호출
	 * @param si_no : 공유 번호
	 * @return mav : /my_share_update_form.ida에 맵핑되는 jsp 파일과  내 가게 공유 정보
	 */
	@RequestMapping(value="/my_share_update_form.ida")
	public ModelAndView myShareUpdateForm(
			@RequestParam(value="si_no") int si_no) {
		ModelAndView mav = new ModelAndView();
		try {
			ShareDTO shareDTO = this.shareService.getShareDTO(si_no);
			mav.addObject("shareDTO", shareDTO);

			mav.setViewName(path + "my_share_update_form");
		}catch(Exception e) {
			System.out.println("<myShareUpdateForm 에러발생>");
			System.out.println(e.getMessage());
		}
		return mav;
	}
	
	/**
	 * 내 가게 공유 수정 기능을 처리할 메소드
	 * 가상주소 /my_share_update_proc.ida로 접근하면 호출
	 * @param shareDTO : 공유 DTO
	 * @return share_update_cnt : 공유 수정 Query 실행 결과
	 */
	@RequestMapping(value="/my_share_update_proc.ida")
	@ResponseBody
	public int myShareUpdate(
			ShareDTO shareDTO) {
		int share_update_cnt = -1;
		
		try {
			share_update_cnt = this.shareService.updateShare(shareDTO);
		} catch(Exception e) {
			System.out.println("<myShareUpdate 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return share_update_cnt;
	}
	
	/**
	 * 내 가게 공유 삭제 기능을 처리할 메소드
	 * 가상주소 /my_share_delete_proc.ida로 접근하면 호출
	 * @param shareDTO : 공유 DTO
	 * @param session : HttpSession 객체
	 * @return share_delete_cnt : 공유 삭제 Query 실행 결과
	 */
	@RequestMapping(value="/my_share_delete_proc.ida")
	@ResponseBody
	public int myShareDelete(
			ShareDTO shareDTO
			, HttpSession session) {
		int share_delete_cnt = -1;
		try {
			String s_id = (String)session.getAttribute("s_id");
			shareDTO.setS_id(s_id);
			
			share_delete_cnt = this.shareService.deleteShare(shareDTO);
		} catch(Exception e) {
			System.out.println("<myShareDelete 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return share_delete_cnt;
	}
	
	/**
	 * 다른 가게 공유에 대해 요청 기능을 처리할 메소드
	 * 가상주소 /request_share.ida로 접근하면 호출
	 * @param shareDTO : 공유 DTO
	 * @param session : HttpSession 객체
	 * @return share_delete_cnt : 공유 요청 Query 실행 결과
	 */
	@RequestMapping(value="/request_share.ida")
	@ResponseBody
	public int requestShare(
			ShareDTO shareDTO
			, HttpSession session) {
		int share_request_cnt = -1;
		
		try {
			String s_id = (String)session.getAttribute("s_id");
			shareDTO.setS_id(s_id);
			
			share_request_cnt = this.shareService.requestShare(shareDTO);
		} catch(Exception e) {
			System.out.println("<requestShare 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return share_request_cnt;
	}
	
	
	/**
	 * 공유 분석 - 표 화면을 보여줄 jsp와 가게가 신청한 공유를 검색 조건에 따라 보여주는 메소드
	 * 가상주소 /share_analysis_form.ida로 접근하면 호출
	 * @return mav : /share_analysis_form.ida에 맵핑되는 jsp 파일과 검색 조건에 맞는 가게 공유 리스트
	 */
	@RequestMapping(value="/share_analysis_form.ida")
	public ModelAndView goShareAnalysisForm() {
		ModelAndView mav = new ModelAndView();
		 
		try {
			mav.setViewName(path + "share_analysis_form");
		} catch(Exception e) {
			System.out.println("<goShareAnalysisForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	/**
	 * 공유 분석 - 차트 화면을 보여줄 jsp와 가게가 신청한 공유를 검색 조건에 따라 차트로 보여주는 메소드
	 * 가상주소 /share_analysis_chart_form.ida로 접근하면 호출
	 * @return mav : /share_analysis_chart_form.ida에 맵핑되는 jsp 파일과 검색 조건에 맞는 가게 공유 차트
	 */
	@RequestMapping(value="/share_analysis_chart_form.ida")
	public ModelAndView goShareAnalysisChartForm() {
		ModelAndView mav = new ModelAndView();
		 
		try {
			mav.setViewName(path + "share_analysis_chart_form");
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goShareAnalysisChartForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	/**
	 * 다른 가게의 공유에 대해 요청 화면을 보여줄 jsp와 다른 가게의 공유 정보를 보여주는 메소드
	 * 가상주소 /share_form.ida로 접근하면 호출
	 * @param share_searchDTO : 공유 검색 DTO
	 * @param session : HttpSession 객체
	 * @return mav : /share_form.ida에 맵핑되는 jsp 파일과 다른 가게의 공유 정보 목록
	 */
	@RequestMapping(value="/share_request_form.ida")
	public ModelAndView goShareRequestForm(
			ShareSearchDTO share_searchDTO
			, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		try {
			String s_id = (String)session.getAttribute("s_id");
			share_searchDTO.setS_id(s_id);
			
			List<ShareDTO> my_share_request_list=this.shareService.getMyShareRequestList(share_searchDTO);
			List<ShareDTO> different_share_request_list = this.shareService.getDifferentShareRequestList(share_searchDTO);

			mav.addObject("my_share_request_list", my_share_request_list);
			mav.addObject("different_share_request_list", different_share_request_list);
			
			mav.setViewName(path + "share_request_form");
		}catch(Exception e) {
			System.out.println("<goShareRequestForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	/**
	 * 내 가게의 공유 요청에 대한 승인 화면을 보여줄 jsp와 내 가게의 공유 정보를 보여주는 메소드
	 * 가상주소 /share_approve_form.ida로 접근하면 호출
	 * @param share_searchDTO : 공유 검색 DTO
	 * @param session : HttpSession 객체
	 * @return mav : /share_approve_form.ida에 맵핑되는 jsp 파일과 내 가게의 공유 정보 목록
	 */
	@RequestMapping(value="/share_approve_form.ida")
	public ModelAndView goShareApproveForm(
			ShareSearchDTO share_searchDTO
			, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		try {
			String s_id = (String)session.getAttribute("s_id");
			share_searchDTO.setS_id(s_id);
			
			List<ShareDTO> my_share_approve_list=this.shareService.getMyShareApproveList(share_searchDTO);
			List<ShareDTO> different_share_approve_list = this.shareService.getDifferentShareApproveList(share_searchDTO);

			mav.addObject("my_share_approve_list", my_share_approve_list);
			mav.addObject("different_share_approve_list", different_share_approve_list);
			mav.setViewName(path + "share_approve_form");
		}catch(Exception e) {
			System.out.println("<goShareApproveForm 에러발생>");
			System.out.println(e.getMessage());
		}
		return mav;
	}
	
	/**
	 * 내 매장 공유 재고 요청 현황 상세보기 화면을 보여줄 jsp와 내 가게의 재고 요청 현황의 상세보기를 보여주는 메소드
	 * 가상주소 /share_request_content_form.ida로 접근하면 호출
	 * @param si_no : 공유 번호
	 * @param s_no : 사용자 번호
	 * @param shareDTO : 공유 DTO
	 * @param session : HttpSession 객체
	 * @return mav : /share_request_content_form.ida에 맵핑되는 jsp 내 가게의 재고 요청 현황의 상세보기
	 */
	@RequestMapping(value="/share_request_content_form.ida")
	public ModelAndView shareRequestContentForm(
			@RequestParam(value="si_no") int si_no
			, @RequestParam(value="s_no") int s_no
			, ShareDTO shareDTO
			, HttpSession session) {
		ModelAndView mav=new ModelAndView();

		try {
			shareDTO.setSi_no(si_no);
			shareDTO.setS_no(s_no);
			shareDTO = this.shareService.getShareRequestDTO(shareDTO);
			
			mav.addObject("shareDTO", shareDTO);
			mav.setViewName(path + "share_request_content_form");
		} catch(Exception e) {
			System.out.println("<shareRequestContentForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}

	/**
	 * 내 매장 공유 재고 요청한 것 수락 기능을 처리할 메소드
	 * 가상주소 /approve_share_reg.ida로 접근하면 호출
	 * @param shareDTO : 공유 DTO
	 * @param session : HttpSession 객체
	 * @return
	 */
	@RequestMapping(value="/approve_share_reg.ida")
	@ResponseBody
	public int approveShareReg(
			ShareDTO shareDTO
			, HttpSession session) {
		int share_approve_cnt = -1;
		
		try {
			String s_id = (String)session.getAttribute("s_id");
			shareDTO.setS_id(s_id);

			share_approve_cnt = this.shareService.approveShare(shareDTO);
		} catch(Exception e) {
			System.out.println("<approveShareReg 에러발생>");
			System.out.println(e.getMessage());
		}

		return share_approve_cnt;
	}
}