package pe.com.socialdata.hotel.model;

import java.util.List;

public class MenuDTO {
	
	private List<PerfilModel> menus;
	private List<PerfilModel> maestros;
	private List<PerfilModel> reportes;
	
	public List<PerfilModel> getMenus() {
		return menus;
	}
	public void setMenus(List<PerfilModel> menus) {
		this.menus = menus;
	}
	public List<PerfilModel> getMaestros() {
		return maestros;
	}
	public void setMaestros(List<PerfilModel> maestros) {
		this.maestros = maestros;
	}
	public List<PerfilModel> getReportes() {
		return reportes;
	}
	public void setReportes(List<PerfilModel> reportes) {
		this.reportes = reportes;
	}
	
	
	
}
