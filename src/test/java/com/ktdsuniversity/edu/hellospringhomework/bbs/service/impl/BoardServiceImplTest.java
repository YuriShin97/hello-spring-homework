package com.ktdsuniversity.edu.hellospringhomework.bbs.service.impl;

import com.ktdsuniversity.edu.hellospringhomework.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.hellospringhomework.bbs.dao.impl.BoardDaoImpl;
import com.ktdsuniversity.edu.hellospringhomework.bbs.service.BoardService;
import com.ktdsuniversity.edu.hellospringhomework.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.hellospringhomework.bbs.vo.WriteBoardVO;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Import({BoardServiceImpl.class, BoardDaoImpl.class})
public class BoardServiceImplTest {

    @Autowired
    private BoardService boardService;

    @MockBean
    private BoardDao boardDao;

    @Test
    public void testCreateNewBoard(){

        WriteBoardVO writeBoardVO = new WriteBoardVO();

        BDDMockito.given(boardDao.insertNewBoard(writeBoardVO)).willReturn(1);

        boolean isSuccess = this.boardService.createNewBoard(writeBoardVO);
        assertTrue(isSuccess);
        System.out.println("isSuccess: " + isSuccess);
    }

}
