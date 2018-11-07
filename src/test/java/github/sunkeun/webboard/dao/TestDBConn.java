package github.sunkeun.webboard.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDBConn {

	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/boardDB";
		String user = "root";
		String pass = "1111";
		
		DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
		Connection con = DriverManager.getConnection(url, user, pass);
		
		PreparedStatement stmt = con.prepareStatement("select * from posts");
		ResultSet rs = stmt.executeQuery();
		while ( rs.next()) {
			Integer seq = rs.getInt("seq");
			String title = rs.getString("title");
			String content = rs.getString("content");
			System.out.printf("%d) %s %s\n", seq, title, content);
		}
		
		rs.close();
		stmt.close();
		con.close();
		 
	}
}
