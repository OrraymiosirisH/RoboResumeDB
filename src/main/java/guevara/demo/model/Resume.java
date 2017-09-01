package guevara.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Resume {

    @GeneratedValue(strategy = GenerationType.AUTO)


    @Id
    private long id;


    @NotNull
    @Size(min=3, max=30)
    private String name;


    @NotNull
    @Size(min=3, max=30)
    private String lastname;

    @NotNull
    @Size(min=3, max=30)
    private String email;


  @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL, fetch = FetchType.EAGER)

  private Set<Educational> educationals;

    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
  private Set<Work> works;
    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
  private Set<Skill> skillss;

  public Resume(){
      setEducationals(new HashSet<Educational>());
//      experience = new HashSet<Experiences>();
      setWorks(new HashSet<Work>());
      setSkillss(new HashSet<Skill>());

  }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }



    public Set<Educational> getEducationals() {
        return educationals;
    }

    public void setEducationals(Set<Educational> educationals) {
        this.educationals = educationals;
    }

    public Set<Work> getWorks() {
        return works;
    }

    public void setWorks(Set<Work> works) {
        this.works = works;
    }


    public Set<Skill> getSkillss() {
        return skillss;
    }

    public void setSkillss(Set<Skill> skillss) {
        this.skillss = skillss;
    }

    public void addEducational(Educational ed) {
        ed.setResume(this);
        this.educationals.add(ed);

    }
    public void addWork(Work w) {
        w.setResume(this);
        this.works.add(w);
    }

        public void addWork(Skill s) {
        s.setResume(this);
        this.skillss.add(s);

    }





}
