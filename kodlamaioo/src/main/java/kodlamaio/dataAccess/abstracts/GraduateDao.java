package kodlamaio.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.entities.concretes.Graduate;

public interface GraduateDao extends JpaRepository<Graduate, Integer>{
	
	boolean existsByDescription(String description);

}
