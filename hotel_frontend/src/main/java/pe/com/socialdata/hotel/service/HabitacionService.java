package pe.com.socialdata.hotel.service;

import java.util.List;

import pe.com.socialdata.hotel.model.HabitacionModel;


public interface HabitacionService {
	HabitacionModel save(HabitacionModel  habitacionModel);
	 
	public List<HabitacionModel> listAllHabitacion();
	
	public abstract HabitacionModel findHabitacionModelById(Long id);
	public abstract HabitacionModel addHabitacion(Long idHotel);
	
	public abstract void removeHabitacion(Long id);
}
