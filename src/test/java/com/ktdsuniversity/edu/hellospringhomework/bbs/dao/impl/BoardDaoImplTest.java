package com.ktdsuniversity.edu.hellospringhomework.bbs.dao.impl;

import com.ktdsuniversity.edu.hellospringhomework.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.hellospringhomework.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.hellospringhomework.bbs.vo.WriteBoardVO;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(BoardDaoImpl.class)
public class BoardDaoImplTest {

    @Autowired
    private BoardDao boardDao;

    @Test
    public void testSelectBoardAllCount() {
        int count = this.boardDao.selectBoardAllCount();
        System.out.println("boardCount: " + count);
    }

    @Test
    public void testSelectAllBoard() {
        List<BoardVO> boardList = this.boardDao.selectAllBoard();
        System.out.println("boardList: " + boardList);
    }

    @Test
    public void testInesrtNewBoard(){
        WriteBoardVO writeBoardVO = new WriteBoardVO();
        writeBoardVO.setContent("Test Content");
        writeBoardVO.setEmail("Test Email");
        writeBoardVO.setSubject("Test Subject");

        int count = this.boardDao.insertNewBoard(writeBoardVO);
        assertTrue(count == 1);
        System.out.println("boardCount: " + count);
    }

    @Test
    public void testIncreaseViewCount(){
        int boardId = 4;

        BoardVO beforeIncreaseViewCount = this.boardDao.selectOneBoard(boardId);
        int viewBeforeIncrease = beforeIncreaseViewCount.getViewCnt();
        System.out.println("조회수 증가 전: " + viewBeforeIncrease);

        boardDao.increaseViewCount(boardId);

        BoardVO afterIncreaseViewCount = this.boardDao.selectOneBoard(boardId);
        int viewAfterIncrease = afterIncreaseViewCount.getViewCnt();

        assertTrue(viewAfterIncrease > viewBeforeIncrease);
        System.out.println("조회수 증가 후: " + viewAfterIncrease);
    }

    @Test
    public void testSelectOneBoard(){
        int boardId = 4;

        BoardVO board = this.boardDao.selectOneBoard(boardId);

        assertNotNull(board);
        assertEquals(boardId, board.getId());

        System.out.println("boardId: " + board.getId());
        System.out.println("subject: " + board.getSubject());
        System.out.println("email: " + board.getEmail());
        System.out.println("viewCnt: " + board.getViewCnt());
        System.out.println("subject: " + board.getSubject());
    }
}
