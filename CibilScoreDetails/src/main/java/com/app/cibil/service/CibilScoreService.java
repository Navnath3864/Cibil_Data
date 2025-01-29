package com.app.cibil.service;

import java.util.List;

import com.app.cibil.model.CibilScoreData;

public interface CibilScoreService {

public	CibilScoreData addCibilScore(CibilScoreData cs);

public List<CibilScoreData> viewAllCibilScores();

public CibilScoreData updateCibilScore(CibilScoreData cs);

public void deleteCibilScoreById(int cibilId);

public CibilScoreData generateCibilScore();

}
