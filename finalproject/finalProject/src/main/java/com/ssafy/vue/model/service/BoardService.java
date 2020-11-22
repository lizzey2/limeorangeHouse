package com.ssafy.vue.model.service;

import java.util.List;

import com.ssafy.vue.model.Board;

public interface BoardService {
	public List<Board> listBoard();
	public Board readBoard(int no);
	public boolean createBoard(Board board);
	public boolean updateBoard(Board board);
	public boolean deleteBoard(int no);
}
