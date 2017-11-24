package pe.com.socialdata.hotel.service;

import java.util.List;


import pe.com.socialdata.hotel.model.HotelModel;
import pe.com.socialdata.hotel.model.HotelModelList;

public interface HotelService {

	 	HotelModel save(HotelModel  hotelModel);
	 
		public List<HotelModelList> listAllHotel();
		
		public abstract HotelModel findHotelModelById(Long id);
		
		public abstract void removeHotel(Long id);
	 
}
