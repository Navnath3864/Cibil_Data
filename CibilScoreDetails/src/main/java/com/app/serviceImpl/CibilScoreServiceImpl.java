package com.app.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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
	public CibilScoreData addCibilScore(CibilScoreData cs) 
	{
		
		int randomCibilScore = ThreadLocalRandom.current().nextInt(100, 999);
        cs.setCibilScore(randomCibilScore);

        
        String currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        cs.setCibilScoreDateTime(currentDateTime);

        
        String status;
        if (randomCibilScore >= 750) 
        {
            status = "Excellant";
        } 
        else if (randomCibilScore >= 650 && randomCibilScore <= 749) 
        {
            status = "Good";
        } 
        else if (randomCibilScore >= 500 && randomCibilScore <= 649) 
        {
            status = "Average";
        } 
        else 
        {
            status = "Poor";
        }
        cs.setStatus(status);

        
        if (randomCibilScore >= 750) {
            cs.setCibilRemark("Applicable");
        } else {
            cs.setCibilRemark("Not Applicable");
        }

        CibilScoreData csd=cibilScoreRepository.save(cs);
        return csd;
		
	}
	

	@Override
	public List<CibilScoreData> viewAllCibilScores() {
		List<CibilScoreData> al=cibilScoreRepository.findAll();
		return al;
	}

	@Override
	public CibilScoreData updateCibilScore(CibilScoreData cs) {
		CibilScoreData csd=cibilScoreRepository.save(cs);
		return csd;
	}

	@Override
	public void deleteCibilScoreById(int cibilId) {
		cibilScoreRepository.deleteById(cibilId);
	}


	@Override
	public CibilScoreData generateCibilScore() {
		CibilScoreData cs = new CibilScoreData();
		int randomCibilScore = ThreadLocalRandom.current().nextInt(100, 999);
        cs.setCibilScore(randomCibilScore);

        
        String currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        cs.setCibilScoreDateTime(currentDateTime);

        
        String status;
        if (randomCibilScore >= 750) 
        {
            status = "Excellant";
        } 
        else if (randomCibilScore >= 650 && randomCibilScore <= 749) 
        {
            status = "Good";
        } 
        else if (randomCibilScore >= 500 && randomCibilScore <= 649) 
        {
            status = "Average";
        } 
        else 
        {
            status = "Poor";
        }
        cs.setStatus(status);

        
        if (randomCibilScore >= 750) {
            cs.setCibilRemark("Approved");
        } else {
            cs.setCibilRemark("Rejected");
        }
        
        return cs;

	}
}
