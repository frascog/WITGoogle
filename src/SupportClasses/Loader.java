/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportClasses;

import Model.SearchableObjects;
import Model.Class;
import Model.Staff;
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
            br = new BufferedReader(new FileReader("src/Data/Faculty.txt"));
            String line = br.readLine();
            while (line != null) {
                setInfoStaff(removeExtraWhiteSpace(line));
                line = br.readLine();
            }
            br.close();
        } catch (IOException ex) {
            System.exit(-1);
        }
        try {
            br = new BufferedReader(new FileReader("src/Data/Spring 2015.txt"));
            String line = br.readLine();
            while (line != null) {
                setInfoClass(removeExtraWhiteSpace(line),"Spring 2015");
                line = br.readLine();
            }
            br.close();
        } catch (IOException ex) {
            System.exit(-1);
        }
        try {
            br = new BufferedReader(new FileReader("src/Data/Summer 2015.txt"));
            String line = br.readLine();
            while (line != null) {
                setInfoClass(removeExtraWhiteSpace(line),"Summer 2015");
                line = br.readLine();
            }
            br.close();
        } catch (IOException ex) {
            System.exit(-1);
        }
        try {
            br = new BufferedReader(new FileReader("src/Data/Fall 2015.txt"));
            String line = br.readLine();
            while (line != null) {
                setInfoClass(removeExtraWhiteSpace(line),"Fall 2015");
                line = br.readLine();
            }
            br.close();
        } catch (IOException ex) {
            System.exit(-1);
        }
    }

    private void setInfoStaff(String line) {
        if (line.contains("Title ")) {
            String[] title = line.split("Title ");
            staff.setTitle(title[1]);
        } else if (line.contains("Deparment ")) {
            String[] department = line.split("Deparment ");
            staff.setDepartment(department[1]);
        } else if (line.contains("Degree ")) {
            String[] degree = line.split("Degree ");
            staff.addDegree(degree[1]);
        } else if (line.contains("OfficeLocation ")) {
            String[] officeLocation = line.split("OfficeLocation ");
            staff.setOfficeLocation(officeLocation[1]);
        } else if (line.contains("OfficeNumber ")) {
            String[] officeNumber = line.split("OfficeNumber ");
            staff.setOfficeNumber(officeNumber[1]);
        } else if (line.contains("Phone ")) {
            String[] phone = line.split("Phone ");
            staff.setPhone(phone[1]);
        } else if (line.contains("Email ")) {
            String[] email = line.split("Email ");
            staff.setEmail(email[1]);
        } else {
            if (staff != null) {
                //System.out.println(staff);
                add(staff, staff.getTitle().split(" "));
                //invertedFile.add(staff, staff.getTitle());
                invertedFile.add(staff, staff.getFirstName().toLowerCase());
                invertedFile.add(staff, staff.getLastName().toLowerCase());
                add(staff, staff.getDepartment().split(" "));
                //invertedFile.add(staff, staff.getDepartment());
                invertedFile.add(staff, staff.getEmail().toLowerCase());
                invertedFile.add(staff, staff.getOfficeLocation().toLowerCase());
                add(staff, staff.getOfficeLocation().split(" "));
                invertedFile.add(staff, staff.getOfficeNumber().toLowerCase());
                add(staff, staff.getPhone().split(" "));
                //invertedFile.add(staff, staff.getPhone());
                for (Object degree : staff.getDegrees()) {
                    String object = degree.toString().toLowerCase();
                    this.add(staff, object.split(" "));
                }
            }
            String[] name = line.split(" ");
            staff = new Staff(name[0], name[1]);
        }
    }

    private void add(SearchableObjects object, String[] strings) {
        for (String string : strings) {
            invertedFile.add(object, string.toLowerCase());
        }
    }

    private String removeExtraWhiteSpace(String string) {
        if (string != null) {
            if (string.length() >= 1) {
                while (string.charAt(0) == ' ' || string.charAt(0) == '\t') {
                    string = string.substring(1);
                }
            }
        }
        return string;
    }

    private void setInfoClass(String line,String semester) {
        if (line.contains("Select")) {

        } else {
            try {
                String[] courseInfo = line.split("\t");
                Class c = null;
                if (courseInfo.length == 16) {
                    c = new Class(Integer.parseInt(courseInfo[0]));
                    c.setAct(Integer.parseInt(courseInfo[10]));
                    c.setBuilding(courseInfo[14]);
                    c.setCap(Integer.parseInt(courseInfo[9]));
                    c.setCourse(Integer.parseInt(courseInfo[2]));
                    c.setCredit(Double.parseDouble(courseInfo[5]));
                    c.setDays(courseInfo[7]);
                    c.setInstructor(findStaff(courseInfo[12].toLowerCase().split(" ")));
                    c.setSection(courseInfo[3]);
                    c.setSubject(Subject.valueOf(courseInfo[1]));
                    c.setTitle(courseInfo[6]);
                    c.setTime(courseInfo[8]);
                    
                } else {
                    c = new Class(Integer.parseInt(courseInfo[1]));
                    c.setAct(Integer.parseInt(courseInfo[11]));
                    c.setBuilding(courseInfo[15]);
                    c.setCap(Integer.parseInt(courseInfo[10]));
                    c.setCourse(Integer.parseInt(courseInfo[3]));
                    c.setCredit(Double.parseDouble(courseInfo[6]));
                    c.setDays(courseInfo[8]);
                    c.setInstructor(findStaff(courseInfo[13].toLowerCase().split(" ")));
                    c.setSection(courseInfo[4]);
                    c.setSubject(Subject.valueOf(courseInfo[2]));
                    c.setTitle(courseInfo[7]);
                    c.setTime(courseInfo[9]);
                }
                    c.setSemester(semester);
                    SubjectMap.map.put(c.getSubject(), SubjectMap.subjectName);
                    addClass(c);
                    add(c.getInstructor(), c.getTitle().toLowerCase().split(" "));
                    invertedFile.add(c.getInstructor(), c.getSubject().toString().toLowerCase());
                    invertedFile.add(c.getInstructor(), c.getCourse());
                    invertedFile.add(c.getInstructor(), Integer.parseInt(c.getSection())+"");
                    invertedFile.add(c.getInstructor(),"teacher");
                    invertedFile.add(c.getInstructor(),"teaches");
                    invertedFile.add(c.getInstructor(),"teach");
            } catch (NumberFormatException e) {
                
            } catch (ArrayIndexOutOfBoundsException e) {
                if (line.split("\t").length == 1) {
                    SubjectMap.subjectName = line;
                }
            }
        }
    }

    private Staff findStaff(String[] staff) {
        String[] staffName;
        if (staff.length == 3) {
            staffName = new String[2];
            staffName[0] = staff[0];
            staffName[1] = staff[1];
        } else if (staff.length == 4) {
            staffName = new String[2];
            staffName[0] = staff[0];
            staffName[1] = staff[2];
        } else {
            staffName = staff;
        }
        Object[] object = invertedFile.search(staffName);
        for (Object o : object) {
            if (o instanceof Staff) {
                Staff s = (Staff) o;
                return s;
            }
        }
        Staff s = new Staff(toTitleCase(staff[0]), toTitleCase(staff[1]));
        this.invertedFile.add(s, staff[0]);
        this.invertedFile.add(s, staff[1]);
        s.setTitle("Adjunct");
        return s ;
    }

    private void addClass(Class c) {
        invertedFile.add(c, c.getAct());
        add(c, c.getBuilding().toLowerCase().split(" "));
        invertedFile.add(c, c.getCRN());
        invertedFile.add(c, c.getCap());
        invertedFile.add(c, c.getCourse());
        invertedFile.add(c, c.getCredit());
        add(c, c.getDays().toLowerCase().split(""));
        invertedFile.add(c, c.getInstructor());
        invertedFile.add(c, c.getInstructor().getFirstName().toLowerCase());
        invertedFile.add(c, c.getInstructor().getLastName().toLowerCase());
        invertedFile.add(c, c.getSection());
        invertedFile.add(c, c.getSemester());
        invertedFile.add(c, SubjectMap.map.get(c.getSection()));
        add(c, c.getTime().toLowerCase().split(":"));
        add(c, c.getSubject().toString().toLowerCase().split(" "));
        add(c, c.getTitle().toString().toLowerCase().split(" "));
    }
    
    public static String toTitleCase(String givenString) {
    String[] arr = givenString.split(" ");
    StringBuffer sb = new StringBuffer();

    for (int i = 0; i < arr.length; i++) {
        sb.append(Character.toUpperCase(arr[i].charAt(0)))
            .append(arr[i].substring(1)).append(" ");
    }          
    return sb.toString().trim();
}  
}
