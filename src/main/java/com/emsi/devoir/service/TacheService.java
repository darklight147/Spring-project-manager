package com.emsi.devoir.service;

import com.emsi.devoir.model.Tache;
import com.emsi.devoir.repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TacheService {
    @Autowired
    TacheRepository tacheRepository;

    public Tache getById(Integer id) {
        return this.tacheRepository.findById(id).get();
    }

}
