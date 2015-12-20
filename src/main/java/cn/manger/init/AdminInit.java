package cn.manger.init;

import javax.annotation.Resource;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import cn.manger.model.Tadmin;
import cn.manger.model.Tauthority;
import cn.manger.model.Trole;
import cn.manger.service.Service;

@Component
public class AdminInit implements ApplicationListener<ApplicationEvent>{
	@Resource
	private Service service;
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		//初始化的时候创建一个管理员
		if(event instanceof ContextRefreshedEvent){
			Tadmin admin = (Tadmin)service.find(Tadmin.class, "username", "admin");
			if(admin==null){
				admin=new Tadmin();
				admin.setUsername("admin");
				admin.setDescription("最高权限管理员");
				admin.setPassword("admin");
				
				Trole role=new Trole();
				role.setName("最高权限管理员");
				role.setDescription("最高权限管理员");
				
				Tauthority authority=new Tauthority();
				authority.setPermission("*");
				
				role.getAuthoritys().add(authority);
				role.setAdmin(admin);
				//admin.setRole(role);
				service.saveorupdate(role);
			}
		}
	}
	
	

}
