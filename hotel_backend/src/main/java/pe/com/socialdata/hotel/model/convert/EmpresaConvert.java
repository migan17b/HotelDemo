package pe.com.socialdata.hotel.model.convert;



import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import pe.com.socialdata.hotel.entity.Empresa;
import pe.com.socialdata.hotel.model.EmpresaModel;



@Component
public class EmpresaConvert extends ConvertBase{
	
	public Empresa convertEmpresaModel2Empresa( EmpresaModel empresaModel){
		Empresa empresa = new Empresa();
	
			BeanUtils.copyProperties( empresaModel, empresa, getNullPropertyNames(empresaModel));
		
		return empresa;
	}
	public EmpresaModel convertEmpresa2EmpresaModel(Empresa empresa){
		EmpresaModel empresaModel = new EmpresaModel();
		
			BeanUtils.copyProperties( empresa, empresaModel, getNullPropertyNames(empresa));
	
		return empresaModel;
	}

}
