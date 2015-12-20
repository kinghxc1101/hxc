package cn.manger.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**权限*/
@Entity
@Table
public class Tauthority implements Serializable{

	private static final long serialVersionUID = -9077588934802148130L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String permission;
	@ManyToOne
	@JoinColumn(name="t_role_id",referencedColumnName="id")
	private Trole role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
