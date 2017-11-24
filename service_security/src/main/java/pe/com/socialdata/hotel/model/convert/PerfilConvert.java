package pe.com.socialdata.hotel.model.convert;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.socialdata.hotel.entity.Perfil;

import pe.com.socialdata.hotel.model.PerfilModel;

@Component
public class PerfilConvert extends ConvertBase {
	
	@Autowired
	ModuleConvert  moduleConvert;
	
	public Perfil convertPerfilModel2Perfil( PerfilModel perfilModel){
		Perfil perfil = new Perfil();
		
			BeanUtils.copyProperties(perfilModel,perfil,getNullPropertyNames(perfilModel) );
			
			
		return perfil;
	}
	public PerfilModel convertPerfil2PerfilModel(Perfil perfil){
		PerfilModel perfilModel = new PerfilModel();

		BeanUtils.copyProperties( perfil,  perfilModel,getNullPropertyNames(perfil));
		
		perfilModel.setModule( moduleConvert.convertModule2ModuleModel(perfil.getModule())  );
		
		return perfilModel;
	}
}
