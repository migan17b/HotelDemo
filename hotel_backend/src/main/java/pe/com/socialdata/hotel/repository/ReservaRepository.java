package pe.com.socialdata.hotel.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;


import pe.com.socialdata.hotel.entity.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Serializable> {

	public abstract Reserva findById(Long id);
}
