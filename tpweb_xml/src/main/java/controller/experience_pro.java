package controller;
import javax.xml.bind.annotation.XmlElement;

public class experience_pro {
    
  
    private String date;

    private String experience;

    public experience_pro() {
             	
    }

    public experience_pro(String Edat,String Eexp) {
        this.date = Edat;
        this.experience = Eexp;
    }
    public String getDate() {
        return date;
    }

@XmlElement
    public void setDate(String date) {
        this.date = date;
    }

    public String getExperience() {
        return experience;
    }
@XmlElement
    public void setExperience(String experience) {
        this.experience = experience;
    }
    
}