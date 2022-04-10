package com.emsi.devoir.repository;

import com.emsi.devoir.model.Developper;
import com.emsi.devoir.model.ProjectDev;
import com.emsi.devoir.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRespository extends JpaRepository<ProjectDev, Integer> {

    @Query("SELECT t from Tache t where t.project.id = :idProject")
    public List<Tache> getTaches(@Param("idProject") Integer idProject);

    @Query("SELECT d from Developper d JOIN d.taches t ON t.project.id = :idProject")
    public List<Developper> getDevs(@Param("idProject") Integer idProject);
}
