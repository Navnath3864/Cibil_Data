package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.CibilScoreData;
import com.app.service.CibilScoreService;

@RestController
public class CibilScoreController {

	@Autowired
	CibilScoreService cibilScoreService;
	@PostMapping("/save")
	public ResponseEntity<CibilScoreData> addCibilScore(@RequestBody CibilScoreData cs)
	{
		CibilScoreData csd=cibilScoreService.addCibilScore(cs);
		return new ResponseEntity<CibilScoreData>(csd,HttpStatus.CREATED);
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<CibilScoreData>> viewAllCibilScores(@RequestBody List<CibilScoreData> cs)
	{
		List<CibilScoreData> csd=cibilScoreService.viewAllCibilScores(cs);
		return new ResponseEntity<List<CibilScoreData>>(csd,HttpStatus.OK);
		
		
	}
}
