package com.ssafy.vue.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.vue.model.MemberDto;
import com.ssafy.vue.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public MemberDto login(MemberDto memberDto) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).login(memberDto);
	}

	@Override
	public String getServerInfo() {
		return "사용자에게 전달하고 싶은 중요정보";
	}

	@Override //회원가입!
	public void signup(MemberDto memberDto) throws Exception {
		sqlSession.getMapper(MemberMapper.class).signup(memberDto);
	}

	@Override //회원정보 수정! ID 입력 후
	@Transactional
	public void userUpdate(MemberDto memberDto) throws Exception {
		sqlSession.getMapper(MemberMapper.class).userUpdate(memberDto);
	}

	@Override //회원정보 삭제! (재차 확인을 묻고 삭제하는 게 좋을거같은데.. 어떻게 안되려나?)
	@Transactional
	public void userDelete(String userid) throws Exception {
		sqlSession.getMapper(MemberMapper.class).userDelete(userid);
	}

	@Override
	public MemberDto detailMember(String userid) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).getuserInfo(userid);
	}

}
