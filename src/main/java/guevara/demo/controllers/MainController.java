package guevara.demo.controllers;


import guevara.demo.model.Educational;
import guevara.demo.model.Resume;
import guevara.demo.model.Skill;
import guevara.demo.model.Work;
import guevara.demo.repository.EducationalRepository;
import guevara.demo.repository.ResumeRepository;
import guevara.demo.repository.SkillRepository;
import guevara.demo.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class MainController {

    private int i;

    @Autowired
    ResumeRepository resumeRepository;
    @Autowired
    EducationalRepository educationalRepository;
    @Autowired
    WorkRepository workRepository;
    @Autowired
    SkillRepository skillRepository;


    @RequestMapping("/login")
public String Login(){

        return "login";
    }

    @GetMapping("/")
    public String loadIndex(Model toSend) {
        toSend.addAttribute("resume", new Resume());
        return "welcome";
    }

    @PostMapping("/welcome")
    public String processIndex(@Valid @ModelAttribute("resume") Resume resume, BindingResult result) {
        if (result.hasErrors()) {
            return "welcome";

        }


        System.out.println("*adding a new Entry");

        resumeRepository.save(resume);

        return "redirect:/Message1";
    }

   @RequestMapping("/Message1")
   public String messPass(Model model){
    model.addAttribute("reslist", resumeRepository.findAll());

    return "Message1";

   }


    @RequestMapping("/addedu/{id}")
    public String loadEdu(@PathVariable("id") long id, Model model) {
        model.addAttribute("resume", resumeRepository.findOne(id));
        Educational educational= new Educational();
        educational.setResume(resumeRepository.findOne(id));
        model.addAttribute("educational", educational);
        return "addedu";


   }


    @PostMapping("/addedu")
    public String processEdu(@Valid @ModelAttribute("educational") Educational educational, BindingResult lista) {
        if (lista.hasErrors()) {
            return "addedu";

        }

        System.out.println("*adding a new Entry");
        educationalRepository.save(educational);

        return "redirect:/Message1";
    }

    @RequestMapping("/addwork/{id}")
    public String loadwok(@PathVariable("id") long id, Model model) {
        model.addAttribute("resume", resumeRepository.findOne(id));
        Work work = new Work();
        work.setResume(resumeRepository.findOne(id));
        model.addAttribute("work", work);
        return "addwork";
    }



    @PostMapping("/addwork")
    public String processExp(@Valid @ModelAttribute("work") Work work, BindingResult audi) {
        if (audi.hasErrors()) {
            return "addwork";

        }

        System.out.println("*adding a new Entry");
        workRepository.save(work);
        return "redirect:/Message1";
    }


//    @GetMapping("/addskill")
//    public String loadSk(Model model) {
//        model.addAttribute("skill", new Skill());
//        return "addskill";
//    }

    @RequestMapping("/addskill/{id}")
    public String loadskl(@PathVariable("id") long id, Model model) {
        model.addAttribute("resume", resumeRepository.findOne(id));
        Skill skill = new Skill();
        skill.setResume(resumeRepository.findOne(id));
        model.addAttribute("skill", skill);
        return "addskill";
    }




    @PostMapping("/addskill")
    public String processSk(@Valid @ModelAttribute("skill") Skill skill, BindingResult honda) {

        if (honda.hasErrors()) {
            return "addskill";

        }

        System.out.println("*adding a new Entry");
        System.out.println("*adding a new Entry" + i++);
        skillRepository.save(skill);
        return "redirect:/Message1";


    }

    @GetMapping("/report")
    public String repoFinal(Model sendModel, @ModelAttribute("resume") Resume resume) {


        Iterable<Resume> res = resumeRepository.findAll();
        Iterable<Educational> educ = educationalRepository.findAll();
        Iterable<Work> workexp = workRepository.findAll();
        Iterable<Skill> skiller = skillRepository.findAll();

        sendModel.addAttribute("listofcostumer", res);
        sendModel.addAttribute("listofeduc", educ);
        sendModel.addAttribute("listofwork", workexp);
        sendModel.addAttribute("listofskiller", skiller);


        return "report";
    }

    @RequestMapping("/final")

    public String sayhello() {

        return "final";


    }



    @RequestMapping("/personal")

    public String myPersonal(Model model) {
            model.addAttribute ("allpersonal", resumeRepository.findAll());

        return "personal";


    }

    @RequestMapping("/update/{id}")
    public String updateResume(@PathVariable("id") long id, Model model){
        model.addAttribute("resume", resumeRepository.findOne(id));
        return "welcome2";
    }



    @PostMapping("/welcome2")
    public String processPersmod(@Valid @ModelAttribute("resume") Resume resume, BindingResult venezzia) {
        if (venezzia.hasErrors()) {
            return "welcome2";

        }

//Modifing
        System.out.println("*Modifying an Entry");

        resumeRepository.save(resume);

        return "redirect:/personal";
    }

    // Educational Area.

    @RequestMapping("/education")

    public String myEduca(Model model) {
        model.addAttribute ("alleducational", educationalRepository.findAll());

        return "education";


    }

    @RequestMapping("/updateedu/{id}")
    public String updateEduc(@PathVariable("id") long id, Model model){
        model.addAttribute("educational", educationalRepository.findOne(id));
        return "editedu";
    }

    @RequestMapping("/deleteedu/{id}")
    public String delEdu(@PathVariable("id") long id) {
        educationalRepository.delete(id);
        return "redirect:/education";
    }


    @PostMapping("/editedu")
    public String processEdumod(@Valid @ModelAttribute("educational") Educational educational, BindingResult milano){
        if (milano.hasErrors()) {
            return "editedu";

        }

//Modifing
        System.out.println("*Modifying an educational Entry");

        educationalRepository.save(educational);

        return "redirect:/education";
    }

//Work area
@RequestMapping("/workout")

public String myWorka(Model model) {
    model.addAttribute ("allwork", workRepository.findAll());

    return "workout";


}

    @RequestMapping("/updatework/{id}")
    public String updateWorka(@PathVariable("id") long id, Model model){
        model.addAttribute("work", workRepository.findOne(id));
        return "editwork";
    }

    @RequestMapping("/deletework/{id}")
    public String delWorka(@PathVariable("id") long id) {
        workRepository.delete(id);
        return "redirect:/workout";
    }


    @PostMapping("/editwork")
    public String processEwork(@Valid @ModelAttribute("work") Work work, BindingResult sevilla){
        if (sevilla.hasErrors()) {
            return "editwork";

        }

//Modifing
        System.out.println("*Modifying an work Entry");

        workRepository.save(work);

        return "redirect:/workout";
    }

    //skill area
    @RequestMapping("/skiller")

    public String mySkill(Model model) {
        model.addAttribute ("allskill", skillRepository.findAll());

        return "skiller";


    }

    @RequestMapping("/updateskill/{id}")
    public String updateSkill(@PathVariable("id") long id, Model model){
        model.addAttribute("skill", skillRepository.findOne(id));
        return "editskill";
    }

    @RequestMapping("/deleteskill/{id}")
    public String delSkill(@PathVariable("id") long id) {
        skillRepository.delete(id);
        return "redirect:/skiller";
    }


    @PostMapping("/editskill")
    public String processSkill(@Valid @ModelAttribute("work") Skill skill, BindingResult bologna){
        if (bologna.hasErrors()) {
            return "editskill";

        }

//Modifing
        System.out.println("*Modifying a skill Entry");

        skillRepository.save(skill);

        return "redirect:/skiller";
    }


}



