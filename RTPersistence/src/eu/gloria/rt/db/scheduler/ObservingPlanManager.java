package eu.gloria.rt.db.scheduler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import eu.gloria.rt.db.util.DBUtil;
import eu.gloria.tools.log.LogUtil;

public class ObservingPlanManager {
	
	public ObservingPlan getNextToProcess(EntityManager em){
		
	ObservingPlan result = null;
		
		try{
		
			Query query = em.createQuery("SELECT op FROM ObservingPlan op where op.state=?1 order by op.id asc");
			query.setParameter(1, ObservingPlanState.QUEUED );
			
			result = (ObservingPlan) query.setMaxResults(1).getSingleResult();
			
		}catch(NoResultException ex){
			//All right...
		}
			
		return result;
			
	}
	
	public ObservingPlan getNextToProcessFromOffshore(EntityManager em){
		
		ObservingPlan result = null;
			
			try{
				
				Date now = new Date();
			
				Query query = em.createQuery("SELECT op FROM ObservingPlan op where op.state=?1 and op.scheduleDateIni<?2 and op.scheduleDateEnd<?3 order by op.id asc");
				query.setParameter(1, ObservingPlanState.OFFSHORE );
				query.setParameter(2, now );
				query.setParameter(3, now );
				
				result = (ObservingPlan) query.setMaxResults(1).getSingleResult();
				
			}catch(NoResultException ex){
				//All right...
			}
				
			return result;
				
	}
	
	public List<ObservingPlan> getAll(EntityManager em){
		
		List<ObservingPlan> result = new ArrayList<ObservingPlan>();
			
		try{
				
			
			Query query = em.createQuery("SELECT op FROM ObservingPlan op order by op.id desc");
				
			List items = query.getResultList();
			if (items != null){
				for (int x = 0; x < items.size(); x++){
					result.add((ObservingPlan)items.get(x));
				}
			}
				
		}catch(NoResultException ex){
			//All right...
		}
				
		return result;
				
	}
	
	
	public ObservingPlan get(EntityManager em, String id){
		
		ObservingPlan result = (ObservingPlan)em.find(ObservingPlan.class , id);
			
		return result;
		
	}
	
	public ObservingPlan getByUuid(EntityManager em, String uuid){
		
		ObservingPlan result = null;
			
			try{
				
				Query query = em.createQuery("SELECT op FROM ObservingPlan op where op.uuid=?1");
				query.setParameter(1, uuid );
				
				result = (ObservingPlan) query.setMaxResults(1).getSingleResult();
				
			}catch(NoResultException ex){
				//All right...
			}
				
			return result;
				
		}
	
	public void create(EntityManager em, ObservingPlan elem) throws Exception{
		
		boolean localEm = false;
		
		try {
			
			if (em == null){
				localEm = true;
				em = DBUtil.getEntityManager();
			}

			if (localEm) DBUtil.beginTransaction(em);

			em.persist(elem);

			if (localEm) DBUtil.commit(em);

		} catch (Exception ex) {
			ex.printStackTrace();
			LogUtil.severe(this, "Error creating an observing plan: " + ex.getMessage());
			if (localEm) DBUtil.rollback(em);
			throw ex;
		} finally {
			if (localEm) DBUtil.close(em);
		}
	}
	
	public long getCountByScheduleDate(EntityManager em, Date ini, Date end) throws Exception{
		
		boolean localEm = false;
		
		try {
			
			if (em == null){
				localEm = true;
				em = DBUtil.getEntityManager();
			}

			DBUtil.beginTransaction(em);

			Query query=em.createQuery("SELECT COUNT(op.id) FROM ObservingPlan op where scheduleDateIni>=?1 AND scheduleDateEnd<=?2");
			query.setParameter(1, ini);
			query.setParameter(2, end);
			Number countResult = (Number) query.getSingleResult();
			
			DBUtil.commit(em);
			
			return countResult.longValue();

		} catch (Exception ex) {
			ex.printStackTrace();
			LogUtil.severe(this, "Error recovering the CountByScheduleDate : " + ex.getMessage());
			DBUtil.rollback(em);
			throw ex;
		} finally {
			if (localEm) DBUtil.close(em);
		}
		
	}

}
