package cn.manger.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Trole extends TbaseEntity {

	private static final long serialVersionUID = -544845215039179253L;
	private String name;
	private String description;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "t_role_id", referencedColumnName = "id")
	private List<Tauthority> authoritys = new ArrayList<Tauthority>();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "t_admin_id")
	private Tadmin admin;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Tauthority> getAuthoritys() {
		return authoritys;
	}

	public void setAuthoritys(List<Tauthority> authoritys) {
		this.authoritys = authoritys;
	}

	public Tadmin getAdmin() {
		return admin;
	}

	public void setAdmin(Tadmin admin) {
		this.admin = admin;
	}

}
