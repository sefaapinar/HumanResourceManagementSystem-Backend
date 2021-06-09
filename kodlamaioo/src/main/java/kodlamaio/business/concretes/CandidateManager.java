package kodlamaio.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.business.abstracts.CandidateService;
import kodlamaio.business.abstracts.FieldService;
import kodlamaio.core.utilities.DataResult;

import kodlamaio.core.utilities.Result;

import kodlamaio.entities.concretes.Candidate;


@Service
public class CandidateManager implements CandidateService {
	
	private FieldService<Candidate> controllerService;
	
	
	@Autowired
	public CandidateManager(FieldService<Candidate> controllerService) {
		super();
		this.controllerService = controllerService;
	}
	@Override
	
	public DataResult<List<Candidate>> getAll() {
			return this.controllerService.getAll();
	}

	@Override
	public Result add(Candidate candidate) {
		
		return this.controllerService.verifyData(candidate);
	}
	
	
}
