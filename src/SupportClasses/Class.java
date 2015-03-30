/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportClasses;

import Views.ClassView;

/**
 *
 * @author Greg
 */
public class Class implements SearchableObjects{
    
    private final int CRN;
    private Subject subject;
    private int course;
    private String section;
    private double credit;
    private String title;
    private String days;
    private int cap;
    private int act;
    private Staff instructor;
    private String building;
    private ClassView view;

    public Class(int CRN) {
        this.CRN = CRN;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public int getAct() {
        return act;
    }

    public void setAct(int act) {
        this.act = act;
    }

    public Staff getInstructor() {
        return instructor;
    }

    public void setInstructor(Staff instructor) {
        this.instructor = instructor;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getCRN() {
        return CRN;
    }

    @Override
    public String toString() {
        return subject + " " + course + " " + section + " " + title;
    }

    public ClassView getView() {
        if (this.view == null){
            this.view = new ClassView(this);
        }
        return view;
    }
    
    
}
