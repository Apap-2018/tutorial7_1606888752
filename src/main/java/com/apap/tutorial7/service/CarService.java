package com.apap.tutorial7.service;

import java.util.List;
import java.util.Optional; 

import com.apap.tutorial7.model.CarModel;
import com.apap.tutorial7.model.DealerModel;

/**
 * CarService
 * @author Amira Taliya
 *
 */
public interface CarService {
	CarModel addCar(CarModel car);

	Optional<CarModel> getCarDetailById(long id);
	
	List<CarModel> getAllCar();
	
	void updateCar(Long carId, CarModel newCar);
	
	void deleteCar(CarModel car);
	
	List<CarModel> viewAllCar();
}
