package pe.com.socialdata.hotel.model.convert;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import pe.com.socialdata.hotel.entity.Hotel;
import pe.com.socialdata.hotel.model.HotelModel;
import pe.com.socialdata.hotel.model.HotelModelList;

@Component
public class HotelConvert extends ConvertBase {

	public Hotel convertHotelModel2Hotel( HotelModel hotelModel){
		Hotel hotel = new Hotel();
		
			BeanUtils.copyProperties( hotelModel, hotel, getNullPropertyNames(hotelModel));
		
		return hotel;
	}
	public HotelModel convertHotel2HotelModel(Hotel hotel){
		HotelModel hotelModel = new HotelModel();
		
			BeanUtils.copyProperties( hotel, hotelModel, getNullPropertyNames(hotel));
		
		return hotelModel;
	}
	
	public HotelModelList convertHotel2HotelModelList(Hotel hotel){
		HotelModelList hotelModel = new HotelModelList();
		
			BeanUtils.copyProperties( hotel, hotelModel, getNullPropertyNames(hotel));
		
		return hotelModel;
	}
}
