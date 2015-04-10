/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Views.StaffView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Greg
 */
public class Staff implements SearchableObjects{
    
    private final String firstName;
    private final String lastName;
    private HashMap<String,List<String>> degrees;
    private String email;
    private String phone;
    private String department;
    private String title;
    private String officeLocation;
    private String officeNumber;
    private StaffView view;

    public Staff(String firstName, String LastName) {
        this.firstName = firstName;
        this.lastName = LastName;
        degrees = new HashMap<String,List<String>>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    public void addDegree(String degree) {
        String[] info = degree.split(" ", 2);
        String title = info[0];
        String institute = info[1];
        if(degrees.containsKey(title)){
            degrees.get(title).add(institute);
        }else{
            List list = new ArrayList<String>();
            list.add(institute);
            degrees.put(title, list);
        }
    }
    
    public Object[] getDegrees(){
        List<String> info = new ArrayList<String>();
        Object[] keys = this.degrees.keySet().toArray();
        for (Object key : keys) {
            String object = key.toString();
            info.add(object);
            for (String school : degrees.get(object)) {
                info.add(school);
            }  
        }
        return info.toArray();
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
    
    public StaffView getView(){
        if (this.view == null){
            this.view = new StaffView(this);
        }
        return view;
    }
}
    
    
