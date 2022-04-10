package com.emsi.devoir.service;

import com.emsi.devoir.model.Developper;
import com.emsi.devoir.model.Tache;
import com.emsi.devoir.repository.DevRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevService {
    @Autowired
    DevRepository devRepository;

    public List<Developper> getAllDevs() {
        return this.devRepository.findAll();
    };

    public Developper addDevelopper(Developper d) {
        return this.devRepository.save(d);
    }

    public boolean affecterTache(Developper d, Tache t) {
        List<Tache> taches = d.getTaches();
        taches.add(t);

        d.setTaches(taches);

        this.devRepository.save(d);

        return true;
    }

    public Developper getByEmail(String email) {
        return this.devRepository.getByEmail(email);
    }

    public List<Developper> getDevs(Integer idProject) {
        return this.devRepository.getByProject(idProject);
    }

    public Developper getById(Integer idDev) {
        return this.devRepository.findById(idDev).get();
    }

}
