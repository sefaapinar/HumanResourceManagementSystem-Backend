package kodlamaio.business.abstracts;

import kodlamaio.core.utilities.Result;
import kodlamaio.entities.concretes.Employer;


public interface VerifiedEmployerService {

	
	void createVerifiedEmployer(Employer employer);
	Result verifiedUser(String companyName);
}
