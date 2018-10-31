package com.apap.tutorial7.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.apap.tutorial7.model.CarModel;
import com.apap.tutorial7.rest.Setting;
import com.apap.tutorial7.service.CarService;

/**
 * carController
 * @author Amira Taliya
 *
 */
/**
 * CarController
 * */
@RestController
@RequestMapping("car")
public class CarController {
	@Autowired
	private CarService carService;
	
	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}
	
	@PostMapping(value = "/add")
	private CarModel addCarSubmit(@RequestBody CarModel car) {
		return carService.addCar(car);
	}
	
	@GetMapping(value = "/{carId}")
	private CarModel viewCar(@PathVariable ("carId") long carId, Model model) {
		return carService.getCarDetailById(carId).get();
	}
	
	@DeleteMapping(value = "/delete")
	private String deleteCar(@RequestParam("carId") long id, Model model) {
		CarModel car = carService.getCarDetailById(id).get();
		carService.deleteCar(car);
		return "Car has been delete";
	}
	
	@PutMapping(value = "/{id}")
	private String updateCarSubmit(
			@PathVariable (value = "id") long id,
			@RequestParam("brand") String brand,
			@RequestParam("type") String type,
			@RequestParam("price") long price,
			@RequestParam("amount") int amount) {
		CarModel car = (CarModel) carService.getCarDetailById(id).get();
		if(car.equals(null)) {
			return "Couldn't find your car";
		}
		car.setBrand(brand);
		car.setType(type);
		car.setPrice(price);
		car.setAmount(amount);
		
		carService.updateCar(id, car);
		return "Car update success";
	}
	
	@GetMapping()
	private List<CarModel> viewAllCar(Model model){
		return carService.viewAllCar();
	}
	
	/**
	@RequestMapping(value = "/car/add/{carId}", method = RequestMethod.GET)
	private String add (@PathVariable(value = "carId") Long carId, Model model) {
		
		
		CarModel car = carService.getCarDetailById(carId).get();
		ArrayList<CarModel> list = new ArrayList<CarModel>();
		list.add(new CarModel());
		car.setListCar(list);
		
		model.addAttribute("title", "Add Car");
		model.addAttribute("car", car);
		return "addCar";
	}
	
	@RequestMapping(value = "/car/add/{carId}", method = RequestMethod.POST, params= {"save"})
	private String addCarSubmit (@ModelAttribute CarModel car) {
		CarModel carr = carService.getCarDetailById(car.getId()).get();
		for(CarModel car : car.getListCar()) {
			car.setCar(carr);
			carService.addCar(car);
		}
		return "add";
	}
	
	@RequestMapping(value = "/car/add/{carId}", params= {"tambah"}, method = RequestMethod.POST)
	private String tambah (@ModelAttribute CarModel car, Model model) {
		car.getListCar().add(new CarModel());
		model.addAttribute("car", car);
		return "addCar";
	}
	
	@RequestMapping(value="/car/add/{carId}", method = RequestMethod.POST, params={"hapus"})
	private String hapus (@ModelAttribute CarModel car, final BindingResult bindingResult, final HttpServletRequest req, Model model) {
		final Integer rowId = Integer.valueOf(req.getParameter("hapus"));
		car.getListCar().remove(rowId.intValue());
		model.addAttribute("car", car);
		return "addCar";
	}

	@RequestMapping(value = "/car/delete", method = RequestMethod.POST )
	private String deleteCar(@ModelAttribute CarModel car, Model model) {
		for(CarModel car: car.getListCar()) {
			carService.deleteCar(car);
		}
		return "delete";
	}
	
	@RequestMapping(value = "/car/update/{id}", method = RequestMethod.POST)
	private String updateCarSubmit(@PathVariable(value = "id") long id, @ModelAttribute CarModel car) {
		carService.updateCar(id, car);
		return "update";
	}
	**/
}