package com.ssafy.vue.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.model.MemberDto;
import com.ssafy.vue.model.service.JwtService;
import com.ssafy.vue.model.service.MemberService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/user")
public class MemberController {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private MemberService memberService;
	
	public static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@PostMapping("/confirm/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody MemberDto memberDto, HttpServletResponse response, HttpSession session) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			MemberDto loginUser = memberService.login(memberDto);
			
			if(loginUser != null) {
//				jwt.io에서 확인
//				로그인 성공했다면 토큰을 생성한다.
				String token = jwtService.create(loginUser);
				logger.trace("로그인 토큰정보 : {}", token);
				System.out.println(loginUser.toString());
//				토큰 정보는 response의 헤더로 보내고 나머지는 Map에 담는다.
//				response.setHeader("auth-token", token);
				resultMap.put("auth-token", token);
				resultMap.put("user-id", loginUser.getUserid());
				resultMap.put("user-name", loginUser.getUsername());
//				resultMap.put("status", true);
//				resultMap.put("data", loginUser);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", "로그인 실패");
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("로그인 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

//	@PostMapping("/info")
//	public ResponseEntity<Map<String, Object>> getInfo(HttpServletRequest req, HttpSession session) {
//		Map<String, Object> resultMap = new HashMap<>();
//		HttpStatus status = null;
//		try {
//			MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
//			if(memberDto != null) {
//				// 보너스로 토큰에 담긴 정보도 전달해보자. 서버에서 토큰을 사용하는 방법임을 알 수 있다.
//				resultMap.putAll(jwtService.get(req.getHeader("auth-token")));
//	
//				resultMap.put("status", true);
//				resultMap.put("info", info);
//				resultMap.put("request_body", memberDto);
//				status = HttpStatus.ACCEPTED;
//			}
//		} catch (RuntimeException e) {
//			logger.error("정보조회 실패 : {}", e);
//			resultMap.put("message", e.getMessage());
//			status = HttpStatus.INTERNAL_SERVER_ERROR;
//		}
//		return new ResponseEntity<Map<String, Object>>(resultMap, status);
//	}
	
	@GetMapping("/info")
	public ResponseEntity<Map<String, Object>> getInfo(HttpServletRequest req) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		System.out.println(">>>>>> " + jwtService.get(req.getHeader("auth-token")));
		try {
			// 사용자에게 전달할 정보이다.
//			String info = memberService.getServerInfo();
			
			resultMap.putAll(jwtService.get(req.getHeader("auth-token")));
//
//			resultMap.put("status", true);
//			resultMap.put("info", info);
			status = HttpStatus.ACCEPTED;
		} catch (RuntimeException e) {
			logger.error("정보조회 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@PostMapping("/confirm/signup") //회원가입?
	public ResponseEntity<String> signup(@RequestBody MemberDto memberDto) throws Exception {
		memberService.signup(memberDto);
		System.out.println(memberDto.toString());
		//responseentity이거는 그냥..메시지같은거 띄우는 용인거같은데?
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
	@DeleteMapping("/userdelete/{userid}")
	public ResponseEntity<String> userDelete(@PathVariable String userid) throws Exception {
		System.out.println("회원탈퇴 완료");
		memberService.userDelete(userid);
		if(userid!=null)
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT); 
	}
	
	//userid를 가지고..와서...비밀번호 체크? select!!!
	@GetMapping("/getuserinfo/{userid}")
	public ResponseEntity<MemberDto> detailMember(@PathVariable String userid) throws Exception {
		return new ResponseEntity<MemberDto>(memberService.detailMember(userid), HttpStatus.OK);
	}
	
	//update!
	@PutMapping("/userupdate/{userid}")
	public ResponseEntity<String> userUpdate(@RequestBody MemberDto memberDto) {
		memberService.userUpdate(memberDto);
		System.out.println("회원정보 수정 완료");
		System.out.println(memberDto.toString());
		if(memberDto!=null)
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT); 
	}

}
