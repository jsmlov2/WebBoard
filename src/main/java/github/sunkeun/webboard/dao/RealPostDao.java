package github.sunkeun.webboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import github.sunkeun.webboard.dto.Post;

@Repository
public class RealPostDao implements IPostDao{
	/*
	String url = "jdbc:mysql://localhost:3306/boardDB";
	String user = "root";
	String pass = "1111";
	static {
		try {
			DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	*/
	@Inject DataSource ds;
	
	@Override
	public List<Post> findAll() {
		
		try {
			Connection con = ds.getConnection();			
			PreparedStatement stmt = con.prepareStatement("select * from posts");
			ResultSet rs = stmt.executeQuery();
			List<Post> all = new ArrayList<>();
			while ( rs.next()) {
				Integer seq = rs.getInt("seq");
				String title = rs.getString("title");
				String content = rs.getString("content");
				all.add(new Post(seq, title, content));
			}
			con.close();
			return all;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Post findPostBySeq(Integer no) {
		try {
			Connection con = ds.getConnection();			
			PreparedStatement stmt = con.prepareStatement("select * from posts where seq = ? ");
			stmt.setInt(1, no);
			ResultSet rs = stmt.executeQuery();
			
			
			Post all = null;
			if ( rs.next()) {
				Integer seq = rs.getInt("seq");
				String title = rs.getString("title");
				String content = rs.getString("content");
				all = new Post(seq, title, content);
			}
			return all;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void insertPost(String tt, String cc) {
		// TODO Auto-generated method stub
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement("insert into posts (title, content)" + 
					"values (?, ? )");
			stmt.setString(1, tt);
			stmt.setString(2, cc);
			int rs = stmt.executeUpdate();
			/*
			if(rs!=1){
				throw new RuntimeException("insert fail!!!");
			}
			*/
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}


	@Override
	public void deletetPost(int seq) {
		// TODO Auto-generated method stub
		
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement("delete from posts where seq=?");
			stmt.setInt(1, seq);
			int rs = stmt.executeUpdate();
			/*
			if(rs!=1){
				throw new RuntimeException("insert fail!!!");
			}
			*/
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override  
	public void updatePost(int seq, String title, String content) {
		// TODO Auto-generated method stub
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement("update posts set title =? , content=? where seq =?");
			stmt.setString(1, title);
			stmt.setString(2, content);
			stmt.setInt(3, seq);
			int rs = stmt.executeUpdate();
			/*
			if(rs!=1){
				throw new RuntimeException("insert fail!!!");
			}
			*/
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
