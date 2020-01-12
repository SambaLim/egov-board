package egovframework.com.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.com.board.service.MyBoardService;
import egovframework.com.board.service.MyBoardVO;

@Service("myBoardService")
public class MyBoardServiceImpl implements MyBoardService {

	@Autowired
	public MyBoardDAO myBoardDAO;
	
	@Override
	public List<MyBoardVO> selectMyBoardList() {
		return myBoardDAO.selectMyBoardList();
	}

}
