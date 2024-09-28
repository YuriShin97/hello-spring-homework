package com.ktdsuniversity.edu.hellospringhomework.bbs.service.impl;

import com.ktdsuniversity.edu.hellospringhomework.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.hellospringhomework.bbs.service.BoardService;
import com.ktdsuniversity.edu.hellospringhomework.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.hellospringhomework.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.hellospringhomework.bbs.vo.WriteBoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDao boardDao;

    @Override
    public BoardListVO getAllBoards() {
        BoardListVO boardListVO = new BoardListVO();
        boardListVO.setBoardCnt(boardDao.selectBoardAllCount());
        boardListVO.setBoardList(boardDao.selectAllBoard());
        return boardListVO;
    }

    @Override
    public boolean createNewBoard(WriteBoardVO writeBoardVO) {
        int createCount = boardDao.insertNewBoard(writeBoardVO);

        return createCount > 0;
    }

    @Override
    public BoardVO selectOneBoard(int id) {
        int updateCount = boardDao.increaseViewCount(id);
        if (updateCount == 0) {
            throw new IllegalStateException("잘못된 접근입니다.");
        }
        BoardVO boardVO = this.boardDao.selectOneBoard(id);
        return boardVO;
    }
}
