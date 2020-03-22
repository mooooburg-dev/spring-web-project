package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
	
//	@Select("select * from system.tbl_board where bno > 0")
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	
	public void inserSelectKey(BoardVO board);
}
