package cn.manger.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.CallbackException;
import org.hibernate.Session;
import org.hibernate.classic.Lifecycle;

@MappedSuperclass
public class TbaseEntity implements Serializable,Lifecycle {
	private static final long serialVersionUID = 2317839412294591318L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	/** 保留字段 */
	private int status;
	private long createTime;
	private long editTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public long getEditTime() {
		return editTime;
	}

	public void setEditTime(long editTime) {
		this.editTime = editTime;
	}

	@Override
	public boolean onDelete(Session session) throws CallbackException {
		return false;
	}

	@Override
	public void onLoad(Session session, Serializable serializable) {
		
	}

	@Override
	public boolean onSave(Session session) throws CallbackException {
		createTime=editTime=System.currentTimeMillis();
		return false;
	}

	@Override
	public boolean onUpdate(Session session) throws CallbackException {
		return false;
	}

}
