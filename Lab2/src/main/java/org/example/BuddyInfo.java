package org.example;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BuddyInfo {

    @Id
    private String name;
    private String address;
    private int tele;

    public BuddyInfo() {}

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
}

