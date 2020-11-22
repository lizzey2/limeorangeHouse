package com.ssafy.vue.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.model.HouseDto;
import com.ssafy.vue.model.mapper.HouseMapper;

@Service
public class HouseListServiceImpl implements HouseListService {
	@Autowired
	private SqlSession session;
	
	@Override
	public List<HouseDto> searchAll() {
		return session.getMapper(HouseMapper.class).searchAll();
	}

	@Override
	public List<HouseDto> searchDongAll(String gu) {
		return session.getMapper(HouseMapper.class).searchDongAll(gu);
	}

	@Override
	public List<HouseDto> search(String gu, String dong) {
		return session.getMapper(HouseMapper.class).search(gu,dong);
	}

	@Override
	public List<HouseDto> searchFromChang(String content) {
		return session.getMapper(HouseMapper.class).searchFromChang(content);
	}

}
