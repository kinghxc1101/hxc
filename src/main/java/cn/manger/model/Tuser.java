package cn.manger.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Tuser implements Serializable{

	private static final long serialVersionUID = -7459216849514123828L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	/**注册用户名*/
	private String username;
	/**注册密码*/
	private String password;
	/**注册邮箱*/
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
