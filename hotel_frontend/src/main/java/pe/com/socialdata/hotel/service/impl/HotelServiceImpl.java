package pe.com.socialdata.hotel.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import pe.com.socialdata.hotel.jasper.HabitacionReporte;
import pe.com.socialdata.hotel.jasper.HotelReport;
import pe.com.socialdata.hotel.jasper.ReporteArchivoBean;
import pe.com.socialdata.hotel.jasper.ReporteJasperBean;
import pe.com.socialdata.hotel.jasper.ReporteJasperConstantes;
import pe.com.socialdata.hotel.jasper.ReporteJasperUtil;
import pe.com.socialdata.hotel.model.CategoriaModel;
import pe.com.socialdata.hotel.model.EstadoHabitacionEnum;
import pe.com.socialdata.hotel.model.HabitacionModel;
import pe.com.socialdata.hotel.model.HotelModel;
import pe.com.socialdata.hotel.model.HotelModelList;
import pe.com.socialdata.hotel.rc.client.util.BackendRestInvoker;
import pe.com.socialdata.hotel.rc.client.util.ConstantesURL;
import pe.com.socialdata.hotel.service.HotelService;
import pe.com.socialdata.hotel.util.NumeroUtil;



@Service
public class HotelServiceImpl implements HotelService {

	private static final Log LOG = LogFactory.getLog(HotelServiceImpl.class);
	@Override
	public HotelModel save(HotelModel hotelModel, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelModelList> listAllHotel(String token) {
		LOG.info("METHOD 'listAllHotel'");
		 BackendRestInvoker<HotelModelList> restInvoker= new BackendRestInvoker<HotelModelList>(ConstantesURL.BACKEND_SERVER,ConstantesURL.BACKEND_PORT);

		  ResponseEntity<List<HotelModelList>> responseEntity=
				restInvoker.sendGetList(ConstantesURL.BACKEND_CONTEXT +"/v1/hoteles"  , HotelModelList.class, token);
		
		 // responseEntity.getStatusCode() 
		  
		  List<HotelModelList> hoteles = responseEntity.getBody();
		  LOG.info("METHOD  fin 'listAllHotel'" + hoteles.size());
		  return hoteles;
	}

	@Override
	public HotelModel findHotelModelById(Long id, String token) {
		BackendRestInvoker<HotelModel> restInvoker= new BackendRestInvoker<HotelModel>(ConstantesURL.BACKEND_SERVER,ConstantesURL.BACKEND_PORT);

		  ResponseEntity<HotelModel> responseEntity=
				restInvoker.sendGet(ConstantesURL.BACKEND_CONTEXT +"/v1/hoteles/"+ id  , HotelModel.class, token);
		
		 // responseEntity.getStatusCode() 
		  HotelModel hotel = responseEntity.getBody();
		  return hotel;
	}

	@Override
	public void removeHotel(Long id, String token) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ReporteArchivoBean generatePDF(Long id, String token) {
		LOG.debug("generatePDF");
		BackendRestInvoker<HotelModel> restInvoker= new BackendRestInvoker<HotelModel>(ConstantesURL.BACKEND_SERVER,ConstantesURL.BACKEND_PORT);

		  ResponseEntity<HotelModel> responseEntity=
				restInvoker.sendGet(ConstantesURL.BACKEND_CONTEXT +"/v1/hoteles/"+ id  , HotelModel.class, token);
		
		 // responseEntity.getStatusCode() 
		  HotelModel hotel = responseEntity.getBody();
		  
		  
		  LOG.debug("genera reporte"); 
		 /*GENERANDO EL REPORTE==============================================*/
	  	Map<String, Object> parametrosJasper = new HashMap<String, Object>();
	  
	  	parametrosJasper.put("direccion", hotel.getDireccion());
	  	parametrosJasper.put("estrellas", hotel.getEstrellas().toString());
	  	parametrosJasper.put("nombre", hotel.getNombre());
	  	parametrosJasper.put("telefono", hotel.getTelefono());
	  	parametrosJasper.put("nomEmpresa", hotel.getEmpresaModel().getNombre());

		
	  	List<HabitacionReporte>listaDataJasper = new ArrayList<HabitacionReporte>();
	  //	List<Map<String , Object>> listaDataJasper = new ArrayList<Map<String , Object>>();
	  	for (HabitacionModel obj : hotel.getHabitaciones()) {
	  		LOG.debug("===========================================");
	  		HabitacionReporte habitacionReporte = new HabitacionReporte();
	  		habitacionReporte.setId(obj.getId().toString());
	  		habitacionReporte.setCategoria(obj.getCategoria().getNombre());
	  		habitacionReporte.setNumHabitacion(obj.getNumHabitacion());
	  		habitacionReporte.setCaracteristicas(obj.getCaracteristicas());
	  		habitacionReporte.setEstado( EstadoHabitacionEnum.findByCode( obj.getIndEstado()).getLabel());
	  		habitacionReporte.setNumCamas(obj.getNumCamas().toString());
	  		habitacionReporte.setNumPiso(obj.getNumPiso().toString());
	  		
	  		habitacionReporte.setPrecioDia(NumeroUtil.formatearMonedaMontoToDecimal("S/.", 2, obj.getPrecioDia()));
	  		habitacionReporte.setPrecioHora(NumeroUtil.formatearMonedaMontoToDecimal("S/.", 2, obj.getPrecioHora()) );
	  		
	  		/*Map<String , Object> habitacionReporte = new HashMap<String , Object>();
	  		habitacionReporte.put("id", obj.getId().toString());
	  		habitacionReporte.put("categoria", obj.getCategoria().getNombre());
	  		habitacionReporte.put("numHabitacion", obj.getNumHabitacion());
	  		habitacionReporte.put("caracteristicas", obj.getCaracteristicas());
	  		habitacionReporte.put("estado", EstadoHabitacionEnum.findByCode( obj.getIndEstado()).getLabel());
	  		habitacionReporte.put("numCamas", obj.getNumCamas().toString());
	  		habitacionReporte.put("numPiso", obj.getNumPiso().toString());
	  		habitacionReporte.put("precioDia",NumeroUtil.formatearMonedaMontoToDecimal("S/.", 2, obj.getPrecioDia()));
	  		habitacionReporte.put("precioHora", NumeroUtil.formatearMonedaMontoToDecimal("S/.", 2, obj.getPrecioHora()) );*/
	  		
	  		listaDataJasper.add(habitacionReporte);
	  		LOG.debug(habitacionReporte);
	  	}
	  	
	  	ReporteJasperBean reporteJasperBean = new ReporteJasperBean();
		reporteJasperBean.setParametros(parametrosJasper);
		reporteJasperBean.setListaDetalle(listaDataJasper);
		reporteJasperBean.setFileName(ReporteJasperConstantes.PLANILLA_HOTEL_PDF);
		reporteJasperBean.setJasperName( ReporteJasperConstantes.PLANILLA_HOTEL_JASPER );
		
		  LOG.debug("generaR jasper");
		ReporteArchivoBean reporteArchivoBean = ReporteJasperUtil.generarArchivoPDF(reporteJasperBean, ReporteJasperConstantes.RUTA_JASPER, ReporteJasperConstantes.RUTA_PDF);
			
		return reporteArchivoBean;
	}

	@Override
	public List<HabitacionReporte> habitacionToReporte(List<HabitacionModel> habitaciones) {
		
		List<HabitacionReporte>listaDataJasper = new ArrayList<HabitacionReporte>();
		for (HabitacionModel obj: habitaciones) {
		HabitacionReporte habitacionReporte = new HabitacionReporte();
  		habitacionReporte.setId(obj.getId().toString());
  		habitacionReporte.setCategoria(obj.getCategoria().getNombre());
  		habitacionReporte.setNumHabitacion(obj.getNumHabitacion());
  		habitacionReporte.setCaracteristicas(obj.getCaracteristicas());
  		habitacionReporte.setEstado( EstadoHabitacionEnum.findByCode( obj.getIndEstado()).getLabel());
  		habitacionReporte.setNumCamas(obj.getNumCamas().toString());
  		habitacionReporte.setNumPiso(obj.getNumPiso().toString());
  		
  		habitacionReporte.setPrecioDia(NumeroUtil.formatearMonedaMontoToDecimal("S/.", 2, obj.getPrecioDia()));
  		habitacionReporte.setPrecioHora(NumeroUtil.formatearMonedaMontoToDecimal("S/.", 2, obj.getPrecioHora()) );
  		
  		listaDataJasper.add(habitacionReporte);
		}
		return listaDataJasper;
	}

}
