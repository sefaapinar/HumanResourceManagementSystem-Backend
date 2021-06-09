package kodlamaio.business.abstracts;

import java.util.List;

import kodlamaio.core.utilities.DataResult;
import kodlamaio.core.utilities.Result;

import kodlamaio.entities.concretes.dtos.JobExperienceDto;

public interface JobExperienceService {

	Result add(JobExperienceDto jobExperienceDto);
	DataResult<List<JobExperienceDto>> getAll();
	
	DataResult<List<JobExperienceDto>>findAllByResumeIdOrderByEndendDateDesc(int id);
	DataResult<List<JobExperienceDto>> findAllByResumeIdOrderByEndedDateDesc(int id);
}
