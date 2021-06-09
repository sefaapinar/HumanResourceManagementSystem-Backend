package kodlamaio.api.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.business.abstracts.VerifiedEmployerService;
import kodlamaio.core.utilities.Result;

@RestController
@RequestMapping("/verifiedEmployer")
public class VerifiedEmployerController {

	private VerifiedEmployerService verifiedEmployerService;
	
	public VerifiedEmployerController(VerifiedEmployerService verifiedEmployerService) {
		super();
		this.verifiedEmployerService=verifiedEmployerService;
	}
	
	@PutMapping("/{companyName}")
	public Result update(@PathVariable("companyName") String companyName) {
		
		return verifiedEmployerService.verifiedUser(companyName);
	}
}
