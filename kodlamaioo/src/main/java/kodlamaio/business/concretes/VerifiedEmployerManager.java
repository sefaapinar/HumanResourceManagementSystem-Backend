package kodlamaio.business.concretes;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.business.abstracts.VerifiedEmployerService;
import kodlamaio.core.utilities.ErrorResult;
import kodlamaio.core.utilities.Result;

import kodlamaio.core.utilities.SuccessResult;
import kodlamaio.dataAccess.abstracts.EmployerDao;
import kodlamaio.dataAccess.abstracts.VerifiedEmployerDao;
import kodlamaio.entities.concretes.Employer;
import kodlamaio.entities.concretes.VerifiedEmployer;

@Service
public class VerifiedEmployerManager implements VerifiedEmployerService {

	private VerifiedEmployerDao verifiedEmployerDao;
	private EmployerDao employerDao;
	
	@Autowired
	public VerifiedEmployerManager(EmployerDao employerDao, VerifiedEmployerDao verifiedEmployerDao) {
		super();
		this.verifiedEmployerDao = verifiedEmployerDao;
		this.employerDao = employerDao;
	}


	@Override
	public void createVerifiedEmployer(Employer employer) {
		VerifiedEmployer vUser = new VerifiedEmployer();
		vUser.setEmployer(employer);
		vUser.setStaffUser(1);
		this.verifiedEmployerDao.save(vUser);
		
	}
	
	@Override
	public Result verifiedUser(String companyName) {
		
		if(!employerDao.existsByCompanyName(companyName)) {
			return new ErrorResult("Şirket İsmi veya Kaydı Bulunmadı.");
		}
		
		if(employerDao.getByCompanyName(companyName).isUserVerified()) {
			return new ErrorResult("Bu Şirket Zaten Onaylanmış.");
		}
		
		Employer employer = new Employer();
		VerifiedEmployer vUser = new VerifiedEmployer();
		employer = employerDao.getByCompanyName(companyName);
		employer.setUserVerified(true);
		employerDao.save(employer);
		vUser = verifiedEmployerDao.getByEmployer_Id(employer.getId());
		vUser.setConfirmed(true);
		LocalDate exception =(LocalDate.now());
		vUser.setVerifiedDate(Date.valueOf(exception));
		verifiedEmployerDao.save(vUser);
		return new SuccessResult("Doğrulama Başarılı!");
	
	}



}
	
