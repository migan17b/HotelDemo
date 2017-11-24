package pe.com.socialdata.hotel.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.socialdata.hotel.entity.Empresa;



public interface EmpresaRepository   extends JpaRepository<Empresa, Serializable> {
	
	public abstract Empresa findById(Integer id);
	public abstract List<Empresa > findByNombreLike(String nombre);
	
	

}
