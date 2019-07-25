package org.solutione.rancho.api;

public class Usuario {

    private int id;
    private String nombre;
    private String apeidos;
    private String sexo;
    private String correo;
    private String password;
    private String foto;

    public Usuario(){

    }

    public void addUser(String nombre,String apeidos, String sexo, String correo,String password,String foto){
        String query = "INSERT INTO usuario " +
                "(id, nombre, apellidos, sexo, correo, password, foto) VALUES (" +
                "NULL, '"
                +nombre+"', '"
                +apeidos+"', '"
                +sexo+"', '"
                +correo+"', '"
                +password+"', '"
                +foto+"');";
        new ConnectSQL().setData(query);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApeidos() {
        return apeidos;
    }

    public void setApeidos(String apeidos) {
        this.apeidos = apeidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
