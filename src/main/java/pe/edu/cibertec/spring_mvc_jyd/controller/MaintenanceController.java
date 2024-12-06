package pe.edu.cibertec.spring_mvc_jyd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.spring_mvc_jyd.dto.FilmDetailDto;
import pe.edu.cibertec.spring_mvc_jyd.dto.FilmDto;
import pe.edu.cibertec.spring_mvc_jyd.entity.Language;
import pe.edu.cibertec.spring_mvc_jyd.service.MaintenanceService;
import pe.edu.cibertec.spring_mvc_jyd.service.LanguageService;

import java.util.List;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;
    @Autowired
    LanguageService languageService;

    @GetMapping("/start")
    public String start(Model model) {
        List<FilmDto> films = maintenanceService.findAllFilms();
        model.addAttribute("films", films);
        return "maintenance";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.findDetailById(id);
        model.addAttribute("film", filmDetailDto);
        return "maintenance-detail";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.findDetailById(id);
        model.addAttribute("film", filmDetailDto);
        return "maintenance-edit";
    }

    @PostMapping("/edit-confirm")
    public String edit(@ModelAttribute FilmDetailDto film, Model model) {
        maintenanceService.updateFilm(film);
        return "redirect:/maintenance/start";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        Boolean result = maintenanceService.deleteFilm(id);
        return "redirect:/maintenance/start";
    }

    @GetMapping("/new")
    public String newFilm(Model model) {
        List<Language> languages = languageService.findAllLanguages();
        model.addAttribute("languages", languages);
        model.addAttribute("film", new FilmDetailDto(null, null, null, null, null, null, null, null, null, null, null));
        return "maintenance-new";
    }

    @PostMapping("/new-confirm")
    public String saveNewFilm(@ModelAttribute FilmDetailDto film, @RequestParam("languageId") Integer languageId,Model model) {
        maintenanceService.saveNewFilm(film, languageId);
        return "redirect:/maintenance/start";
    }

}
