package org.example;

import org.junit.Test;

import jakarta.persistence.*;
import java.util.List;

public class JPATest {
    @Test
    public void performJPA() {
        BuddyInfo buddy1 = new BuddyInfo("John Doe","123 Fake Street", 1234567890);
        BuddyInfo buddy2 = new BuddyInfo("Jane Doe","125 Other Street", 1876543212);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        EntityTransaction tx2 = em.getTransaction();

        tx.begin();

        em.persist(buddy1);
        em.persist(buddy2);

        tx.commit();

        Query q = em.createQuery("SELECT b FROM BuddyInfo b");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();

        System.out.println("List of buddies\n----------------");

        for(BuddyInfo buddy : results){
            System.out.println(buddy.getName()+" has a phone number "+buddy.getTele()+" and lives at "+buddy.getAddress());
        }

        AddressBook book = new AddressBook();
        book.addBuddy(buddy1);
        book.addBuddy(buddy2);

        tx2.begin();

        em.persist(book);

        tx2.commit();

        /*Query q2 = em.createQuery("SELECT a FROM AddressBook a");

        @SuppressWarnings("unchecked")
        List<AddressBook> results2 = q2.getResultList();

        System.out.println("List of address books\n----------------");

        for(AddressBook a : results2){
            System.out.println(a.toString());
        }*/

        em.close();
        emf.close();
    }
}