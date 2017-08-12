package guevara.demo.repository;

import guevara.demo.model.Educational;
import guevara.demo.model.Skill;
import org.springframework.data.repository.CrudRepository;

public interface SkillRepository extends CrudRepository<Skill,Long> {


}

