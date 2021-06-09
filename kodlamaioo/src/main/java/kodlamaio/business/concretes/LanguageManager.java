package kodlamaio.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.business.abstracts.LanguageService;
import kodlamaio.core.dtoConverter.DtoConverterService;
import kodlamaio.core.utilities.DataResult;
import kodlamaio.core.utilities.Result;
import kodlamaio.core.utilities.SuccessDataResult;
import kodlamaio.core.utilities.SuccessResult;
import kodlamaio.dataAccess.abstracts.LanguageDao;
import kodlamaio.entities.concretes.Language;
import kodlamaio.entities.concretes.dtos.LanguageDto;

@Service
public class LanguageManager implements LanguageService{
	
	private LanguageDao	languageDao;
	private DtoConverterService dtoConverterService;

	@Autowired
	public LanguageManager(LanguageDao languageDao, DtoConverterService dtoConverterService) {
		super();
		this.languageDao=languageDao;
		this.dtoConverterService = dtoConverterService;
	}
	
	@Override
	public Result add(LanguageDto languageDto) {
		languageDao.save((Language) dtoConverterService.dtoClassConverter(languageDto, LanguageDto.class));
		return new SuccessResult("Başarıyla Eklendi");
	}

	@Override
	public DataResult<List<LanguageDto>> getAll() {
		return new SuccessDataResult<List<LanguageDto>>
		(this.dtoConverterService.dtoConverter(languageDao.findAll(),LanguageDto.class), "Data Listelendi");
	}

	

}
