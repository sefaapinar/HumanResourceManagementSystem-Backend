package kodlamaio.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language,Integer>{
	
}
