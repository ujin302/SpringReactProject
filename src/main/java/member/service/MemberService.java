package member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.bean.MemberDTO;
import member.dao.MemberDAOInfc;

@Service
public class MemberService implements MemberServiceInfc {
	@Autowired
	private MemberDAOInfc memberDAOInfc;

	@Override
	public String loginSubmit(MemberDTO memberDTO) {
		return memberDAOInfc.isLogin(memberDTO);
	}
	
//	public String getId 

}
