package controller;
import java.util.ArrayList;
import java.util.List;

public class experiences_info {
    
    private List<experience_pro> experiences;
    
public experiences_info() {
    	experiences = new ArrayList<experience_pro>();
    }

public List<experience_pro> getExpereiences() {
        return experiences;
    }
 public void setCompetences(List<experience_pro> competenceList) {
        this.experiences = competenceList;
    }
    
    public void add(experience_pro c) {
    	experiences.add(c);
    }
    
    public void remove(experience_pro c) {
    	experiences.remove(c);
    }
}
