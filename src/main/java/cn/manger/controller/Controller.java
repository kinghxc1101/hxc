package cn.manger.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.manger.model.Tuser;
import cn.manger.service.Service;

@org.springframework.stereotype.Controller
public class Controller {
	private static Log LOG = LogFactory.getLog(CodeController.class);
	@Resource(name = "service")
	private Service service;

	@RequestMapping(value = "/reg")
	public ModelAndView regview() {
		LOG.info("/reg");
		ModelAndView modelview = new ModelAndView();
		modelview.setViewName("/WEB-INF/front/reg.jsp");
		return modelview;

	}

	@RequestMapping("/index.jhtml")
	public ModelAndView index() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/WEB-INF/front/index.jsp");
		return modelAndView;
	}

	@RequestMapping(value = "/register")
	public String register(Tuser user, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String validateCode = request.getParameter("validateCode");
		String sessionCode = (String) session.getAttribute("sessionCode");
		if (validateCode.equalsIgnoreCase(sessionCode)) {
			user.setPassword(DigestUtils.md5Hex(user.getPassword()));
			service.saveorupdate(user);
			session.setAttribute("user", user);
		}
		return "redirect:/index.jhtml";
	}

	@RequestMapping(value = "/validEmail")
	public @ResponseBody
	String validEmail(String email) {
		String result = "true";
		// if (StringUtils.isNotBlank(email)) {
		// Pattern regex = Pattern
		// .compile("[A-Z0-9a-z._%+-]+@[A-Z0-9a-z.-]+\\.[A-Za-z]{2,6}");
		// Matcher matcher = regex.matcher(email);
		// if (matcher.find()) {
		Tuser user = (Tuser) service.find(Tuser.class, "email", email);
		if (user != null) {
			result = "false";
		}
		// } else {
		// result = "email is exit";
		// }
		// } else {
		// result = "email fomat error";
		// }
		// }
		return result;
	}

	// @RequestMapping(value = "/saveorupdate")
	// public ModelAndView saveorupdate() {
	// Student student = (Student) service.find(Student.class, 1);
	// // String password = DigestUtils.md5Hex("sssss");
	// student.setName("sasd");
	// service.saveorupdate(student);
	// ModelAndView modelview = new ModelAndView();
	// modelview.setViewName("/WEB-INF/front/save.jsp");
	// return modelview;
	//
	// }
	//
	// @RequestMapping(value = "/find")
	// public String find(HttpServletRequest request) {
	// Student student = (Student) service.find(Student.class, 2);
	// request.setAttribute("student", student);
	// return "/WEB-INF/front/save.jsp";
	// }

	@RequestMapping(value = "/ss")
	public String find() {
		System.out.println("ss");
		return "/WEB-INF/front/index.jsp";

	}
}
