package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.CibilScoreService;

@RestController
public class CibilScoreController {

	@Autowired
	CibilScoreService cibilScoreService;
	
}
