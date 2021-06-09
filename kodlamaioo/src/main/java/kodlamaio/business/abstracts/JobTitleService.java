package kodlamaio.business.abstracts;

import java.util.List;

import kodlamaio.core.utilities.DataResult;
import kodlamaio.core.utilities.Result;
import kodlamaio.entities.concretes.JobTitle;

public interface JobTitleService {
	
	DataResult<List<JobTitle>>getAll();
	
	Result add(JobTitle jobTitle);
	
}
