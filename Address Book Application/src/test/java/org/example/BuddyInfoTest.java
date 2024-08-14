package org.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BuddyInfoTest {
    BuddyInfo buddy;

    @Before
    public void setUp(){
        buddy = new BuddyInfo("John Doe","123 Fake Street", 1234567890);
    }

    @Test
    public void getNameTest(){
        assertEquals("John Doe", buddy.getName());
    }

    @Test
    public void getAddressTest(){
        assertEquals("123 Fake Street", buddy.getAddress());
    }

    @Test
    public void getTeleTest(){
        assertEquals(1234567890, buddy.getTele());
    }
}