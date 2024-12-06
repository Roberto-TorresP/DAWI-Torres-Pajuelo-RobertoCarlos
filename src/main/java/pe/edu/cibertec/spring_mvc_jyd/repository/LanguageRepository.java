package pe.edu.cibertec.spring_mvc_jyd.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.spring_mvc_jyd.entity.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Integer> {
}
