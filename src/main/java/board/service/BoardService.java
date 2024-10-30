package board.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.bean.BoardDTO;
import board.dao.BoardDAO;
import member.dao.MemberDAOInfc;

@Service
public class BoardService implements BoardServiceInfc {
	@Autowired
	private BoardDAO boardDAO;
	@Autowired
	private MemberDAOInfc memberDAOInfc;
	
	@Override
	public void submit(BoardDTO boardDTO) {
		boardDTO.setName(boardDTO.getName().replace("\"", ""));
		String id = memberDAOInfc.getId(boardDTO.getName());
		boardDTO.setId(id);
		System.out.println(boardDTO);
		boardDAO.submit(boardDTO); // 게시물 작성
		boardDAO.refUpdate();
	}

	@Override
	public ArrayList<BoardDTO> getList() {
		return boardDAO.getList();
	}

	@Override
	public BoardDTO getItem(int seq) {
		System.out.println(boardDAO.getItem(seq));
		return boardDAO.getItem(seq);
	}

}
