package pe.edu.cibertec.spring_mvc_jyd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.spring_mvc_jyd.entity.Language;
import pe.edu.cibertec.spring_mvc_jyd.repository.LanguageRepository;
import pe.edu.cibertec.spring_mvc_jyd.service.LanguageService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    LanguageRepository languageRepository;

    @Override
    public List<Language> findAllLanguages() {
        return StreamSupport.stream(languageRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}