package com.ktdsuniversity.edu.hellospringhomework.bbs.service.impl;

import com.ktdsuniversity.edu.hellospringhomework.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.hellospringhomework.bbs.service.BoardService;
import com.ktdsuniversity.edu.hellospringhomework.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.hellospringhomework.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.hellospringhomework.bbs.vo.WriteBoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 서비스 구현체를 선언하고 이를 스프링에 등록
@Service
public class BoardServiceImpl implements BoardService {

    // BoardDao 선언
    @Autowired
    private BoardDao boardDao;

    // 모든 게시글을 가져오는 메소드
    @Override
    public BoardListVO getAllBoards() {
        BoardListVO boardListVO = new BoardListVO(); // 이 객체에 메소드 반환값 저장 예정
        // 게시글 개수 세팅
        boardListVO.setBoardCnt(boardDao.selectBoardAllCount());
        // 게시글 리스트 세팅
        boardListVO.setBoardList(boardDao.selectAllBoard());
        return boardListVO; // 세팅된 객체 반환
    }

    // 새로운 게시글을 생성하는 메소드
    @Override
    public boolean createNewBoard(WriteBoardVO writeBoardVO) {
        // 삽입된 게시글 수를 확인
        int createCount = boardDao.insertNewBoard(writeBoardVO);
        return createCount > 0; // 생성된 게시글이 있으면 true 반환
    }

    // 하나의 게시글을 선택하는 메소드
    @Override
    public BoardVO selectOneBoard(int id) {
        // 조회수를 증가시킴
        int updateCount = boardDao.updateViewCount(id);

        // 조회수를 증가시킨 수가 0이면 예외를 던짐
        if (updateCount == 0) {
            throw new IllegalStateException("잘못된 접근입니다.");
        }
        // 해당 id의 게시글 정보 가져옴
        BoardVO boardVO = this.boardDao.selectOneBoard(id);
        return boardVO;
    }
}
