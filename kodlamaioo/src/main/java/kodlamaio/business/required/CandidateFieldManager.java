package kodlamaio.business.required;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.business.abstracts.FieldService;
import kodlamaio.business.abstracts.VerificationCodeService;
import kodlamaio.core.Service.MernisService;
import kodlamaio.core.utilities.DataResult;
import kodlamaio.core.utilities.ErrorResult;
import kodlamaio.core.utilities.Result;
import kodlamaio.core.utilities.SuccessDataResult;
import kodlamaio.core.utilities.SuccessResult;
import kodlamaio.dataAccess.abstracts.CandidateDao;
import kodlamaio.dataAccess.abstracts.UserDao;
import kodlamaio.entities.concretes.Candidate;

@Service
public class CandidateFieldManager implements FieldService<Candidate> {
	
	
	
	private CandidateDao candidatesDao;
	private UserDao userDao; 
	private MernisService<Candidate> mernisService;
	private VerificationCodeService verificationCodeService;
	
	@Autowired
	public CandidateFieldManager(CandidateDao candidatesDao, UserDao userDao, MernisService<Candidate> mernisService, VerificationCodeService verificationCodeService) {
		super();
		this.candidatesDao = candidatesDao;
		this.userDao = userDao;
		this.mernisService = mernisService;
		this.verificationCodeService = verificationCodeService;
	}

	
	
	@Override
	public Result verifyData(Candidate candidate) {
		
		if (!this.mernisService.TCKontrol(candidate)) {
			return new ErrorResult("Mernis Kimlik Doğrulaması Başarısız Oldu");
		}
		if (this.userDao.existsByEmail(candidate.getEmail())) {
			return new ErrorResult("Mail Adresi Daha Önce Kullanıldı");
		}
		if (candidatesDao.existsByNationalIdentity(candidate.getNationalIdentity())) {
			return new ErrorResult("TC Kimlik Numarası Daha Önce Kullanıldı");
		}		
		if (!candidate.getPassword().equals(candidate.getPasswordRepeat())) {
			return new ErrorResult("Şifreler Uyuşmuyor");
		}
		
		this.candidatesDao.save(candidate);
		
		this.verificationCodeService.createVerifyCode(userDao.getOne(candidate.getId()));
		
		this.verificationCodeService.sendeEmail(candidate.getEmail());
		
		return new SuccessResult("Kayıt Başarılı");
		
		
		
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidatesDao.findAll(),"Listeleme İşlemi Başarılı");
	}
	
	
	
	
	
	
	
	
	
	
	
}