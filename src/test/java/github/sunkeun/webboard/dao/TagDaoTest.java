package github.sunkeun.webboard.dao;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import github.sunkeun.webboard.dto.Post;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
public class TagDaoTest {

	@Inject RealPostDao postDao;
	
	@Test
	public void test_태그명으로_조회() {
		Long seq = postDao.findTagSeq("asdf");
		assertNotNull(seq);
		seq = postDao.findTagSeq("nothing");
		assertNotNull(seq);
		
	}
	
	@Test
	public void test_글조회_태그도같이() {
		Post p = postDao.findPostBySeq(21);
		assertNotNull(p);
		assertNotNull(p.getTags());
		assertEquals(2, p.getTags().size());
		System.out.println(p.getTags());
	}
	
	@Test
	@Ignore
	public void test_insert_post() {
		
		postDao.insertPost("new post", "content of new post", "xyz");
	}

	
	int add( int a, int b, int c) {
		return a + b * c;
	}
}
