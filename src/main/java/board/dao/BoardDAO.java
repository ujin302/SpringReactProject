package board.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import board.bean.BoardDTO;

@Mapper
public interface BoardDAO {
	public void submit(BoardDTO boardDTO);

	public ArrayList<BoardDTO> getList();
	
	public void refUpdate();

	public BoardDTO getItem(int seq);
}
