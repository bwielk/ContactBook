package addressbook;

import java.io.*;
import java.util.*;

public class Contacts {

    private static LinkedHashMap<String, Contact> contacts = new LinkedHashMap<String, Contact>();
    private static Contact newContact;

    public static void main(String args[]) throws IOException, Contact.WrongEmailFormatException, Contact.WrongPhoneNumberFormatException {

//        newContact = new Contact("Amy", "Winehouse", "amywinehouse@gmail.co", "903432123", "amyw", "Amy");
//        contacts.put(newContact.getDisplayedName(), newContact);
//        newContact = new Contact("Kylie", "Minogue", "kyliekylie@kylie.eu", "123412123", "kkkylie", "Kylie");
//        contacts.put(newContact.getDisplayedName(), newContact);
//        newContact = new Contact("Maddie", "Donna", "mad@donna.co", "900902313", "madonna123", "Madonna");
//        contacts.put(newContact.getDisplayedName(), newContact);
//        newContact = new Contact("Jenny", "Packham", "jenny@jennypack.com", "777623231", "jennypack", "Jenny");
//        contacts.put(newContact.getDisplayedName(), newContact);
        //System.out.println(contacts.toString());

        try(BufferedWriter contactsFile = new BufferedWriter(new FileWriter("contacts.txt"))){
            for(Contact contact : contacts.values()){
                contactsFile.write(
                        contact.getName() + "\t"
                        + contact.getSurname() + "\t"
                        + contact.getEmail() + "\t"
                        + contact.getPhoneNum() + "\t"
                        + contact.getSkypeName() + "\t"
                        + contact.getDisplayedName() + "\n");
            }
        }
    }

    static {

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("contacts.txt")))){
            scanner.useDelimiter("\t");
            Contact newContact;
            while(scanner.hasNextLine()) {
                String name = scanner.next();
                scanner.skip(scanner.delimiter());

                String surname = scanner.next();
                scanner.skip(scanner.delimiter());

                String email = scanner.next();
                scanner.skip(scanner.delimiter());

                String phoneNum = scanner.next();
                scanner.skip(scanner.delimiter());

                String skype = scanner.next();
                scanner.skip(scanner.delimiter());

                String displayedName = scanner.nextLine();
                newContact = new Contact(name, surname, email, phoneNum, skype, displayedName);
                System.out.println(newContact.toString());
                contacts.put(displayedName, newContact);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Contact.WrongEmailFormatException e) { //from new Contact creation
            e.printStackTrace();
        } catch (Contact.WrongPhoneNumberFormatException e) { // from new Contact creation
            e.printStackTrace();
        }
    }
}