package eu.gloria.rt.tools.ssh;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

/**
 * Allows user to execute a command using ssh connection.
 * @author jcabello
 *
 */
public class SshCmd {
	
	/**
	 * SSH host.
	 */
	private String host;
	
	/**
	 * SSh port, 22 by default.
	 */
	private String port;
	
	/**
	 * User login.
	 */
	private String userLogin;
	
	/**
	 * User password
	 */
	private String userPw;
	
	/**
	 * Sudo password.
	 */
	private String sudoPw;
	
	/**
	 * Command exit status: 0 is ok.
	 */
	private int exitStatus;
	
	/**
	 * Constructor.
	 */
	public SshCmd(){
		this.exitStatus = 0;
		this.port = "22";
	}
	
	/**
	 * Executes a ssh command.
	 * @param cmd Command.
	 * @throws SshException In error case.
	 */
	public void execute(String cmd) throws SshException{
		
		try{
			
			JSch jsch=new JSch();  
			Session session=jsch.getSession(userLogin, host, Integer.parseInt(port));
			SshUserInfo ui = new SshUserInfo(userPw, null);
		    session.setUserInfo(ui);
		    session.connect();
			Channel channel=session.openChannel("exec");
			
			if (sudoPw != null){
				// man sudo
			    //   -S  The -S (stdin) option causes sudo to read the password from the
			    //       standard input instead of the terminal device.
			    //   -p  The -p (prompt) option allows you to override the default
			    //       password prompt and use a custom one.
				cmd = "sudo -S -p '' " + cmd;
			}
			
			
		    ((ChannelExec)channel).setCommand(cmd);
			channel.setInputStream(null);
			 
			InputStream in=channel.getInputStream();
			
		    channel.connect();
		    
		    if (sudoPw != null){
		    	OutputStream out=channel.getOutputStream();
			    //((ChannelExec)channel).setErrStream(System.err);
		    	out.write((sudoPw+"\n").getBytes());
			    out.flush();
		    }

		    byte[] tmp=new byte[1024];
		    while(true){ 
		      while(in.available()>0){
		        int i=in.read(tmp, 0, 1024);
		        if(i<0)break;
		          //System.out.print(new String(tmp, 0, i));
		      }
		      if(channel.isClosed()){
		        //System.out.println("exit-status: "+channel.getExitStatus());
		      	this.exitStatus = channel.getExitStatus();
		        break;
		      }
		      try{Thread.sleep(1000);}catch(Exception ee){}
		    }
		      
		    channel.disconnect();
		    session.disconnect();
		      
		}catch(IOException ioe){
			
			throw new SshException(ioe.getMessage());
			
		}catch(JSchException ex){
			
			throw new SshException(ex.getMessage());
			
		}
		
		if (exitStatus != 0){
			throw new SshException("Unsuccessfull command execution, returned code=" + exitStatus);
		}
	}
	
	/**
	 * Access method
	 * @return Value.
	 */
	public String getHost() {
		return host;
	}
	
	/**
	 * Access method.
	 * @param host Value.
	 */
	public void setHost(String host) {
		this.host = host;
	}
	
	/**
	 * Access method.
	 * @return Value.
	 */
	public String getPort() {
		return port;
	}
	
	/**
	 * Access method.
	 * @param port value.
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Access method.
	 * @return value.
	 */
	public String getUserLogin() {
		return userLogin;
	}
	
	/**
	 * Access method.
	 * @param port value.
	 */
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	
	/**
	 * Access method.
	 * @return value.
	 */
	public String getUserPw() {
		return userPw;
	}
	
	/**
	 * Access method.
	 * @param port value.
	 */
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	
	/**
	 * Access method.
	 * @return value.
	 */
	public String getSudoPw() {
		return sudoPw;
	}
	
	/**
	 * Access method.
	 * @param port value.
	 */
	public void setSudoPw(String sudoPw) {
		this.sudoPw = sudoPw;
	}

	/**
	 * Access method.
	 * @return value.
	 */
	public int getExitStatus() {
		return exitStatus;
	}

	/**
	 * Access method.
	 * @param port value.
	 */
	public void setExitStatus(int exitStatus) {
		this.exitStatus = exitStatus;
	}

}
