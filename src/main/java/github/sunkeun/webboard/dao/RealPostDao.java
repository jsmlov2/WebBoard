package github.sunkeun.webboard.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import github.sunkeun.webboard.dto.Post;
import github.sunkeun.webboard.dto.Tag;

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
	
	// @Inject SqlSessionFactory fac;
	
	@Inject SqlSession session;
	
	
	
	@Override
	public List<Post> findAll() {
		List<Post> allPosts = session.selectList("PostMapper.findAll");
		return allPosts;
	}
	/*
	public List<Post> findAll() {
		
		SqlSession session = fac.openSession();
		try {
			List<Post> allPosts = session.selectList("PostMapper.findAll");
			return allPosts;			
		} finally {
			session.close(); // conn.close();
		}
	}
	*/

	@Override
	public Post findPostBySeq(Integer no) {
		Post post = session.selectOne("PostMapper.findPostBySeq",no);
		return post;
	/*	try {
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
		}*/
		
	}

	Long findTagSeq ( String tagName ) { // Tag
		// insert IGNORE into tab_name
		Long tagSeq = session.selectOne("TagMapper.findTagByName", tagName);
		
		if ( tagSeq == null) {
			Tag newTag = new Tag(tagName);
			session.insert("TagMapper.insertTag", newTag);
			tagSeq = newTag.getSeq();
		}
		
		return tagSeq;
	}
	
	@Override
	public void insertPost(String tt, String cc, List<String> tags) {
		// TODO Auto-generated method stub
		Post p = new Post(null, tt, cc); // seq == null 
		int inserted = session.insert("PostMapper.insertPost", p);
		if ( inserted != 1 ) {
			// error!
		}
		System.out.println("[GEN POST SEQ] " + p.getSeq());
		
		for(String tag : tags ) {
			Long tagSeq = findTagSeq(tag);			
			Map<String, Object> param = new HashMap<>();
			param.put("post", p);
			param.put("tag", tagSeq);
			session.insert("TagMapper.insertMapping", param );
		}
		
		
	}


	@Override
	public void deletetPost(int seq) {
		// TODO Auto-generated method stub
		
		session.delete("PostMapper.deletetPost",seq);
		/*try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement("delete from posts where seq=?");
			stmt.setInt(1, seq);
			int rs = stmt.executeUpdate();
			
			if(rs!=1){
				throw new RuntimeException("insert fail!!!");
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}*/
		
	}

	@Override  
	public void updatePost(int seq, String title, String content) {
		Map<String, Object> param = new HashMap<>();
		param.put("t", title);
		param.put("content", content);
		param.put("pk", seq);
		
		int rupdate = session.update("PostMapper.updatePost", param);
		if ( rupdate != 1 ) {
			System.out.println("안 먹었음!!!!" + seq);
		}
		
		// TODO Auto-generated method stub
/*		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement("update posts set title =? , content=? where seq =?");
			stmt.setString(1, title);
			stmt.setString(2, content);
			stmt.setInt(3, seq);
			int rs = stmt.executeUpdate();
			
			if(rs!=1){
				throw new RuntimeException("insert fail!!!");
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}*/
		
	}

}
