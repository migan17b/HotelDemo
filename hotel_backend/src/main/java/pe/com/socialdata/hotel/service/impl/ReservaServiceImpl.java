package pe.com.socialdata.hotel.service.impl;




import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.com.socialdata.hotel.entity.Consumo;
import pe.com.socialdata.hotel.entity.Reserva;
import pe.com.socialdata.hotel.model.ConsumoModel;
import pe.com.socialdata.hotel.model.ReservaModel;
import pe.com.socialdata.hotel.model.convert.ConsumoConvert;
import pe.com.socialdata.hotel.model.convert.ReservaConvert;
import pe.com.socialdata.hotel.repository.ConsumoRepository;
import pe.com.socialdata.hotel.repository.ReservaRepository;
import pe.com.socialdata.hotel.service.ReservaService;
import pe.com.socialdata.hotel.util.ConstantesHotel;
import pe.com.socialdata.hotel.util.ResourceBundleUtil;
import pe.com.socialdata.hotel.util.ServiceException;

@Service
public class ReservaServiceImpl  implements ReservaService{

	private static final Log LOG = LogFactory.getLog(ReservaServiceImpl.class);
	
	@Autowired
	ReservaRepository reservaRepository;
	
	@Autowired
	ConsumoRepository consumoRepository;
	
	@Autowired
	ReservaConvert reservaConvert;
	
	@Autowired
	ConsumoConvert consumoConvert;
	
	
	@Transactional(propagation=Propagation.REQUIRES_NEW  )
	@Override
	public ReservaModel registrarReserva(ReservaModel reservaModel) {
		LOG.debug(getClass().getName() +"Inicia save");
		try {
				reservaModel.setFechaReserva(new Date());
				reservaModel.setIndEstado(ConstantesHotel.RESERVA_ESTADO_RESERVADO);
				
				Reserva reserva=reservaConvert.convertReservaModel2Reserva (reservaModel);
				//LOG.debug("id_producto"  + producto.getId() );
				
				reserva= reservaRepository.save(  reserva);
				
				List<Consumo> consumos = new ArrayList<Consumo>();
				for(ConsumoModel obj : reservaModel.getConsumos() ) {
					Consumo  consumo= consumoConvert.convertConsumoModel2Consumo(obj);
					consumo =consumoRepository.save(consumo);
					consumos.add(consumo);
				} 
				reservaModel = reservaConvert.convertReserva2ReservaModel(reserva);
			
		}catch (GenericJDBCException eq) {
		
		//	LOG.error(eq.getMessage(), eq);
			throw new ServiceException(this, ResourceBundleUtil.getMessage(ConstantesHotel.MENSAJE_ERROR_DATA_BD));	
		} catch (Exception ex) {
			//LOG.error(ex.getMessage(), ex);
			throw new ServiceException(this, ResourceBundleUtil.getMessage(ConstantesHotel.MENSAJE_ERROR_GENERICO));
		}
		finally{
			LOG.debug(getClass().getName() +"Fin save");
		}
			return reservaModel;
	}

	@Override
	public ReservaModel findReservaModelById(Long id) {
		return 	reservaConvert.convertReserva2ReservaModel ( reservaRepository.findById (id));
		
	}

	@Override
	public void anulaReserva(Long id) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public ReservaModel actualizarReserva(ReservaModel reservaModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReservaModel> searchReservaByFechaReserva(Date fechaDesde, Date fechaHasta) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
