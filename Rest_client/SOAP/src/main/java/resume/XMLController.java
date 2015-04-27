package resume;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/resume")
public class XMLController {

    private  ListeResume resumes;


    public XMLController()
    {
        resumes=new ListeResume();

        //ajout d'experience
        ListeExperience experience=new ListeExperience();
        Experience exp=new Experience(" Web","web XML","2015");
        experience.addExperience(exp);

        //ajout de langue
        ListeLangue langue=new ListeLangue();
        Language lang=new Language("Anglais","evoluee");
        langue.addLangue(lang);

        //ajout d'un cv
        Resume cv1=new Resume("idrissou","paul","Ingenieur en Informatique",experience,langue);
        resumes.addResume(cv1);

        Resume cv2=new Resume("pascal","lebon","crevier",experience,langue);
        resumes.addResume(cv2);
    }



    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody ListeResume getResume()
    {
        return resumes;
    }

    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public @ResponseBody Resume getResumeXML(@PathVariable int id) {
        return resumes.getResume(id);
    }

    @RequestMapping(method= RequestMethod.POST)
    public  @ResponseBody String add(@RequestBody Resume Resum)
    {
        this.resumes.addResume(Resum);
        return "CV save:"+Resum.toString();
    }
}
