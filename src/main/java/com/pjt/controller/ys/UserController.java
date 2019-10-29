package com.pjt.controller.ys;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pjt.common.service.CommonService;
import com.pjt.domain.ys.GenderVO;
import com.pjt.domain.ys.LocVO;
import com.pjt.domain.ys.PageMaker;
import com.pjt.domain.ys.ReligionVO;
import com.pjt.domain.ys.UserSearchDTO;
import com.pjt.domain.ys.UserSearchRequestDTO;
import com.pjt.service.ys.UserService;
import com.pjt.util.ys.MediaUtils;
import com.pjt.util.ys.UploadFileUtils;

@Controller
@RequestMapping(value = "ys/user/*")
//@RequestMapping(value="/test/*")
public class UserController {

	@Resource(name = "uploadPath")
	private String uploadPath;

	@Inject
	CommonService cservice;
	
	@Inject
	UserService service;
	
	//회원검색
	@RequestMapping(value = "userSearch", method = RequestMethod.GET)
	public void listPage(UserSearchRequestDTO dto, Model model) throws Exception {
		System.out.println("____________"+dto.getPage()+"________"+dto.getPerPageNum()+"________"+dto.getStartRow()+"________"+dto.getEndRow());
		dto.setPage(dto.getPage());
		List<UserSearchDTO> list = service.getSearchUserList(dto);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(dto);
		int totalCount = service.listSearchCount(dto);
		pageMaker.setTotalCount(totalCount);

		List<GenderVO> genderlist = cservice.getGenderList();
		List<LocVO> loclist = cservice.getLocList();
		List<ReligionVO> religionlist = cservice.getReligionList();
		model.addAttribute("genderlist", genderlist);
		model.addAttribute("loclist", loclist);
		model.addAttribute("religionlist", religionlist);

		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("list", list);
	}
//	//사진 전송
//	@ResponseBody
//	@RequestMapping(value = "/uploadAjax", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
//	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception {
//		String originalName = file.getOriginalFilename();
//		String uploadedFileName = UploadFileUtils.uploadFile(uploadPath, originalName, file.getBytes());
//
//		System.out.println("uploadedFileName:" + uploadedFileName);
//		
//		return new ResponseEntity<String>(uploadedFileName, HttpStatus.CREATED);
//	}
//	//사진 삭제
//	@ResponseBody
//	@RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
//	public ResponseEntity<String> deleteFile(String fileName) throws Exception {
//		
//		System.out.println("delete, fileName:" + fileName);
//		int index;
//		for(int i=0;i<2;i++){
//			index=fileName.indexOf('/');
//			fileName=fileName.substring(index+1);
//		}
//		System.out.println("원래 파일 이름:"+fileName);
//
//		ResponseEntity<String> entity = null;
//				
//		try {
//			MediaType mType = MediaUtils.getMediaType(
//					MediaUtils.getFormatName(fileName));
//			if (mType != null) {
//				UploadFileUtils.deletethumnailImage(uploadPath, "/"+fileName);
//			}
//			UploadFileUtils.deleteLocalFile(uploadPath, "/"+fileName);
//			
//			entity = new ResponseEntity<String>("DELETED", HttpStatus.OK);
////			MediaType mType = MediaUtils.getMediaType(
////					MediaUtils.getFormatName(fileName));
////			System.out.println("mType:" + mType);
////			// 이미지라면, 원본 지우기
////			if (mType != null) {
////				UploadFileUtils.deleteOriginalImage(uploadPath, fileName);
////			}
////
////			// 이미지인지 여부와 상관없이 전달된 파일 삭제
////			// 이미지인 경우 - 섬네일
////			UploadFileUtils.deleteLocalFile(uploadPath, fileName);
////
////			entity = new ResponseEntity<String>("DELETED", HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
//		}
//
//		return entity;
//
//	}
//	//사진 보여주기
//	@ResponseBody
//	@RequestMapping(value = "/displayFile")
//	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {
//		System.out.println("startView");
//		System.out.println("fileName:" + fileName);
//		ResponseEntity<byte[]> entity = null;
//		InputStream in = null;
//
//		try {
//			HttpHeaders headers = new HttpHeaders();
//			String path = uploadPath + fileName;
//
//			in = new FileInputStream(path);
//
//			int dotIndex = fileName.lastIndexOf(".");
//			String formatName = fileName.substring(dotIndex + 1).toUpperCase();
//
//			MediaType mType = MediaUtils.getMediaType(formatName);
//
//
//			if (mType != null) {
//				headers.setContentType(mType); // image/jpeg
//				System.out.println("headers:" + headers);
//			}
//
//			else {
//				int uIndex = fileName.indexOf("_");
//				String orinalName = fileName.substring(uIndex + 1);
//				String nString = new String(orinalName.getBytes("utf-8"), "iso-8859-1");
//				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//				headers.add("Content-Disposition", "attachment; filename=\"" + nString + "\"");
//			}
//
//			byte[] data = IOUtils.toByteArray(in);
//
//			entity = new ResponseEntity<byte[]>(data, headers, HttpStatus.CREATED);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
//		}
//
//		return entity;
//	}

//	//사진 여러개 삭제
//	@ResponseBody
//	@RequestMapping(value = "/deleteAllFiles", method = RequestMethod.POST)
//	public ResponseEntity<String> deleteFile(@RequestBody String[] files) throws Exception {
//		
//		System.out.println("files:" + files);
//		ResponseEntity<String> entity = null;
//		
//		try {
//			if (files != null && files.length > 0) {
//				
//				for (String fileName : files) {
//					MediaType mType = MediaUtils.getMediaType(
//							MediaUtils.getFormatName(fileName));
//					if (mType != null) {
//						UploadFileUtils.deleteOriginalImage(uploadPath, fileName);
//					}
//					UploadFileUtils.deleteLocalFile(uploadPath, fileName);
//					
//				}
//			} 
//			
//			entity = new ResponseEntity<String>("DELEDTED", HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
//		}
//		
//		return entity;
//	}
//	// 가입 화면
//	@RequestMapping(value = "signIt", method = RequestMethod.GET)
//	public void signForm(Model model) throws Exception {
//		List<GenderVO> genderlist = cservice.getGenderList();
//		List<LocVO> loclist = cservice.getLocList();
//		List<ReligionVO> religionlist = cservice.getReligionList();
//		model.addAttribute("genderlist", genderlist);
//		model.addAttribute("loclist", loclist);
//		model.addAttribute("religionlist", religionlist);
//	}
//	
//	@RequestMapping(value = "SignItAction", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
//	public String signAction(@RequestParam("files")String[] files,UserVO vo, Model model) throws Exception {
//		// 사진
//		String uploadedFileName=files[files.length-1];
////		String originalName = file.getOriginalFilename();
////
////		String uploadedFileName = UploadFileUtils.uploadFile(uploadPath, originalName, file.getBytes());
//		vo.setUser_photo(uploadedFileName);
//		// 다른정보
//
//		service.registUser(vo);
//		
//		return "redirect:/intro";
//	}
//	@RequestMapping(value = "SignItAction", method = RequestMethod.POST)
//	public String signAction(@RequestParam("files")String[] files,UserVO vo, Model model) throws Exception {
//		// 사진
//		System.out.println("_________________"+files.length);
//		String uploadedFileName=files[files.length];
////		String originalName = file.getOriginalFilename();
////
////		String uploadedFileName = UploadFileUtils.uploadFile(uploadPath, originalName, file.getBytes());
//		vo.setUser_photo(uploadedFileName);
//		// 다른정보
//		service.registUser(vo);
//		return "redirect:/ys/random/randommatch";
//	}
//
//	// 로그인 화면
//	@RequestMapping(value = "login", method = RequestMethod.GET)
//	public void loginForm() throws Exception {
//
//	}
//
//	@RequestMapping(value = "login", method = RequestMethod.POST)
//	public String loginAction(LoginDTO dto, HttpSession session,Model model) throws Exception {
//		try{
//		String id = service.login(dto);
//		if(id ==null){
//			throw new MyException("로그인 실패.<br/> 아이디 또는 비밀번호가 틀렸습니다.");
//		}
//		session.setAttribute("id", id);
//		}catch (Exception e) {
//			model.addAttribute("re", e.getMessage());
//			return "/ys/user/login";
//		}
//		return "redirect:/intro";
//	}
//	@RequestMapping(value = "logout", method = RequestMethod.GET)
//	public String loginAction(HttpSession session) throws Exception {
//		session.removeAttribute("id");
//		return "redirect:/intro";
//	}
//	// 마이페이지
//	@RequestMapping(value = "mypage", method = RequestMethod.GET)
//	public String myPageForm(HttpSession session, Model model, String re) throws Exception {
//		
//		String id = (String) session.getAttribute("id");
//		if (id == null) {
//			return "redirect:/ys/user/login";
//		}
//		if(re != null){
//			model.addAttribute("re", re);
//		}
//		List<LocVO> loclist = cservice.getLocList();
//		List<ReligionVO> religionlist = cservice.getReligionList();
//		
//		UserVO vo = service.getUserInfo(id);
//
//		model.addAttribute("userInfo", vo);
//
//		model.addAttribute("loclist", loclist);
//		model.addAttribute("religionlist", religionlist);
//		return "/ys/user/mypage";
//	}
//	//17.11.23
//	@RequestMapping(value = "mypage", method = RequestMethod.POST)
//	public String myPageAction(String[] files,HttpSession session, UserVO vo, Model model) throws Exception {
////			System.out.println("files:" + files);
////			for (String s : files) {
////				System.out.println("s:" + s);
////			}
////			System.out.println("vo:" + vo);
//			
//			String uploadedFileName= null;
//			// 사진
//			System.out.println("------passPoint 0-------");
//			
//			if(files != null){
//				uploadedFileName=files[files.length-1];
//			}
//		try{
//			System.out.println("------passPoint 1-------");
//	//		String originalName = file.getOriginalFilename();
//	//		String uploadedFileName = UploadFileUtils.uploadFile(uploadPath, originalName, file.getBytes());
//			vo.setUser_photo(uploadedFileName);
//			
//			// 그 외의 정보
//			String id = (String) session.getAttribute("id");
//			vo.setUser_id(id);
//			System.out.println(vo.toString());
//			System.out.println("------passPoint 2-------");
//			int i=service.updateUserInfo(vo);
//			System.out.println("------passPoint 3-------");
//			if(i!=1){
//				System.out.println("------passPoint 4-------");
//				throw new MyException("변경 실패. 다시 시도 해보세요.");
//			}
//		}catch (Exception e) {
//			model.addAttribute("re", e.getMessage());
//			return "redirect:/ys/user/mypage";
//		}		
//		return "redirect:/intro";
//	}
//	@RequestMapping(value = "MyPageAction", method = RequestMethod.POST)
//	public String myPageAction(MultipartFile file, HttpSession session, UserVO vo) throws Exception {
//		// 사진
//		String originalName = file.getOriginalFilename();
//		String uploadedFileName = UploadFileUtils.uploadFile(uploadPath, originalName, file.getBytes());
//		vo.setUser_photo(uploadedFileName);
//
//		// 그 외의 정보
//		String id = (String) session.getAttribute("id");
//		vo.setUser_id(id);
//		service.updateUserInfo(vo);
//
//		return "redirect:/ys/random/randommatch";
//	}

}
