package eu.gloria.rt.db.scheduler;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import eu.gloria.rt.db.util.DBUtil;
import eu.gloria.tools.log.LogUtil;



public class AdvertisementManager {
	
	public AdvertisementManager(){
	}
	
	
	public void cancelOutOfTime(EntityManager em){
		
		Query query = em.createQuery("UPDATE Advertisement adv SET adv.state=?1 where adv.state= ?2 AND adv.deadline < ?3");
		query.setParameter(1, AdvertisementState.CANCELED);
		query.setParameter(2, AdvertisementState.PENDING);
		query.setParameter(3, new Date());
		
		query.executeUpdate();
	}
	
	public Advertisement get(EntityManager em, String id){
		
		Advertisement adv = (Advertisement)em.find(Advertisement.class , id);
			
		return adv;
		
	}
	
	public Advertisement getByUuid(EntityManager em, String uuid){
		
		Advertisement result = null;
			
			try{
				
				Query query = em.createQuery("SELECT adv FROM Advertisement adv where adv.uuid=?1");
				query.setParameter(1, uuid );
				
				result = (Advertisement) query.setMaxResults(1).getSingleResult();
				
			}catch(NoResultException ex){
				//All right...
			}
				
			return result;
				
		}
	
	public void create(EntityManager em, Advertisement adv){
		
		boolean localEm = false;
		
		try {
			
			if (em == null){
				localEm = true;
				em = DBUtil.getEntityManager();
			}

			DBUtil.beginTransaction(em);

			em.persist(adv);

			DBUtil.commit(em);

		} catch (Exception ex) {
			ex.printStackTrace();
			LogUtil.severe(this, "Error creating an advertisement: " + ex.getMessage());
			DBUtil.rollback(em);
		} finally {
			if (localEm) DBUtil.close(em);
		}
	}
	
	public Advertisement getNextToProcess(EntityManager em){
		
		Advertisement adv = null;
		
		try{
		
			Query query = em.createQuery("SELECT adv FROM Advertisement adv where adv.state=?1 order by adv.id asc");
			query.setParameter(1, AdvertisementState.PENDING);
			
			adv = (Advertisement) query.setMaxResults(1).getSingleResult();
		}catch(NoResultException ex){
			//All right...
		}
			
		return adv;
			
	}
	
		
	public long getCount(EntityManager em, Date ini, Date end) throws Exception{
		
		boolean localEm = false;
		
		try {
			
			if (em == null){
				localEm = true;
				em = DBUtil.getEntityManager();
			}

			DBUtil.beginTransaction(em);

			Query query=em.createQuery("SELECT COUNT(adv.id) FROM Advertisement adv where predIntervalIni>=?1 AND predIntervalEnd<=?2");
			query.setParameter(1, ini);
			query.setParameter(2, end);
			Number countResult = (Number) query.getSingleResult();
			
			DBUtil.commit(em);
			
			return countResult.longValue();

		} catch (Exception ex) {
			DBUtil.rollback(em);
			throw ex;
		} finally {
			if (localEm) DBUtil.close(em);
		}
		
	}

}
