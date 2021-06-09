package kodlamaio.core.adapter;

import java.rmi.RemoteException;

import kodlamaio.tr.OOPKPSPublicSoap;
import org.springframework.stereotype.Service;

import kodlamaio.core.Service.MernisService;
import kodlamaio.entities.concretes.Candidate;

@Service
public class mernisAdapter implements MernisService<Candidate>{

	@Override
	public boolean TCKontrol(Candidate candidate) {


        OOPKPSPublicSoap kpsPublic;
        try {
            kpsPublic = new OOPKPSPublicSoap();
            boolean durum = kpsPublic.TCKimlikNoDogrula(
                    Long.parseLong(candidate.getNationalIdentity()), 
                    candidate.getName().toUpperCase(), 
					candidate.getSurname().toUpperCase(), 
					Integer.parseInt(candidate.getBirth_year()));
            		return durum;


        } catch (Exception e) {
			e.printStackTrace();
		}


		return false;

    }

}
