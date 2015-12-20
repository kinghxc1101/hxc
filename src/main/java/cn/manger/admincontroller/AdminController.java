package cn.manger.admincontroller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.manger.model.Tadmin;
import cn.manger.model.Tauthority;
import cn.manger.model.Trole;
import cn.manger.service.Service;

@Controller
public class AdminController {
	@Resource
	private Service service;

	@RequestMapping(value = "/admin/login")
	public ModelAndView login() {

		ModelAndView modelview = new ModelAndView();
		modelview.setViewName("/WEB-INF/back/login.jsp");
		return modelview;

	}

	@RequestMapping(value = "/admin/manager")
	public ModelAndView manger() {

		ModelAndView modelview = new ModelAndView();
		modelview.setViewName("/WEB-INF/back/index.jsp");
		return modelview;

	}

	@RequestMapping(value = "/admin/roleList")
	public ModelAndView rolelist(HttpServletRequest request) {

		ModelAndView modelview = new ModelAndView();
		@SuppressWarnings("unchecked")
		List<Trole> roles = (List<Trole>) service.findObject(Trole.class);
		request.setAttribute("roles", roles);
		modelview.setViewName("/WEB-INF/back/power/roleList.jsp");
		return modelview;

	}

	@RequestMapping(value = "/admin/addRole")
	@RequiresPermissions("account:create")
	public ModelAndView addRole() {

		ModelAndView modelview = new ModelAndView();
		modelview.setViewName("/WEB-INF/back/power/addRole.jsp");
		return modelview;

	}

	@RequestMapping(value = "/admin/power")
	public String power(Integer roleId, ServletRequest request) {
		Trole role = (Trole) service.find(Trole.class, roleId);
		List<Tauthority> authoritys = role.getAuthoritys();
		request.setAttribute("authoritys", authoritys);
		request.setAttribute("roleId", roleId);
		request.setAttribute("role", role);
		return "/WEB-INF/back/power/powerEdit.jsp";
	}

	@RequestMapping(value = "/admin/deleteRole")
	@RequiresPermissions("account:create")
	public String deleteRole(Integer roleId) {
		service.delete(Trole.class, roleId);
		return "redirect:/admin/roleList.jhtml";
	}

	// ajax判断管理员用户名是否存在
	@RequestMapping(value = "/admin/ajaxValidateAdmin")
	public @ResponseBody
	String ajaxValidateAdmin(String adminName) {
		Tadmin admin = (Tadmin) service.find(Tadmin.class, "username",
				adminName);
		if (admin != null) {
			return "exist";
		}
		return "success";
	 }

	@RequestMapping(value = "/admin/addRoleForAdmin")
	@RequiresPermissions("account:create")
	public String addRoleForAdmin(HttpServletRequest request) {
		String adminName = request.getParameter("adminName");
		String roleId = request.getParameter("roleId");
		String description = request.getParameter("description");
		String repass = request.getParameter("repass");
		Tadmin admin = new Tadmin();
		admin.setUsername(adminName);
		admin.setPassword(repass);
		admin.setDescription(description);
		if (!StringUtils.isEmpty(roleId)) {
			Trole role = (Trole) service.find(Trole.class,
					Integer.valueOf(roleId));
			role.setAdmin(admin);
		}
		service.saveorupdate(admin);
		return "redirect:/admin/adminList.jhtml";
	}

	@RequestMapping(value = "/admin/adminList")
	public String adminList(HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		List<Tadmin> admins = (List<Tadmin>) service.findObject(Tadmin.class);
		request.setAttribute("admins", admins);
		return "/WEB-INF/back/power/adminList.jsp";
	}

	@RequestMapping(value = "/admin/editAdmin")
	public String editAdmin(HttpServletRequest request, Integer adminId) {
		@SuppressWarnings("unchecked")
		List<Trole> roles = (List<Trole>) service.findObject(Trole.class);
		Tadmin admin = (Tadmin) service.find(Tadmin.class, adminId);
		request.setAttribute("roles", roles);
		request.setAttribute("admin", admin);
		request.setAttribute("adminId", adminId);
		return "/WEB-INF/back/power/editAdmin.jsp";
	}

	@RequestMapping(value = "/admin/addAdmin")
	@RequiresPermissions("account:create")
	public String addAdmin(HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		List<Trole> roles = (List<Trole>) service.findObject(Trole.class);
		request.setAttribute("roles", roles);
		return "/WEB-INF/back/power/addAdmin.jsp";
	}

	@RequestMapping(value = "/admin/deleteAdmin")
	@RequiresPermissions("account:create")
	public String deleteAdmin(Integer adminId) {
		service.delete(Tadmin.class, adminId);
		return "redirect:/admin/adminList.jhtml";
	}

	@RequestMapping(value = "/admin/logout")
	public String adminLogin() {
		try {
			Subject currentUser = SecurityUtils.getSubject();
			if (SecurityUtils.getSubject().getSession() != null) {
				currentUser.logout();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/login.jhtml";
	}

	@RequestMapping(value = "/authorException")
	public String authorException() {
		return "/WEB-INF/back/authorException.jsp";
	}

}
