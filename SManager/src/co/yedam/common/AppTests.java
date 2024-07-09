package co.yedam.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import co.yedam.vo.StudentVO;

public class AppTests {
	public static Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver"; // oracle 라이브러리에 oracle.jdbc 밑에 해당 클래스가 있는지 체크하는 용도로 쓸거임.
		String user = "jsp";
		String pass = "jsp";
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("오라클 드라이버 없음.");
			e.printStackTrace();
			return null;
		}
		return conn;

	} // end of getConn
	public static void main(String[] args) {
		// 1) Oracle JDBC Driver 자바라이브러리.
			// SManager - buildpath - classpath - 오른쪽 두번째 jar?클릭 후 java 붙여넣기한거 지정
		// 2) connection 객체.
		Scanner scn = new Scanner(System.in);
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
		
		//addStudent(sno, sname, phon); //입력. 주석 풀면 add 실행되고 mod 실행됨.
//		modStudent(sno, sname, phon); // 수정
		modStu(std); //modStu(sno, sname, phon, addr, birth);
//		removeStudent(sno);
		search(); // 목록조회 메소드. 아래 주석 달았던 조회기능 부분을 밖으로 빼서 맨 밑의 메인에서 호출했음.
		
//		// 조회기능.
//		try {
//			Connection conn = getConn();
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery("select * from tbl_student");
//			// ResultSet안에 [객체1, 객체2, 객체3]을 담고 있을거임.
//			//next() 역할은 커서가 첫 데이터로 이동해서(위에서 객체1적힌 곳에) 값이 있으면 while에서 true, 없으면 false를 출력해줄거임.
//			while(rs.next()) {
//				System.out.println(rs.getString("std_no")+", "+rs.getString("std_name"));
//			}
//			System.out.println("end of data.");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		// 조회기능 끝.
	}
	
	
	// 삭제 기능.
	public static void removeStudent(String stdNo) {
		//delete from tbl_student
		//where std_no = 'S2024-04'
		Connection conn = getConn();
		String sql = "delete from tbl_student"; // = String sql = "delete from tbl_student where std_no = '"+stdNo+"'";
		sql += " where std_no = '"+stdNo+"'"; //따로 하려면 "뒤에 한 칸 띄어서 입력해야함.
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // 추가할땐 insert , 수정 update, 삭제 delete를 뒤에 붙이는 것. => 처리된 건수를 반환해주는 메소드가 executeUpdate. 타입은 int.
			System.out.println("처리된 건수는 " + r + "건.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 수정 기능 2.
	public static void modStu(StudentVO svo) { // = public static void modStu(String stdNo, String stdName, String phone, String addr, String birth) {

		Connection conn = getConn(); //nvl 널 값일 경우 원래 칼럼의 값을 ㅗ밭겠다는 뜻. stdName이 널이면 std_name으로 받겠다
		String sql = "update tbl_student";
//		sql += " set std_name = nvl('" + stdName + "', std_name)";
//		sql += " 	,std_phone = nvl('" +phone + "', std_phone)";
//		sql += " 	,address = nvl('" +addr + "', address)";
//		sql += " 	,birth_date = nvl('" +birth + "', birth_date)";
//		sql += " where std_no = '"+stdNo+"'";
		sql += " set std_name = nvl('" + svo.getStdName() + "', std_name)";
		sql += " 	,std_phone = nvl('" +svo.getStdPhone() + "', std_phone)";
		sql += " 	,address = nvl('" +svo.getAddress() + "', address)";
		sql += " 	,birth_date = nvl('" +svo.getBirthDate() + "', birth_date)";
		sql += " where std_no = '"+svo.getStdNo()+"'";
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // 추가할땐 insert , 수정 update, 삭제 delete를 뒤에 붙이는 것. => 처리된 건수를 반환해주는 메소드가 executeUpdate. 타입은 int.
			System.out.println("처리된 건수는 " + r + "건.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
			
	
	// 수정기능.
	public static void modStudent(String stdNo, String stdName, String stdPhone) {
		//update tbl_student
		//set    std_name = '변경값'
		//	       ,std_phone = '변경값'
		//	where  std_no = 'S2024-01'
		Connection conn = getConn();
		String sql = "update tbl_student";
		sql += " set std_name = '"+stdName+"',std_phone =  '"+stdPhone+"'";
		sql += " where std_no = '"+stdNo+"'";
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // 추가할땐 insert , 수정 update, 삭제 delete를 뒤에 붙이는 것. => 처리된 건수를 반환해주는 메소드가 executeUpdate. 타입은 int.
			System.out.println("처리된 건수는 " + r + "건.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	// 입력기능.
	// insert into tbl_student (std_no, std_name, std_phone)
	// values ('S2024-04', '김민규', '010-2222-5678')
	public static void addStudent(String stdNo, String stdName, String phone) {
		Connection conn = getConn();
		String sql = "insert into tbl_student (std_no, std_name, std_phone)";
		sql += "values('" + stdNo+"', '"+stdName+"', '"+phone+"')"; 
				//"values('S2024-05', '박성태', '010-6789-9876')" 에서 임의로 고정값 넣었었는데 매개로 전달되는값을 하기위해서 형태를 바꿨음.
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // 추가할땐 insert , 수정 update, 삭제 delete를 뒤에 붙이는 것. => 처리된 건수를 반환해주는 메소드가 executeUpdate. 타입은 int.
			System.out.println("처리된 건수는 " + r + "건.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	// 조회 처리 기능.
	public static void search() {
		// 조회기능.
		try {
			Connection conn = getConn();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from tbl_student order by std_no"); // 쿼리를 실행해서 statement가 해석을 함.  excuteQuery를 조회해 줌. 처리한 결과를 statement가 resultset으로 반환.resultset은 여러개를 담을 수 수 있는 데이터 구조. next를 만나서 객체 1, 2, 3을 만남.by std_no을 넣으면 목록 순서대로 됨.
			// ResultSet안에 [객체1, 객체2, 객체3]을 담고 있을거임.
			//next() 역할은 커서가 첫 데이터로 이동해서(위에서 객체1적힌 곳에) 값이 있으면 while에서 true, 없으면 false를 출력해줄거임.
			while(rs.next()) {
				String birth = rs.getString("birth_date"); // 데이터 시간까지 안나오게 하는법
				birth = birth != null ? birth.substring(0,10) : ""; // 데이터 시간까지 안나오게 하는법
				System.out.println(rs.getString("std_no")+", "+rs.getString("std_name")+", "+rs.getString("std_phone")+", "+rs.getString("address")+", "+birth);// 데이터 시간까지 안나오게 하고 공백이면 birth가 출력.
			}
			System.out.println("end of data.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 조회기능 끝.
	}
}
