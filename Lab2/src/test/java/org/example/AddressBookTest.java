package org.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AddressBookTest {
    AddressBook book;
    BuddyInfo buddy1, buddy2;

    @Before
    public void setUp(){
        book = new AddressBook(2);
        buddy1 = new BuddyInfo("John Doe","123 Fake Street", 1234567890);
        buddy2 = new BuddyInfo("Jane Doe","125 Other Street", 1876543212);

        book.addBuddy(buddy1);
        book.addBuddy(buddy2);
    }

    @Test
    public void removeBuddy(){
        book.removeBuddy(buddy1);
        assertEquals(1, book.getBuddyInfoList().size());
    }

    @Test
    public void addBuddy(){
        book.addBuddy(buddy1);
        assertEquals(3, book.getBuddyInfoList().size());
    }
}