package com.app.cibil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.cibil.model.CibilScoreData;

@Repository
public interface CibilScoreRepository extends JpaRepository<CibilScoreData, Integer>{

}
