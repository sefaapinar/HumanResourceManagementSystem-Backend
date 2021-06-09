package kodlamaio.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.business.abstracts.JobExperienceService;
import kodlamaio.core.dtoConverter.DtoConverterService;
import kodlamaio.core.utilities.DataResult;
import kodlamaio.core.utilities.Result;
import kodlamaio.core.utilities.SuccessDataResult;
import kodlamaio.core.utilities.SuccessResult;
import kodlamaio.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.entities.concretes.JobExperience;
import kodlamaio.entities.concretes.dtos.JobExperienceDto;

@Service
public class JobExperienceManager implements JobExperienceService{

	private JobExperienceDao jobExperienceDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao,DtoConverterService dtoConverterService) {
		super();
		this.jobExperienceDao=jobExperienceDao;
		this.dtoConverterService = dtoConverterService;
	}
	
	@Override
	public Result add(JobExperienceDto jobExperienceDto) {
		jobExperienceDao.save((JobExperience) dtoConverterService.dtoClassConverter(jobExperienceDto, JobExperience.class));
		return new SuccessResult("Başarıyla Eklendi");
	}

	@Override
	public SuccessDataResult<List<JobExperienceDto>> getAll() {
		return new SuccessDataResult<List<JobExperienceDto>>
		(this.dtoConverterService.dtoConverter(this.jobExperienceDao.findAll(),JobExperienceDto.class),"Veriler Listelendi");
	}

	@Override
	public DataResult<List<JobExperienceDto>> findAllByResumeIdOrderByEndedDateDesc(int id) {
		return new SuccessDataResult<List<JobExperienceDto>>
		(this.dtoConverterService.dtoConverter(this.jobExperienceDao.findAllByResumeIdOrderByEndedDateDesc(id),JobExperienceDto.class),"Veriler Listelendi");
	}

	@Override
	public DataResult<List<JobExperienceDto>> findAllByResumeIdOrderByEndendDateDesc(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
