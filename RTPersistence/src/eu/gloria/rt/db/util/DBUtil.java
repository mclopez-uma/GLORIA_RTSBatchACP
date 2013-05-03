package eu.gloria.rt.db.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import eu.gloria.tools.log.LogUtil;



/**
 * Database JPA util.
 * 
 * @author jcabello
 *
 */
public class DBUtil {
	
	private static DBUtil singleton;
	
	
	static{
		singleton = new DBUtil();
	}
	
	private EntityManagerFactory factory;
	
	private DBUtil(){
		factory = Persistence.createEntityManagerFactory("RTPersistence");
	}
	
	protected void finalize() throws Throwable
	{
		
		if (factory != null) factory.close();
		
		super.finalize(); 
	}
	
	public static EntityManagerFactory getEntityManagerFactory(){
		return singleton.factory;
	}
	
	public static EntityManager getEntityManager(){
		return singleton.factory.createEntityManager();
	}
	
	public static void close(EntityManager manager){
		try{
			if (manager != null){
				manager.close();
			}
		}catch(Exception ex){
			ex.printStackTrace();
			LogUtil.severe(null, "DBUtil.close(EntityManager). Error closing EntityManager: " + ex.getMessage());
		}
	}
	
	public static void beginTransaction(EntityManager manager){
		if (manager != null){
			manager.getTransaction().begin();
		}
	}
	
	public static void commit(EntityManager manager){
		if (manager != null){
			manager.getTransaction().commit();
		}
		
	}
	
	public static void rollback(EntityManager manager){
		if (manager != null){
			EntityTransaction tx = manager.getTransaction();
			if(tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		
	}

}
