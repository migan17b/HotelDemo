package pe.com.socialdata.hotel.model.convert;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import pe.com.socialdata.hotel.entity.Module;

import pe.com.socialdata.hotel.model.ModuleModel;

@Component
public class ModuleConvert extends ConvertBase {
	
	public Module convertModuleModel2Module( ModuleModel moduleModel){
		Module module = new Module();
		
			BeanUtils.copyProperties(moduleModel,module,getNullPropertyNames(moduleModel) );
	
		return module;
	}
	public ModuleModel convertModule2ModuleModel(Module module){
		ModuleModel moduleModel = new ModuleModel();

		BeanUtils.copyProperties( module,  moduleModel,getNullPropertyNames(module));
	
		return moduleModel;
	}
}
