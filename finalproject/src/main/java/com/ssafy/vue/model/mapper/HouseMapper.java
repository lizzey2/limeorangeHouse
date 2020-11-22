package com.ssafy.vue.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.model.HouseDto;

@Mapper
public interface HouseMapper {
	public List<HouseDto> searchAll();
	public List<HouseDto> searchDongAll(String gu);
	public List<HouseDto> search(String gu, String dong);
	public List<HouseDto> searchFromChang(String content); //검색창으로 검색한 결과
}
