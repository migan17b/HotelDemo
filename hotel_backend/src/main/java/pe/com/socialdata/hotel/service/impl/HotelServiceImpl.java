package pe.com.socialdata.hotel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.socialdata.hotel.entity.Empresa;
import pe.com.socialdata.hotel.entity.Habitacion;
import pe.com.socialdata.hotel.entity.Hotel;
import pe.com.socialdata.hotel.model.EmpresaModel;
import pe.com.socialdata.hotel.model.HabitacionModel;
import pe.com.socialdata.hotel.model.HotelModel;
import pe.com.socialdata.hotel.model.HotelModelList;
import pe.com.socialdata.hotel.model.convert.EmpresaConvert;
import pe.com.socialdata.hotel.model.convert.HabitacionConvert;
import pe.com.socialdata.hotel.model.convert.HotelConvert;
import pe.com.socialdata.hotel.repository.EmpresaRepository;
import pe.com.socialdata.hotel.repository.HotelRepository;
import pe.com.socialdata.hotel.service.HotelService;
import pe.com.socialdata.hotel.util.ConstantesHotel;
import pe.com.socialdata.hotel.util.ResourceBundleUtil;
import pe.com.socialdata.hotel.util.ServiceException;

@Service("hotelService")
public class HotelServiceImpl implements HotelService {
	

	private static final Log LOG = LogFactory.getLog(HotelServiceImpl.class);
	
	@Autowired
	HotelRepository hotelRepository;
	
	@Autowired
	EmpresaRepository empresaRepository;
	
	@Autowired
	HotelConvert hotelConvert;
	

	@Autowired
	HabitacionConvert habitacionConvert;
	
	@Autowired
	EmpresaConvert empresaConvert;
	
	@Override
	public HotelModel save(HotelModel hotelModel) {
		try {
			Hotel hotel = hotelConvert.convertHotelModel2Hotel (hotelModel);
			//Empresa empresa= new Empresa();
			//empresa.setId(hotelModel.getIdEmpresa());
			LOG.debug("ID_EMPRESA: " + hotelModel.getIdEmpresa());
			Empresa empresa= empresaRepository.findById(hotelModel.getIdEmpresa());
			hotel.setEmpresa(empresa);
			hotel =hotelRepository.save(hotel);
			hotelModel = hotelConvert.convertHotel2HotelModel (hotel);
		}catch (GenericJDBCException eq) {
			
			//	LOG.error(eq.getMessage(), eq);
				throw new ServiceException(this, ResourceBundleUtil.getMessage(ConstantesHotel.MENSAJE_ERROR_DATA_BD));	
			} catch (Exception ex) {
				LOG.error(ex.getMessage(), ex);
				throw new ServiceException(this, ResourceBundleUtil.getMessage(ConstantesHotel.MENSAJE_ERROR_GENERICO));
			}
			finally{
				LOG.debug(getClass().getName() +"Fin save");
			}
		return hotelModel;
	}

	@Override
	public List<HotelModelList> listAllHotel() {
		LOG.debug("inicia listAllHotel");
		List<Hotel> hoteles= (List<Hotel>)hotelRepository.findAll();
	 	List<HotelModelList> hotelesModel = new ArrayList<HotelModelList>();
	 	if (null!=hoteles){
	 		
		 	for(Hotel hotel : hoteles){
		 		LOG.debug("idhotel:"+ hotel.getId());
		 		hotelesModel.add(hotelConvert.convertHotel2HotelModelList(hotel) );
		 	}
	 	}
	 	LOG.debug("fin listAllHotel");
	 	return hotelesModel;
	}

	@Override
	public HotelModel findHotelModelById(Long id) {
		LOG.debug("inicio findHotelModelById");
		EmpresaModel empresaModel =null;
		Hotel hotel= hotelRepository.findById (id);
		
		HotelModel hotelModel =hotelConvert.convertHotel2HotelModel(hotel);
		if (null !=hotel.getEmpresa()) {
			LOG.debug("empresa : " + hotel.getEmpresa().getNombre());
			empresaModel = empresaConvert.convertEmpresa2EmpresaModel(hotel.getEmpresa());	
		}
		 
		List<HabitacionModel> habitaciones = new ArrayList<HabitacionModel>();
		for (Habitacion obj : hotel.getHabitaciones()) {
			LOG.debug("num habitacion : " + obj.getNumHabitacion());
			
			habitaciones.add( habitacionConvert.convertHabitacion2HabitacionModel(obj) );
		}
		hotelModel.setHabitaciones(habitaciones);
		hotelModel.setEmpresaModel(empresaModel);
		LOG.debug("fin findHotelModelById");
		return 	hotelModel;
	}

	@Override
	public void removeHotel(Long id) {
		Hotel hotel= findHotelById(id);
		if (null != hotel ){
			hotelRepository.delete(hotel);
		}else{
			LOG.warn("Hotel no existe!");
		}	
		
		
	}

	
	
	
	private Hotel findHotelById(Long id) {
		 
		return hotelRepository.findById(id);
	}
	
}
