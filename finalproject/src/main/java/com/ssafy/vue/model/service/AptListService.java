package com.ssafy.vue.model.service;

import java.util.List;

import com.ssafy.vue.model.AptDto;

public interface AptListService {
	public List<AptDto> searchAll();
	public List<AptDto> searchDongAll(String gu);
	public List<AptDto> search(String gu, String dong);
	public List<AptDto> searchFromChang(String content);
}
