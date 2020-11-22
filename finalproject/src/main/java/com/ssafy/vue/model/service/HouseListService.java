package com.ssafy.vue.model.service;

import java.util.List;

import com.ssafy.vue.model.HouseDto;

public interface HouseListService {
	public List<HouseDto> searchAll();
	public List<HouseDto> searchDongAll(String gu);
	public List<HouseDto> search(String gu, String dong);
	public List<HouseDto> searchFromChang(String content);
}
