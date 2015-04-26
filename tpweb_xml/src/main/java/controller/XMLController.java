package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/resume")
public class XMLController {

   private final  Listecv CV;

    public  XMLController(){
		CV = new Listecv();
	
	experiences_info expe = new experiences_info();
	experience_pro ex = new experience_pro("12/15/2015","vendeur");
	expe.add(ex);

       //ajout de langue
        langues langue=new langues();
        langue lang = new langue("Anglais","Faible");
        langue.add(lang);

 //creation d'un cv
Curriculum cv1 = new Curriculum("idriss","amzath","girardin",expe,langue);
CV.add(cv1);
Curriculum cv2 = new Curriculum("serge","paul","rouen",expe,langue);
      CV.add(cv2);   
    }

    
      
  
    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public @ResponseBody
    Curriculum getCVInXML(@PathVariable int id) {
        return CV.getCvList(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Listecv getCvsInXML() {
        return CV;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String addCVWithPost(@RequestBody Curriculum curriculumVitae) {
        this.CV.add(curriculumVitae);
	 return "CV Enregistre avec succes :"+curriculumVitae.toString();
}
}