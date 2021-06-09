package kodlamaio.business.abstracts;

import java.util.List;



import kodlamaio.core.utilities.DataResult;
import kodlamaio.core.utilities.Result;

import kodlamaio.entities.concretes.dtos.TechnologyDto;

public interface TechnologyService {

	Result add( TechnologyDto technologyDto);
	
	DataResult<List<TechnologyDto>> getAll();
	
}
