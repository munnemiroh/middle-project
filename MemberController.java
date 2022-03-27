package com.javaclass.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaclass.domain.MemberVO;
import com.javaclass.service.MemberService;

// ### (1) 해당 어노테이션 지정
public class MemberController {

	// ### (2) 해당 어노테이션 지정
	private MemberService memberServiceImpl;
	
	@RequestMapping("/{step}.do")
	public String viewPage(@PathVariable String step) {
		return step;
	}
	
	// ### (3) 해당 어노테이션 지정
	public void insertMember( MemberVO vo ) {
		memberServiceImpl.insertMember(vo);
	}
	
	// ### (4) 해당 어노테이션 지정
	public String login(MemberVO vo, HttpSession session) {
		MemberVO result = memberServiceImpl.loginCheck(vo);
		if(result==null) {
			return "loginForm";
		}else {
			// (5) 로그인 성공한 사용자이름을 세션에 저장
			
			
			return "loginConfirm";
		}
	}
	
}
