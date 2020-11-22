package com.ssafy.vue.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.model.AptDto;
import com.ssafy.vue.model.mapper.AptMapper;

@Service
public class AptListServiceImpl implements AptListService {
	@Autowired
	private SqlSession session;
	
	@Override
	public List<AptDto> searchAll() {
		return session.getMapper(AptMapper.class).searchAll();
	}

	@Override
	public List<AptDto> searchDongAll(String gu) {
		return session.getMapper(AptMapper.class).searchDongAll(gu);
	}

	@Override
	public List<AptDto> search(String gu, String dong) {
		return session.getMapper(AptMapper.class).search(gu,dong);
	}

	@Override
	public List<AptDto> searchFromChang(String content) {
		return session.getMapper(AptMapper.class).searchFromChang(content);
	}

}
