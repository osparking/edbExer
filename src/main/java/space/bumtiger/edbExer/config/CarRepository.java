package space.bumtiger.edbExer.config;

import org.springframework.data.repository.CrudRepository;

import space.bumtiger.edbExer.model.Car;

public interface CarRepository extends CrudRepository<Car, Long>{
}
