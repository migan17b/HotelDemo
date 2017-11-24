package pe.com.socialdata.hotel.repository;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;


import pe.com.socialdata.hotel.entity.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Serializable>{
	public abstract Habitacion findById(Long id);
	public abstract Habitacion  findByNumHabitacion(String numHabitacion);
	

}
