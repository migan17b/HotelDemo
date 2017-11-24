package pe.com.socialdata.hotel.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;


import pe.com.socialdata.hotel.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Serializable>   {

	public abstract Hotel findById(Long id);
}
