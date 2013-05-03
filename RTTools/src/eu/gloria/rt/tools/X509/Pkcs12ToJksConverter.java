package eu.gloria.rt.tools.X509;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.util.Enumeration;

public class Pkcs12ToJksConverter {

	public static void main(String[] args) throws Exception
    {
       if (args.length != 4) {
          System.out.println("sintaxis: java Pkcs12ToJksConverter {pkcs12file} {pkcs12file password} {newjksfile} {jksfile password} ");
          System.exit(1);
       }
 
       File pkcs12File = new File(args[0]);
       String pkcs12FilePw = args[1];
       File jksFile = new File(args[2]);
       String jksFilePw = args[3] ;
 
       if (!pkcs12File.canRead()) {
          System.out.println( "Impossible to acecss to the file: " + pkcs12File.getPath());
          System.exit(1);
       }
 
       if (jksFile.exists()){
    	   System.out.println("The file " + jksFile.getPath() + " already exists.");
           System.exit(1);
       }
       
       /*if (!jksFile.canWrite()) {
          System.out.println("Impossible to write the file: " + jksFile.getPath());
          System.exit(1);
       }*/
 
       KeyStore kspkcs12 = KeyStore.getInstance("pkcs12");
       KeyStore ksjks = KeyStore.getInstance("jks");
 
       kspkcs12.load(new FileInputStream(pkcs12File), pkcs12FilePw.toCharArray());
 
       ksjks.load(null, jksFilePw.toCharArray());
 
       Enumeration<String> eAliases = kspkcs12.aliases();
       
       while (eAliases.hasMoreElements()) {
    	   
          String strAlias = (String)eAliases.nextElement();
          
          System.out.println("Found alias: " + strAlias);
 
          if (kspkcs12.isKeyEntry(strAlias)) {
        	  
             System.out.println("setting entry alias: " + strAlias);
             
             Key key = kspkcs12.getKey(strAlias,  pkcs12FilePw.toCharArray());
 
             Certificate[] chain = kspkcs12.getCertificateChain(strAlias);
 
             ksjks.setKeyEntry(strAlias, key, jksFilePw.toCharArray(), chain);
          }
       }
       
       
       //Writes the final file
       OutputStream out = new FileOutputStream(jksFile);
       ksjks.store(out, jksFilePw.toCharArray());
       out.close();
       
    }
 

}
