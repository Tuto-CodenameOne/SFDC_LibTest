/**
 * Your application code goes here
 */

package userclasses;

import com.codename1.io.Log;
import generated.StateMachineBase;
import com.codename1.ui.*; 
import com.codename1.ui.events.*;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.AccountRenderer;
import java.util.Hashtable;
import java.util.Vector;
import tuto.codenameone.sfdc.SFDC_Connector;
import tuto.codenameone.sfdc.event.SFDC_QueryEvent;
import tuto.codenameone.sfdc.object.SFDC_Account;
import tuto.codenameone.sfdc.utils.SFDC_Environment;

/**
 *
 * @author Your name here
 */
public class StateMachine extends StateMachineBase {
//    
//    public StateMachine(String resFile) {
//        super(resFile);
//        // do not modify, write code in initVars and initialize class members there,
//        // the constructor might be invoked too late due to race conditions that might occur
//    }
//    
//    /**
//     * this method should be used to initialize variables instead of
//     * the constructor/class scope to avoid race conditions
//     */
//    protected void initVars(Resources res) {
//    }
//
//
//    @Override
//    protected void beforeMain(Form f) {
//        // createSimpleLabel();
//    }
//
//    private void createTextLabel() {
//        Label label = new Label("Je suis un texte");
//    }
//    
//    private void createImageLabel(Image image) {
//        Label label = new Label(image);
//    }
//    
//    private void createImageAndTextLabel(Image image) {
//        Label label = new Label(image);
//        label.setText("Je suis un texte");
//    }
//    
//    private Label createImageAndTextLabelWithAlignment(Image image) {
//        Label label = new Label(image);
//        label.setText("Je suis un texte");
//        // Augmentation de l'espace entre l'image et le texte
//        label.setGap(20);
//        // Précise l'alignement vertical
//        label.setVerticalAlignment(Label.CENTER);
//        // Précise le positionnement Text/Icon
//        label.setTextPosition(Label.RIGHT);
//        return label;
//    }
//    
//    private SFDC_Connector connector;
//
//    private Form newForm;
//    @Override
//    protected void onMain_ButtonAction(Component c, ActionEvent event) {
//        newForm = (Form) createContainer(fetchResourceFile(), "View2");
//        newForm.show();
//        connector = new SFDC_Connector(SFDC_Environment.DEVELOPER);
//        connector.addListener(new ActionListener() {
//
//            public void actionPerformed(ActionEvent evt) {
//                Log.p("bladi connect");
//                executeQuery();
//                
//            }
//        });
//        connector.connect("bertrand.cirot@gmail.com", "Attack69", "3MVG9A2kN3Bn17hs0_eokhJChUt7DemhK_YSyIwnz11vPE9VDrmrddMn6zyGhoBdRxGscPXc6C3Ep34N50uUm", "8387316613336804658", "N3VLrgN7lxjvDe6XRLlV1J6TI");
//        
//    }
//    
//    public void executeQuery() {
//        String query = "Select Id, Name from Account";
//        connector.addListener(new ActionListener() {
//
//            public void actionPerformed(ActionEvent evt) {
//                Log.p("Cool des datas :)");
//                SFDC_QueryEvent event = (SFDC_QueryEvent)evt;
//                if (event.getDatas() != null) {
//                    findTextArea().setText(event.getDatas().toString());
//                } else {
//                    Log.p("Pas de datas en fait :(");
//                }
//            }
//        });
//        connector.executeQuery(query);
//        
//    }
    
    
    // Access Token Request Parameters
    private static String key = "3MVG9A2kN3Bn17hs0_eokhJChUt7DemhK_YSyIwnz11vPE9VDrmrddMn6zyGhoBdRxGscPXc6C3Ep34N50uUm";
    private static String secret = "8387316613336804658";
    private static String securityToken = "N3VLrgN7lxjvDe6XRLlV1J6TI";
    
    private Resources res;
    
    public StateMachine(String resFile) {
        super(resFile);
        // do not modify, write code in initVars and initialize class members there,
        // the constructor might be invoked too late due to race conditions that might occur
    }
    
    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
    protected void initVars(Resources res) {
        this.res = res;
    }
    
    private SFDC_Connector connector;

    @Override
    protected void onMain_BtnConnectAction(Component c, ActionEvent event) {
        connector = new SFDC_Connector(SFDC_Environment.DEVELOPER);
        connector.addConnectionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                Log.p("Connected !");
                loadMainView();
                executeQuery();
            }
        });
        connector.connect(findTiLogin().getText(), findTiPass().getText(), key, secret, securityToken);
        
    }
    
    public void executeQuery() {
        String query = "Select Id, Name from Account";
        connector.addQueryListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                Log.p("Cool des datas :)");
                SFDC_QueryEvent event = (SFDC_QueryEvent)evt;
                if (event.getDatas() != null) {
                    List list = findAccountList();
                    if (list != null) {
                        list.setRenderer(new AccountRenderer());

                        Vector rawItems = event.getDatas();
                        Vector finalItems = new Vector();
                        for (Object rawItem : rawItems) {
                            SFDC_Account finalItem = new SFDC_Account();
                            finalItem.injectDatas((Hashtable)rawItem);
                            finalItems.add(finalItem);
                        }
                        list.setModel(new DefaultListModel(finalItems));
                    }
                } else {
                    Log.p("Pas de datas en fait :(");
                }
            }
        });
        connector.executeQuery(query);
        
    }
    
    private void loadMainView() {
        Form form = (Form)createContainer(getResourceFilePath(), "MainView");
        form.show();
    }
}
