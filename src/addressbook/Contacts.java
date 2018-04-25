package addressbook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Contacts {

    private static LinkedHashMap<String, Contact> contacts = new LinkedHashMap<String, Contact>();
    private static Contact newContact;

    public static void main(String args[]) throws Contact.WrongEmailFormatException, Contact.WrongPhoneNumberFormatException, IOException {

        newContact = new Contact("Amy", "Winehouse", "amywinehouse@gmail.co", "903432123", "amyw", "Amy");
        contacts.put(newContact.getDisplayedName(), newContact);
        newContact = new Contact("Kylie", "Minogue", "kyliekylie@kylie.eu", "123412123", "kkkylie", "Kylie");
        contacts.put(newContact.getDisplayedName(), newContact);
        newContact = new Contact("Maddie", "Donna", "mad@donna.co", "900902313", "madonna123", "Madonna");
        contacts.put(newContact.getDisplayedName(), newContact);
        newContact = new Contact("Jenny", "Packham", "jenny@jennypack.com", "777623231", "jennypack", "Jenny");
        contacts.put(newContact.getDisplayedName(), newContact);

        System.out.println(contacts.toString());

        try(BufferedWriter contactsFile = new BufferedWriter(new FileWriter("contacts.txt"))){
            for(Contact contact : contacts.values()){
                contactsFile.write(contact.getName() + "\t"
                        + contact.getSurname() + "\t"
                        + contact.getPhoneNum() + "\t"
                        + contact.getEmail() + "\t"
                        + contact.getSkypeName() + "\t"
                        + contact.getDisplayedName() + "\n");
            }
        }
    }
}