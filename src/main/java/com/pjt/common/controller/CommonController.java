package com.pjt.common.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pjt.common.service.CommonService;
import com.pjt.domain.ys.GenderVO;
import com.pjt.domain.ys.LocVO;
import com.pjt.domain.ys.LoginDTO;
import com.pjt.domain.ys.MasterMeetVO;
import com.pjt.domain.ys.ReligionVO;
import com.pjt.domain.ys.Statistical;
import com.pjt.domain.ys.UserVO;
import com.pjt.exception.ys.MyException;
import com.pjt.service.ys.UserService;
import com.pjt.util.ys.MediaUtils;
import com.pjt.util.ys.UploadFileUtils;

@Controller
public class CommonController {

	@Resource(name = "uploadPath")
	private String uploadPath;
	@Inject
	UserService service;
	@Inject
	CommonService cservice;

	//사진 전송
	@ResponseBody
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception {
		String originalName = file.getOriginalFilename();
		String uploadedFileName = UploadFileUtils.uploadFile(uploadPath, originalName, file.getBytes());

		System.out.println("uploadedFileName:" + uploadedFileName);
		
		return new ResponseEntity<String>(uploadedFileName, HttpStatus.CREATED);
	}
	//사진 보여주기
	@ResponseBody
	@RequestMapping(value = "/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {
		System.out.println("startView");
		System.out.println("fileName:" + fileName);
		ResponseEntity<byte[]> entity = null;
		InputStream in = null;

		try {
			HttpHeaders headers = new HttpHeaders();
			String path = uploadPath + fileName;
			// D:/upload/2017/10/27/s_<image_name>.jpg
			in = new FileInputStream(path);

			int dotIndex = fileName.lastIndexOf(".");
			String formatName = fileName.substring(dotIndex + 1).toUpperCase();

			MediaType mType = MediaUtils.getMediaType(formatName);

			// 이미지인 경우
			if (mType != null) {
				headers.setContentType(mType); // image/jpeg
				System.out.println("headers:" + headers);
			}
			// 이미지가 아닌 경우
			else {
				// 한글 파일명 안깨지게...
				// ..........................
				int uIndex = fileName.indexOf("_");
				String orinalName = fileName.substring(uIndex + 1);
				String nString = new String(orinalName.getBytes("utf-8"), "iso-8859-1");
				// 다른 이름으로 저장
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				// 다른 이름으로 저장할때 나타날 파일명 지정
				headers.add("Content-Disposition", "attachment; filename=\"" + nString + "\"");
			}

			byte[] data = IOUtils.toByteArray(in);

			entity = new ResponseEntity<byte[]>(data, headers, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	//사진 삭제
	@ResponseBody
	@RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName) throws Exception {
		
		System.out.println("delete, fileName:" + fileName);
		int index;
		for(int i=0;i<2;i++){
			index=fileName.indexOf('/');
			fileName=fileName.substring(index+1);
		}
		System.out.println("원래 파일 이름:"+fileName);

		ResponseEntity<String> entity = null;
				
		try {
			MediaType mType = MediaUtils.getMediaType(
					MediaUtils.getFormatName(fileName));
			if (mType != null) {
				UploadFileUtils.deletethumnailImage(uploadPath, "/"+fileName);
			}
			UploadFileUtils.deleteLocalFile(uploadPath, "/"+fileName);
			
			entity = new ResponseEntity<String>("DELETED", HttpStatus.OK);
//				MediaType mType = MediaUtils.getMediaType(
//						MediaUtils.getFormatName(fileName));
//				System.out.println("mType:" + mType);
//				// 이미지라면, 원본 지우기
//				if (mType != null) {
//					UploadFileUtils.deleteOriginalImage(uploadPath, fileName);
//				}
//
//				// 이미지인지 여부와 상관없이 전달된 파일 삭제
//				// 이미지인 경우 - 섬네일
//				UploadFileUtils.deleteLocalFile(uploadPath, fileName);
//
//				entity = new ResponseEntity<String>("DELETED", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

		return entity;

	}
	//가입 화면
	@RequestMapping(value = "/signIt", method = RequestMethod.GET)
	public void signForm(Model model) throws Exception {
		List<GenderVO> genderlist = cservice.getGenderList();
		List<LocVO> loclist = cservice.getLocList();
		List<ReligionVO> religionlist = cservice.getReligionList();
		model.addAttribute("genderlist", genderlist);
		model.addAttribute("loclist", loclist);
		model.addAttribute("religionlist", religionlist);
	}

	//가입
	@RequestMapping(value = "/SignItAction", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String signAction(@RequestParam("files") String[] files, UserVO vo, Model model) throws Exception {
		// 사진
		String uploadedFileName = files[files.length - 1];
		// String originalName = file.getOriginalFilename();
		// String uploadedFileName = UploadFileUtils.uploadFile(uploadPath,
		// originalName, file.getBytes());
		vo.setUser_photo(uploadedFileName);
		// 다른정보

		service.registUser(vo);

		return "redirect:/intro";
	}

	//로그인 화면
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginForm(HttpSession session, HttpServletRequest request) throws Exception {
		String oriUrl = request.getHeader("referer");
		if (oriUrl.equals("null")) {
			oriUrl = request.getRequestURI();
		}
		System.out.println("_1_____________" + oriUrl);
		session.setAttribute("saveURL", oriUrl);
	}

	//로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginAction(LoginDTO dto, HttpSession session, Model model, HttpServletRequest request)
			throws Exception {
		
		String oriUrl = (String) session.getAttribute("saveURL");
		
		try {
			String id = service.login(dto);
			if (id == null) {
				throw new MyException("로그인 실패.<br/> 아이디 또는 비밀번호가 틀렸습니다.");
			}
			session.setAttribute("id", id);
		} catch (Exception e) {
			model.addAttribute("re", e.getMessage());
			return "login";
		}
		return "redirect:" + oriUrl;
	}

	//로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String loginAction(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/intro";
	}

	//인증 화면
	@RequestMapping(value = "/cert", method = RequestMethod.GET)
	public void cert() throws Exception {

	}

	//회원정보 수정 화면
	@RequestMapping(value = "/cert", method = RequestMethod.POST)
	public String certAction(LoginDTO dto, HttpSession session, Model model, String re) throws Exception {
		System.out.println("Pass0");
		String certid = null;

		try {
			certid = service.login(dto);
			System.out.println("Pass2" + certid);
			if (certid == null) {
				throw new MyException("로그인 실패.<br/> 비밀번호가 틀렸습니다.");
			}
		} catch (Exception e) {
			model.addAttribute("re", e.getMessage());
			return "cert";
		}

		System.out.println("Pass3");

		List<LocVO> loclist = cservice.getLocList();
		List<ReligionVO> religionlist = cservice.getReligionList();

		UserVO vo = service.getUserInfo(certid);

		model.addAttribute("userInfo", vo);
		model.addAttribute("loclist", loclist);
		model.addAttribute("religionlist", religionlist);
		return "/mypage";
	}

	//회원정보 수정
	@RequestMapping(value = "/mypage", method = RequestMethod.POST)
	public String myPageAction(String[] files, HttpSession session, UserVO vo, Model model) throws Exception {
		
		// System.out.println("files:" + files);
		// for (String s : files) {
		// System.out.println("s:" + s);
		// }
		// System.out.println("vo:" + vo);

		String id = (String) session.getAttribute("id");
		String uploadedFileName = null;
		// 사진
		System.out.println("------passPoint 0-------");

		if (files != null) {
			// 이전 사진 삭제
			String oldThumnailFileName = service.getUserPhoto(id);
			try {
				MediaType mType = MediaUtils.getMediaType(MediaUtils.getFormatName(oldThumnailFileName));
				if (mType != null) {
					UploadFileUtils.deleteOriginalImage(uploadPath, oldThumnailFileName);
				}
				UploadFileUtils.deleteLocalFile(uploadPath, oldThumnailFileName);
			} catch (Exception e) {
			}
			// DB 파일이름 등록
			uploadedFileName = files[files.length - 1];
		}
		System.out.println("------passPoint 1-------");
		try {
			// String originalName = file.getOriginalFilename();
			// String uploadedFileName = UploadFileUtils.uploadFile(uploadPath,
			// originalName, file.getBytes());
			vo.setUser_photo(uploadedFileName);

			// 그 외의 정보

			vo.setUser_id(id);
			System.out.println(vo.toString());
			int i = service.updateUserInfo(vo);
			if (i != 1) {
				throw new MyException("변경 실패. 다시 시도 해보세요.");
			}
		} catch (Exception e) {
			model.addAttribute("re", e.getMessage());
			return "mypage";
		}

		return "redirect:/intro";
	}
//MasterController이동 해야함
	@RequestMapping(value = "/meetlist", method = RequestMethod.GET)
	public String meetlist(Model model) throws Exception {
		List<MasterMeetVO>mlist=cservice.getMeetList();
		List<Statistical>slist= cservice.getStatisticalList();
		int fcount=cservice.getGenderCount(1);
		int mcount=cservice.getGenderCount(2);
		int wmeet=cservice.getMeetStatusCount('w');
		int imeet=cservice.getMeetStatusCount('i');
		int cmeet=cservice.getMeetStatusCount('c');
		
//		int todayLogincount=cservice.getTodayLogin();
//		int todayMeetcount=cservice.getTodayMeetCount();
		model.addAttribute("meetlist",mlist);
		model.addAttribute("statisticallist",slist);
		model.addAttribute("fcount",fcount);
		model.addAttribute("mcount",mcount);
		model.addAttribute("wmeet",wmeet);
		model.addAttribute("imeet",imeet);
		model.addAttribute("cmeet",cmeet);
//		model.addAttribute("todaylogin",todayLogincount);
//		model.addAttribute("todaymeet",todayMeetcount);
		return "common/masterMeetList";
	}
	// // 마이페이지
	// @RequestMapping(value = "/mypage", method = RequestMethod.GET)
	// public String myPageForm(HttpSession session, Model model, String re)
	// throws Exception {
	//
	// if(){
	//
	// }
	// String id = (String) session.getAttribute("id");
	// if (id == null) {
	// return "redirect:/login";
	// }
	// if(re != null){
	// model.addAttribute("re", re);
	// }
	// List<LocVO> loclist = cservice.getLocList();
	// List<ReligionVO> religionlist = cservice.getReligionList();
	//
	// UserVO vo = service.getUserInfo(id);
	//
	// model.addAttribute("userInfo", vo);
	//
	// model.addAttribute("loclist", loclist);
	// model.addAttribute("religionlist", religionlist);
	// return "/mypage";
	// }
}
