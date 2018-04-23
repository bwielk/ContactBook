package addressbook;

public class Contact {

    private String name;
    private String surname;
    private String email;
    private String phoneNum;
    private String skypeName;
    private String displayedName;

    public Contact(String name, String surname, String email, String phoneNum, String skypeName, String displayedName)
    throws Contact.WrongPhoneNumberFormatException{
        this.name = name;
        this.surname = surname;
        this.email = email;
        if(phoneNum.length()<9 || phoneNum.length()>10){
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

    public class WrongPhoneNumberFormatException extends Exception{

        public WrongPhoneNumberFormatException(String s){
            super(s);
        }
    }
}