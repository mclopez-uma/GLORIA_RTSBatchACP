package eu.gloria.rt.tools.ssh;

public class SshTest {

	/**
	 * Class to tests
	 * @param args
	 * @throws SshException 
	 */
	public static void main(String[] args) throws SshException {
		// TODO Auto-generated method stub
		
		/*SshCmd cmd = new SshCmd();
		cmd.setUserLogin("uma");
		cmd.setUserPw("uma");
		cmd.setSudoPw("uma");
		cmd.setHost("150.214.56.219");
		cmd.setPort("22");
		
		
		
		cmd.execute("rts2-plan --add PRUEBA  +150");*/
		
		
		SshCmd cmd = new SshCmd();
		cmd.setUserLogin("jcabello");
		cmd.setUserPw("636834605");
		cmd.setSudoPw(null);
		cmd.setHost("125.236.238.49");
		cmd.setPort("2222");
		
		
		
		cmd.execute("/tmp/backup/remove_current_fits.sh");
		

	}

}
