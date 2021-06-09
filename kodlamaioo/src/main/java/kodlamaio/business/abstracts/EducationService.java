package kodlamaio.business.abstracts;

import java.util.List;

import kodlamaio.core.utilities.DataResult;
import kodlamaio.core.utilities.Result;
import kodlamaio.entities.concretes.dtos.EducationDto;

public interface EducationService {

	Result add(EducationDto educationDto);
	
	DataResult<List<EducationDto>> findAllByResumeIdOrderByEndedDateDesc(int id);
	
	DataResult<List<EducationDto>>getAll();
}
