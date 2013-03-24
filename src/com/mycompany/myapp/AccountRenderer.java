/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.List;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.ListCellRenderer;
import tuto.codenameone.sfdc.object.SFDC_Account;

/**
 *
 * @author BeBack
 */
public class AccountRenderer extends Container implements ListCellRenderer {
    
    private Label ligne1 = new Label("");
    private Label ligne2 = new Label("");
    
    public AccountRenderer() {
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        this.addComponent(ligne1);
        this.addComponent(ligne2);
    }
    
    public Component getListCellRendererComponent(List list, Object value, int index, boolean isSelected) {
        SFDC_Account account = (SFDC_Account) value;
        ligne1.setText(account.Id);
        ligne2.setText(account.Name);
        return this;
    }

    public Component getListFocusComponent(List list) {
        return null;
    }
}
