package com.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.CibilScoreData;
import com.app.repository.CibilScoreRepository;
import com.app.service.CibilScoreService;

@Service
public class CibilScoreServiceImpl implements CibilScoreService{

	@Autowired
	CibilScoreRepository cibilScoreRepository;

	@Override
	public CibilScoreData addCibilScore(CibilScoreData cs) {
		CibilScoreData csd=cibilScoreRepository.save(cs);
		return csd;
	}

	@Override
	public List<CibilScoreData> viewAllCibilScores(List<CibilScoreData> cs) {
		List<CibilScoreData> al=cibilScoreRepository.findAll();
		return al;
	}
}
