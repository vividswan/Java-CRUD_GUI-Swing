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
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb?serverTimezone=UTC", "root",
					"1234567890");
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
	
	
	public String[][] userList() {
		ArrayList<String[]> list = new ArrayList<String[]>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from user");
			rs = pstmt.executeQuery();
				while(rs.next()) {
					list.add(new String[] {
							Integer.toString(rs.getInt(1)),
							rs.getString(2),
							rs.getString(3),
							Integer.toString(rs.getInt(4))
					});
				}
		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			close(conn, pstmt, rs);
		}
		String[][] arr = new String[list.size()][4];
		return list.toArray(arr);
	}
	
	public String[][] findByName(String name) {
		ArrayList<String[]> list = new ArrayList<String[]>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from user where name like '%"+name+"%';");
			rs = pstmt.executeQuery();
				while(rs.next()) {
					list.add(new String[] {
							Integer.toString(rs.getInt(1)),
							rs.getString(2),
							rs.getString(3),
							Integer.toString(rs.getInt(4))
					});
				}
		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			close(conn, pstmt, rs);
		}
		String[][] arr = new String[list.size()][4];
		return list.toArray(arr);
	}
	
	
	public void userInsert(UserVO user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into user(name,email,age) values(?,?,?)");
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setInt(3, user.getAge());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("오류 발생 : " + e);
		} finally {
			close(conn, pstmt);
		}
	}

	


}
