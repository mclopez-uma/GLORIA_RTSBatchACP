package eu.gloria.rt.tools.transfer;

import java.io.File;
import java.net.URL;
import java.util.Date;

/**
 * File Uploader tool.
 * 
 * @author jcabello
 *
 */
public class FileUploader {
	
	public static void main(String[] args) throws Exception{
		
		File file = new File("c:\\dummy\\kk.txt");
		System.out.println("filename=" + file.getName());
		System.out.println("lastModification=" + new Date(file.lastModified()));
		
		
		
		
		//URL url = new URL("ftp://user:password@localhost:23/tmp/kk.txt");
		URL url = new URL("file:///C:/dummy/tmp.txt");
		//URL url = new URL("file:///tmp/kk/");
		
		//URL url = new URL("file:///usr/share/gloria/rts/repositories/rep01/");
		
		System.out.println("url=" + url.toString());
		System.out.println("host=" + url.getHost());
		System.out.println("file=" + url.getPath());
		System.out.println("auth=" + url.getAuthority());
		System.out.println("path=" + url.getPath());
		System.out.println("port=" + url.getPort());
		System.out.println("protocol=" + url.getProtocol());
		System.out.println("file=" + url.getFile());
		
		//URL urlSource = new URL("file:///C:/dummy/cp1/tmp.txt");
		//URL urlTarget = new URL("file:///C:/dummy/cp2/f1/tmp.txt");
		
		//FileUploader uploader = new FileUploader("c:\\dummy\\cp1");
		//uploader.upload(urlSource, urlTarget);
		
		
	}
	
	private String tmpPath;
	
	public FileUploader(String tmpPath){
		this.tmpPath = tmpPath;
	}
	
	public void upload(URL source, URL target) throws Exception{
		
		if (source.getProtocol().equals("file") && target.getProtocol().equals("file")){ //Move local file
			moveLocalFile(source, target);
		}else{
			throw new Exception("Impossible to transfer the file.");
		}
		
	}
	
	private void moveLocalFile(URL source, URL target) throws Exception{
		
		File sFile = new File(source.getPath());
		File tFile = new File(target.getPath());
		
		if (!sFile.exists()){
			throw new Exception("FileUploader::The source local file does not exist. SourceFile=" + tFile.toString());
		}
		
		if (!tFile.getParentFile().exists()){
			if (!tFile.getParentFile().mkdirs()){
				throw new Exception("FileUploader::Impossible to create the target directory. TargetFile=" + tFile.toString());
			}
			//tFile.getParentFile().setExecutable(true, false);
			//tFile.getParentFile().setWritable(true, false);
			//tFile.getParentFile().setReadable(true, false);
		}
		
		
		if (!sFile.renameTo(tFile)){
			throw new Exception("FileUploader:: Impossible to move the file. [source=" +sFile.toString() + ", target=" + tFile.toString() + "]");
		}
		
	}

}
