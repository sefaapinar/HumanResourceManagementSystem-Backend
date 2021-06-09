package kodlamaio.business.required;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.business.abstracts.FieldService;
import kodlamaio.business.abstracts.VerificationCodeService;
import kodlamaio.business.abstracts.VerifiedEmployerService;
import kodlamaio.core.utilities.DataResult;
import kodlamaio.core.utilities.ErrorResult;
import kodlamaio.core.utilities.Result;
import kodlamaio.core.utilities.SuccessDataResult;
import kodlamaio.core.utilities.SuccessResult;
import kodlamaio.dataAccess.abstracts.EmployerDao;
import kodlamaio.dataAccess.abstracts.UserDao;
import kodlamaio.entities.concretes.Employer;

@Service
public class EmployerFieldManager implements FieldService<Employer> {

	@Autowired
	private EmployerDao employerDao;
	private UserDao userDao;
	private VerificationCodeService verifyCodeService;
	private VerifiedEmployerService verifiedEmployerService; 
	
	public EmployerFieldManager(EmployerDao employerDao, UserDao userDao, VerificationCodeService verifyCodeService, VerifiedEmployerService verifiedEmployerService) {
		super();
		this.employerDao = employerDao;
		this.userDao = userDao;
		this.verifyCodeService = verifyCodeService;
		this.verifiedEmployerService = verifiedEmployerService;
	}
	
	
	@Override
	public Result verifyData(Employer employer) {
		String[] splitEmail = employer.getEmail().split("@");
		if (!splitEmail[1].equals(employer.getWebAddress())) {
			return new ErrorResult("Yalnızca Şirket Web Sitenizin Uzantısına Sahip Bir Mail Adresiyle Kayıt Olabilirsiniz");
		}
		if (this.userDao.existsByEmail(employer.getEmail())) {
			return new ErrorResult("Mail Adresi Daha Önce Kullanıldı");
		}
		if (employer.getPassword().equals(employer.getPasswordRepeat()) == false) {
			return new ErrorResult("Şifreler Uyuşmuyor");
		}
		this.employerDao.save(employer);
		this.verifyCodeService.createVerifyCode(userDao.getOne(employer.getId()));
		this.verifiedEmployerService.createVerifiedEmployer(employer);
		this.verifyCodeService.sendeEmail(employer.getEmail());
		return new SuccessResult("Kayıt Başarılı");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Listeleme Başarılı");
	}
	
	
	
}