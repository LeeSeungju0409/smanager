package co.yedam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * DB connection 기능.
 */
public class DAO {
	Connection conn = null;
	Statement stmt;
	PreparedStatement psmt;
	ResultSet rs;
	

	public Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver"; // oracle 라이브러리에 oracle.jdbc 밑에 해당 클래스가 있는지 체크하는 용도로 쓸거임.
		String user = "jsp";
		String pass = "jsp";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("오라클 드라이버 없음.");
			e.printStackTrace();
		}
		return conn;
			
	} // end of getConn
}


	

