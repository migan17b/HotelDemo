package pe.com.socialdata.hotel.model.convert;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


import pe.com.socialdata.hotel.entity.Consumo;
import pe.com.socialdata.hotel.entity.ConsumoPK;
import pe.com.socialdata.hotel.model.ConsumoModel;

@Component
public class ConsumoConvert extends ConvertBase{
	
	public Consumo convertConsumoModel2Consumo( ConsumoModel consumoModel){
		Consumo consumo = new Consumo();
		
		BeanUtils.copyProperties( consumoModel, consumo, getNullPropertyNames(consumoModel));
		if (null !=consumoModel.getIdProducto()  && null !=consumoModel.getIdReserva()) {
			ConsumoPK pk =new ConsumoPK();
			BeanUtils.copyProperties( consumoModel, pk, getNullPropertyNames(consumoModel));
			consumo.setId(pk);
		}
		
		return consumo;
	}
	public ConsumoModel convertConsumo2ConsumoModel(Consumo consumo){
		ConsumoModel consumoModel = new ConsumoModel();
		
			BeanUtils.copyProperties( consumo, consumoModel, getNullPropertyNames(consumo));
			consumoModel.setIdProducto(consumo.getId().getIdProducto());
			consumoModel.setIdReserva(consumo.getId().getIdReserva());
			
		return consumoModel;
	}

	
}
