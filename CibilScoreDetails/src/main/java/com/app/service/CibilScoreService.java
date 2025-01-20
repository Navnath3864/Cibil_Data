package com.app.service;

import java.util.List;

import com.app.model.CibilScoreData;

public interface CibilScoreService {

public	CibilScoreData addCibilScore(CibilScoreData cs);

public List<CibilScoreData> viewAllCibilScores(List<CibilScoreData> cs);

}
