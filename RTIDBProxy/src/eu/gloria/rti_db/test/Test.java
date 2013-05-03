package eu.gloria.rti_db.test;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import eu.gloria.rt.entity.db.File;
import eu.gloria.rt.entity.db.FileContentType;
import eu.gloria.rt.entity.db.FileFormat;
import eu.gloria.rt.entity.db.FileType;
import eu.gloria.rt.entity.db.ObservingPlan;
import eu.gloria.rt.entity.db.ObservingPlanOwner;
import eu.gloria.rt.entity.db.ObservingPlanType;
import eu.gloria.rti_db.tools.RTIDBProxyConnection;

public class Test {
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		try{
			
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(new Date());
			XMLGregorianCalendar xmlCalendarNow = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);


			
			System.out.println("BEGIN:" + (new Date()));
			
			RTIDBProxyConnection rts = new RTIDBProxyConnection("localhost", "9080", "RTIDB", "gloria_user", "12345", false, "c:\\repositorio\\workspace\\resources\\certificates\\dev\\cacerts_gloria_ca_dev");
			
			
			//Recover OP
			ObservingPlan opRecover = rts.getProxy().opGet("0001");
			
			System.out.println("uuid = " + rts.getProxy().uuidCreate());
			
			/*ObservingPlan op = new ObservingPlan();
			op.setOwner(ObservingPlanOwner.USER);
			op.setType(ObservingPlanType.OBSERVATION);
			op.setUser("jcabello");
			
			String uuidOp = rts.getProxy().opCreate(op);
			
			System.out.println("uuidOp = " + uuidOp);
			
			
			File file = new File();
			file.setContentType(FileContentType.OBSERVATION);
			file.setDate(xmlCalendarNow);
			file.setType(FileType.IMAGE);
			file.setUrl("miurl");
			
			String uuidFile1 = rts.getProxy().fileCreate(uuidOp, file);
			System.out.println("uuidFile1=" + uuidFile1);
			String sourceURL = "file:///usr/share/gloria/rts/repositories/tmp/tmp1.txt";
			rts.getProxy().fileAddFormat(uuidFile1, FileFormat.JPG, sourceURL);
			
			//String uuidFile2 = rts.getProxy().fileCreate(uuidOp, file);
			
			
			//System.out.println("uuidFile2=" + uuidFile2);
			
			//rts.getProxy().fileAddFormat(uuidFile2, FileFormat.JPG);
			//rts.getProxy().fileAddFormat(uuidFile2, FileFormat.FITS);
			
			//File file1 = rts.getProxy().fileGet(uuidFile1);
			//File file2 = rts.getProxy().fileGet(uuidFile2);
			//File file3 = rts.getProxy().fileGet("hola caracola");
			
			//rts.getProxy().fileDeleteFormat(uuidFile2, FileFormat.JPG);*/
			
			
			System.out.println("END:" + (new Date()));
			
			
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		
	
	}

}
