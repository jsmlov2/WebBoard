package github.sunkeun.webboard.dao;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

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
public class PostDaoTest {

	@Inject RealPostDao postDao;
	
	@Test
	public void test_글조회() {
		Post p = postDao.findPostBySeq(21);
		assertNotNull(p.getWriter());
		assertNotNull(p.getWriter().getId());
		assertNotNull(p.getWriter().getName());
	}
}
