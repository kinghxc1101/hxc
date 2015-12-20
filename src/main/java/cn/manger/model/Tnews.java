package cn.manger.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Tnews extends TbaseEntity {

	private static final long serialVersionUID = 2373290306586084763L;
	private String title;
	private String imgurl;
	private String description;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
