package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.common.SearchVO;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService {
	SqlSession SqlSession = DataSource.getInstance().openSession(true);
	ReplyMapper mapper = SqlSession.getMapper(ReplyMapper.class);

	@Override
	public List<ReplyVO> replyList(SearchVO search) {
		// TODO Auto-generated method stub
		return mapper.selectListPaging(search);
	}

	@Override
	public boolean addReply(ReplyVO rvo) {
		// TODO Auto-generated method stub
		return mapper.insertReply(rvo) == 1;
	}

	@Override
	public boolean removeReply(int replyNo) {
		// TODO Auto-generated method stub
		return mapper.deleteReply(replyNo) == 1;
	}

	
	@Override
	public int replyTotalCnt(int boardNo) {
		// TODO Auto-generated method stub
		return mapper.totalReplyCnt(boardNo);
	}
}
