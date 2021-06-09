package kodlamaio.business.abstracts;

import java.util.List;

import kodlamaio.core.utilities.DataResult;
import kodlamaio.core.utilities.Result;
import kodlamaio.entities.concretes.Candidate;

public interface CandidateService {

	DataResult<List<Candidate>>getAll();

	Result add(Candidate candidate);
	
}
