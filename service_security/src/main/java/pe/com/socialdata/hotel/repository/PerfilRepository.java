package pe.com.socialdata.hotel.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.com.socialdata.hotel.entity.Perfil;




public interface PerfilRepository extends JpaRepository<Perfil, Serializable> {

	public abstract Perfil findById(Long id);
	
	@Query("select p from Perfil p , Module m where p.module.id =m.id and m.module = null and lower(p.rol) = lower(:rol) order by  m.menuOrder")
	List<Perfil> findByRolWithQuery(@Param("rol") String rol);
	
	@Query("select p from Perfil p , Module m where p.module.id =m.id and m.module.id = :idModule  and lower(p.rol) = lower(:rol) order by  m.menuOrder")
	List<Perfil> findByRolandModuleWithQuery(@Param("rol") String rol, @Param ("idModule") Long idModule);
}
