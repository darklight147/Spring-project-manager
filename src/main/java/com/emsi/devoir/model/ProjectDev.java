package com.emsi.devoir.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class ProjectDev extends Project {

    public ProjectDev() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String description;
}
