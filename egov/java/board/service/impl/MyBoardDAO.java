package egovframework.com.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.board.service.MyBoardVO;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class MyBoardDAO extends EgovComAbstractDAO {
	
	/*
	 * 게시판 글 목록조회
	 */
	public List<MyBoardVO> selectMyBoardList() {
		return selectList("myBoardList");
	}
}
