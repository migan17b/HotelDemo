package pe.com.socialdata.hotel.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.socialdata.hotel.entity.Categoria;




public interface CategoriaRepository extends JpaRepository<Categoria, Serializable>{
	
	public abstract Categoria findById(Long id);
	public abstract Categoria findByNombreLike(String  nombre);
}
