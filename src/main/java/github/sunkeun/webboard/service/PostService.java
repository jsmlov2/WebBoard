package github.sunkeun.webboard.service;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import github.sunkeun.webboard.dao.IPostDao;
import github.sunkeun.webboard.dto.Member;
import github.sunkeun.webboard.dto.Post;

/**
 * 주문
 * 
 * 택배디비 insert 문자디비 문자 날림 insert update
 * 
 * @author 조선근
 *
 */
@Service
public class PostService {

	@Inject
	IPostDao postDao;

	public List<Post> findAll() {
		return postDao.findAll();
	}

	/**
	 * 주어진 PK 값에 해당하는 글을 하나 찾아서 반환해 달라!
	 * 
	 * @param seq
	 * @return
	 */
	public Post findPostBySeq(Integer seq) {
		return postDao.findPostBySeq(seq);
	}

	public void insertPost(String tt, String cc, String tag, Member writer) {
		// TODO Auto-generated method stub
		// java,c#,css
		String[] tags = tag.split(",");
		List<String> tagList = Arrays.asList(tags); // String 배열을 List<String> 으로 변환

		postDao.insertPost(tt, cc, tagList, writer);
		// mmsDao.insert()

	}

	public void deletePost(int seq) {
		// TODO Auto-generated method stub

		postDao.deletetPost(seq);

	}

	public void updatePost(int seq, String title, String content) {
		// TODO Auto-generated method stub
		postDao.updatePost(seq, title, content);
	}

}
