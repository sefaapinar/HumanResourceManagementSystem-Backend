package kodlamaio.business.abstracts;

import kodlamaio.core.utilities.Result;
import kodlamaio.entities.concretes.User;


public interface VerificationCodeService {
	
	String createVerifyCode(User user);
	void sendeEmail(String email);
	Result verifyUser(String code);

}
