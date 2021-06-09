package kodlamaio.business.abstracts;

import java.util.List;

import kodlamaio.core.utilities.DataResult;
import kodlamaio.core.utilities.Result;

public interface FieldService<T>{
	Result verifyData(T Data);
	
	DataResult<List<T>> getAll();
}
