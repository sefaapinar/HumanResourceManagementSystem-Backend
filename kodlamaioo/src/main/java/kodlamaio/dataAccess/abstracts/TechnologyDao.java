package kodlamaio.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.entities.concretes.Technology;

public interface TechnologyDao extends JpaRepository<Technology,Integer> {
	
}
