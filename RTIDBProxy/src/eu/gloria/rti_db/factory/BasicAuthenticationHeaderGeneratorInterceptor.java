package eu.gloria.rti_db.factory;


import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.cxf.interceptor.AbstractOutDatabindingInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.springframework.beans.factory.annotation.Required;

/**
 * CXF Interceptor to add the HTTP Authorization data (user/pw).
 * 
 * @author jcabello
 *
 */
public class BasicAuthenticationHeaderGeneratorInterceptor extends AbstractOutDatabindingInterceptor {

	public static final String COLON = ":";
	public static final String SPACE = " ";
	public static final String BASIC = "Basic";
	
	/** Map of allowed users to this system with their corresponding passwords. */
	private Map users;
	
	/**
	 * HTTP Authorization - User
	 */
	private String httpHeaderUser;
	
	/**
	 * HTTP Authorization - Password
	 */
	private String httpHeaderPw;
	
	@Required
	public void setUsers(Map users) {
		this.users = users;
	}

	/**
	 * Constructor
	 * @param httpHeaderUser HTTP Authorization User
	 * @param httpHeaderPw HTTP AUthorization PW
	 */
	public BasicAuthenticationHeaderGeneratorInterceptor(String httpHeaderUser, String httpHeaderPw) {
		super(Phase.MARSHAL);
		this.httpHeaderUser = httpHeaderUser;
		this.httpHeaderPw = httpHeaderPw;
	}

	/**
	 * Unused constructor
	 * @param phase Phase
	 */
	public BasicAuthenticationHeaderGeneratorInterceptor(String phase) {
		super(phase);
	}

	/**
	 * Adds the HTTP Authorization data.
	 * 
	 * @param Message CXF Message.
	 */
	public void handleMessage(Message outMessage) throws Fault {
		Map<String, List> headers = (Map<String, List>) outMessage
				.get(Message.PROTOCOL_HEADERS);
		try {
			headers.put(
					"Authorization",
					Collections.singletonList(BASIC + SPACE
							+ getBase64EncodedCredentials().trim()));
		} catch (Exception ce) {
			throw new Fault(ce);
		}
	}

	/**
	 * Builds the HTTP Authorization attribute.
	 * @return HTTP Attribute String
	 */
	private String getBase64EncodedCredentials() {
		String userName = httpHeaderUser;
		String password = httpHeaderPw;
		
		String clearCredentials = userName + COLON + password;
		return new String(Base64.encodeBase64(clearCredentials.getBytes()));
	}
}
