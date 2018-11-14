package github.sunkeun.webboard.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import github.sunkeun.webboard.dto.Member;
import github.sunkeun.webboard.service.UserService;

@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	UserService userService ;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String login() {
		
		
		
		return "/join";
	}
 
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String insertMember(@RequestParam String id, @RequestParam String pw, 
			@RequestParam String name, @RequestParam String address, @RequestParam String  eMail ) {
		
		System.out.println("%s %s %S %S %S"+id+pw+name+address+eMail);
		Member m = new Member();
		m.setId(id);
		m.setPw(pw);
		m.setName(name);
		m.setAddress(address);
		m.seteMail(eMail);
		
		userService.insertMember(m);
		
		return "/confirmLogin";
		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String doLogin() {
		
		
		return "/confirmLogin";
	}
	
	@RequestMapping(value="/doLogin", method=RequestMethod.POST)
	public String doLogin(@RequestParam String id, @RequestParam String pw, HttpSession session) {
		
		Member m = userService.login(id,pw);
		
		System.out.println("login user: " + m);
		if(m!=null) {
			
			session.setAttribute("Member", m);
			// 302 
			// location /xxxx/list
			//return "/list"; // <- list.jsp
			return "redirect:/list"; // http://localhost:8080/webboard/list (브라우저 재요청)
		}else {
			session.setAttribute("error", "LOOGIN_ERR");
			return "redirect:/login";
		}
		
	}
	
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		
		
		if(session != null) {
			session.removeAttribute("Member");
			session.invalidate();
		}
	
		return "redirect:/list";
		
	}
	

	
}
