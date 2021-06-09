package kodlamaio.business.abstracts;

import java.util.List;

import kodlamaio.core.utilities.DataResult;
import kodlamaio.core.utilities.Result;

import kodlamaio.entities.concretes.JobPosting;
import kodlamaio.entities.concretes.dtos.JobPostingAddDto;
import kodlamaio.entities.concretes.dtos.JobPostingDto;

public interface JobPostingService {

	Result add(JobPostingAddDto jobPostingAddDto);
	Result delete(JobPosting jobPosting);
	DataResult<List<JobPostingDto>> findByIsActive();
	DataResult<List<JobPostingDto>> findByIsActiveOrderByCloseDate();
	DataResult<List<JobPostingDto>> findByIsActiveAndEmployer_CompanyName(String companyName);

	
	
}
