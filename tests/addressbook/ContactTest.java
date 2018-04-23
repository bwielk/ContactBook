package addressbook;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactTest {

    private Contact contact1;
    private Contact contact2;

    @Before
    public void before(){
        contact1 = new Contact("Eva","Messica","em@em.com","evessica","Eva");
        contact2 = new Contact("James", "Deen", "jd@jd.com", "jdeen", "James");
    }

    @Test
    public void classContactExists(){
        assertEquals(Contact.class, contact1.getClass());
        assertEquals(Contact.class, contact2.getClass());
    }

    @Test
    public void contactContainsAllTheDetails_gettersWork(){
        //contact has name
        assertEquals("Eva", contact1.getName());
        assertEquals("James", contact2.getName());
        //contact has surname
        assertEquals("Messica", contact1.getSurname());
        assertEquals("Deen", contact2.getSurname());
        //contact has email
        assertEquals("em@em.com", contact1.getEmail());
        assertEquals("jd@jd.com", contact2.getEmail());
        //contact has skype name
        assertEquals("evessica", contact1.getSkypeName());
        assertEquals("jdeen", contact2.getSkypeName());
        //contact has a displayed name
        assertEquals("Eva", contact1.getDisplayedName());
        assertEquals("James", contact2.getDisplayedName());
    }
}