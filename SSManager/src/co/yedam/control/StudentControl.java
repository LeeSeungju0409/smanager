package co.yedam.control;

import java.util.List;
import java.util.Scanner;

import co.yedam.dao.StudentDAO;
import co.yedam.vo.StudentVO;

/*
 * 사용자입력을 가이드, 처리된 결과 출력.
 */
public class StudentControl {
	Scanner scn = new Scanner(System.in);
	StudentDAO sdao = new StudentDAO(); // StudentDAO = 기능 활용해서 추가적인 기능을 만들어본 클래스.

	public void run() {
		boolean isTrue = true;

		while (isTrue) {
			System.out.println("1.학생목록  2.등록  3.수정  4.삭제  5.종료");
			System.out.print("선택> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				studentList();
				break;
			case 2:
				addStudent();
				break;
			case 3:
				modifyStudent();
				break;
			case 4:
				delStudent();
				break;
			case 5:
				System.out.println("종료합니다.");
				isTrue = false;
			}
		}
	} // end of run().

	// 삭제기능.
	void delStudent() {
		String sno = "";
			System.out.println("삭제할 학생번호>");
			sno = scn.nextLine();
			
			StudentVO std = new StudentVO();
			std.setStdNo(sno);
			if (sdao.deleteStudent(std)) { // 메소드끼리 이름이 같을 수 없어서 delStudent로 썼음.
				System.out.println("삭제완료!");
			} else {
				System.out.println("삭제할 번호가 없습니다.");
			}
		
	}

	// 수정기능.
	void modifyStudent() {
		String sno = ""; // sno 변수를 while 구문 밖에서 써야하기때문에 여기서 선언
		while (true) {
			System.out.println("변경할 학생번호>");
			sno = scn.nextLine();
			if (sdao.selectExists(sno) == 1) {
				// 학생번호 존재.
				break;
			}
			System.out.println("찾는 학생번호가 없음 학생번호 다시 입력> ");
		}
		System.out.println("변경할 연락처>");
		String phone = scn.nextLine();
		System.out.println("변경할 주소>");
		String addr = scn.nextLine();

		StudentVO svo = new StudentVO();
		svo.setAddress(addr);
		svo.setStdPhone(phone);
		svo.setStdNo(sno);

		if (sdao.updateStudent(svo)) {
			System.out.println("수정완료!");
		}
	}

	// 등록기능.
	void addStudent() {
		System.out.println(">학생번호 입력.");
		String sno = scn.nextLine(); // 입력하는 걸 받아들이는 메소드가 nextLine.
		System.out.println(">학생이름 입력.");
		String sname = scn.nextLine();
		System.out.println(">연락처 입력.");
		String phon = scn.nextLine();
		System.out.println(">주소 입력.");
		String addr = scn.nextLine();
		System.out.println(">생일 입력.");
		String birth = scn.nextLine();

		StudentVO std = new StudentVO();
		std.setStdNo(sno);
		std.setStdName(sname);
		std.setStdPhone(phon);
		std.setAddress(addr);
		std.setBirthDate(birth);

		// 입력기능 호출.
		if (sdao.insertStudent(std)) {
			System.out.println("저장완료!");
		} else {
			System.out.println("처리중 예외발생!");
		}
	}

	// 목록 출력 기능.
	void studentList() {
		List<StudentVO> students = sdao.selectList();
		System.out.println("학생번호   학생이름     연락처");
		System.out.println("--------------------------------");
		for (StudentVO svo : students) {
			System.out.println(svo.briefShow());
		}
	} // end of studentList().

}
