package com.emsi.devoir.controller;

import com.emsi.devoir.model.Developper;
import com.emsi.devoir.service.DevService;
import com.emsi.devoir.service.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devs")
public class DevController {
    @Autowired
    DevService devService;

    @Autowired
    TacheService tacheService;


    @GetMapping
    public List<Developper> getAll() {
        return this.devService.getAllDevs();
    }

    @PostMapping
    public Developper addDev(@RequestBody Developper developper) {
        return this.devService.addDevelopper(developper);
    }

    @PostMapping("{idDev}/{idTache}")
    public void affecterTacheDev(@PathVariable("idDev") Integer idDev, @PathVariable("idTache") Integer idTache) {
        this.devService.affecterTache(this.devService.getById(idDev), this.tacheService.getById(idTache));

        return;
    }

    @GetMapping("{idDev}")
    public Developper getDev(@PathVariable("idDev") Integer idDev) {
        return this.devService.getById(idDev);
    }

    @GetMapping("project/{idProject}")
    public List<Developper> getDevProject(@PathVariable("idProject") Integer idProject) {
        return this.devService.getDevs(idProject);
    }


}
