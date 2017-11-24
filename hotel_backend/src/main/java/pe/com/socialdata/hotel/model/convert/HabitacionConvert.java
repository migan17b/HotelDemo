package pe.com.socialdata.hotel.model.convert;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.socialdata.hotel.entity.Habitacion;
import pe.com.socialdata.hotel.model.CategoriaModel;
import pe.com.socialdata.hotel.model.HabitacionModel;

@Component
public class HabitacionConvert extends ConvertBase  {
	
	@Autowired
	CategoriaConvert categoriaConvert;
	public Habitacion convertHabitacionModel2Habitacion( HabitacionModel habitacionModel){
		Habitacion habitacion = new Habitacion();
		
			BeanUtils.copyProperties( habitacionModel, habitacion, getNullPropertyNames(habitacionModel));
		
		return habitacion;
	}
	public HabitacionModel convertHabitacion2HabitacionModel(Habitacion habitacion){
		HabitacionModel habitacionModel = new HabitacionModel();
		CategoriaModel categoria=	categoriaConvert.convertCategoria2CategoriaModel(habitacion.getCategoria() );
			BeanUtils.copyProperties( habitacion, habitacionModel, getNullPropertyNames(habitacion));
		habitacionModel.setCategoria(categoria);
		return habitacionModel;
	}
}
