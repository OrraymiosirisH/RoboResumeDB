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

import javax.validation.Valid;




@Controller
public class MainController {

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
        public String loadEdu (Model toSend,@ModelAttribute("resume") Resume resume){
            toSend.addAttribute("educational", new Educational());
            return "addedu";
        }

        @PostMapping("/addedu")
        public String processEdu (@Valid @ModelAttribute("educational") Educational educational, @ModelAttribute("resume") Resume resume, BindingResult lista){
            if (lista.hasErrors()) {
                return "addedu";

            }

            System.out.println("*adding a new Entry");
            educationalRepository.save(educational);
            return "message2";
        }

    @Autowired
    WorkRepository workRepository;

    @GetMapping("/addwork")
    public String loadExp (Model toSend,@ModelAttribute("resume") Resume resume){
        toSend.addAttribute("work", new Work());
        return "addwork";
    }

    @PostMapping("/addwork")
    public String processExp (@Valid @ModelAttribute("work") Work work, @ModelAttribute("resume") Resume resume, BindingResult audi){
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
    public String loadSk (Model toSend,@ModelAttribute("resume") Resume resume){
        toSend.addAttribute("skill", new Skill());
        return "addskill";
    }

    @PostMapping("/addskill")
    public String processSk (@Valid @ModelAttribute("skill") Skill skill, @ModelAttribute("resume") Resume resume, BindingResult honda){
        if (honda.hasErrors()) {
            return "addskill";

        }

        System.out.println("*adding a new Entry");
        skillRepository.save(skill);
        return "message4";
    }


    @GetMapping("/report")
    public String repoFinal(Model toSend, @ModelAttribute("resume") Resume resume){


        Iterable<Educational> educ = educationalRepository.findAll();
        Iterable<Work> workexp = workRepository.findAll();
        Iterable<Skill> skiller = skillRepository.findAll();



        return "report";
    }



}





