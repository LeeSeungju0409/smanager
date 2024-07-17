package co.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.mapper.DataSource;
import co.yedam.mapper.StudentMapper;
import co.yedam.vo.StudentVO;

public class MybatisTest {
	public static void main(String[] args) {
		SqlSessionFactory factory = DataSource.getInstance();
		SqlSession sqlSession = factory.openSession();// SqlSession 객체를 얻는 방법.
		// 매퍼 인터페이스의 구현 
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		StudentVO student = new StudentVO();
		student.setStdNo("S2024-09");
//		student.setStdName("김동동");
		student.setStdPhone("010-9999-5555");
		
		int cnt = mapper.updateStudent(student);
//		int cnt = mapper.insertStudent(student);
//		System.out.println("처리된 건수: " + cnt);
		sqlSession.commit(); // 커밋을 하는 것이 귀찮다면 ... openSession에 (true)를 넣어주면 됨.openSession(true) 이렇게 바꿨다면 여기서는 커밋없애기.
		
//		int cnt = mapper.deleteStudent(student.getStdNo());
//		System.out.println("처리된 건수: " + cnt);
//		sqlSession.commit(); // 커밋을 하는 것이 귀찮다면 ... openSession에 (true)를 넣어주면 됨.openSession(true) 이렇게 바꿨다면 여기서는 커밋없애기.

		
		List<StudentVO> list = mapper.studentList();
		for(StudentVO svo : list) {
			System.out.println(svo);
		}
		System.out.println("OK");
	}
}
