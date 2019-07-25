package org.solutione.rancho.api;

public class Tarea {
    private int iduser;
    private String idpryecto;
    private int nivel;
    private String msj;
    private int completado;

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getIdpryecto() {
        return idpryecto;
    }

    public void setIdpryecto(String idpryecto) {
        this.idpryecto = idpryecto;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }

    public int getCompletado() {
        return completado;
    }

    public void setCompletado(int completado) {
        this.completado = completado;
    }
}
