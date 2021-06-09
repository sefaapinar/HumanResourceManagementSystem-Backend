package kodlamaio.business.abstracts;

import java.util.List;

import kodlamaio.core.utilities.DataResult;
import kodlamaio.core.utilities.Result;
import kodlamaio.entities.concretes.Graduate;

public interface GraduateService {

	DataResult<List<Graduate>> getAll();
	Result add(Graduate graduate);
}
