package kodlamaio.business.concretes;

import java.util.List;

//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.business.abstracts.JobPostingService;
import kodlamaio.core.dtoConverter.DtoConverterService;
import kodlamaio.core.utilities.DataResult;
import kodlamaio.core.utilities.Result;
import kodlamaio.core.utilities.SuccessDataResult;
import kodlamaio.core.utilities.SuccessResult;
import kodlamaio.dataAccess.abstracts.JobPostingDao;
import kodlamaio.entities.concretes.JobPosting;
import kodlamaio.entities.concretes.dtos.JobPostingAddDto;
import kodlamaio.entities.concretes.dtos.JobPostingDto;

@Service
public class JobPostingManager implements JobPostingService{
	
	private JobPostingDao jobPostingDao;
	private DtoConverterService dtoConverterService;
	
	

	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao, DtoConverterService dtoConverterService) {
		//ModelMapper modelMapper
		super();
		this.jobPostingDao = jobPostingDao;
		this.dtoConverterService=dtoConverterService;
	}
	
	@Override
	public Result add(JobPostingAddDto jobPostingAddDto) {
		this.jobPostingDao.save((JobPosting) dtoConverterService.dtoClassConverter(jobPostingAddDto, JobPosting.class));
		return new SuccessResult("İş İlanı Eklendi");
	}
	@Override
	public Result delete(JobPosting jobPosting) {
		this.jobPostingDao.delete(jobPosting);
		return new SuccessResult("Silme işlemi Tamamlandı");
	}
	@Override
	public DataResult<List<JobPostingDto>> findByIsActive() {
		return new SuccessDataResult<List<JobPostingDto>>(dtoConverterService.dtoConverter
				(jobPostingDao.findByIsActive(true), JobPostingDto.class),"Aktif İş İlanları Listelendi");
		
	}
	
	@Override
	public DataResult<List<JobPostingDto>> findByIsActiveAndEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobPostingDto>>
		(this.dtoConverterService.dtoConverter(this.jobPostingDao.findByIsActiveAndEmployer_CompanyName(true, companyName), JobPostingDto.class),"Data Listelendi");
	}


//	@Override
//	public DataResult<List<JobPostingDto>> findByIsActiveOrderByClosedDate() {
//		
//	}

	@Override
	public DataResult<List<JobPostingDto>> findByIsActiveOrderByCloseDate() {
		return new SuccessDataResult<List<JobPostingDto>>
		(this.dtoConverterService.dtoConverter(this.jobPostingDao.findByIsActiveOrderByClosedDate(true), JobPostingDto.class),"Data Listelendi");
	}

	

	
}
