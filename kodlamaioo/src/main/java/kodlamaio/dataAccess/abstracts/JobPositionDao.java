package kodlamaio.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.entities.concretes.JobTitle;

@Repository
public interface JobPositionDao extends JpaRepository<JobTitle,Integer> {

	boolean existsByPosition(String position);
}
