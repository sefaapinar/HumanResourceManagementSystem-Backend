package kodlamaio.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.business.abstracts.JobExperienceService;
import kodlamaio.core.utilities.DataResult;
import kodlamaio.core.utilities.Result;
import kodlamaio.entities.concretes.dtos.JobExperienceDto;

@RestController
@RequestMapping("api/experience")
public class JobExperienceController {

	private JobExperienceService jobExperienceService;
	
	@Autowired
	public JobExperienceController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}


	@GetMapping("/getOrderByDate")
	public DataResult<List<JobExperienceDto>> findAllByResumeIdOrderByEndedDateDesc(int id){
		return this.jobExperienceService.findAllByResumeIdOrderByEndendDateDesc(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobExperienceDto>> getAll(){
		return this.jobExperienceService.getAll();
	}
	
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody JobExperienceDto jobExperienceDto) {
		return this.jobExperienceService.add(jobExperienceDto);
	  }
	
}
