package kodlamaio.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.core.utilities.DataResult;
import kodlamaio.core.utilities.Result;

import kodlamaio.entities.concretes.dtos.ResumeAddDto;
import kodlamaio.entities.concretes.dtos.ResumeGetDto;

public interface ResumeService {

	Result add(ResumeAddDto resumeDto);
	DataResult<List<ResumeGetDto>> getAll();
	DataResult<List<ResumeGetDto>> findAllByCandidateId(int id);
	Result saveImage(MultipartFile file, int resumeId);
}
