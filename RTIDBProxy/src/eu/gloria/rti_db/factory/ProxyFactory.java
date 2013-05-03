package eu.gloria.rti_db.factory;

import java.net.URL;

import javax.net.ssl.TrustManager;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transport.http.MessageTrustDecider;
import org.apache.cxf.ws.security.trust.STSClient;

import eu.gloria.rti_db.GloriaRtiDb;
import eu.gloria.rti_db.GloriaRtiDb_Service;



/**
 * Utility to instance RTS web service proxy.
 * 
 * @author jcabello
 *
 */
public class ProxyFactory {
	
	private QName SERVICE_NAME = new QName("http://gloria.eu/rti_db", "gloria_rti_db");
	
	//Static initialization
	static {
		
		//Avoid to verify the host name in the url within the X509.
	    javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
	    		new javax.net.ssl.HostnameVerifier(){
 
	    			public boolean verify(String hostname, javax.net.ssl.SSLSession sslSession) {
	    				return true;
	    			}
	    		});
	}
	
	/**
	 * Sets the SSL Cacert file. (System property: javax.net.ssl.trustStore)
	 * @param file Cacert location
	 */
	public void setSSLCacertFile(String file){
		System.setProperty("javax.net.ssl.trustStore", file);
	}
	
	/**
	 * Returns the SSL trust store location. (System property: javax.net.ssl.trustStore)
	 * @return File location
	 */
	public String getSSLCacertFile(){
		return System.getProperty("javax.net.ssl.trustStore");
	}
	
	/**
	 * Sets the SSL Cacert file password. (System property: javax.net.ssl.trustStorePassword)
	 * @param pw Password
	 */
	public void setSSLCacertFilePw(String pw){
		System.setProperty("javax.net.ssl.trustStorePassword", pw);
	}
	
	/**
	 * Gets the SSL cacert file password. (System property: javax.net.ssl.trustStorePassword)
	 * @return PW
	 */
	public String getSSLCacertFilePw(){
		return System.getProperty("javax.net.ssl.trustStorePassword");
	}
	
	
	/**
	 * Creates a proxy to access to the web service
	 * @param urlWsdl WSDL file URL (it must be public content)
	 * @param urlWs Web service Url
	 * @param sessionMantenance true if the proxy must maintain the session.
	 * @param httpHeaderUser Http Authentication user.
	 * @param httpHeaderPw Http Autentication pw.
	 * @return Proxy
	 * @throws Exception In error case
	 */
	public GloriaRtiDb getProxy(URL urlWsdl, URL urlWs, boolean sessionMantenance, String httpHeaderUser, String httpHeaderPw)  throws Exception{
		
		
    	//Sets the keys repository for the CA_GLORIA (public key)
    	//System.setProperty("javax.net.ssl.trustStore", "c:\\repositorio\\workspace\\certificados\\cacerts_gloria_ca_dev");
		//System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
		
		//Proxy created using the wsdl public (without ACL restriction)
		GloriaRtiDb_Service ss = new GloriaRtiDb_Service(urlWsdl, SERVICE_NAME);
		GloriaRtiDb port = ss.getGloriaRtiDbSOAP(); 
        
        //Disables the checking of the server certificate CN.
        Client client = ClientProxy.getClient(port);
        STSClient stsClient = new STSClient(client.getBus()); 
        
        HTTPConduit conduit = (HTTPConduit) client.getConduit();
	    TLSClientParameters tlsParams = conduit.getTlsClientParameters();
        if (tlsParams == null) {
        	tlsParams = new TLSClientParameters();
           conduit.setTlsClientParameters(tlsParams);
        }
        tlsParams.setDisableCNCheck(true);
        tlsParams.setUseHttpsURLConnectionDefaultHostnameVerifier(false);
        
        
        
        //Changes the url of the proxy to the real url
        BindingProvider bp = (BindingProvider)port;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, urlWs.toString());
        
        //Session mantenance
        if (sessionMantenance){
        	bp.getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, Boolean.TRUE);
        }
        
        //Example of own TrustManager....
        /*X509TrustManagerAnonymous trustManager = new X509TrustManagerAnonymous();
        TrustManager[] trustManagerList ={trustManager};
        tlsParams.setTrustManagers(trustManagerList);*/
        
        //Se indica el USER/PW en la cabecera HTTP
        BasicAuthenticationHeaderGeneratorInterceptor inter = new BasicAuthenticationHeaderGeneratorInterceptor(httpHeaderUser, httpHeaderPw);
        client.getEndpoint().getOutInterceptors().add(inter);
    	
        return port;
		
	}
	
	

}
