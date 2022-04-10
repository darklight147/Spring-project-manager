package com.emsi.devoir.service;

import com.emsi.devoir.model.Developper;
import com.emsi.devoir.model.Project;
import com.emsi.devoir.model.ProjectDev;
import com.emsi.devoir.model.Tache;
import com.emsi.devoir.repository.ProjectRespository;
import com.emsi.devoir.repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
Ajouter un projet
Obtenir tous les projets
Obtenir un projet par son id
Ajouter une tâche à un projet
Obtenir les tâches d’un projet
Obtenir les développeurs affectés à un projet
*/

@Service
public class ProjectService {
    @Autowired
    ProjectRespository projectRespository;

    @Autowired
    TacheRepository tacheRepository;

    public ProjectDev addProject(ProjectDev p) {
        return this.projectRespository.save(p);
    }

    public List<ProjectDev> getAllProjects() {
        return this.projectRespository.findAll();
    }

    public ProjectDev getById(Integer id) {
        return this.projectRespository.findById(id).get();
    }

    public boolean addTache(ProjectDev p, Tache t) {
        t.setProject(p);
        this.tacheRepository.save(t);

        return true;
    }

    public List<Tache> getTaches(Integer idProject) {
        return this.projectRespository.getTaches(idProject);
    }

    public List<Developper> getDevs(Integer idProject) {
        return this.projectRespository.getDevs(idProject);
    }

}
