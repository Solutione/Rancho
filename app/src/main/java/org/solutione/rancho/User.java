package org.solutione.rancho;


//this is very simple class and it only contains the user attributes, a constructor and the getters
// you can easily do this by right click -> generate -> constructor and getters
public class User {

    private int id;
    private String username, email, gender,surname;

    public User(int id, String username,String surname, String email, String gender) {
        this.id = id;
        this.username = username;
        this.surname=surname;
        this.email = email;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

public String getSurname(){return  surname;}

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }
}
