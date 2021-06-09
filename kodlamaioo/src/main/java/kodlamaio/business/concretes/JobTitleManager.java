package kodlamaio.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.business.abstracts.FieldService;
import kodlamaio.business.abstracts.JobTitleService;
import kodlamaio.core.utilities.DataResult;
import kodlamaio.core.utilities.Result;
import kodlamaio.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{

	private FieldService<JobTitle> controllerService;
	
	@Autowired
	public JobTitleManager(FieldService<JobTitle> controllerService) {
		super();
		this.controllerService = controllerService;
	}
	@Override
	public DataResult<List<JobTitle>> getAll() {
		return controllerService.getAll();
		
	}
	
	@Override
	public Result add(JobTitle jobTitle) {
		return controllerService.verifyData(jobTitle);
	}
	
	

}
