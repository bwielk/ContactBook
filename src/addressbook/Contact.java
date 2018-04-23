package addressbook;

public class Contact {

    private String name;
    private String surname;
    private String email;
    private String skypeName;
    private String displayedName;

    public Contact(String name, String surname, String email, String skypeName, String displayedName){
        this.name = name;
        this.surname = surname;
        this.email = email;
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

}

