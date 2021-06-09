package kodlamaio.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.business.abstracts.EducationService;
import kodlamaio.core.dtoConverter.DtoConverterService;
import kodlamaio.core.utilities.DataResult;
import kodlamaio.core.utilities.Result;
import kodlamaio.core.utilities.SuccessDataResult;
import kodlamaio.core.utilities.SuccessResult;
import kodlamaio.dataAccess.abstracts.EducationDao;
import kodlamaio.entities.concretes.Education;
import kodlamaio.entities.concretes.dtos.EducationDto;

@Service
public class EducationManager implements EducationService {

	private EducationDao educationDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public EducationManager(EducationDao educationDao, DtoConverterService dtoConverterService) {
		super();
		this.educationDao = educationDao;
		this.dtoConverterService = dtoConverterService;
	}
	
	@Override
	public Result add(EducationDto educationDto) {
		educationDao.save((Education) dtoConverterService.dtoClassConverter(educationDto, Education.class));
		return new SuccessResult("Başarıyla Eklendi");
	}

	@Override
	public DataResult<List<EducationDto>> getAll() {
		return new SuccessDataResult<List<EducationDto>>(dtoConverterService.dtoConverter(educationDao.findAll(), EducationDto.class));
	}

	@Override
	public DataResult<List<EducationDto>> findAllByResumeIdOrderByEndedDateDesc(int id) {
		return new SuccessDataResult<List<EducationDto>>(dtoConverterService.dtoConverter(educationDao.findAllByResumeIdOrderByEndedDateDesc(id), EducationDto.class));
	}

}
