package github.sunkeun.webboard.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import github.sunkeun.webboard.dao.LoginDao;
import github.sunkeun.webboard.dto.Member;

@Service
public class UserService {
	
	@Inject
	LoginDao loginDao; 
	
	public void insertMember(Member m) {
		// TODO Auto-generated method stub
		
		loginDao.insertMember(m);
		
		
	}

	public Member login(String id, String pwd) {
		// TODO Auto-generated method stub
		
		return loginDao.login(id,pwd); 
		
		// return null;
	}

}
