package kodlamaio.business.required;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.business.abstracts.FieldService;
import kodlamaio.core.utilities.DataResult;
import kodlamaio.core.utilities.ErrorResult;
import kodlamaio.core.utilities.Result;
import kodlamaio.core.utilities.SuccessDataResult;
import kodlamaio.core.utilities.SuccessResult;
import kodlamaio.dataAccess.abstracts.JobPositionDao;
import kodlamaio.entities.concretes.JobTitle;

@Service
public class JobTitleFieldManager implements FieldService<JobTitle>{
	
	@Autowired
	private JobPositionDao jobPositionDao;
	
	public JobTitleFieldManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	
	@Override
	public Result verifyData(JobTitle jobPosition) {
		if (jobPositionDao.existsByPosition(jobPosition.getPosition())) {
			return new ErrorResult("Bu Pozisyon Daha Önce Kaydedildi");
		}
		
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult("Kayıt Başarılı bir şekilde Eklendi");
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobPositionDao.findAll(),"Listeleme İşlemi Başarılı");
	}


}