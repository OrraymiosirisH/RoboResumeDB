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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;




@Controller
public class MainController {

    private int i;

    @Autowired
    ResumeRepository resumeRepository;

    @GetMapping("/welcome")
    public String loadTvForm(Model toSend) {
        toSend.addAttribute("resume", new Resume());
        return "welcome";

    }

    @PostMapping("/welcome")
    public String processTvForm(@Valid @ModelAttribute("resume") Resume resume, BindingResult result) {
        if (result.hasErrors()) {
            return "welcome";

        }

//add the book to the database
            System.out.println("*adding a new Entry");
//      System.out.println(resume.getResumename());
            resumeRepository.save(resume);

            return "Message1";
        }


        @Autowired
        EducationalRepository educationalRepository;

        @GetMapping("/addedu")
        public String loadEdu (Model toSend){
            toSend.addAttribute("educational", new Educational());
            return "addedu";
        }
    //,@ModelAttribute("resume") Resume resume
        @PostMapping("/addedu")
        public String processEdu (@Valid @ModelAttribute("educational") Educational educational, BindingResult lista){
            if (lista.hasErrors()) {
                return "addedu";
               // @ModelAttribute("resume") Resume resume,
            }

            System.out.println("*adding a new Entry");
            educationalRepository.save(educational);

            return "message2";
        }

    @Autowired
    WorkRepository workRepository;

    @GetMapping("/addwork")
    public String loadExp (Model toSend){
        toSend.addAttribute("work", new Work());
        return "addwork";
    }

    @PostMapping("/addwork")
    public String processExp (@Valid @ModelAttribute("work") Work work, BindingResult audi){
        if (audi.hasErrors()) {
            return "addwork";

        }

        System.out.println("*adding a new Entry");
        workRepository.save(work);
        return "message3";
    }


    @Autowired
    SkillRepository skillRepository;


    @GetMapping("/addskill")
    public String loadSk (Model toSend){
        toSend.addAttribute("skill", new Skill());
        return "addskill";
    }

    @PostMapping("/addskill")
    public String processSk (@Valid @ModelAttribute("skill") Skill skill, BindingResult honda) {

            if (honda.hasErrors()) {
                return "addskill";

            }

            System.out.println("*adding a new Entry");
            System.out.println("*adding a new Entry" + i++);
            skillRepository.save(skill);
            return "message4";


    }

    @GetMapping("/report")
    public String repoFinal(Model sendModel, @ModelAttribute("resume") Resume resume){


        Iterable<Resume> res = resumeRepository.findAll();
        Iterable<Educational> educ = educationalRepository.findAll();
        Iterable<Work> workexp = workRepository.findAll();
        Iterable<Skill> skiller = skillRepository.findAll();

        sendModel.addAttribute("listofcostumer",res);
        sendModel.addAttribute("listofeduc",educ);
        sendModel.addAttribute("listofwork",workexp);
        sendModel.addAttribute("listofskiller",skiller);


        return "report";
    }

    @RequestMapping("/final")

    public String sayhello(){



        return "final";


    }




}





