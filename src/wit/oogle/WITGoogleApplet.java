/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wit.oogle;

import Views.MainPanel;
import java.applet.Applet;
import java.awt.BorderLayout;

/**
 *
 * @author frascog
 */
public class WITGoogleApplet extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void init() {
        this.setLayout(new BorderLayout());
        this.add(new MainPanel(), BorderLayout.CENTER);
    }

    // TODO overwrite start(), stop() and destroy() methods
}
