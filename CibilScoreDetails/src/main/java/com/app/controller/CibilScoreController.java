package com.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.CibilScoreData;
import com.app.service.CibilScoreService;

@RestController
@RequestMapping("/api/cibil")
public class CibilScoreController {
	
	@Autowired
	CibilScoreService cibilScoreService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CibilScoreController.class);  
	
	@PostMapping("/save")
	public ResponseEntity<CibilScoreData> addCibilScore(@RequestBody CibilScoreData cs)
	{
		LOGGER.info("Received POST request to create CibilScore: {}", cs);
		CibilScoreData csd=cibilScoreService.addCibilScore(cs);
		LOGGER.debug("CibilScore created successfully: {}", csd);
		return new ResponseEntity<CibilScoreData>(csd,HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<CibilScoreData> generateCibil()
	{
		LOGGER.info("Received GET request to fetch CibilScore");
		CibilScoreData csd=cibilScoreService.generateCibilScore();
		LOGGER.debug("Returning CibilScore: {}", csd);
		return new ResponseEntity<CibilScoreData>(csd,HttpStatus.OK);
	}
	
	
}