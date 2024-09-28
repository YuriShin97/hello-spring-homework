package com.ktdsuniversity.edu.hellospringhomework.bbs.dao;

import com.ktdsuniversity.edu.hellospringhomework.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.hellospringhomework.bbs.vo.WriteBoardVO;

import java.util.List;

public interface BoardDao {

    public int selectBoardAllCount();

    public List<BoardVO> selectAllBoard();

    public int insertNewBoard(WriteBoardVO writeBoardVo);

    public int increaseViewCount(int id);

    public BoardVO selectOneBoard(int id);
}
