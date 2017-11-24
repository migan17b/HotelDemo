package pe.com.socialdata.hotel.model.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.socialdata.hotel.entity.Consumo;
import pe.com.socialdata.hotel.entity.Reserva;
import pe.com.socialdata.hotel.model.ConsumoModel;
import pe.com.socialdata.hotel.model.ReservaModel;

@Component
public class ReservaConvert extends ConvertBase{
	@Autowired
	ConsumoConvert consumoConvert;
	public Reserva convertReservaModel2Reserva( ReservaModel reservaModel){
		Reserva reserva = new Reserva();
	
		BeanUtils.copyProperties( reservaModel, reserva, getNullPropertyNames(reservaModel));
		
		
		return reserva;
	}
	public ReservaModel convertReserva2ReservaModel(Reserva reserva){
		ReservaModel reservaModel = new ReservaModel();
		List<ConsumoModel> consumos=new ArrayList<ConsumoModel>();
		BeanUtils.copyProperties( reserva, reservaModel, getNullPropertyNames(reserva));
		
		for(Consumo obj : reserva.getConsumos() ) {
			consumos.add( consumoConvert.convertConsumo2ConsumoModel(obj) );
		}
		reservaModel.setConsumos(consumos);
			
		return reservaModel;
	}

}
