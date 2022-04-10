package com.emsi.devoir.controller;

import com.emsi.devoir.model.ProjectDev;
import com.emsi.devoir.model.Tache;
import com.emsi.devoir.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectService projectService;


    @GetMapping
    public List<ProjectDev> getAll() {
        return this.projectService.getAllProjects();
    }

    @PostMapping
    public ProjectDev addProject(@RequestBody ProjectDev projectDev) {
        return this.projectService.addProject(projectDev);
    }

    @GetMapping("{idProject}/tache")
    public List<Tache> getTacheProject(@PathVariable(name = "idProject") Integer idProject) {
        return this.projectService.getTaches(idProject);
    }

    @PostMapping("{idProject}/tache")
    public void addTacheProject(@PathVariable(name = "idProject") Integer idProject, @RequestBody Tache tache) {
        this.projectService.addTache(this.projectService.getById(idProject), tache);
        return;
    }

    @PostMapping("/dev")
    public ProjectDev create(@RequestBody ProjectDev projectDev) {
        return this.projectService.addProject(projectDev);
    }
}
