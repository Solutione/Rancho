package org.solutione.rancho;

public class user {
    private int id;
    private String usuario,apellidos, email, password;

    public user(int id, String usuario, String apellidos,String email, String password) {
        this.id = id;
        this.usuario = usuario;
        this.apellidos=apellidos;
        this.email = email;
        this.password= password;
    }

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }
    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
