package org.solutione.rancho.api;

public class Finca {
    private int iduser;
    private String idfinca;
    private String nombre;
    private float Ainf;
    private float Atotal;
    private String ubicacion;
    private String foto;

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getIdfinca() {
        return idfinca;
    }

    public void setIdfinca(String idfinca) {
        this.idfinca = idfinca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getAinf() {
        return Ainf;
    }

    public void setAinf(float ainf) {
        Ainf = ainf;
    }

    public float getAtotal() {
        return Atotal;
    }

    public void setAtotal(float atotal) {
        Atotal = atotal;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
