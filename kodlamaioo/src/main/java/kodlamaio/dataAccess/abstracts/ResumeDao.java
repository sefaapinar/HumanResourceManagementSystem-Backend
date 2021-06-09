package kodlamaio.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.entities.concretes.Resume;

public interface ResumeDao extends JpaRepository<Resume,Integer>{

	List<Resume>findAllByCandidateId(int id);

}
