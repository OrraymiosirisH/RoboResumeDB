package guevara.demo.repository;

import guevara.demo.model.Work;
import org.springframework.data.repository.CrudRepository;

public interface WorkRepository extends CrudRepository<Work,Long> {

}

