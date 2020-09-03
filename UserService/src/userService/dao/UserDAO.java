package userService.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import userService.vo.UserVO;

public class UserDAO {
	
	
	private static UserDAO dao = new UserDAO();
	
	private UserDAO() {}
	
	public static UserDAO getInstance() {
		return dao;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/webdb?serverTimezone=UTC";
			String user = "root";
			String password = "1234567890";
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
			
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
		return conn;
	}
	
	public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				System.out.println("오류 발생 : " + e);
			}
		}
		close(conn, ps);
	}
	
	public void close(Connection conn, PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception e) {
				System.out.println("오류 발생 : " + e);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println("오류 발생 : " + e);
			}
		}
	}
	
	
	public ArrayList<UserVO> userList() {
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		UserVO user = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from user");
			rs = pstmt.executeQuery();
				while(!rs.next()) {
				user = new UserVO();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setAge(rs.getInt(4));
				list.add(user);
				}
		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
	
	
	public void userInsert(UserVO user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into book values(?,?,?)");
			pstmt.setInt(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getEmail());
			pstmt.setInt(4, user.getAge());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			close(conn, pstmt);
		}
	}

	


}
