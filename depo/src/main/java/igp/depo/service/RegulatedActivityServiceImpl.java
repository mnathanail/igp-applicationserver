package igp.depo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import igp.depo.model.RegulatedActivity;
import igp.depo.repo.RegulatedActivityDao;

@Service
public class RegulatedActivityServiceImpl implements RegulatedActivityService{

	@Autowired
	private RegulatedActivityDao regulatedActivityDao;
	
	private final String[] activities = 
		{
				"ΣΧΟΛΕΙΑ",
				"ΠΑΙΔΙΚΕΣ ΧΑΡΕΣ",
				"ΓΗΠΕΔΟ ΜΠΑΣΚΕΤ",
				"ΓΗΠΕΔΟ ΣΤΙΒΟΥ",
				"ΓΗΠΕΔΟ ΠΟΔΟΣΦΑΙΡΟΥ",
				"ΛΟΥΝΑ ΠΑΡΚ"
		};
	
	
	@Override
	@Transactional
	public void batchCreate(){
		
		RegulatedActivity ra;
		
		for(String activity : activities) {
			ra = new RegulatedActivity();
			ra.setName(activity);
			this.regulatedActivityDao.save(ra);
		}

	}
	
	
	@Override
	@Transactional
	public List<RegulatedActivity> getRegulatedActivities(){
		return this.regulatedActivityDao.findAllRegulatedActivities();
	}

}
