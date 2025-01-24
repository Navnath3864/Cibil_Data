package com.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		CibilScoreData csd=cibilScoreService.addCibilScore(cs);
		return new ResponseEntity<CibilScoreData>(csd,HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<CibilScoreData> generateCibil()
	{
		LOGGER.info("Request GET privide cibil score details");
		CibilScoreData csd=cibilScoreService.generateCibilScore();
	//	LOGGER.debug("Debug cibil score details : {}"+csd);
		return new ResponseEntity<CibilScoreData>(csd,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<CibilScoreData>> viewAllCibilScores()
	{
		List<CibilScoreData> csd=cibilScoreService.viewAllCibilScores();
		return new ResponseEntity<List<CibilScoreData>>(csd,HttpStatus.OK);
		
}
	
	@PutMapping("/update")
	public ResponseEntity<CibilScoreData> updateCibilScore(@RequestBody CibilScoreData cs)
	{
		CibilScoreData csd=cibilScoreService.updateCibilScore(cs);
		return new ResponseEntity<CibilScoreData>(csd,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("delete/{cibilId}")
	public ResponseEntity<List<CibilScoreData>> deleteCibilScoreById(@PathVariable int cibilId)
	{
		cibilScoreService.deleteCibilScoreById(cibilId);
		List<CibilScoreData> csd=cibilScoreService.viewAllCibilScores();
		return new ResponseEntity<List<CibilScoreData>>(csd,HttpStatus.OK);
		
		
	}
	
}
