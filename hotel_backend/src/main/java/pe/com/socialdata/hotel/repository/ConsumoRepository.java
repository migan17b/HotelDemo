package pe.com.socialdata.hotel.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;


import pe.com.socialdata.hotel.entity.Consumo;
import pe.com.socialdata.hotel.entity.ConsumoPK;


public interface ConsumoRepository extends JpaRepository<Consumo, Serializable>{

	public abstract Consumo findById(ConsumoPK id);
}
