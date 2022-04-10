package com.emsi.devoir.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Float duree;

    @ManyToOne
    @JoinColumn(name = "tache_id")
    private ProjectDev project;

}
