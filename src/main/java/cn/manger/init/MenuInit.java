package cn.manger.init;

import java.util.List;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import cn.manger.model.Tmenu;
import cn.manger.service.RedisService;
import cn.manger.service.Service;

@Component
public class MenuInit implements ApplicationListener<ApplicationEvent> {
	@Resource
	Service service;
	@Resource
	RedisService redisService;

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ContextRefreshedEvent) {
			@SuppressWarnings("unchecked")
			List<Tmenu> menuList = (List<Tmenu>) service.findList(Tmenu.class);
			if (menuList != null) {
				for (Tmenu tmenu : menuList) {
					JSONObject jsonObject = new JSONObject(tmenu);
					String menu = jsonObject.toString();
					System.out.println(menu);
					redisService.setCacheValue(tmenu.getId() + "", menu,
							tmenu.getParentid());
				}
			}
		}
	}
}
