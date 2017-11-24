package pe.com.socialdata.hotel.service;

import java.util.List;

import pe.com.socialdata.hotel.model.EmpresaModel;

public interface EmpresaService {

	public abstract EmpresaModel save(EmpresaModel empresaModel);
	
	public List<EmpresaModel> listAllEmpresa();
	
	public abstract EmpresaModel findEmpresaModelById(Integer id);
	
	public abstract void removeEmpresa(Integer id);
	
	public List<EmpresaModel> searchEmpresaByName(String name);
	
	
}
