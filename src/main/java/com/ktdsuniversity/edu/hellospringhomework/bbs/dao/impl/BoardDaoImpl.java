package com.ktdsuniversity.edu.hellospringhomework.bbs.dao.impl;

import com.ktdsuniversity.edu.hellospringhomework.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.hellospringhomework.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.hellospringhomework.bbs.vo.WriteBoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDao {

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    @Override
    public int selectBoardAllCount() {
        return getSqlSession().selectOne("com.ktdsuniversity.edu.hellospringhomework.bbs.dao.BoardDao.selectBoardAllCount");
    }

    @Override
    public List<BoardVO> selectAllBoard() {
        return getSqlSession().selectList("com.ktdsuniversity.edu.hellospringhomework.bbs.dao.BoardDao.selectAllBoard");
    }

    @Override
    public int insertNewBoard(WriteBoardVO writeBoardVO) {
        return this.getSqlSession().insert("com.ktdsuniversity.edu.hellospringhomework.bbs.dao.BoardDao.insertNewBoard", writeBoardVO);
    }

    @Override
    public int increaseViewCount(int id) {
        return this.getSqlSession().update("com.ktdsuniversity.edu.hellospringhomework.bbs.dao.BoardDao.increaseViewCount", id);
    }

    @Override
    public BoardVO selectOneBoard(int id) {
        return this.getSqlSession().selectOne("com.ktdsuniversity.edu.hellospringhomework.bbs.dao.BoardDao.selectOneBoard", id);
    }
}
