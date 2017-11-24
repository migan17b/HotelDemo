package pe.com.socialdata.hotel.service.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pe.com.socialdata.hotel.entity.Producto;
import pe.com.socialdata.hotel.model.ProductoModel;
import pe.com.socialdata.hotel.model.convert.ProductoConvert;
import pe.com.socialdata.hotel.repository.ProductoRepository;
import pe.com.socialdata.hotel.service.ProductoService;
import pe.com.socialdata.hotel.util.ConstantesHotel;
import pe.com.socialdata.hotel.util.ResourceBundleUtil;
import pe.com.socialdata.hotel.util.ServiceException;


@Service("productoService")
public class ProductoServiceImpl implements ProductoService {
	
	private static final Log LOG = LogFactory.getLog(ProductoServiceImpl.class);
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	@Qualifier("productoConvert")
	ProductoConvert productoConvert;
	
	@Override
	public ProductoModel addProducto(ProductoModel productoModel) throws ServiceException {
		LOG.debug(getClass().getName() +"Inicia save");
	try {
			Producto producto=productoConvert.convertProductoModel2Producto(productoModel);
			//LOG.debug("id_producto"  + producto.getId() );
			
		 producto= productoRepository.save(  producto);
		
		productoModel = productoConvert.convertProducto2ProductoModel(producto);
		
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
		return productoModel;
		
	}

	@Override
	public List<ProductoModel> listAllProductos() {
		LOG.debug("inicia listAllProductos");
		List<Producto> productos= (List<Producto>)productoRepository.findAll();
	 	List<ProductoModel> productosModel = new ArrayList<ProductoModel>();
	 	if (null!=productos){
	 		
		 	for(Producto producto : productos){
		 		LOG.debug("idProducto:"+ producto.getId());
		 		productosModel.add(productoConvert.convertProducto2ProductoModel(producto) );
		 	}
	 	}
	 	LOG.debug("fin listAllProductos");
	 	return productosModel;
	}

	@Override
	public ProductoModel findProductoModelByI2(Long idProducto) {
		return 	productoConvert.convertProducto2ProductoModel( productoRepository.findById (idProducto));
	}

	@Override
	public void removePoducto(Long idProducto) {
		Producto producto= findProductoById(idProducto);
		if (null != producto ){
			productoRepository.delete(producto);
		}else{
			LOG.warn("producto no existe!");
		}	
		
	}
	
	
	private Producto findProductoById(long idProducto) {
		 
		return productoRepository.findById(idProducto);
	}

	@Override
	public List<ProductoModel> searchProductoName(String nombre) throws ServiceException {
		List<Producto> productos =productoRepository.findByNombreLike(nombre);
		List<ProductoModel> productosModel = new ArrayList<ProductoModel>();
		for(Producto obj : productos) {
			productosModel.add( productoConvert.convertProducto2ProductoModel(obj) );
		}
		return productosModel;
	}

	

}
