package cn.manger.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Tadmin extends TbaseEntity {

	private static final long serialVersionUID = 3261222397528062682L;
	public static final String USER_NAME = "username";
	private String username;
	private String password;
	private String description;
	@OneToOne(mappedBy = "admin", cascade = CascadeType.ALL)
	private Trole role;

	public Trole getRole() {
		return role;
	}

	public void setRole(Trole role) {
		this.role = role;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
