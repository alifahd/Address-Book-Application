package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BuddyInfo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private int tele;

    protected BuddyInfo() {}

    public BuddyInfo(String name, String address, int tele) {
        this.name = name;
        this.address = address;
        this.tele = tele;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getTele() {
        return tele;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTele(int tele) {
        this.tele = tele;
    }

    public String toString(){
        return getName()+" has a phone number "+getTele()+" and lives at "+getAddress();
    }

}

