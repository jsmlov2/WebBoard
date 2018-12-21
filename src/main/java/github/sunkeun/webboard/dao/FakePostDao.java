package github.sunkeun.webboard.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Repository;

import github.sunkeun.webboard.dto.Member;
import github.sunkeun.webboard.dto.Post;

/**
 * PostDao p = new PostDao();
 * @author 조선근
 *
 */
public class FakePostDao implements IPostDao {

	List<Post> fakes = fakes = new ArrayList<>(); // ; statment;
	{		
	
		fakes.add(new Post(1000, "t1", "content"));
		fakes.add(new Post(1001, "t2", "yes"));
		fakes.add(new Post(1002, "t3", "cosfa;sdkfja;sldk sa;dlkfjds fent"));
	}
	/* (non-Javadoc)
	 * @see github.sunkeun.webboard.dao.IPostDao#findAll()
	 */
	@Override
	public List<Post> findAll() {
			
		
		return fakes;
	}

	/* (non-Javadoc)
	 * @see github.sunkeun.webboard.dao.IPostDao#findPostBySeq(java.lang.Integer)
	 */
	@Override
	public Post findPostBySeq(Integer seq) {
		
		Post target = null;
		// Integer s= target.getSeq(); // null.getSeq(); npe 
		
		for (int i = 0; i < fakes.size(); i++) {
			
			if(fakes.get(i).getSeq().equals(seq)) {
				target = fakes.get(i);
			}
		}
		
		return target;
	}

	/* (non-Javadoc)
	 * @see github.sunkeun.webboard.dao.IPostDao#insertPost(java.lang.String, java.lang.String)
	 */
	@Override
	public void insertPost(String tt, String cc, List<String> tag, Member writer) {
		// TODO Auto-generated method stub
		Integer seq = fakes.get(fakes.size()-1).getSeq() + 1;
		fakes.add(new Post(seq, tt, cc));
		
	}
	

	/* (non-Javadoc)
	 * @see github.sunkeun.webboard.dao.IPostDao#deletetPost(int)
	 */
	@Override
	public void deletetPost(int seq) {
		// TODO Auto-generated method stub
		
		ListIterator<Post> it = fakes.listIterator();
		while ( it.hasNext()) {
			Post p = it.next();
			if(p.getSeq().equals(seq)) {
				it.remove();
			}
			
		}
		
		/*
		Post del = null;
		for (Post post : fakes) {
			if(post.getSeq().equals(seq)) {
				del = post;
				break;
			}
		}
		
		if ( del != null ) {
			fakes.remove(del);
		}
		*/
	}

	/* (non-Javadoc)
	 * @see github.sunkeun.webboard.dao.IPostDao#updatePost(int, java.lang.String, java.lang.String)
	 */
	@Override
	public void updatePost(int seq, String title, String content) {
		// TODO Auto-generated method stub
		
		 Post p = null;
	     for (Post post : fakes) {
			if(post.getSeq().equals(seq)) {
				p = post;
				break;
			}
		}
		p.setTitle(title);
		p.setContent(content);
	}
}
