package com.app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.repository.CibilScoreRepository;
import com.app.service.CibilScoreService;

@Service
public class CibilScoreServiceImpl implements CibilScoreService{

	@Autowired
	CibilScoreRepository cibilScoreRepository;
}
