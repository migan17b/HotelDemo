package pe.com.socialdata.hotel.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;



import pe.com.socialdata.hotel.entity.Log;


public interface LogRepository extends MongoRepository<Log, String> {

	
	
	public abstract List<Log> findByUsername(String username);
}
