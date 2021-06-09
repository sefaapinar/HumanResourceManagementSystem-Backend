package kodlamaio.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
		
	Employer getByCompanyName(String companyName);
	boolean existsByCompanyName(String companyName);
}
