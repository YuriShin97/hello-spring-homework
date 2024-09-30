package com.ktdsuniversity.edu.hellospringhomework.bbs.dao;

import com.ktdsuniversity.edu.hellospringhomework.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.hellospringhomework.bbs.vo.WriteBoardVO;

import java.util.List;

// 게시판 관련 동작을 정의한 DAO 인터페이스
public interface BoardDao {

	// 전체 게시판 글 수를 반환하는 메서드 정의
	public int selectBoardAllCount();

	// 전체 게시판 내용을 반환하는 메서드 정의
	public List<BoardVO> selectAllBoard();

	// 새 게시판 글을 삽입하는 메서드 정의
	public int insertNewBoard(WriteBoardVO writeBoardVo);

	// 게시판 글의 조회수를 증가시키는 메서드 정의
	public int updateViewCount(int id);

	// 특정 ID를 가진 게시글의 정보를 반환하는 메서드 정의
	public BoardVO selectOneBoard(int id);
}
