package com.apap.tutorial7.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial7.model.CarModel;
import com.apap.tutorial7.repository.CarDb;

/**
 * DealerServiceImpl
 * @author Amira Taliya
 *
 */
@Service
@Transactional
public class CarServiceImpl implements CarService{
	@Autowired
	private CarDb carDb;
	
	@Override
	public CarModel addCar(CarModel car) {
		return carDb.save(car);
	}
	
	@Override
	public Optional<CarModel> getCarDetailById(long id) {
		return carDb.findById(id);
	}
	
	@Override
	public void updateCar(Long carId, CarModel newCar) {
		CarModel oldCarData = carDb.findById(carId).get();
		oldCarData.setBrand(newCar.getBrand());
		oldCarData.setType(newCar.getType());
		oldCarData.setPrice(newCar.getPrice());
		oldCarData.setAmount(newCar.getAmount());
		carDb.save(oldCarData);
	}

	@Override
	public void deleteCar(CarModel car) {
		carDb.delete(car);
	}

	@Override
	public List<CarModel> getAllCar() {
		return carDb.findAll();
	}

	@Override
	public List<CarModel> viewAllCar() {
		return carDb.findAll();
	}

}
