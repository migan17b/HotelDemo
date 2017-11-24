package pe.com.socialdata.hotel.model.convert;



import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import pe.com.socialdata.hotel.entity.Categoria;
import pe.com.socialdata.hotel.entity.Empresa;
import pe.com.socialdata.hotel.model.CategoriaModel;
import pe.com.socialdata.hotel.model.EmpresaModel;



@Component
public class CategoriaConvert extends ConvertBase{
	
	public Categoria convertCategoriaModel2Categoria( CategoriaModel categoriaModel){
		Categoria categoria = new Categoria();
	
			BeanUtils.copyProperties( categoriaModel, categoria, getNullPropertyNames(categoriaModel));
		
		return categoria;
	}
	public CategoriaModel convertCategoria2CategoriaModel(Categoria categoria){
		CategoriaModel categoriaModel = new CategoriaModel();
		
			BeanUtils.copyProperties( categoria, categoriaModel, getNullPropertyNames(categoria));
	
		return categoriaModel;
	}

}
