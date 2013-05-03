package eu.gloria.rt.tools.ssh;

import com.jcraft.jsch.UserInfo;

/**
 * Class used by SshCmd to wrapping the user information.
 * @author jcabello
 *
 */
public class SshUserInfo implements UserInfo {
	
	/**
	 * User password,
	 */
	private String password;
	
	/**
	 * User passphrase.
	 */
	private String passphrase;
	
	/**
	 * Constructor
	 * @param password User password
	 * @param passphrase User passphrase.
	 */
	public SshUserInfo(String password, String passphrase ){
		this.password = password;
		this.passphrase = passphrase;
	}
	

	@Override
	public String getPassphrase() {
		return passphrase;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean promptPassphrase(String arg0) {
		return false;
	}

	@Override
	public boolean promptPassword(String arg0) {
		return true; //REQUIRED!!
	}

	@Override
	public boolean promptYesNo(String arg0) {
		return true; //REQUIRED!!
	}

	@Override
	public void showMessage(String arg0) {
		
	}

}
