package board.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;

import board.bean.BoardDTO;
import board.service.BoardServiceInfc;

@Controller
@CrossOrigin
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardServiceInfc boardServiceInfc;
	
	@PostMapping(value = "/submit")
	@ResponseBody
	public void Submit(@ModelAttribute BoardDTO boardDTO) {
		System.out.println(boardDTO.toString());
		boardServiceInfc.submit(boardDTO);
	}
	
	@GetMapping("/item")
	@ResponseBody
	public BoardDTO item(@RequestParam("seq") int seq) {
		System.out.println(seq);
		return boardServiceInfc.getItem(seq);
	}
	
}

@RestController
@CrossOrigin
@RequestMapping("/board")
class BoardListController {
	@Autowired
	private BoardServiceInfc boardServiceInfc;
	
	@GetMapping(value = "/list")
	public ArrayList<BoardDTO> list() {
		ArrayList<BoardDTO> list = boardServiceInfc.getList();
		for (BoardDTO boardDTO : list) {
			System.out.println(boardDTO.toString());
		}
		
		return list;
	}
}
