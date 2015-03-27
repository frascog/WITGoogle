/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wit.oogle;

import SupportClasses.Staff;
import Views.MainPanel;
import java.applet.Applet;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author Greg
 */
public class WIToogle extends Applet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("WIT - Google");
        jFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });  
        jFrame.add(new MainPanel());
        jFrame.pack();
        jFrame.setVisible(true);
//        if (staff != null) {
//            for (Object object : staff) {
//                Staff staffs = (Staff) object;
//                System.out.println(staffs);
//            }
//        }
    }
}
