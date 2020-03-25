package org.solutione.rancho.api;

public class Borre {
private String raza;
private String peso;
private String idfinca;
private String fechaparto;
private String nombrecarnero;
private String tipoparto;
private String proposito;
private String genero;

public Borre(String raza,String peso,String idfinca,String fechaparto,String nombrecarnero,String tipoparto,String proposito,String genero){
    this.raza=raza;
    this.peso=peso;
    this.idfinca=idfinca;
    this.fechaparto=fechaparto;
    this.nombrecarnero=nombrecarnero;
    this.tipoparto=tipoparto;
    this.proposito=proposito;
    this.genero=genero;
}
    public Borre(String raza,String peso,String nombrecarnero,String fechaparto){
        this.raza=raza;
        this.peso=peso;
        this.nombrecarnero=nombrecarnero;
        this.fechaparto=fechaparto;
    }

public String getraza(){
return raza;
}
public String getpeso(){
    return  peso;
}
public String getIdfinca(){return idfinca;}
public String getFechaparto(){return fechaparto;}
public String getGenero(){return genero;}
public String getNombrecarnero(){return nombrecarnero;}
public String getTipoparto(){return tipoparto;}
public String getProposito(){return proposito;}
}
