/**
 * This class contains generated code from the Codename One Designer, DO NOT MODIFY!
 * This class is designed for subclassing that way the code generator can overwrite it
 * anytime without erasing your changes which should exist in a subclass!
 * For details about this file and how it works please read this blog post:
 * http://codenameone.blogspot.com/2010/10/ui-builder-class-how-to-actually-use.html
*/
package generated;

import com.codename1.ui.*;
import com.codename1.ui.util.*;
import com.codename1.ui.plaf.*;
import com.codename1.ui.events.*;

public abstract class StateMachineBase extends UIBuilder {
    private Container aboutToShowThisContainer;
    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
    /**
    * @deprecated use the version that accepts a resource as an argument instead
    
**/
    protected void initVars() {}

    protected void initVars(Resources res) {}

    public StateMachineBase(Resources res, String resPath, boolean loadTheme) {
        startApp(res, resPath, loadTheme);
    }

    public Container startApp(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("List", com.codename1.ui.List.class);
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    if(resPath.endsWith(".res")) {
                        res = Resources.open(resPath);
                        System.out.println("Warning: you should construct the state machine without the .res extension to allow theme overlays");
                    } else {
                        res = Resources.openLayered(resPath);
                    }
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        if(res != null) {
            setResourceFilePath(resPath);
            setResourceFile(res);
            initVars(res);
            return showForm("Main", null);
        } else {
            Form f = (Form)createContainer(resPath, "Main");
            initVars(fetchResourceFile());
            beforeShow(f);
            f.show();
            postShow(f);
            return f;
        }
    }

    public Container createWidget(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("List", com.codename1.ui.List.class);
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    res = Resources.openLayered(resPath);
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        return createContainer(resPath, "Main");
    }

    protected void initTheme(Resources res) {
            String[] themes = res.getThemeResourceNames();
            if(themes != null && themes.length > 0) {
                UIManager.getInstance().setThemeProps(res.getTheme(themes[0]));
            }
    }

    public StateMachineBase() {
    }

    public StateMachineBase(String resPath) {
        this(null, resPath, true);
    }

    public StateMachineBase(Resources res) {
        this(res, null, true);
    }

    public StateMachineBase(String resPath, boolean loadTheme) {
        this(null, resPath, loadTheme);
    }

    public StateMachineBase(Resources res, boolean loadTheme) {
        this(res, null, loadTheme);
    }

    public com.codename1.ui.TextField findTiPass(Component root) {
        return (com.codename1.ui.TextField)findByName("TiPass", root);
    }

    public com.codename1.ui.TextField findTiPass() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TiPass", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TiPass", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findTiLogin(Component root) {
        return (com.codename1.ui.TextField)findByName("TiLogin", root);
    }

    public com.codename1.ui.TextField findTiLogin() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("TiLogin", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("TiLogin", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.List findAccountList(Component root) {
        return (com.codename1.ui.List)findByName("AccountList", root);
    }

    public com.codename1.ui.List findAccountList() {
        com.codename1.ui.List cmp = (com.codename1.ui.List)findByName("AccountList", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.List)findByName("AccountList", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnConnect(Component root) {
        return (com.codename1.ui.Button)findByName("BtnConnect", root);
    }

    public com.codename1.ui.Button findBtnConnect() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("BtnConnect", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("BtnConnect", aboutToShowThisContainer);
        }
        return cmp;
    }

    protected void exitForm(Form f) {
        if("Main".equals(f.getName())) {
            exitMain(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("MainView".equals(f.getName())) {
            exitMainView(f);
            aboutToShowThisContainer = null;
            return;
        }

    }


    protected void exitMain(Form f) {
    }


    protected void exitMainView(Form f) {
    }

    protected void beforeShow(Form f) {
    aboutToShowThisContainer = f;
        if("Main".equals(f.getName())) {
            beforeMain(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("MainView".equals(f.getName())) {
            beforeMainView(f);
            aboutToShowThisContainer = null;
            return;
        }

    }


    protected void beforeMain(Form f) {
    }


    protected void beforeMainView(Form f) {
    }

    protected void beforeShowContainer(Container c) {
    aboutToShowThisContainer = c;
        if("Main".equals(c.getName())) {
            beforeContainerMain(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("MainView".equals(c.getName())) {
            beforeContainerMainView(c);
            aboutToShowThisContainer = null;
            return;
        }

    }


    protected void beforeContainerMain(Container c) {
    }


    protected void beforeContainerMainView(Container c) {
    }

    protected void postShow(Form f) {
        if("Main".equals(f.getName())) {
            postMain(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("MainView".equals(f.getName())) {
            postMainView(f);
            aboutToShowThisContainer = null;
            return;
        }

    }


    protected void postMain(Form f) {
    }


    protected void postMainView(Form f) {
    }

    protected void postShowContainer(Container c) {
        if("Main".equals(c.getName())) {
            postContainerMain(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("MainView".equals(c.getName())) {
            postContainerMainView(c);
            aboutToShowThisContainer = null;
            return;
        }

    }


    protected void postContainerMain(Container c) {
    }


    protected void postContainerMainView(Container c) {
    }

    protected void onCreateRoot(String rootName) {
        if("Main".equals(rootName)) {
            onCreateMain();
            aboutToShowThisContainer = null;
            return;
        }

        if("MainView".equals(rootName)) {
            onCreateMainView();
            aboutToShowThisContainer = null;
            return;
        }

    }


    protected void onCreateMain() {
    }


    protected void onCreateMainView() {
    }

    protected boolean setListModel(List cmp) {
        String listName = cmp.getName();
        if("AccountList".equals(listName)) {
            return initListModelAccountList(cmp);
        }
        return super.setListModel(cmp);
    }

    protected boolean initListModelAccountList(List cmp) {
        return false;
    }

    protected void handleComponentAction(Component c, ActionEvent event) {
        Container rootContainerAncestor = getRootAncestor(c);
        if(rootContainerAncestor == null) return;
        String rootContainerName = rootContainerAncestor.getName();
        if(c.getParent().getLeadParent() != null) {
            c = c.getParent().getLeadParent();
        }
        if(rootContainerName == null) return;
        if(rootContainerName.equals("Main")) {
            if("TiLogin".equals(c.getName())) {
                onMain_TiLoginAction(c, event);
                return;
            }
            if("TiPass".equals(c.getName())) {
                onMain_TiPassAction(c, event);
                return;
            }
            if("BtnConnect".equals(c.getName())) {
                onMain_BtnConnectAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("MainView")) {
            if("AccountList".equals(c.getName())) {
                onMainView_AccountListAction(c, event);
                return;
            }
        }
    }

      protected void onMain_TiLoginAction(Component c, ActionEvent event) {
      }

      protected void onMain_TiPassAction(Component c, ActionEvent event) {
      }

      protected void onMain_BtnConnectAction(Component c, ActionEvent event) {
      }

      protected void onMainView_AccountListAction(Component c, ActionEvent event) {
      }

}
