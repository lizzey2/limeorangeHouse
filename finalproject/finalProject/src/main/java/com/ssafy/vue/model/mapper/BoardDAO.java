package com.ssafy.vue.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.model.Board;

@Mapper
public interface BoardDAO {
	public List<Board> listBoard();
	public Board readBoard(int no);
	public int createBoard(Board board);
	public int updateBoard(Board board);
	public int deleteBoard(int no);
}