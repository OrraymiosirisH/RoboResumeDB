package guevara.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Skill {


    @GeneratedValue(strategy = GenerationType.AUTO)


    @Id
    private long id;


    @NotNull
    @Size(min = 2, max = 30)
    private String ski;


    public String getSki() {
        return ski;
    }

    public void setSki(String ski) {
        this.ski = ski;
    }
}