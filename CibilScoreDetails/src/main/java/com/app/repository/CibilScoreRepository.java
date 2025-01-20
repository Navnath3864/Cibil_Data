package com.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.CibilScoreData;

@Repository
public interface CibilScoreRepository extends JpaRepository<CibilScoreData, Integer>{

}
