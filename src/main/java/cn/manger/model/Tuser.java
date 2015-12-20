package cn.manger.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Tuser extends TbaseEntity {

	private static final long serialVersionUID = -7459216849514123828L;
	/** 注册用户名 */
	private String username;
	/** 注册密码 */
	private String password;
	/** 注册邮箱 */
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
