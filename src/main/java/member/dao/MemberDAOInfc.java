package member.dao;

import org.apache.ibatis.annotations.Mapper;

import member.bean.MemberDTO;

@Mapper
public interface MemberDAOInfc {
	public String isLogin(MemberDTO dto);

	public String getId(String name); 

}
