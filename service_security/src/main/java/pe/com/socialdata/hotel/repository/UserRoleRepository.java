package pe.com.socialdata.hotel.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.socialdata.hotel.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Serializable>{
	

	public abstract UserRole findByUserRoleId(Long id);
}
