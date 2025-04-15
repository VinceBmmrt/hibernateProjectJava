package com.telusko;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    private int rollNb;
    private String sName;
    private int sAge;

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getsAge() {
        return sAge;
    }

    public void setsAge(int sAge) {
        this.sAge = sAge;
    }


    public int getRollNb() {
        return rollNb;
    }

    public void setRollNb(int rollNb) {
        this.rollNb = rollNb;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNb=" + rollNb +
                ", sName='" + sName + '\'' +
                ", sAge=" + sAge +
                '}';
    }
}
