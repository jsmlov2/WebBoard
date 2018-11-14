package github.sunkeun.webboard.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import github.sunkeun.webboard.dto.Post;
import github.sunkeun.webboard.service.PostService;

/**
 * Handles requests for the application home page.
 * 
 *   http://localhost:8084     /webboardyes
 *                     
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	PostService postService; //@Service찾아서 자동으로 객체생성
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		model.addAttribute("ggg", "SDFEEDD " );
		
		return "home";
	}
	/**
	 * 
	 * 
	 * <beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<beans:property name="prefix" value="/WEB-INF/views/" />
		<beans:property name="suffix" value=".jsp" />
	</beans:bean>
	 * @return
	 * 
	 * /WEB-INF/views/yes.jsp
	 */
	@RequestMapping(value = "/yes", method = RequestMethod.GET)
	public String pageYes ( ) {
		return "yes";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String pageList (HttpServletRequest req ) {
		List<Post> all = postService.findAll();
		req.setAttribute("posts", all);
		
		return "list";
	}
	// /content/22222
	// http://localhost:8080/webboard/content/yes
	
	@RequestMapping(value = "/content/{pnum}", method = RequestMethod.GET)
	public String pageContent ( @PathVariable Integer pnum,HttpServletRequest req) {
		Post post = postService.findPostBySeq ( pnum );
		System.out.println(post); // null
		req.setAttribute("post", post);
		return "content";
	}
	
	// /content?pnum=1001
	/*
	@RequestMapping(value = "/content", method = RequestMethod.GET)
	public String pageContent2 ( @RequestParam Integer pnum, HttpServletRequest req) {
		Post post = postService.findPostBySeq ( pnum );
		System.out.println(post); // null
		req.setAttribute("post", post);
		return "content";
	}
	*/
	
	//http://localhost:8080/webboard/write
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String pageWrite ( HttpServletRequest req) {
		return "write";
	}

	/**
	 *                     GET /list
	 *                     req#0
	 *                     .
	 *                     .
	 *                     .
	 *                     .
	 *   htmlskdk
	 *   
	 *     
	 *     
	 * 
	 *          POST /doWrite  tt cc
	 *          .
	 *          .
	 *          .
	 *          .
	 *    <----- /list 로 다시 요청을 보내!\
	 *    
	 *          
	 * 
	 *  
	 * @param tt
	 * @param cc
	 * @param req
	 * @return
	 */
	//http://localhost:8080/webboard/doWrite
	@RequestMapping(value = "/doWrite", method = RequestMethod.POST)
	public String pagedoWrite (@RequestParam String tt, @RequestParam String cc, HttpServletRequest req ) {
		// req.setCharacterEncoding("UTF-8");
		// postSerivce.insertPost( dkdkdkdkdkdk, dkdkdkdk )
		System.out.println("title:" + tt);
		System.out.println("cc: " + cc);
		
		postService.insertPost( cc, tt );
		
		return "redirect:/list"; //
	}
	
	//@RequestMapping(value = "/delete?seq={seq}", method = RequestMethod.POST)
	// public String pagedoWrite (@RequestParam int seq ) {
	@RequestMapping(value = "/delete/{seq}", method = RequestMethod.POST)
	public String pagedoWrite (@PathVariable int seq ) {
		
	    System.out.println(seq);
		postService.deletePost(seq);
		
		return "redirect:/list"; //
	}

//	@RequestMapping(value = "/update/{seq}", method = RequestMethod.GET)
//	public String pageUpdate (@RequestParam int seq ,HttpServletRequest req) {
		@RequestMapping(value = "/update/{seq}", method = RequestMethod.GET)
	public String pageUpdate (@PathVariable int seq ,HttpServletRequest req) {
		
	    System.out.println(seq);
	    
	    
	    Post p = postService.findPostBySeq(seq);
	    req.setAttribute("post", p);
		
	    // postService.updatePost(seq);
		
		return "update"; // 302 /board/update
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String pageUpdate (@RequestParam int seq, @RequestParam String title,  
			@RequestParam String content) {
		
	    System.out.println(seq);
	    
	    postService.updatePost(seq,title,content);		
		return "redirect:/list"; 
	}

	
}
