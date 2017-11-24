package pe.com.socialdata.hotel.service;

import java.util.List;

import pe.com.socialdata.hotel.jasper.HabitacionReporte;
import pe.com.socialdata.hotel.jasper.ReporteArchivoBean;
import pe.com.socialdata.hotel.model.HabitacionModel;
import pe.com.socialdata.hotel.model.HotelModel;
import pe.com.socialdata.hotel.model.HotelModelList;

public interface HotelService {

	 	HotelModel save(HotelModel  hotelModel, String token);
	 
		public List<HotelModelList> listAllHotel( String token);
		
		public abstract HotelModel findHotelModelById(Long id, String token);
		
		public abstract void removeHotel(Long id, String token);
		
		public abstract ReporteArchivoBean generatePDF(Long id, String token);
	 
		
		public List<HabitacionReporte> habitacionToReporte( List<HabitacionModel> habitaciones);
}
