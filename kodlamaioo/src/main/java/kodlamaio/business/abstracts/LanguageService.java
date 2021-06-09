package kodlamaio.business.abstracts;

import java.util.List;

import kodlamaio.core.utilities.DataResult;
import kodlamaio.core.utilities.Result;

import kodlamaio.entities.concretes.dtos.LanguageDto;

public interface LanguageService {

	Result add(LanguageDto languageDto);
	DataResult<List<LanguageDto>>getAll();
}
