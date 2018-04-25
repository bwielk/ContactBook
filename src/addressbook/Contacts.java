package addressbook;

import java.io.*;
import java.util.*;

public class Contacts {

    private static LinkedHashMap<String, Contact> contacts = new LinkedHashMap<String, Contact>();

    public static void main(String args[]) throws IOException{

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
                System.out.println("ADDED " + newContact.toString());
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