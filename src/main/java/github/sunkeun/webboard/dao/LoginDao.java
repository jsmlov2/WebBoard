package github.sunkeun.webboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import github.sunkeun.webboard.dto.Member;


@Repository
public class LoginDao {

	
  @Inject DataSource ds;
  @Inject SqlSession session; // SqlSession session = new SqlSession();
  
	public void insertMember(Member m) {
		// TODO Auto-generated method stub
		System.out.println(m.getId());
		
		session.insert("UserMapper.insertMember", m);
		
	/*	Map<String,Object> param = new HashMap<>();
		param.put("id", m.getId());
		param.put("pw",  m.getPw());
		param.put("name", m.getName());
		param.put("address", m.getAddress());
		param.put("eMail", m.geteMail());
		param.put("rDate", m.getrDate());
		
		session.insert("UserMapper.insertMember", param);*/
	/*	try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement("insert into members (id, pw, name, eMail, address) "
					+ "values(?, ?, ?, ?, ?)");
			
			stmt.setString(1,m.getId() );
			stmt.setString(2,m.getPw() );
			stmt.setString(3,m.getName() );
			stmt.setString(4,m.geteMail() );
			stmt.setString(5,m.getAddress() );
			int rs = stmt.executeUpdate();
			
			if(rs!=1) {
				System.out.println("데이터 안들어감");
			}
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	*/
	}

	public Member login(String id, String pw) {
		// TODO Auto-generated method stub
		
		Map<String, Object> param = new HashMap<>();
		param.put("id", id);
		param.put("pw", pw);
		
		Member m = (Member)session.selectOne("UserMapper.login", param);
		return m;
		
		/*
		
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement("select m.*" + 
					" from members m" + 
					" where  m.id = ?  and m.pw = ? ");
			
			stmt.setString(1, id );
			stmt.setString(2, pwd );
			
			ResultSet rs = stmt.executeQuery();
			
			
			if( rs.next()) {
				String name = rs.getString("name");
				String address = rs.getString("address");
				String eMail = rs.getString("eMail");
				String rDate = rs.getString("rDate");
				
				m  = new Member();
				m.setId(id);
				m.setPw(pwd);
				m.setName(name);
				m.setAddress(address);
				m.seteMail(eMail);
				m.setrDate(rDate);
			}
			
			return m ;
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}*/
		
	}

}
