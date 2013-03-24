package tuto.codenameone.sfdc;


/**
 *  SFDC Connector for CodenameOne
 * 
 *  @author BCirot (Tuto-CodenameOne)
 */
public class SFDC_Connector extends internal.__IOHandler {

	public String access_token;

	public String instance_url;

	public String id;

	public String issued_at;

	public String signature;

	/**
	 *  Contructor
	 */
	public SFDC_Connector(String environement) {
	}

	public void connect(String login, String password, String consumerKey, String consumerSecret) {
	}

	public void connect(String login, String password, String consumerKey, String consumerSecret, String securityToken) {
	}

	public void executeQuery(String query) {
	}

	public void executeQuery(String query, Class objectType) {
	}
}
