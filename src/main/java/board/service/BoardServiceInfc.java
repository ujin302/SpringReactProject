package board.service;

import java.util.ArrayList;

import board.bean.BoardDTO;

public interface BoardServiceInfc {
	public void submit(BoardDTO boardDTO);

	public ArrayList<BoardDTO> getList();

	public BoardDTO getItem(int seq);

}
