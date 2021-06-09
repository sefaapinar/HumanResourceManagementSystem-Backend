package kodlamaio.business.abstracts;

import java.util.List;

import kodlamaio.core.utilities.DataResult;
import kodlamaio.core.utilities.Result;
import kodlamaio.entities.concretes.City;

public interface CityService {

	Result add(City city);
	DataResult<List<City>>getAll();
}
