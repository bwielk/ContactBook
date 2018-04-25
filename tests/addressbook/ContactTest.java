package addressbook;

import com.sun.org.apache.xml.internal.security.keys.ContentHandlerAlreadyRegisteredException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactTest {

    private Contact contact1;
    private Contact contact2;
    private Contact newContact;

    @Before
    public void before() throws Contact.WrongPhoneNumberFormatException, Contact.WrongEmailFormatException {
        contact1 = new Contact("Eva","Messica","em@em.com", "9872341123","evessica","Eva");
        contact2 = new Contact("James", "Deen", "jd@jd.com", "987321121","jdeen", "James");
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
        //get phone number
        assertEquals("9872341123", contact1.getPhoneNum());
        assertEquals("987321121", contact2.getPhoneNum());
    }

    @Test(expected = Contact.WrongPhoneNumberFormatException.class)
    public void exceptionIsThrownIfContactHasIncorrectNumberOfChars() throws Contact.WrongPhoneNumberFormatException, Contact.WrongEmailFormatException {
       newContact = new Contact("Bart", "Simpson", "bs@bs.com", "87211233", "bart", "bsimp");
    }

    @Test(expected = Contact.WrongPhoneNumberFormatException.class)
    public void exceptionIsThrownIfThePhoneNumberContainsIncorrectCharacters() throws Contact.WrongPhoneNumberFormatException, Contact.WrongEmailFormatException {
        newContact = new Contact("Bart", "Simpson", "bs@bs.com", "872AAA233", "bart", "bsimp");
    }

    @Test(expected = Contact.WrongEmailFormatException.class)
    public void exceptionIsThrownIfContactsEmailMissesTheATCharacter() throws Contact.WrongPhoneNumberFormatException, Contact.WrongEmailFormatException{
        newContact = new Contact("Bart", "Simpson", "bsbs.com", "87211233", "bart", "bsimp");
    }
}