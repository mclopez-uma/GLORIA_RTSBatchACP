package eu.gloria.rt.tools.ssh;

/**
 * Exception raised by SshCmd class.
 * @author jcabello
 *
 */
public class SshException extends Exception {

	/**
	 * Constructor.
	 * 
	 */
	public SshException(){
	} 
	
	/**
	 * Constructor.
	 * @param message Error message.
	 */
	public SshException(String message){
		super(message); 
	} 
	
	/**
	 * Constructor.
	 * @param cause Original Exception.
	 */
	public SshException(Throwable cause) { 
		super(cause); 
	}
	
}
