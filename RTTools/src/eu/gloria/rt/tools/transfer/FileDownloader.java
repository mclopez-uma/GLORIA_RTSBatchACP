package eu.gloria.rt.tools.transfer;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class FileDownloader {
	
	private String tmpPath;
	
	public FileDownloader(String tmpPath){
		this.tmpPath = tmpPath;
	}
	
	public void download(URL source, String fileName) throws Exception{
		
		if (source.getProtocol().equals("http")){ //http
			httpDownload(source, fileName);
		}else{
			throw new Exception("Impossible to download the file.");
		}
		
	}
	
	private void httpDownload(URL source, String fileName) throws Exception {
		
        source.openConnection();
        InputStream reader = source.openStream();
 
        FileOutputStream writer = new FileOutputStream(fileName);
        byte[] buffer = new byte[153600];
        int totalBytesRead = 0;
        int bytesRead = 0;
 
        while ((bytesRead = reader.read(buffer)) > 0)
        {  
           writer.write(buffer, 0, bytesRead);
           buffer = new byte[153600];
           totalBytesRead += bytesRead;
        }
 
        writer.close();
        reader.close();
		
	}


}
