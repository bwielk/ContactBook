package addressbook;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {

    private String name;
    private String surname;
    private String email;
    private String phoneNum;
    private String skypeName;
    private String displayedName;

    public Contact(String name, String surname, String email, String phoneNum, String skypeName, String displayedName)
    throws Contact.WrongPhoneNumberFormatException, Contact.WrongEmailFormatException{
        this.name = name;
        this.surname = surname;
        String emailFormat = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
        Pattern pattern = Pattern.compile(emailFormat);
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()){
            this.email = email;
        } else {
            throw new WrongEmailFormatException("The email address must contain the @ character");
        }
        if((phoneNum.length()<9 || phoneNum.length()>10) || containsDigits(phoneNum)){
            throw new Contact.WrongPhoneNumberFormatException("The phone number must consist of 9 to 10 digits");
        }else{
            this.phoneNum = phoneNum;
        }
        this.skypeName = skypeName;
        this.displayedName = displayedName;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public String getEmail(){
        return this.email;
    }

    public String getSkypeName(){
        return this.skypeName;
    }

    public String getDisplayedName(){
        return this.displayedName;
    }

    public String getPhoneNum(){
        return this.phoneNum;
    }

    private boolean containsDigits(String string){
        boolean containsCharsOtherThanDigits = false;
        for(char c : string.toCharArray()){
            if(Character.isDigit(c)){
                continue;
            }else{
                containsCharsOtherThanDigits = true;
            }
        }
        return containsCharsOtherThanDigits;
    }

    @Override
    public String toString(){
        return "name: " + getName() + "\t" +
                "surname: " + getSurname() + "\t" +
                "email: " + getEmail() + "\t" +
                "phone number: " + getPhoneNum() + "\t" +
                "skype: " + getSkypeName() + "\t" +
                "displayed name: " + getDisplayedName();
    }

    public class WrongPhoneNumberFormatException extends Exception{

        public WrongPhoneNumberFormatException(String s){
            super(s);
        }
    }

    public class WrongEmailFormatException extends Exception{

        public WrongEmailFormatException(String s){
            super(s);
        }
    }
}