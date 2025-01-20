package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.CibilScoreData;
import com.app.service.CibilScoreService;

@RestController
public class CibilScoreController {

	@Autowired
	CibilScoreService cibilScoreService;
	
	@PostMapping("/api/cibil/save")
	public ResponseEntity<CibilScoreData> addCibilScore(@RequestBody CibilScoreData cs)
	{
		CibilScoreData csd=cibilScoreService.addCibilScore(cs);
		return new ResponseEntity<CibilScoreData>(csd,HttpStatus.CREATED);
	}
	@GetMapping("/api/cibil/getAll")
	public ResponseEntity<List<CibilScoreData>> viewAllCibilScores()
	{
		List<CibilScoreData> csd=cibilScoreService.viewAllCibilScores();
		return new ResponseEntity<List<CibilScoreData>>(csd,HttpStatus.OK);
	}
	
	@PutMapping("/api/cibil/update")
	public ResponseEntity<CibilScoreData> updateCibilScore(@RequestBody CibilScoreData cs)
	{
		CibilScoreData csd=cibilScoreService.updateCibilScore(cs);
		return new ResponseEntity<CibilScoreData>(csd,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/api/cibil/{cibilId}")
	public ResponseEntity<List<CibilScoreData>> deleteCibilScoreById(@PathVariable("cibilId") int cibilId)
	{
		cibilScoreService.deleteCibilScoreById(cibilId);
		List<CibilScoreData> csd=cibilScoreService.viewAllCibilScores();
		return new ResponseEntity<List<CibilScoreData>>(csd,HttpStatus.OK);
	}
	
}
