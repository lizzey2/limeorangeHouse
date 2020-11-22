package com.ssafy.vue.model.service;

import com.ssafy.vue.model.MemberDto;

public interface MemberService {

	public MemberDto login(MemberDto memberDto) throws Exception;
	public String getServerInfo();
	
	public void signup(MemberDto memberDto) throws Exception;
	public void userUpdate(MemberDto memberDto) throws Exception;
	public void userDelete(String userid) throws Exception;
	public MemberDto detailMember(String userid) throws Exception;
}
