package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.StudentMapper;
import com.yedam.vo.MemberVO;
import com.yedam.vo.StudentVO;

public class MemberServiceImpl implements MemberService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true); //자동으로 커밋하려고 true 넣음.
	StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
	
	
	@Override
	public MemberVO loginCheck(String id, String pw) {
		return mapper.selectMember(id, pw);
	}


	@Override
	public List<MemberVO> memberList(String res, String order) {
		// TODO Auto-generated method stub
		return mapper.memberList(res, order);
	}
	
	@Override
	public List<StudentVO> studentList() {
		// TODO Auto-generated method stub
		return mapper.studentList();
	}
	
	@Override
	public boolean removeStudent(String sno) {
		return mapper.deleteStudent(sno) == 1;
	}
	
	@Override
	public boolean addStudent(StudentVO svo) {
		// TODO Auto-generated method stub
		return mapper.insertStudent(svo) == 1;
	}
	
}
