package kodlamaio.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.business.abstracts.ResumeService;
import kodlamaio.core.utilities.DataResult;
import kodlamaio.core.utilities.Result;
import kodlamaio.entities.concretes.dtos.ResumeAddDto;
import kodlamaio.entities.concretes.dtos.ResumeGetDto;

@RestController
@RequestMapping("api/resumes")
public class ResumeController {

		
		private ResumeService resumeService;

		@Autowired
		public ResumeController(ResumeService resumeService) {
			super();
			this.resumeService = resumeService;
		}
		
		@GetMapping("/getall")
		public DataResult<List<ResumeGetDto>> getAll(){
			return this.resumeService.getAll();
		}
		
		@GetMapping("/getByCandidateId")
		public DataResult<List<ResumeGetDto>> findAllByCandidateId(int id){
			return this.resumeService.findAllByCandidateId(id);
		}
		
		
		@PostMapping(value="/add")
		public Result add(@Valid @RequestBody ResumeAddDto resumeDto) {
			return this.resumeService.add(resumeDto);
		  }
		
		
		@PutMapping("/uploadImage")
		public Result saveImage(@RequestBody MultipartFile file,@RequestParam int resumeId) {
			return this.resumeService.saveImage(file, resumeId);
			
		}
		
	}

