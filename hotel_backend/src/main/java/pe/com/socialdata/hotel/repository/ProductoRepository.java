package pe.com.socialdata.hotel.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



import pe.com.socialdata.hotel.entity.Producto;

// CrudRepository<Producto, Long>{
public interface ProductoRepository   extends JpaRepository<Producto, Serializable>{
	

	public abstract Producto findById(Long id);
	
	public abstract Producto findByNombre(String nombre);
	
	public abstract List<Producto> findByNombreLike(String nombre);
	
	public abstract int countByTipo(String tipo);
	
	@Query("from Producto p where lower(p.precioVenta) = lower(:precioVenta)")
	Producto findByNameWithQuery(@Param("precioVenta") Double precioVenta);
	
	Producto getByIdNamedQuery(Long id);
	
	
	

	
}
