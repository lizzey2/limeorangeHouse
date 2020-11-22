package com.ssafy.vue.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.model.MemberDto;

@Mapper
public interface MemberMapper {

	public MemberDto login(MemberDto memberDto) throws SQLException;
	public void signup(MemberDto memberDto) throws SQLException;
	public void userUpdate(MemberDto memberDto) throws SQLException;//회원정보 수정
	public void userDelete(String userid) throws SQLException; //회원정보 삭제
	public MemberDto getuserInfo(String userid) throws SQLException; //userid로 회원정보 검색
}
