package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.StudentVO;

public interface StudentMapper {
	List<StudentVO> studentList();
	// insert, update, delete = > 변경처리된 건수 반환값으로 지정.
	int insertStudent(StudentVO svo);
	int updateStudent(StudentVO svo); // 학생번호 기준 -> 연락처변경.
	int deleteStudent(String stdNo);
}
