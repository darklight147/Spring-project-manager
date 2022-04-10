package com.emsi.devoir.repository;

import com.emsi.devoir.model.Developper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DevRepository extends JpaRepository<Developper, Integer> {

    @Query("SELECT d FROM Developper d where d.name = :name")
    public Developper findByName(@Param("name") String name);

    public Developper getByEmail(@Param("email") String email);

    @Query("SELECT d from Developper d JOIN d.taches t on t.project.id = :idProject")
    public List<Developper> getByProject(@Param("idProject") Integer idProject);
}
