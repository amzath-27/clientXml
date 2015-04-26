
package controller;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author idriss
 */
public class langues {
     private List<langue> langueList;
      
     public langues() {
		langueList = new ArrayList<langue>();
	}

	public List<langue> getLangueList() {
        return langueList;
    }

    public void setLangueList(List<langue> langueList) {
        this.langueList = langueList;
    }

    public void add(langue l) {
    	this.langueList.add(l);
    }
}
