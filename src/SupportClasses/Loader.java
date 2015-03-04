/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportClasses;

import DataStructure.InvertedFile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Greg
 */
public class Loader {

        private Staff staff = null;
        private InvertedFile invertedFile;
        
    public Loader(InvertedFile invertedFile) {
        this.invertedFile = invertedFile;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src/Data/Data.txt"));
            String line = br.readLine();
            while (line != null) {
                setInfo(removeExtraWhiteSpace(line));
                line = br.readLine();
            }
            System.out.println(staff);
            br.close();
        } catch (IOException ex) {
            System.exit(-1);
        }
    }

    private void setInfo(String line) {
        if(line.contains("Title ")){
            String[] title = line.split("Title ");
            staff.setTitle(title[1]);
        } else if (line.contains("Deparment ")){
            String[] department = line.split("Deparment ");
            staff.setDepartment(department[1]);
        } else if (line.contains("Degree ")){
            String[] degree = line.split("Degree ");
            staff.addDegree(degree[1]);
        } else if (line.contains("OfficeLocation ")){
            String[] officeLocation = line.split("OfficeLocation ");
            staff.setOfficeLocation(officeLocation[1]);
        } else if (line.contains("OfficeNumber ")){
            String[] officeNumber = line.split("OfficeNumber ");
            staff.setOfficeNumber(officeNumber[1]);
        } else if (line.contains("Phone ")){
            String[] phone = line.split("Phone ");
            staff.setPhone(phone[1]);
        } else if (line.contains("Email ")){
            String[] email = line.split("Email ");
            staff.setEmail(email[1]);
        } else {
            if(staff!= null){
                System.out.println(staff);
                invertedFile.add(staff, staff.getTitle());
                invertedFile.add(staff, staff.getFirstName());
                invertedFile.add(staff, staff.getLastName());
                invertedFile.add(staff, staff.getDepartment());
                invertedFile.add(staff, staff.getEmail());
                invertedFile.add(staff, staff.getOfficeLocation());
                invertedFile.add(staff, staff.getOfficeNumber());
                invertedFile.add(staff, staff.getPhone());
            }
            String[] name = line.split(" ");
            staff = new Staff(name[0], name[1]);
            
        }    
    }
    
    private String removeExtraWhiteSpace(String string) {
        if (string != null) {
            while (string.charAt(0) == ' ' || string.charAt(0) == '\t') {
                string = string.substring(1);
            }
        }
        return string;
    }
}
