package addressbook;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactTest {

    private Contact contact1;
    private Contact contact2;

    @Before
    public void before(){
        contact1 = new Contact();
        contact2 = new Contact();
    }

    @Test
    public void classContactExists(){
        assertEquals(Contact.class, contact1.getClass());
        assertEquals(Contact.class, contact2.getClass());
    }
}