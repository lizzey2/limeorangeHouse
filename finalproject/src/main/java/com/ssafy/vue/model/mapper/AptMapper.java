package com.ssafy.vue.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.model.AptDto;

@Mapper
public interface AptMapper {
	public List<AptDto> searchAll();
	public List<AptDto> searchDongAll(String gu);
	public List<AptDto> search(String gu, String dong);
	public List<AptDto> searchFromChang(String content); //검색창으로 검색한 결과
}
