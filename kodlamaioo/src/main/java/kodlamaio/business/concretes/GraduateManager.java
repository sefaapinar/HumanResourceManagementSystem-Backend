package kodlamaio.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.business.abstracts.GraduateService;
import kodlamaio.core.utilities.DataResult;
import kodlamaio.core.utilities.ErrorResult;
import kodlamaio.core.utilities.Result;
import kodlamaio.core.utilities.SuccessDataResult;
import kodlamaio.core.utilities.SuccessResult;
import kodlamaio.dataAccess.abstracts.GraduateDao;
import kodlamaio.entities.concretes.Graduate;

@Service
public class GraduateManager implements GraduateService {

	private GraduateDao graduateDao;
	
	@Autowired
	public GraduateManager(GraduateDao graduateDao) {
		super();
		this.graduateDao = graduateDao;
	}
	
	@Override
	public DataResult<List<Graduate>> getAll() {
		
		return new SuccessDataResult<List<Graduate>>(this.graduateDao.findAll(),"Veriler Listelendi");
	}

	@Override
	public Result add(Graduate graduate) {
		if(graduateDao.existsByDescription(graduate.getDescription())) {
			return new ErrorResult("Varolan Bir Açıklamayı Tekrar Eklemeyezsin.");
		}
		this.graduateDao.save(graduate);
		return new SuccessResult("Başarıyla EKlendi.");
	}

}
