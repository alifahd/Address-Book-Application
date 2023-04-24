package org.example;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade= CascadeType.PERSIST, fetch=FetchType.EAGER)
    private List<BuddyInfo> buddyInfoList;

    public AddressBook() {
        this.buddyInfoList = new ArrayList<BuddyInfo>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * Returns the list of buddies
     *
     * @return list of buddies
     */
    public List<BuddyInfo> getBuddyInfoList() {
        return buddyInfoList;
    }

    public void setBuddyInfoList(List<BuddyInfo> buddyInfoList) {
        this.buddyInfoList = buddyInfoList;
    }

    /**
     *
     * Adds BuddyInfo object to the Address Book
     *
     * @param b
     */
    public void addBuddy(BuddyInfo b) {
        buddyInfoList.add(b);
    }

    /**
     *
     * Removes BuddyInfo object from the Address Book
     *
     * @param b
     */
    public void removeBuddy(BuddyInfo b) {
        for(BuddyInfo buddy : this.buddyInfoList) {
            if(buddy.equals(b)) {
                this.buddyInfoList.remove(buddy);
            }
        }
    }

    public String toString(){
        String s = "";
        for(BuddyInfo buddy : this.buddyInfoList) {
            s += buddy.getName()+" has a phone number "+buddy.getTele()+" and lives at "+buddy.getAddress()+"\n";
        }
        return s;
    }

    /**
     *
     * @param args
     */
    public void main(String[] args) {
        AddressBook book = new AddressBook();
        BuddyInfo buddy1 = new BuddyInfo("John Doe","123 Fake Street", 1234567890);
        BuddyInfo buddy2 = new BuddyInfo("Jane Doe","125 Other Street", 1876543212);

        book.addBuddy(buddy1);
        book.addBuddy(buddy2);

        System.out.println("Address Book:");
        for(BuddyInfo buddy : this.buddyInfoList) {
            System.out.println(buddy.getName()+" has a phone number "+buddy.getTele()+" and lives at "+buddy.getAddress());
        }
    }
}