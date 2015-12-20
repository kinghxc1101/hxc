package cn.manger.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/** 权限 */
@Entity
@Table
public class Tauthority extends TbaseEntity {

	private static final long serialVersionUID = -9077588934802148130L;

	private String permission;
	@ManyToOne
	@JoinColumn(name = "t_role_id", referencedColumnName = "id")
	private Trole role;

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Trole getRole() {
		return role;
	}

	public void setRole(Trole role) {
		this.role = role;
	}

}
