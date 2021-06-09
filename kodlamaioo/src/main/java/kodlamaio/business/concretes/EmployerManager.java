package kodlamaio.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.business.abstracts.EmployerService;
import kodlamaio.business.abstracts.FieldService;
import kodlamaio.core.utilities.DataResult;
import kodlamaio.core.utilities.Result;

import kodlamaio.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private FieldService<Employer>controllerService;
	
	@Autowired
	public EmployerManager(FieldService<Employer> controllerService) {
		super();
		this.controllerService=controllerService;
	}
	
	@Override
	public Result add(Employer employer) {
		return this.controllerService.verifyData(employer);
		
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return controllerService.getAll();
	}

}
