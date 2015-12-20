package cn.manger.admincontroller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.manger.model.Tadmin;
import cn.manger.model.Tauthority;
import cn.manger.model.Trole;
import cn.manger.service.Service;

@Controller
public class AdminPowerController {

	@Resource
	private Service service;

	@RequestMapping(value = "/admin/addRoleLogic")
	@RequiresPermissions("account:create")
	public String addRoleLogic(ServletRequest request) {

		Trole role = new Trole();
		String roleName = request.getParameter("roleName");
		String description = request.getParameter("description");
		role.setName(roleName);
		role.setDescription(description);
		service.saveorupdate(role);

		// 获取被选中的checkbook 并且name="authority"

		String[] parameterValues = request.getParameterValues("authority");
		if (parameterValues != null) {
			for (String permission : parameterValues) {
				Tauthority authority = new Tauthority();
				authority.setPermission(permission);
				authority.setRole(role);
				service.saveorupdate(authority);
			}
		}
		return "redirect:/admin/roleList.jhtml";
	}

	@RequestMapping(value = "/admin/updateRole")
	@RequiresPermissions("account:updateRole")
	public String editRoleLogic(ServletRequest request) {
		String roleId = request.getParameter("roleId");
		String roleName = request.getParameter("roleName");
		String description = request.getParameter("description");
		int id = Integer.parseInt(roleId);
		Trole role = (Trole) service.find(Trole.class, id);// ?
		role.setName(roleName);
		role.setDescription(description);
		service.saveorupdate(role);

		List<Tauthority> authoritys = role.getAuthoritys();
		List<Integer> idList = new ArrayList<Integer>();
		if (authoritys != null) {
			for (Tauthority authority : authoritys) {
				idList.add(authority.getId());
			}
		}
		// 更新权限之前首先删除之前的权限
		service.delete(Tauthority.class, idList);
		// 获取被选中的checkbook 并且name="authority"
		String[] parameterValues = request.getParameterValues("authority");
		if (parameterValues != null) {
			for (String permission : parameterValues) {
				Tauthority authority = new Tauthority();
				authority.setPermission(permission);
				authority.setRole(role);
				service.saveorupdate(authority);

			}
		}
		service.save(role);
		return "redirect:/admin/roleList.jhtml";
	}

	@RequestMapping(value = "/admin/updateRoleForAdmin")
	@RequiresPermissions("account:updateRole")
	public String updateRoleForAdmin(ServletRequest request) {
		String adminId = request.getParameter("adminId");
		String adminName = request.getParameter("adminName");
		String description = request.getParameter("description");
		String roleId = request.getParameter("roleId");
		String repass = request.getParameter("repass");
		Trole role = (Trole) service
				.find(Trole.class, Integer.parseInt(roleId));
		Tadmin admin = (Tadmin) service.find(Tadmin.class,
				Integer.parseInt(adminId));
		admin.setUsername(adminName);
		admin.setPassword(repass);
		admin.setDescription(description);
		role.setAdmin(admin);
		service.saveorupdate(role);
		return "redirect:/admin/adminList.jhtml";

	}
}
