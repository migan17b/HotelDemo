package pe.com.socialdata.hotel.service;




import java.util.Date;
import java.util.List;

import pe.com.socialdata.hotel.model.ReservaModel;

public interface ReservaService {
public abstract ReservaModel registrarReserva(ReservaModel reservaModel);
	
	public abstract ReservaModel actualizarReserva(ReservaModel reservaModel);
	
	public abstract ReservaModel findReservaModelById(Long id);
	
	public abstract void anulaReserva(Long id);
	


	
	public List<ReservaModel> searchReservaByFechaReserva(Date fechaDesde, Date fechaHasta);
}
