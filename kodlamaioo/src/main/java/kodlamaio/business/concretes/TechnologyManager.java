package kodlamaio.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.business.abstracts.TechnologyService;
import kodlamaio.core.dtoConverter.DtoConverterService;
import kodlamaio.core.utilities.DataResult;
import kodlamaio.core.utilities.Result;
import kodlamaio.core.utilities.SuccessDataResult;
import kodlamaio.core.utilities.SuccessResult;
import kodlamaio.dataAccess.abstracts.TechnologyDao;
import kodlamaio.entities.concretes.Technology;
import kodlamaio.entities.concretes.dtos.TechnologyDto;

@Service
public class TechnologyManager implements TechnologyService {

	private TechnologyDao technologyDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public TechnologyManager(TechnologyDao technologyDao, DtoConverterService dtoConverterService) {
		super();
		this.technologyDao=technologyDao;
		this.dtoConverterService=dtoConverterService;
	}
	
	@Override
	public Result add(TechnologyDto technologyDto) {
		technologyDao.save((Technology) dtoConverterService.dtoClassConverter(technologyDto, Technology.class));
		return new SuccessResult("Başarıyla Eklendi");
	}

	@Override
	public DataResult<List<TechnologyDto>> getAll() {
		return new SuccessDataResult<List<TechnologyDto>>
		(dtoConverterService.dtoConverter(technologyDao.findAll(),TechnologyDto.class),"Başarıyla Listelendi");
	}


}
