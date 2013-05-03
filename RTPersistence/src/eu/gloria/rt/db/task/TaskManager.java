package eu.gloria.rt.db.task;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import eu.gloria.rt.db.util.DBUtil;
import eu.gloria.tools.log.LogUtil;

/**
 * 
 * @author jcabello
 *
 */
public class TaskManager {
	
	public static void main(String[] args) throws Exception {
		
		EntityManager em = DBUtil.getEntityManager();
		
		try {
			
			DBUtil.beginTransaction(em);
			
			Task t = new Task();
			t.setEnable(1);
			t.setName("ACP_Retriever");
			t.setProvider("eu.gloria.rt.worker.offshore.WorkerOffshoreRetriever");
			t.setSleepTime(1000);

			em.persist(t);

			DBUtil.commit(em);

		} catch (Exception ex) {
			ex.printStackTrace();
			DBUtil.rollback(em);
		} finally {
			DBUtil.close(em);
		}
		
		
		/*ArrayList<TaskProperty> props = new ArrayList<TaskProperty>();
		
		TaskProperty prop = new TaskProperty();
		prop.setName("sleepTime");
		prop.setValue("5000");
		prop.setType(TaskPropertyType.INT);
		
		prop.setTask(t);
		
		props.add(prop);
		
		em.persist(prop);*/
		
		
		System.out.println("");
	}
	
	public List<Task> getTasks(EntityManager em){
		
		List<Task> result = null;
		boolean localEm = false;
		
		try {
			
			if (em == null){
				localEm = true;
				em = DBUtil.getEntityManager();
			}

			DBUtil.beginTransaction(em);

			Query query = em.createQuery("SELECT t FROM Task t");
			
			result = query.getResultList();

			DBUtil.commit(em);
			
		}catch(NoResultException ex){
			//All right...
			DBUtil.commit(em);
		}catch (Exception ex) {
			ex.printStackTrace();
			LogUtil.severe(this, "Error recovering the Task properties from database " + ex.getMessage());
			DBUtil.rollback(em);
		} finally {
			if (localEm) DBUtil.close(em);
		}
		
		return result;
			
	}

}
