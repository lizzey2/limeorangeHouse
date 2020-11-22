package com.ssafy.vue.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.model.Board;
import com.ssafy.vue.model.service.BoardService;

//http://localhost:9999/vue/swagger-ui.html
@CrossOrigin("*")
@RestController
@RequestMapping("/board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private BoardService boardService;

	@GetMapping("/listboard")
	public ResponseEntity<List<Board>>listBoard() throws Exception {
		return new ResponseEntity<List<Board>>(boardService.listBoard(), HttpStatus.OK);
	}

	@GetMapping("/readboard/{no}")
	public ResponseEntity<Board> readBoard(@PathVariable int no) {
		return new ResponseEntity<Board>(boardService.readBoard(no), HttpStatus.OK);
	}

	@PostMapping("/createboard")
	public ResponseEntity<String> createBoard(@RequestBody Board board) {
		if (boardService.createBoard(board)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@PutMapping("/updateboard/{no}")
	public ResponseEntity<String> updateBoard(@RequestBody Board board) {
		if (boardService.updateBoard(board)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/deleteboard/{no}")
	public ResponseEntity<String> deleteBoard(@PathVariable int no) {
		System.out.println(">>>>>>>>>>>>> 삭제");
		System.out.println(boardService.readBoard(no));
		if (boardService.deleteBoard(no)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}