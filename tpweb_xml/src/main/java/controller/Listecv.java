package controller;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.ArrayList;

@XmlRootElement
//ResumeManager = Listecv
public class Listecv {

		private int nombreResume;
    private List<Curriculum> cvList;

    public List<Curriculum> getCvList() {
        return cvList;
    }

    public void setCvList(List<Curriculum> cvList) {
        this.cvList = cvList;
    }

    public void add(Curriculum nouveauCV){
	nombreResume++;
        nouveauCV.setId(nombreResume);
        this.cvList.add(nouveauCV);
    }

    public Curriculum getCvList(Integer i){
	for(Curriculum res:cvList)
	{
		if(res.getId()==i)
            {
                return res;
            }
        }
        return  null;
    }

     public void delete(Curriculum nouveauCV) {
        this.cvList.remove(nouveauCV);
    }
     
     public List<Curriculum> getListCV() {
        return cvList;
    }
     
     public void setListResume(List<Curriculum> list) {
        this.cvList = list;
    }
     
    public Listecv() {
        cvList = new  ArrayList<Curriculum>();
 		nombreResume=0;
    }

}



































