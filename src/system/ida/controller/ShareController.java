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

import system.ida.dto.IngredientDTO;
import system.ida.dto.ShareDTO;
import system.ida.dto.ShareSearchDTO;
import system.ida.dto.StockDTO;
import system.ida.service.ShareService;

@Controller
public class ShareController {

	/**
	 * 속성변수 선언
	 */
	private final String path = "Share/";	// jsp 경로
	@Autowired
	private ShareService shareService;	// StockService 인터페이스를 구현받은 객체를 생성해서 저장
	
	@RequestMapping(value="/share_form.ida")
	public ModelAndView goShareForm(
			ShareSearchDTO share_searchDTO,
			HttpSession session
	) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "share_form");
		String s_id = (String)session.getAttribute("s_id");
		try {
			share_searchDTO.setS_id(s_id);
			List<ShareDTO> my_share_list=this.shareService.getMyShareList(share_searchDTO);
			List<ShareDTO> different_share_list = this.shareService.getDifferentShareList(share_searchDTO);
			List<StockDTO> stock_list = this.shareService.getStockList(share_searchDTO);
			mav.addObject("my_share_list", my_share_list);
			mav.addObject("different_share_list", different_share_list);
			mav.addObject("stock_list", stock_list);
		}catch(Exception e) {
			System.out.println("<goShareForm 에러발생>");
			System.out.println(e.getMessage());
		}
		return mav;
	}
	
	@RequestMapping(value="/insert_share_reg.ida"
			, method = RequestMethod.POST
			, produces="application/json;charset=UTF-8")
	@ResponseBody
	public int insertStockReg(
			ShareDTO shareDTO
			,HttpSession session
	) {
		int share_reg_cnt=0;
		String s_id = (String)session.getAttribute("s_id");
		try {
			shareDTO.setS_id(s_id);
			share_reg_cnt=this.shareService.insertShare(shareDTO);
		}catch(Exception e){
			System.out.println("<insertStockReg 에러발생>");
			System.out.println(e.getMessage());
		}
		return share_reg_cnt;
	}
	@RequestMapping(value="/different_share_content_form.ida")
	public ModelAndView different_share_content_form(
			@RequestParam(value="si_no") int si_no
			,HttpSession session
	) {
		ModelAndView mav=new ModelAndView();

		mav.setViewName(path + "different_share_content_form");
		try {
			session.setAttribute("uri", "different_share_content_form.ida");
			ShareDTO shareDTO = this.shareService.getShareDTO(si_no);
			mav.addObject("shareDTO", shareDTO);
		}catch(Exception e) {
			System.out.println("<different_share_content_form 에러발생>");
			System.out.println(e.getMessage());
		}
		return mav;
	}	
	
	@RequestMapping(value="/my_share_content_form.ida")
	public ModelAndView my_share_content_form(
			@RequestParam(value="si_no") int si_no
			,HttpSession session
	) {
		ModelAndView mav=new ModelAndView();

		mav.setViewName(path + "my_share_content_form");
		try {
			session.setAttribute("uri", "my_share_content_form.ida");
			ShareDTO shareDTO = this.shareService.getShareDTO(si_no);
			mav.addObject("shareDTO", shareDTO);
		}catch(Exception e) {
			System.out.println("<my_share_content_form 에러발생>");
			System.out.println(e.getMessage());
		}
		return mav;
	}
	
	@RequestMapping(value="/my_share_update_form.ida")
	public ModelAndView my_share_update_form(
			@RequestParam(value="si_no") int si_no
			,HttpSession session
	) {
		ModelAndView mav=new ModelAndView();

		mav.setViewName(path + "my_share_update_form");
		try {
			session.setAttribute("uri", "my_share_update_form.ida");
			ShareDTO shareDTO = this.shareService.getShareDTO(si_no);
			mav.addObject("shareDTO", shareDTO);
		}catch(Exception e) {
			System.out.println("<my_share_update_form 에러발생>");
			System.out.println(e.getMessage());
		}
		return mav;
	}
	
	@RequestMapping(value="/my_share_update_proc.ida")
	@ResponseBody
	public int my_share_update(
			ShareDTO shareDTO
	) {
		int share_update_cnt = 0;
		try {				 
			share_update_cnt = this.shareService.updateShare(shareDTO);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
		
		return share_update_cnt;
	}
	
	
	@RequestMapping(value="/my_share_delete_proc.ida")
	@ResponseBody
	public int my_share_delete(
			ShareDTO shareDTO
			,HttpSession session
	) {
		int share_delete_cnt = 0;
		String s_id = (String)session.getAttribute("s_id");
		try {				 
			shareDTO.setS_id(s_id);
			share_delete_cnt = this.shareService.deleteShare(shareDTO);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
		
		return share_delete_cnt;
	}
	
	
	@RequestMapping(value="/request_share.ida")
	@ResponseBody
	public int request_share(
			ShareDTO shareDTO
			,HttpSession session
	) {
		int share_request_cnt = 0;
		String s_id = (String)session.getAttribute("s_id");
		try {				 
			shareDTO.setS_id(s_id);	 
			share_request_cnt = this.shareService.requestShare(shareDTO);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
		
		return share_request_cnt;
	}
	
	
	/**
	 * 발주 분석 화면을 보여줄 jsp와 가게가 신청한 발주를 검색 조건에 따라 보여주는 메소드
	 * 가상주소 /share_analysis_form.ida로 접근하면 호출
	 * @return mav : /share_analysis_form.ida에 맵핑되는 jsp 파일과 검색 조건에 맞는 가게 발주 리스트
	 */
	@RequestMapping(value="/share_analysis_form.ida")
	public ModelAndView goShareAnalysisForm(
		HttpSession session
		) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "share_analysis_form");
		 
		try {
			String s_id =(String)session.getAttribute("s_id");
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goShareAnalysisForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	/**
	 * 발주 분석 - 차트화면을 보여줄 jsp와 가게가 신청한 발주를 검색 조건에 따라 차트로 보여주는 메소드
	 * 가상주소 /share_analysis_chart_form.ida로 접근하면 호출
	 * @return mav : /share_analysis_chart_form.ida에 맵핑되는 jsp 파일과 검색 조건에 맞는 가게 발주 차트
	 */
	@RequestMapping(value="/share_analysis_chart_form.ida")
	public ModelAndView goShareAnalysisChartForm(
		HttpSession session
		) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "share_analysis_chart_form");
		 
		try {
			String s_id =(String)session.getAttribute("s_id");
		} catch(Exception e) {	// try 구문에서 예외가 발생하면 실행할 구문 설정
			System.out.println("<goShareAnalysisChartForm 에러발생>");
			System.out.println(e.getMessage());
		}
		
		return mav;
	}
	
	
	@RequestMapping(value="/share_request_form.ida")
	public ModelAndView goShareRequestForm(
			ShareSearchDTO share_searchDTO,
			HttpSession session
	) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "share_request_form");
		String s_id = (String)session.getAttribute("s_id");
		try {
			share_searchDTO.setS_id(s_id);
			System.out.println(share_searchDTO.getS_id());
			List<ShareDTO> my_share_request_list=this.shareService.getMyShareRequestList(share_searchDTO);
			List<ShareDTO> different_share_request_list = this.shareService.getDifferentShareRequestList(share_searchDTO);

			mav.addObject("my_share_request_list", my_share_request_list);
			mav.addObject("different_share_request_list", different_share_request_list);
		}catch(Exception e) {
			System.out.println("<goShareRequestForm 에러발생>");
			System.out.println(e.getMessage());
		}
		return mav;
	}
	@RequestMapping(value="/share_approve_form.ida")
	public ModelAndView goShareApproveForm(
			ShareSearchDTO share_searchDTO,
			HttpSession session
	) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(path + "share_approve_form");
		String s_id = (String)session.getAttribute("s_id");
		try {
			share_searchDTO.setS_id(s_id);
/*			List<ShareDTO> my_share_list=this.shareService.getMyShareList(share_searchDTO);
			List<ShareDTO> different_share_list = this.shareService.getDifferentShareList(share_searchDTO);
			List<StockDTO> stock_list = this.shareService.getStockList(share_searchDTO);
			mav.addObject("my_share_list", my_share_list);
			mav.addObject("different_share_list", different_share_list);
			mav.addObject("stock_list", stock_list);
*/		}catch(Exception e) {
			System.out.println("<goShareApproveForm 에러발생>");
			System.out.println(e.getMessage());
		}
		return mav;
	}
}