package pe.edu.cibertec.spring_mvc_jyd.service;

import pe.edu.cibertec.spring_mvc_jyd.entity.Language;
import java.util.List;

public interface LanguageService {
    List<Language> findAllLanguages();

}
