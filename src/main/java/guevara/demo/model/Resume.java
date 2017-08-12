package guevara.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    private String email;


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
}
