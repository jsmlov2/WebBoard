package github.sunkeun.webboard.dao;

import java.util.List;

import github.sunkeun.webboard.dto.Post;


public interface IPostDao {

	List<Post> findAll();

	Post findPostBySeq(Integer seq);

	void insertPost(String tt, String cc, String tag);

	void deletetPost(int seq);

	void updatePost(int seq, String title, String content);

}