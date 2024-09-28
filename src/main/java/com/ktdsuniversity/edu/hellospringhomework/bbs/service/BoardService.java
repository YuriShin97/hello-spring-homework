package com.ktdsuniversity.edu.hellospringhomework.bbs.service;

import com.ktdsuniversity.edu.hellospringhomework.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.hellospringhomework.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.hellospringhomework.bbs.vo.WriteBoardVO;

public interface BoardService {
    public BoardListVO getAllBoards();

    public boolean createNewBoard(WriteBoardVO writeBoardVO);

    public BoardVO selectOneBoard(int id);
}
