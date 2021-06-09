package kodlamaio.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.entities.concretes.VerifiedEmployer;

public interface VerifiedEmployerDao extends JpaRepository<VerifiedEmployer,Integer> {

	VerifiedEmployer getByEmployer_Id(int id);
	
	boolean existsByEmployer_Id(int id);

}
