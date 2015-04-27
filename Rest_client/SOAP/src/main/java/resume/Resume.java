package resume;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "resume")
public class Resume {

    private int id;
    private String nom;
    private String prenom;
    private String Adresse;
    ListeExperience experience;
    ListeLangue langue;

    public Resume(){
        this.id=0;
        this.nom="";
        this.prenom="";
        this.Adresse="";
        this.experience = new ListeExperience();
        this.langue = new ListeLangue();
    }
    public Resume(String nom,String prenom,String Adresse,ListeExperience experience,ListeLangue langue)
    {
        this.nom=nom;
        this.prenom=prenom;
        this.Adresse=Adresse;
        this.experience=experience;
        this.langue=langue;

    }

    public int getId(){return id;}

    @XmlElement
    public void setId(int id){this.id=id;}


   public String getNom(){return nom;}

    @XmlElement
    public void setNom(String nom){this.nom=nom;}

    public String getPrenom(){return prenom;}

    @XmlElement
    public void setPrenom(String prenom){this.prenom=prenom;}

    public String getAdresse(){return Adresse;}

    @XmlElement
    public void setAdresse(String Adresse){this.Adresse=Adresse;    }


    public ListeExperience getExperience(){return experience;}

    @XmlElement
    public void setExperience(ListeExperience experience){this.experience=experience;}

    public ListeLangue getLangue(){return langue;}

    @XmlElement
    public void setLangue(ListeLangue langue){this.langue=langue;}


}
