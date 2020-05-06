package igp.depo.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import igp.depo.model.AitisiModel;
import igp.depo.model.ForeasModel;
import igp.depo.model.StatusKey;
import igp.depo.repo.AitisiDao;
import igp.depo.repo.ForeasDao;
import igp.depo.utils.StatusEnum;

@Service
public class AitisiServiceImpl implements AitisiService {
	
	@Autowired
	private AitisiDao aitisiDao;
	
	@Autowired
	private ForeasDao foreasDao;
	

	@Override
	@Transactional
	  public AitisiModel createAitisi(Integer foreasId, AitisiModel aitisi) {
		Set<AitisiModel> aitisis = new HashSet<>();
		
		try {
	    Optional<ForeasModel> byId = this.foreasDao.findById(foreasId);
	    ForeasModel foreas = byId.get();
	    aitisi.setStatus(new StatusKey(StatusEnum.PENDING));
	    aitisi.setForeas(foreas);
	    aitisi.setForeasTitle(foreas.getDistinctiveTitle());
	    aitisis.add(this.aitisiDao.save(aitisi));
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
	public AitisiModel updateAitisi(Integer aitisiId, StatusKey status) {
		
		 if (this.aitisiDao.findById(aitisiId).isPresent()){
			 AitisiModel existingAitisi = this.aitisiDao.findById(aitisiId).get();

			  
			 switch(status.getStatus()) {
			 case ACCEPTED:
				 existingAitisi.setStatus(new StatusKey(StatusEnum.ACCEPTED));
				 existingAitisi.setSubmition_date_expiration(LocalDateTime.now( ZoneId.of( "Europe/Athens" )).plusYears(1));
				 break;
			 case REJECTED:
				 existingAitisi.setStatus(new StatusKey(StatusEnum.REJECTED));
				 existingAitisi.setSubmition_date(LocalDateTime.now( ZoneId.of( "Europe/Athens" )));
				 break;
			 default:
				 existingAitisi.setStatus(new StatusKey(StatusEnum.PENDING));
			 }
			 
			   AitisiModel updatedAitisi = aitisiDao.save(existingAitisi);

	            return updatedAitisi;
	        }else{
	            return null;
	        }
	}
	

}
