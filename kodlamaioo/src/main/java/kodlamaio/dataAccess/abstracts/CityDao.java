package kodlamaio.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.entities.concretes.City;

public interface CityDao  extends JpaRepository<City, Integer>{

}
