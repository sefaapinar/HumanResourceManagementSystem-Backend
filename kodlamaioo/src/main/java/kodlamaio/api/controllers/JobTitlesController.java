package kodlamaio.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.business.abstracts.JobTitleService;
import kodlamaio.core.utilities.DataResult;
import kodlamaio.core.utilities.Result;
import kodlamaio.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobs")
public class JobTitlesController {
	
	private JobTitleService jobPositionsService;
	
	@Autowired
	public JobTitlesController(JobTitleService jobPositionsService) {
		super();
		this.jobPositionsService = jobPositionsService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobTitle>> getAll(){
		return this.jobPositionsService.getAll();
	}
	
	@PostMapping("/add")
	public Result add (@Valid @RequestBody JobTitle jobPosition) {
		return this.jobPositionsService.add(jobPosition);
	}
	


}
