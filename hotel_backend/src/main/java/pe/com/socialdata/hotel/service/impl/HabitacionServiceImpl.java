package pe.com.socialdata.hotel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.socialdata.hotel.entity.Habitacion;
import pe.com.socialdata.hotel.model.CategoriaModel;
import pe.com.socialdata.hotel.model.HabitacionModel;

import pe.com.socialdata.hotel.model.convert.HabitacionConvert;
import pe.com.socialdata.hotel.repository.HabitacionRepository;
import pe.com.socialdata.hotel.service.CategoriaService;
import pe.com.socialdata.hotel.service.HabitacionService;
import pe.com.socialdata.hotel.service.HotelService;
import pe.com.socialdata.hotel.util.ConstantesHotel;
import pe.com.socialdata.hotel.util.ResourceBundleUtil;
import pe.com.socialdata.hotel.util.ServiceException;

@Service("habitacionService")
public class HabitacionServiceImpl  implements HabitacionService{
	
	private static final Log LOG = LogFactory.getLog(HabitacionServiceImpl.class);
	
	@Autowired
	HabitacionRepository habitacionRepository;
	
	@Autowired
	HotelService hotelService;
	
	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	HabitacionConvert habitacionConvert;
	
	
	@Override
	public HabitacionModel save(HabitacionModel habitacionModel) {
		try {
			Habitacion habitacion = habitacionConvert.convertHabitacionModel2Habitacion (habitacionModel);
			if (null==habitacion.getId()) {
				habitacion.setIndEstado(ConstantesHotel.HABITACION_ESTADO_LIBRE);
			}
			//Empresa empresa= new Empresa();
			//empresa.setId(hotelModel.getIdEmpresa());
			//hotel.setEmpresa(empresaRepository.findById(hotelModel.getIdEmpresa()));
			habitacion =habitacionRepository.save(habitacion);
			habitacionModel = habitacionConvert.convertHabitacion2HabitacionModel (habitacion);
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
		return habitacionModel;
	}

	@Override
	public List<HabitacionModel> listAllHabitacion() {
		LOG.debug("inicia listAllHabitacion");
		List<Habitacion> habitaciones= (List<Habitacion>)habitacionRepository.findAll();
	 	List<HabitacionModel> habitacionesModel = new ArrayList<HabitacionModel>();
	 	if (null!=habitaciones){
	 		
		 	for(Habitacion habitacion : habitaciones){
		 		LOG.debug("id:"+ habitacion.getId());
		 		habitacionesModel.add(habitacionConvert.convertHabitacion2HabitacionModel(habitacion) );
		 	}
	 	}
	 	LOG.debug("fin listAllHabitacion");
	 	return habitacionesModel;
	}

	@Override
	public HabitacionModel findHabitacionModelById(Long id) {
		HabitacionModel habitacionModel =new HabitacionModel();
		habitacionModel =	habitacionConvert.convertHabitacion2HabitacionModel ( habitacionRepository.findById (id));
		List<CategoriaModel> categorias  = categoriaService.listAllCategoria();
		habitacionModel.setCategorias(categorias );
		return habitacionModel;
		
	}

	@Override
	public void removeHabitacion(Long id) {
		Habitacion habitacion= findHabitacionById(id);
		if (null != habitacion ){
			habitacionRepository.delete(habitacion);
		}else{
			LOG.warn("Habitacion no existe!");
		}	
		
	}
	
	private Habitacion findHabitacionById(Long id) {
		 
		return habitacionRepository.findById(id);
	}

	@Override
	public HabitacionModel addHabitacion(Long idHotel) {
		LOG.debug("inicia addHabitacion");
		HabitacionModel habitacionModel =new HabitacionModel();
		
		habitacionModel.setHotel( hotelService.findHotelModelById(idHotel) );
		habitacionModel.setIdHotel(idHotel);
		List<CategoriaModel> categorias  = categoriaService.listAllCategoria();
		habitacionModel.setCategorias(categorias );
		// TODO Auto-generated method stub
		return habitacionModel;
	}

}
