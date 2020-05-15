package org.solutione.rancho.api;

public class Notifications {
private String  titulo;
private String informacion;
private String Cordero;
public Notifications(String titulo,String informacion,String Cordero){
this.Cordero=Cordero;
this.titulo=titulo;
this.informacion=informacion;
}
public Notifications(){}

    public String getcordero() {
        return Cordero;
    }

    public String getInformacion() {
        return informacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setCordero(String cordero) {
        this.Cordero = cordero;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
