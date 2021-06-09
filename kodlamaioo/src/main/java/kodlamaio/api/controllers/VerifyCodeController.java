package kodlamaio.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.business.abstracts.VerificationCodeService;
import kodlamaio.core.utilities.Result;

@RestController
@RequestMapping("/valid")
public class VerifyCodeController {
	
	private VerificationCodeService verificationCodeService;
	
	@Autowired
	public VerifyCodeController(VerificationCodeService verificationCodeService) {
		super();
		this.verificationCodeService = verificationCodeService;
	}


	@PutMapping("/{verifyCode}")
	public Result update(@PathVariable("verifyCode") String verifyCode) {
		return verificationCodeService.verifyUser(verifyCode);
	}
}
