package addressbook;

import java.util.*;

public class Contacts {

    private static LinkedHashMap<String, Contact> contacts = new LinkedHashMap<String, Contact>();
    private static Contact newContact;

    public static void main(String args[]) throws Contact.WrongEmailFormatException, Contact.WrongPhoneNumberFormatException {

        newContact = new Contact("Amy", "Winehouse", "amywinehouse@gmail.co", "903432123", "amyw", "Amy");
        contacts.put(newContact.getDisplayedName(), newContact);
        newContact = new Contact("Kylie", "Minogue", "kyliekylie@kylie.eu", "123412123", "kkkylie", "Kylie");
        contacts.put(newContact.getDisplayedName(), newContact);
        newContact = new Contact("Maddie", "Donna", "mad@donna.co", "900902313", "madonna123", "Madonna");
        contacts.put(newContact.getDisplayedName(), newContact);
        newContact = new Contact("Jenny", "Packham", "jenny@jennypack.com", "777623231", "jennypack", "Jenny");
        contacts.put(newContact.getDisplayedName(), newContact);

        System.out.println(contacts.size());
    }
}