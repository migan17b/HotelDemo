		package pe.com.socialdata.hotel.service;

import java.util.List;



import pe.com.socialdata.hotel.model.ProductoModel;
import pe.com.socialdata.hotel.util.ServiceException;

public interface ProductoService {
	
	public abstract ProductoModel  addProducto(ProductoModel productoModel);
	
	public List<ProductoModel> listAllProductos(); 
	

	public ProductoModel  findProductoModelByI2(Long idProducto) ;
	public abstract void removePoducto( Long idProducto);
	
	

	public List<ProductoModel> searchProductoName(String nombre) throws ServiceException;
	

}
