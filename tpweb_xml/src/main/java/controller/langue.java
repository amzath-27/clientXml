package controller;

import javax.xml.bind.annotation.XmlElement;

public class langue {
  
    private String nom;
        private String niveau;


    public langue() { 
    }

    public langue(String nom,String nivo) {
        this.nom=nom;
        this.niveau = nivo;
    }

    public String getnom() {
        return nom;
    }
    
@XmlElement
    public void setnom(String nom) {
        this.nom = nom;
    }
    
     public String getnivo() {
        return niveau;
    }
    
@XmlElement
    public void setNivo(String nivo) {
        this.niveau = nivo;
    }
    
   
}