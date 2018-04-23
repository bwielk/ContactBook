package addressbook;

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
        if(!email.contains("@")) {
            throw new Contact.WrongEmailFormatException("The email address must contain the @ character");
        }else{
            this.email = email;
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