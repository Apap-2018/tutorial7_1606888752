package com.apap.tutorial7.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tutorial7.model.DealerModel;

/**
 * DealerDb
 * @author Amira Taliya
 *
 */
@Repository
public interface DealerDb extends JpaRepository<DealerModel, Long>{
}
