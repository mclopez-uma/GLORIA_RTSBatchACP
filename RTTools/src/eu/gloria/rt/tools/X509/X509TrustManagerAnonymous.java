package eu.gloria.rt.tools.X509;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * Trust Manager Anonymous
 * @author jcabello
 *
 */
public class X509TrustManagerAnonymous implements X509TrustManager {

	@Override
	public void checkClientTrusted(X509Certificate[] arg0, String arg1)
			throws CertificateException {
		// TODO Auto-generated method stub
		System.out.println("X509TrustManagerAnonymous.checkClientTrusted()");
		
	}

	@Override
	public void checkServerTrusted(X509Certificate[] arg0, String arg1)
			throws CertificateException {
		System.out.println("X509TrustManagerAnonymous.checkServerTrusted()");
		
	}

	@Override
	public X509Certificate[] getAcceptedIssuers() {
		// TODO Auto-generated method stub
		//System.out.println("--->3");
		return null;
	}

}
