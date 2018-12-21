package github.sunkeun.webboard;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import github.sunkeun.webboard.dto.Member;

public class ObjectmapperTest {

	@Test
	public void test() throws JsonProcessingException {
		Member m = new Member();
		m.setId("XXXXX");
		Member m2 = new Member();
		m2.setId("YYYY");
		List<Member> members = new  ArrayList<>();
		members.add(m);
		members.add(m2);
		
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(members);
		System.out.println(json);
		
	}

}
