package eu.gloria.rt.db.repository;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import eu.gloria.rt.db.util.DBUtil;
import eu.gloria.tools.log.LogUtil;
import eu.gloria.tools.uuid.file.UUID;

public class RepManager {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		
		EntityManager em = DBUtil.getEntityManager();
		
		RepManager manager = new RepManager();
		
		Repository repository = new Repository();
		repository.setActive(1);
		repository.setCod(1);
		repository.setConnUrl("file:///usr/share/gloria/rts/repositories/rep01/");
		repository.setPublicUrl("TODO");
		repository.setDescription("Default");
		repository.setName("REP01");
		
		manager.create(em, repository);
		
		Repository rep = manager.getRepActive(em);
		
		System.out.println("kk");
		
		

		
		//RepObservingPlan op0 = manager.getOp(em, "0000000000000001000000010000013dab017a20");
		
		
		
		/*UUID uuidOp = new UUID(1, 1);
		RepObservingPlan op = new RepObservingPlan();
		op.setOwner(RepObservingPlanOwner.USER);
		op.setType(RepObservingPlanType.OBSERVATION);
		op.setUser("jcabello");
		op.setUuid(uuidOp.getValue());
		
		System.out.println("uuidOp=" + uuidOp.getValue());
		
		manager.create(em, op);
		
		RepObservingPlan op2 = manager.getOp(em, uuidOp.getValue());
		
		UUID uuidFile = new UUID(1, 1);
		RepFile dbFile = new RepFile();
    	dbFile.setContentType(RepFileContentType.OBSERVATION);
    	dbFile.setDate(new Date());
    	//dbFile.setFormat(FileFormat.FITS);
    	dbFile.setType(RepFileType.IMAGE);
    	dbFile.setRepObservingPlan(op2);
    	dbFile.setUuid(uuidFile.getValue());
    	System.out.println("uuidFile=" + uuidFile.getValue());
    	
    	manager.create(em, dbFile);
    	
    	RepFileFormat fileFormat = new RepFileFormat();
    	fileFormat.setFormat(FileFormat.FITS);
    	fileFormat.setRepFile(dbFile);
    	
    	manager.create(em, fileFormat);
    	
    	fileFormat = new RepFileFormat();
    	fileFormat.setFormat(FileFormat.JPG);
    	fileFormat.setRepFile(dbFile);
    	
    	manager.create(em, fileFormat);
    	
    	RepObservingPlan op3 = manager.getOp(em, uuidOp.getValue());
    	
    	uuidFile = new UUID(1, 1);
		dbFile = new RepFile();
    	dbFile.setContentType(RepFileContentType.OBSERVATION);
    	dbFile.setDate(new Date());
    	dbFile.setFormat(FileFormat.FITS);
    	dbFile.setRepObservingPlan(op3);
    	dbFile.setUuid(uuidFile.getValue());
    	System.out.println("uuidFile=" + uuidFile.getValue());
    	
    	manager.create(em, dbFile);*/
    	
    	em.close();
    	em = DBUtil.getEntityManager();
    	
