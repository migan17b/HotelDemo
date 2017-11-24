package pe.com.socialdata.hotel.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "MODULE" database table.
 * 
 */
@Entity
@Table(name="MODULE" , schema="REG_HOTEL")

public class Module implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_MODULE")
	private Long id;

	@Column(name="CODE")
	private String code;

	

	@Column(name="MENU_LABEL")
	private String menuLabel;

	@Column(name="MENU_ORDER")
	private Integer menuOrder;

	@Column(name="NAME")
	private String name;


	@Column(name="URL")
	private String url;
	
	@Column(name="VISIBLE")
	private String visible;

	//bi-directional many-to-one association to Module
	@ManyToOne
	@JoinColumn(name="PARENT_MODULE_ID")
	private Module module;

	

	
	
	public Module() {
	}





	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getCode() {
		return code;
	}





	public void setCode(String code) {
		this.code = code;
	}





	public String getMenuLabel() {
		return menuLabel;
	}





	public void setMenuLabel(String menuLabel) {
		this.menuLabel = menuLabel;
	}





	public Integer getMenuOrder() {
		return menuOrder;
	}





	public void setMenuOrder(Integer menuOrder) {
		this.menuOrder = menuOrder;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getUrl() {
		return url;
	}





	public void setUrl(String url) {
		this.url = url;
	}





	public String getVisible() {
		return visible;
	}





	public void setVisible(String visible) {
		this.visible = visible;
	}





	public Module getModule() {
		return module;
	}





	public void setModule(Module module) {
		this.module = module;
	}

	

}