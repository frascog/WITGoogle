/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wit.oogle;

import DataStructure.InvertedFile;
import SupportClasses.Loader;
import java.applet.Applet;
import java.util.Scanner;

/**
 *
 * @author Greg
 */
public class WIToogle extends Applet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InvertedFile invertedFile = new InvertedFile<String,String>();
        new Loader(invertedFile);
        System.out.println();
        System.out.println(invertedFile);
        System.out.println();
        //Scanner keyboard = new Scanner(System.in);
        //String search = keyboard.nextLine();
        //System.out.println(invertedFile.search(search));
    }


}