		System.out.println("FIN");
		

	}
	
	public void create(EntityManager em, RepObservingPlan op){
		
		boolean localEm = false;
		
		try {
			
			if (em == null){
				localEm = true;
				em = DBUtil.getEntityManager();
			}

			DBUtil.beginTransaction(em);

			em.persist(op);

			DBUtil.commit(em);

		} catch (Exception ex) {
			ex.printStackTrace();
			LogUtil.severe(this, "Error creating an ObservingPlan: " + ex.getMessage());
			DBUtil.rollback(em);
		} finally {
			if (localEm) DBUtil.close(em);
		}
	}
	
	public RepObservingPlan getOp(EntityManager em, String uuid){
		
		RepObservingPlan result = null;
		
		try{
		
			Query query = em.createQuery("SELECT op FROM RepObservingPlan op where op.uuid=?1");
			query.setParameter(1, uuid);
			
			result = (RepObservingPlan) query.setMaxResults(1).getSingleResult();
			
		}catch(NoResultException ex){
			//All right...
		}
			
		return result;
	}
	
	public Repository getRepActive(EntityManager em){
		
		Repository result = null;
		
		try{
		
			Query query = em.createQuery("SELECT re FROM Repository re where re.active=?1");
			query.setParameter(1, 1);
			
			result = (Repository) query.setMaxResults(1).getSingleResult();
			
		}catch(NoResultException ex){
			//All right...
		}
			
		return result;
	}
	
	public void delete(EntityManager em, RepObservingPlan op){
		
		boolean localEm = false;
		
		try {
			
			if (em == null){
				localEm = true;
				em = DBUtil.getEntityManager();
			}

			DBUtil.beginTransaction(em);

			em.remove(op);

			DBUtil.commit(em);

		} catch (Exception ex) {
			ex.printStackTrace();
			LogUtil.severe(this, "Error deleting an ObservingPlan: " + ex.getMessage());
			DBUtil.rollback(em);
		} finally {
			if (localEm) DBUtil.close(em);
		}
	}
	
	public void create(EntityManager em, RepFile file){
		
		boolean localEm = false;
		
		try {
			
			if (em == null){
				localEm = true;
				em = DBUtil.getEntityManager();
			}

			DBUtil.beginTransaction(em);

			em.persist(file);

			DBUtil.commit(em);

		} catch (Exception ex) {
			ex.printStackTrace();
			LogUtil.severe(this, "Error creating a RepFile: " + ex.getMessage());
			DBUtil.rollback(em);
		} finally {
			if (localEm) DBUtil.close(em);
		}
	}
	
	public void create(EntityManager em, Repository rep){
		
		boolean localEm = false;
		
		try {
			
			if (em == null){
				localEm = true;
				em = DBUtil.getEntityManager();
			}

			DBUtil.beginTransaction(em);

			em.persist(rep);

			DBUtil.commit(em);

		} catch (Exception ex) {
			ex.printStackTrace();
			LogUtil.severe(this, "Error creating a Repository: " + ex.getMessage());
			DBUtil.rollback(em);
		} finally {
			if (localEm) DBUtil.close(em);
		}
	}
	
	public void create(EntityManager em, RepFileFormat format){
		
		boolean localEm = false;
		
		try {
			
			if (em == null){
				localEm = true;
				em = DBUtil.getEntityManager();
			}

			DBUtil.beginTransaction(em);

			em.persist(format);

			DBUtil.commit(em);

		} catch (Exception ex) {
			ex.printStackTrace();
			LogUtil.severe(this, "Error creating a RepFileFormat: " + ex.getMessage());
			DBUtil.rollback(em);
		} finally {
			if (localEm) DBUtil.close(em);
		}
	}
	
	public RepFile getFile(EntityManager em, String uuid){
		
		RepFile result = null;
		
		try{
		
			Query query = em.createQuery("SELECT file FROM RepFile file where file.uuid=?1");
			query.setParameter(1, uuid);
			
			result = (RepFile) query.setMaxResults(1).getSingleResult();
			
		}catch(NoResultException ex){
			//All right...
		}
			
		return result;
	}
	
	public void delete(EntityManager em, RepFile file){
		
		boolean localEm = false;
		
		try {
			
			if (em == null){
				localEm = true;
				em = DBUtil.getEntityManager();
			}

			DBUtil.beginTransaction(em);

			em.remove(file);

			DBUtil.commit(em);

		} catch (Exception ex) {
			ex.printStackTrace();
			LogUtil.severe(this, "Error deleting a File: " + ex.getMessage());
			DBUtil.rollback(em);
		} finally {
			if (localEm) DBUtil.close(em);
		}
	}
	
	public void delete(EntityManager em, RepFileFormat fileFormat){
		
		boolean localEm = false;
		
		try {
			
			if (em == null){
				localEm = true;
				em = DBUtil.getEntityManager();
			}

			DBUtil.beginTransaction(em);

			em.remove(fileFormat);

			DBUtil.commit(em);

		} catch (Exception ex) {
			ex.printStackTrace();
			LogUtil.severe(this, "Error deleting a fileFormat: " + ex.getMessage());
			DBUtil.rollback(em);
		} finally {
			if (localEm) DBUtil.close(em);
		}
	}
	
	

}
