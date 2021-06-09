package kodlamaio.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.business.abstracts.JobPostingService;
import kodlamaio.core.utilities.DataResult;
import kodlamaio.core.utilities.Result;
import kodlamaio.entities.concretes.dtos.JobPostingAddDto;
import kodlamaio.entities.concretes.dtos.JobPostingDto;

@RestController
@RequestMapping("api/posting")
public class JobPostingController {
	
	
	private JobPostingService jobPostingService;

	
	@Autowired
	public JobPostingController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}
	

	@PostMapping("/add")
	Result add(@RequestBody JobPostingAddDto jobPostingAddDto) {
		return this.jobPostingService.add(jobPostingAddDto);
	}
	
	@GetMapping("/getActive")
	DataResult<List<JobPostingDto>> findByIsActive(){
		return this.jobPostingService.findByIsActive();
	}
	
	
	@GetMapping("/getActive/OrderByEndDate")
	DataResult<List<JobPostingDto>> findByIsActiveOrderByClosedDate(){
		return this.jobPostingService.findByIsActiveOrderByCloseDate();
	}
	
	@GetMapping("/get/CompanyName")
	DataResult<List<JobPostingDto>> findByIsActiveAndEmployer_CompanyName(String companyName){
		return this.jobPostingService.findByIsActiveAndEmployer_CompanyName(companyName);
		
	}
}
