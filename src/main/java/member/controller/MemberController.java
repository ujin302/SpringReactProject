package member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import member.bean.MemberDTO;
import member.service.MemberServiceInfc;

@Controller
@CrossOrigin
@RequestMapping("member")
public class MemberController {
	@Autowired
	private MemberServiceInfc memberServiceInfc;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping(value = "/sessionCheck")
	@ResponseBody
	public String sessionCheck(HttpSession session) {
		//System.out.println("sessionCheck11: "+session.getAttribute("name").toString());
		String name = "";
		try {
			name = session.getAttribute("name").toString();
		} catch (NullPointerException e) {
			name = "";
		}
		
		System.out.println("sessionCheck: "+ name);
		return name;
	}
	
	@GetMapping(value = "login/submit")
	@ResponseBody
	public String loginSubmit(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
		System.out.println(memberDTO.toString());
		String name = memberServiceInfc.loginSubmit(memberDTO);
		
//		// 로그인 실패
		if(name == null) return "fail";
		System.out.println(name);
		return name;
	}
	
}
