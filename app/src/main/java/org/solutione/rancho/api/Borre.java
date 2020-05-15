
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
private String id;
public Borre(){}

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


    public Borre(String id,String nombrecarnero,String fechaparto,String proposito,String raza,String peso,String genero){
        this.id=id;
        this.raza=raza;
        this.peso=peso;
        this.fechaparto=fechaparto;
        this.nombrecarnero=nombrecarnero;
        this.proposito=proposito;
        this.genero=genero;
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
public void setRaza(String raza) {this.raza = raza;}
public void setPeso(String peso) {this.peso = peso;}
public void setIdfinca(String idfinca) {this.idfinca = idfinca;}
public void setFechaparto(String fechaparto) {this.fechaparto = fechaparto; }
public void setGenero(String genero) {this.genero = genero;}
public void setNombrecarnero(String nombrecarnero) {this.nombrecarnero = nombrecarnero;}
public void setProposito(String proposito) {this.proposito = proposito;}
public void setTipoparto(String tipoparto) {this.tipoparto = tipoparto;}


}
