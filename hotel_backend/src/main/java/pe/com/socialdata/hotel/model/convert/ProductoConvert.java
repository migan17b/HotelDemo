package pe.com.socialdata.hotel.model.convert;


import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;


import pe.com.socialdata.hotel.entity.Producto;
import pe.com.socialdata.hotel.model.ProductoModel;

@Component("productoConvert")
public class ProductoConvert extends ConvertBase {
	
	public Producto convertProductoModel2Producto( ProductoModel productoModel){
		Producto producto = new Producto();
		
			BeanUtils.copyProperties(productoModel,producto,getNullPropertyNames(productoModel) );
	
		return producto;
	}
	public ProductoModel convertProducto2ProductoModel(Producto producto){
		ProductoModel productoModel = new ProductoModel();

		BeanUtils.copyProperties( producto,  productoModel,getNullPropertyNames(producto));
	
		return productoModel;
	}
	
	
	

}
