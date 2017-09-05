package guevara.demo.repository;

import guevara.demo.model.Resume;
import org.springframework.data.repository.CrudRepository;

    public interface ResumeRepository extends CrudRepository<Resume,Long> {

Iterable<Resume>findResumeById(long Long);


    }

