package kodlamaio.business.concretes;

import java.time.LocalDate;
import java.sql.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.business.abstracts.VerificationCodeService;
import kodlamaio.core.utilities.ErrorResult;
import kodlamaio.core.utilities.Result;
import kodlamaio.core.utilities.SuccessResult;
import kodlamaio.dataAccess.abstracts.UserDao;
import kodlamaio.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.entities.concretes.User;
import kodlamaio.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService {

	private VerificationCodeDao verificationCodeDao;
	private UserDao userDao;
	
	@Autowired //bir bean içerisinde ki verileri başka bir bean'e injeckte edebiliriz.
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao,UserDao userDao) {
		super();
		this.userDao=userDao;
		this.verificationCodeDao = verificationCodeDao;
	}
	
	@Override
	public String createVerifyCode(User user) {
		String vCode = UUID.randomUUID().toString();
		VerificationCode Code = new VerificationCode();
		LocalDate e = (LocalDate.now());
		Code.setUser_id(user);
		Code.setCreatedDate(Date.valueOf(e));
		Code.setCode(UUID.randomUUID().toString());
		this.verificationCodeDao.save(Code);
		return vCode;
	}
	
	@Override
	public void sendeEmail(String email) {
		System.out.println("Doğrulama Maili Gönderildi :" +email );
		
	}
	
	@Override
	public Result verifyUser(String code) {
		
		if (!this.verificationCodeDao.existsByCode(code)) {
			return new ErrorResult("Hatalı Doğrulama İşlemi");
		}
		VerificationCode newVerifyCode = verificationCodeDao.getByCode(code);
		if (this.verificationCodeDao.getOne(newVerifyCode.getId()).is_verified()) {
			return new ErrorResult("Doğrulama işlemi daha önce yapıldı");
		}
		LocalDate e = (LocalDate.now());
		newVerifyCode.set_verified(true);
		newVerifyCode.setCreatedDate(Date.valueOf(e));
		verificationCodeDao.save(newVerifyCode);
		User verifyUser = new User();
		verifyUser = userDao.getOne(newVerifyCode.getUser_id().getId());
		verifyUser.setVerify(true);
		userDao.save(verifyUser);
		return new SuccessResult("Doğrulandı :)");	
		
			
	}

}
