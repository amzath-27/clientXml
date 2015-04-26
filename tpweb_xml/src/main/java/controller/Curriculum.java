package controller;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "resume")

//Resume = curriculum
public class Curriculum {
    private int id;
    
        private String lastName;
        private String firstName;
        private String Adresse;
        

    experiences_info experiences_pro;
    langues langues;

    public Curriculum() {
        this.id =0;
        this.lastName = "";
        this.firstName = "";
        this.Adresse = "";
        this.experiences_pro = new experiences_info();
        this.langues = new langues();
    }

    public Curriculum(String lastName,String firstName,String Adresse,experiences_info experiences_pro,langues langues ) {
       
        this.lastName = lastName;
        this.firstName = firstName;
        this.Adresse = Adresse;
        this.experiences_pro = experiences_pro;
        this.langues = langues;    
    }
    
@XmlElement
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
  @XmlElement
    public void setAdresse(String ad) {
        this.Adresse = ad;
    }
    
@XmlElement
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
   public String getLastName() {
        return lastName;
    }
   
   public String getAdresse() {
        return Adresse;
    }
   
    public  int getId() {
		return id;
	}
        
    public String getFirstName() {
        return firstName;
    }


    public experiences_info getExperiences() {
        return experiences_pro;
    }

@XmlElement
    public void setExperiences(experiences_info experiences) {
        this.experiences_pro = experiences;
    }

    public langues getLangues() {
        return langues;
    }

@XmlElement
    public void setLangues(langues langues) {
        this.langues = langues;
    }

@XmlElement
    public void setId(int id) { 
    	this.id = id;
    }
}
