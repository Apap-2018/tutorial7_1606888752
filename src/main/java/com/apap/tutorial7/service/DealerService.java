package com.apap.tutorial7.service;

import java.util.List;
import java.util.Optional;

import com.apap.tutorial7.model.DealerModel;

/**
 * DealerService
 * @author Amira Taliya
 *
 */
public interface DealerService {
	Optional<DealerModel> getDealerDetailById(long id);
	
	List<DealerModel> getAllDealer();
	
	DealerModel addDealer(DealerModel dealer);
	
	void updateDealer(Long dealerId, DealerModel newDealer);
	
	List<DealerModel> viewAllDealer();

	void deleteDealer(DealerModel dealer);
}
