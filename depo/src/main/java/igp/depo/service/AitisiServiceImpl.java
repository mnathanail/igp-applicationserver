package igp.depo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import igp.depo.model.AitisiModel;
import igp.depo.model.ForeasModel;
import igp.depo.model.RegulatedActivity;
import igp.depo.model.StatusKey;
import igp.depo.repo.AitisiDao;
import igp.depo.repo.ForeasDao;
import igp.depo.repo.RegulatedActivityDao;
import igp.depo.utils.StatusEnum;

@Service
public class AitisiServiceImpl implements AitisiService {
	
	@Autowired
	private AitisiDao aitisiDao;
	
	@Autowired
	private ForeasDao foreasDao;
	
	@Autowired
	private RegulatedActivityDao regulatedActivityDao;

	@Override
	@Transactional
	  public AitisiModel createAitisi(Integer foreasId, AitisiModel aitisi) {
		Set<AitisiModel> aitisis = new HashSet<>();
		
		try {
			
	    Optional<ForeasModel> foreasById = this.foreasDao.findById(foreasId);
	    ForeasModel foreas = foreasById.get();
	    aitisi.setStatus(new StatusKey(StatusEnum.PENDING));
	    
	    
	    
	    RegulatedActivity activity = regulatedActivityDao.findByName(aitisi.getRegulatedActivity());
	    aitisi.setActivity(activity);
	    
	    aitisi.setForeas(foreas);
	    aitisi.setForeasTitle(foreas.getDistinctiveTitle());
	    aitisi.setActivity_id(activity.getActivityId());
	    aitisi.setForea_id(foreas.getFid());
	    aitisis.add(this.aitisiDao.save(aitisi));
	    
	    activity.setAitisis(aitisis);
	    
	    foreas.setAitisi(aitisis);
	    
	    
	    
		}
		catch(Exception e) {aitisi=null;}
	    
	    return aitisi;
	    }
	
	@Override
	@Transactional
	public Set<AitisiModel> fetchAitisis(Integer foreasId){
		
		return this.foreasDao.findById(foreasId).get().getAitisi();
		
	}

	@Override
	@Transactional
	public AitisiModel getAitisiById(Integer aitisiId){
		
		return this.aitisiDao.findById(aitisiId).get();
		
	}
	
	@Override
	@Transactional
	public List<AitisiModel> findAllAitisis(){
		 return this.aitisiDao.findAllAitisis();
	}
	
	
	@Override
	@Transactional
	public AitisiModel updateAitisi(Integer aitisiId, StatusKey status) {
		
		 if (this.aitisiDao.findById(aitisiId).isPresent()){
			 AitisiModel existingAitisi = this.aitisiDao.findById(aitisiId).get();
			 
			 switch(status.getStatus()) {
			 case ACCEPTED:
				 existingAitisi.setStatus(new StatusKey(StatusEnum.ACCEPTED));
				 existingAitisi.setRevision_date(LocalDateTime.now( ZoneId.of( "Europe/Athens" )));
				 existingAitisi.setSubmition_date_expiration(LocalDateTime.now( ZoneId.of( "Europe/Athens" )).plusYears(1));
				 break;
			 case REJECTED:
				 existingAitisi.setStatus(new StatusKey(StatusEnum.REJECTED));
				 existingAitisi.setRevision_date(LocalDateTime.now( ZoneId.of( "Europe/Athens" )));
				 existingAitisi.setSubmition_date_expiration(null);
				 break;
			 default:
				 existingAitisi.setStatus(new StatusKey(StatusEnum.PENDING));
				 existingAitisi.setRevision_date(LocalDateTime.now( ZoneId.of( "Europe/Athens" )));
				 existingAitisi.setSubmition_date_expiration(null);
			 }
			 
			   AitisiModel updatedAitisi = aitisiDao.save(existingAitisi);

	            return updatedAitisi;
	        }else{
	            return null;
	        }
	}
	
	
	@Override
	@Transactional
	public List<AitisiModel> findAitisisByMonth(Integer month){
		
		return aitisiDao.findAitisisByMonth(month);
	}
	
	@Override
	@Transactional	
public String findAverageResponse() throws ParseException{
	List<AitisiModel> aitisis = this.aitisiDao.findAllAitisis();
	
	long num = 0;
	
	if(!aitisis.isEmpty()) { 
	
	for (int i = 0; i<aitisis.size(); i++) {
		
		if(aitisis.get(i).getRevision_date()!=null) {
	
	String dateStart = aitisis.get(i).getSubmition_date().toString();
	String dateStop = aitisis.get(i).getRevision_date().toString();

	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	Date d1 = null;
	Date d2 = null;
	
		d1 = format.parse(dateStart);
		d2 = format.parse(dateStop);

		//milliseconds
		long diff = d2.getTime() - d1.getTime();
		
		num+= diff;

		/*long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);

		System.out.print(diffDays + " days, ");
		System.out.print(diffHours + " hours, ");
		System.out.print(diffMinutes + " minutes, ");
		System.out.print(diffSeconds + " seconds.");*/
		}
		else {
			continue;
		}
	}
	
	}
	else {
		return "No forms available..";
	}
	
	long res = num / aitisis.size();
	
	long diffSeconds = res / 1000 % 60;
	long diffMinutes = res / (60 * 1000) % 60;
	long diffHours = res / (60 * 60 * 1000) % 24;
	long diffDays = res / (24 * 60 * 60 * 1000);
		
		return (diffDays + " days, "+diffHours + " hours, "+diffMinutes + " minutes, "+diffSeconds + " seconds.");
	}
	
	
	
	
	@Override
	@Transactional	
	public String findAcceptedPercent(){
		List<AitisiModel> aitisis = this.aitisiDao.findAllAitisis();
		
		int accepted = 0;
		
		if(!aitisis.isEmpty()) { 
		
		for (int i = 0; i<aitisis.size(); i++) {
			
			if(aitisis.get(i).getSubmition_date_expiration()!=null) {
				accepted++;
				}
			else continue;
			}
		
	}else {
		return "No forms available..";
	}
		
		double result = (double)(accepted * 100)/aitisis.size();
		
		return result +" % are accepted.";
	}
	
	
	

}
