package cn.manger.shiro;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.manger.model.Tadmin;
import cn.manger.model.Tauthority;
import cn.manger.model.Trole;
import cn.manger.service.Service;





public class AuthenticationRealm extends AuthorizingRealm{
	private static final Log log=LogFactory.getLog(AuthenticationRealm.class); 
	
	@Resource
	private Service service;
	//shiro登录验证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
		TokenAuthentication authenticationToken=null;
		try {
			//该authenticationToken是从AuthenticationFilter中的TokenAuthentication传递过来的
			authenticationToken = (TokenAuthentication) token;			
			String username = authenticationToken.getUsername();
			log.debug("current uername:"+username);
			String tokenPassword = new String(authenticationToken.getPassword());
			// 查询数据库根据用户名获取密码
			Tadmin admin=(Tadmin)service.find(Tadmin.class,Tadmin.USER_NAME, username);
			if(admin!=null){
				String password=admin.getPassword();
				if(tokenPassword.equals(password)){
					// 获取数据库userId
					long userId=admin.getId();
					//该验证信息必须和AuthenticationFilter中的TokenAuthentication用户名和密码一致
					System.out.println(getName());
					return new SimpleAuthenticationInfo(new Principal(userId, username), password, getName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.debug("管理员密码不匹配");
		throw new UnknownAccountException();
	}
	//shiro授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Principal principal = (Principal) principals.fromRealm(getName()).iterator().next();
		String username=principal.getUsername();
		log.debug("doGetAuthorizationInfo:"+principal.getUsername());
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		Tadmin admin=(Tadmin)service.find(Tadmin.class, Tadmin.USER_NAME, username);
		// 从数据库获取用户角色
		Trole role = admin.getRole();
		if(role!=null){
			authorizationInfo.addRole(role.getName());
			List<Tauthority> authoritys = role.getAuthoritys();
			for (Iterator<Tauthority> iterator = authoritys.iterator(); iterator.hasNext();) {
				Tauthority authority = (Tauthority) iterator.next();
				// 从数据获取角色权限
				authorizationInfo.addStringPermission(authority.getPermission());
			}
		}
		return authorizationInfo;
	}

}
