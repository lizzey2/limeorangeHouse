package com.ssafy.vue.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.vue.model.mapper.BoardDAO;
import com.ssafy.vue.model.Board;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
	private BoardDAO boardDao;

    @Override
	public List<Board> listBoard() {
		return boardDao.listBoard();
	}
    
  	@Override
	public boolean createBoard(Board board) {
		return boardDao.createBoard(board) == 1;
	}

	@Override
	public Board readBoard(int no) {
		return boardDao.readBoard(no);
	}

	@Override
	@Transactional
	public boolean updateBoard(Board board) {
		return boardDao.updateBoard(board) == 1;
	}

	@Override
	@Transactional
	public boolean deleteBoard(int no) {
		return boardDao.deleteBoard(no) == 1;
	}
}